package ru.gb.android.marketsample.start.product.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.gb.android.marketsample.databinding.ItemProductBinding
import coil.load
import ru.gb.android.marketsample.start.product.presentation.ProductVO

class ProductHolder(
    private val binding: ItemProductBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(product: ProductVO) {
        binding.image.load(product.image)
        binding.name.text = product.name
        binding.price.text = "${product.price} руб"
    }
}
