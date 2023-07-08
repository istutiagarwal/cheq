package com.example.cheqq.data

import android.graphics.drawable.Drawable

data class FeaturedDetailsData(
    val featuredDetailsTitle: String,
    val innerRecyclerView: ArrayList<FeaturedDetailsItem>,
    val backgroundImage: Drawable,
    val isChipPriceVisible: Boolean
)
data class FeaturedDetailsItem(
    val detailsCompanyLogo: Int,
    val detailsAmount: String,
    val chipsPrice: String,
    val detailsLogo: Int
)