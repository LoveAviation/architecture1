package ru.gb.android.marketsample.clean.domain.dataSource.remote

import ru.gb.android.marketsample.clean.domain.dto.PromoDto
import ru.gb.android.marketsample.clean.domain.api.PromoApiService

class PromoRemoteDataSource(
    private val promoApiService: PromoApiService,
) {
    suspend fun getPromos(): List<PromoDto> {
        return promoApiService.getPromos()
    }
}
