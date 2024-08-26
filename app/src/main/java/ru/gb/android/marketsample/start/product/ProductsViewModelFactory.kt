package ru.gb.android.marketsample.start.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.gb.android.marketsample.start.product.data.repository.ProductRepository
import ru.gb.android.marketsample.start.promo.data.repository.PromoRepository
import ru.gb.android.marketsample.start.product.presentation.ProductsViewModel
import ru.gb.android.marketsample.start.promo.presentation.PromoViewModel

class ProductsViewModelFactory(
    private val productRepository: ProductRepository,
    private val promoRepository: PromoRepository,
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(ProductsViewModel::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                return ProductsViewModel(
                    productRepository = productRepository,
                    promoRepository = promoRepository,
                ) as T
            }

            modelClass.isAssignableFrom(PromoViewModel::class.java) -> {
                @Suppress("UNCHECKED_CAST")
                return PromoViewModel(
                    promoRepository = promoRepository,
                ) as T
            }
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
