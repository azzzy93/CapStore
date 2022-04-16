package kg.geektech.capstore.domain.product.repository

import kg.geektech.capstore.core.base.BaseResult
import kg.geektech.capstore.domain.product.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun getProduct(): Flow<BaseResult<List<ProductEntity>, String>>

}