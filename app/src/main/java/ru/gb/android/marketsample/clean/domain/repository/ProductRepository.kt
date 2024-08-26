package ru.gb.android.marketsample.clean.domain.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import ru.gb.android.marketsample.clean.domain.dataSource.local.ProductLocalDataSource
import ru.gb.android.marketsample.clean.domain.dataSource.remote.ProductRemoteDataSource
import ru.gb.android.marketsample.clean.domain.entities.ProductEntity
import ru.gb.android.marketsample.clean.domain.mappers.ProductDataMapper

class ProductRepository(
    private val productLocalDataSource: ProductLocalDataSource,
    private val productRemoteDataSource: ProductRemoteDataSource,
    private val productDataMapper: ProductDataMapper,
    private val coroutineDispatcher: CoroutineDispatcher,
) {
    private val scope = CoroutineScope(SupervisorJob() + coroutineDispatcher)

    fun consumeProducts(): Flow<List<ProductEntity>> {
        scope.launch {
            val products = productRemoteDataSource.getProducts()
            productLocalDataSource.saveProducts(
                products.map(productDataMapper::toEntity)
            )
        }

        return productLocalDataSource.consumeProducts()
            .flowOn(coroutineDispatcher)
    }
}
