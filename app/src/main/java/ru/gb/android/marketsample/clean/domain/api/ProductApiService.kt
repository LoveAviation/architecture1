package ru.gb.android.marketsample.clean.domain.api

import retrofit2.http.GET
import ru.gb.android.marketsample.clean.domain.dto.ProductDto

interface ProductApiService {
    @GET("test_api_products.json")
    suspend fun getProducts(): List<ProductDto>
}
