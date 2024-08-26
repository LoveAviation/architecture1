package ru.gb.android.marketsample.clean.presentation.adapters.promoAdapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.gb.android.marketsample.clean.presentation.viewObject.PromoVO
import ru.gb.android.marketsample.databinding.ItemPromoBinding

class PromoHolder(
    private val binding: ItemPromoBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(promo: PromoVO) {
        binding.image.load(promo.image)
        binding.name.text = promo.name
        binding.description.text = promo.description
    }
}
