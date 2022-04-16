package kg.geektech.capstore.domain.product.usecase

import kg.geektech.capstore.core.base.BaseResult
import kg.geektech.capstore.domain.product.entity.ProductEntity
import kg.geektech.capstore.domain.product.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductUseCase @Inject constructor(private val repository: ProductRepository) {

    suspend fun invoke(): Flow<BaseResult<List<ProductEntity>, String>> {
        return repository.getProduct()
    }

}