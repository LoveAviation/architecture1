package ru.gb.android.marketsample.clean.domain.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import ru.gb.android.marketsample.clean.domain.dataSource.local.PromoLocalDataSource
import ru.gb.android.marketsample.clean.domain.dataSource.remote.PromoRemoteDataSource
import ru.gb.android.marketsample.clean.domain.entities.PromoEntity
import ru.gb.android.marketsample.clean.domain.mappers.PromoDataMapper

class PromoRepository(
    private val promoLocalDataSource: PromoLocalDataSource,
    private val promoRemoteDataSource: PromoRemoteDataSource,
    private val promoDataMapper: PromoDataMapper,
    private val coroutineDispatcher: CoroutineDispatcher,
) {
    private val scope = CoroutineScope(SupervisorJob() + coroutineDispatcher)

    fun consumePromos(): Flow<List<PromoEntity>> {
        scope.launch {
            val promos = promoRemoteDataSource.getPromos()
            promoLocalDataSource.savePromos(
                promos.map(promoDataMapper::toEntity)
            )
        }

        return promoLocalDataSource.consumeProducts()
            .flowOn(coroutineDispatcher)
    }
}
