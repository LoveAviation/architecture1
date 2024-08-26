package ru.gb.android.marketsample.clean.data.domainMapper

import ru.gb.android.marketsample.clean.data.dataModel.Product
import ru.gb.android.marketsample.clean.domain.dto.ProductDto
import ru.gb.android.marketsample.clean.domain.entities.ProductEntity


class ProductDomainMapper {
    fun fromDto(productDto: ProductDto): Product {
        return Product(
            id = productDto.id,
            name = productDto.name,
            image = productDto.image,
            price = productDto.price
        )
    }

    fun fromEntity(productEntity: ProductEntity): Product {
        return Product(
            id = productEntity.id,
            name = productEntity.name,
            image = productEntity.image,
            price = productEntity.price
        )
    }

    fun toEntity(product: Product): ProductEntity {
        return ProductEntity(
            id = product.id,
            name = product.name,
            image = product.image,
            price = product.price
        )
    }
}