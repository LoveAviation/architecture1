package ru.gb.android.marketsample.clean.domain.api

import retrofit2.http.GET
import ru.gb.android.marketsample.clean.domain.dto.PromoDto

interface PromoApiService {
    @GET("test_api_promo.json")
    suspend fun getPromos(): List<PromoDto>
}
