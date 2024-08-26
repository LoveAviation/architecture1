package ru.gb.android.marketsample.clean.data.useCase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.gb.android.marketsample.clean.data.dataModel.Product
import ru.gb.android.marketsample.clean.data.domainMapper.ProductDomainMapper
import ru.gb.android.marketsample.clean.domain.repository.ProductRepository

class ConsumeProductsUseCase(
    private val productRepository: ProductRepository,
    private val productDomainMapper: ProductDomainMapper,
) {
    operator fun invoke(): Flow<List<Product>> {
        return productRepository.consumeProducts()
            .map{ products -> products.map(productDomainMapper::fromEntity) }
    }
}