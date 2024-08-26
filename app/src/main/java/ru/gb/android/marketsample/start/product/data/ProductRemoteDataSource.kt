package ru.gb.android.marketsample.start.product.data

import ru.gb.android.marketsample.start.product.data.api.ProductApiService
import ru.gb.android.marketsample.start.product.data.api.ProductDto

class ProductRemoteDataSource(
    private val productApiService: ProductApiService
) {

    suspend fun getProducts(): List<ProductDto>{
        return productApiService.getProducts()
    }
}