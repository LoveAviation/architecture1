package ru.gb.android.marketsample.start.promo.data

import ru.gb.android.marketsample.start.promo.data.api.PromoApiService
import ru.gb.android.marketsample.start.promo.data.api.PromoDto

class PromoRemoteDataSource(
    private val promoApiService: PromoApiService
) {

    suspend fun getPromos(): List<PromoDto>{
        return promoApiService.getPromos()
    }
}