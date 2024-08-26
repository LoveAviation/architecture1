package ru.gb.android.marketsample.clean.domain.dataSource.remote

import ru.gb.android.marketsample.clean.domain.dto.ProductDto
import ru.gb.android.marketsample.clean.domain.api.ProductApiService

class ProductRemoteDataSource(
    private val productApiService: ProductApiService,
) {
    suspend fun getProducts(): List<ProductDto> {
        return productApiService.getProducts()
    }
}
