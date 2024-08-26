package ru.gb.android.marketsample.clean.domain.mappers

import ru.gb.android.marketsample.clean.domain.dto.PromoDto
import ru.gb.android.marketsample.clean.domain.entities.PromoEntity

class PromoDataMapper {
    fun toEntity(promoDto: PromoDto): PromoEntity {
        return PromoEntity(
            id = promoDto.id,
            name = promoDto.name,
            image = promoDto.image,
            discount = promoDto.discount,
            description = promoDto.description,
            type = promoDto.type,
            products = promoDto.products ?: emptyList(),
        )
    }
}
