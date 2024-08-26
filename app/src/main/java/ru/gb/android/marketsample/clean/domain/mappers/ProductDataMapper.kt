package ru.gb.android.marketsample.clean.domain.mappers

import ru.gb.android.marketsample.clean.domain.dto.ProductDto
import ru.gb.android.marketsample.clean.domain.entities.ProductEntity

class ProductDataMapper {
    fun toEntity(productDto: ProductDto): ProductEntity {
        return ProductEntity(
            id = productDto.id,
            name = productDto.name,
            image = productDto.image,
            price = productDto.price
        )
    }
}
