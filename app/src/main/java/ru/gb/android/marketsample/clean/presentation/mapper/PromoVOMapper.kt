package ru.gb.android.marketsample.clean.presentation.mapper

import ru.gb.android.marketsample.clean.data.dataModel.Promo
import ru.gb.android.marketsample.clean.presentation.viewObject.PromoVO


class PromoVOMapper {
    fun map(promo: Promo): PromoVO {
        return PromoVO(
            id = promo.id,
            name = promo.name,
            image = promo.image,
            description = promo.description
        )
    }
}
