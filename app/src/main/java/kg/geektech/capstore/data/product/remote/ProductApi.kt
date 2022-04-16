package kg.geektech.capstore.data.product.remote

import kg.geektech.capstore.domain.product.entity.ProductEntityResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {

    @GET("api/v1/caps")
    suspend fun getProduct(
        @Query("format") format: String = "json"
    ): Response<ProductEntityResponse>
}