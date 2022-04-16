package kg.geektech.capstore.domain.product.entity

import com.google.gson.annotations.SerializedName

data class ProductEntityResponse(
    val count: Int? = null,
    val next: Any? = null,
    val previous: Any? = null,
    val results: List<ProductEntity>? = null
)

data class ProductEntity(
    val brand: String? = null,
    @SerializedName("capsimage")
    val capsImage: List<CapsImage>? = null,
    val id: Int? = null,
    @SerializedName("is_available")
    val isAvailable: Boolean? = null,
    val name: String? = null,
    @SerializedName("new_price")
    val newPrice: Int? = null,
    val price: Int? = null
)

data class CapsImage(
    val id: Int? = null,
    val image: String? = null
)
