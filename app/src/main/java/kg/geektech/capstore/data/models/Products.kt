package kg.geektech.capstore.data.models

data class Products(
    var img: Int? = null,
    var brand: String? = null,
    var brandImg: Int? = null,
    var model: String? = null,
    var price: Int? = null,
    var priceOld: Int? = null,
    var count: Int? = null,
    var size: String? = null
)