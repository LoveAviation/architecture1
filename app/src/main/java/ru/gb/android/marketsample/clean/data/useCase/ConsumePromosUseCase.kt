package ru.gb.android.marketsample.clean.data.useCase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.gb.android.marketsample.clean.data.dataModel.Promo
import ru.gb.android.marketsample.clean.data.domainMapper.PromoDomainMapper
import ru.gb.android.marketsample.clean.domain.repository.PromoRepository

class ConsumePromosUseCase(
    private val promoRepository: PromoRepository,
    private val promoDomainMapper: PromoDomainMapper,
) {
    operator fun invoke(): Flow<List<Promo>> {
        return promoRepository.consumePromos()
            .map{ promos -> promos.map(promoDomainMapper::fromEntity) }
    }
}