package kg.geektech.capstore.models

data class Products(
    var img: Int? = null,
    var brand: String? = null,
    var model: String? = null,
    var price: String? = null,
    var priceOld: String? = null,
)