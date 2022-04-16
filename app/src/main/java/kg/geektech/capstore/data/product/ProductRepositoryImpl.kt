package kg.geektech.capstore.data.product

import kg.geektech.capstore.core.base.BaseResult
import kg.geektech.capstore.data.product.remote.ProductApi
import kg.geektech.capstore.domain.product.entity.ProductEntity
import kg.geektech.capstore.domain.product.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val productApi: ProductApi) :
    ProductRepository {

    override suspend fun getProduct(): Flow<BaseResult<List<ProductEntity>, String>> {
        return flow {
            val response = productApi.getProduct()
            if (response.isSuccessful) {
                val body = response.body()
                body?.results?.let {
                    emit(BaseResult.Success(it))
                }
            } else {
                emit(BaseResult.Error(response.message()))
            }
        }
    }

}