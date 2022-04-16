package kg.geektech.capstore.ui.fragments.bestsellers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.geektech.capstore.core.base.BaseResult
import kg.geektech.capstore.domain.product.entity.ProductEntity
import kg.geektech.capstore.domain.product.usecase.GetProductUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val getProductUseCase: GetProductUseCase) :
    ViewModel() {

    private val _productList = MutableStateFlow<List<ProductEntity>>(mutableListOf())
    val productList: StateFlow<List<ProductEntity>> get() = _productList

    private val _state = MutableStateFlow<ProductFragmentState>(ProductFragmentState.Init)
    val state: StateFlow<ProductFragmentState> get() = _state

    fun getProduct() {
        viewModelScope.launch {
            getProductUseCase.invoke()
                .onStart {
                    setLoading()
                }
                .catch {
                    hideLoading()
                    showToast(it.localizedMessage ?: "Error")
                }
                .collect {
                    hideLoading()
                    when (it) {
                        is BaseResult.Success -> {
                            _productList.value = it.data
                        }
                        is BaseResult.Error -> {
                            showToast(it.errorMsg)
                        }
                    }
                }
        }
    }

    private fun showToast(message: String) {
        _state.value = ProductFragmentState.ShowToast(message)
    }

    private fun hideLoading() {
        _state.value = ProductFragmentState.IsLoading(false)
    }

    private fun setLoading() {
        _state.value = ProductFragmentState.IsLoading(true)
    }

    sealed class ProductFragmentState {
        object Init : ProductFragmentState()
        data class IsLoading(val isLoading: Boolean) : ProductFragmentState()
        data class ShowToast(val message: String) : ProductFragmentState()
    }
}