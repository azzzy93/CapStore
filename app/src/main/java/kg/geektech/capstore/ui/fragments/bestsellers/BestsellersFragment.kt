package kg.geektech.capstore.ui.fragments.bestsellers

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kg.geektech.capstore.R
import kg.geektech.capstore.core.base.BaseFragment
import kg.geektech.capstore.core.extensions.showCustomToast
import kg.geektech.capstore.databinding.FragmentBestsellersBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class BestsellersFragment : BaseFragment<FragmentBestsellersBinding>() {

    private val adapter: ProductAdapter by lazy {
        ProductAdapter()
    }
    private val viewModel: ProductViewModel by viewModels()

    override fun bind(): FragmentBestsellersBinding {
        return FragmentBestsellersBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
        viewModel.getProduct()
        viewModel.state.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).onEach {
            handleState(it)
        }.launchIn(lifecycleScope)
        viewModel.productList.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).onEach {
            adapter.submitList(it)
        }.launchIn(lifecycleScope)
    }

    private fun handleState(state: ProductViewModel.ProductFragmentState) {
        when (state) {
            is ProductViewModel.ProductFragmentState.IsLoading -> {
                binding.progressBar.isVisible = state.isLoading
            }
            is ProductViewModel.ProductFragmentState.ShowToast -> {
                requireContext().showCustomToast(
                    "Message: ${state.message}",
                    requireActivity(),
                    layoutInflater
                )
            }
            is ProductViewModel.ProductFragmentState.Init -> Unit
        }
    }

    override fun initViews() {
        binding.tvTitle.text = getString(R.string.bestsellers)
        initAdapter()
    }

    override fun initListeners() {
        binding.ivBack.setOnClickListener {
            navController.navigateUp()
        }
        adapter.onItemClick = {
            navController.navigate(BestsellersFragmentDirections.actionBestsellersFragmentToProductDetailFragment())
        }
    }

    private fun initAdapter() {
        binding.rv.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rv.adapter = adapter
    }
}