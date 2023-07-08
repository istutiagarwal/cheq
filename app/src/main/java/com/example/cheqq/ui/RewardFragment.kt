package com.example.cheqq.ui

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cheqq.R
import com.example.cheqq.data.BankData
import com.example.cheqq.data.ExploreVouchersData
import com.example.cheqq.data.FeaturedDetailsData
import com.example.cheqq.data.FeaturedDetailsItem
import com.example.cheqq.databinding.FragmentHomeBinding
import com.example.cheqq.databinding.FragmentRewardBinding
import com.example.cheqq.ui.adapter.BaseAdapter
import com.example.cheqq.ui.adapter.GenericSimpleRecyclerBindingInterface

/**
 * A simple [Fragment] subclass.
 * Use the [RewardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RewardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentRewardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reward, container, false)
        initParentRecyclerView()
        initExploreVouchersRecyclerView()
        // Inflate the layout for this fragment
        return binding.root
    }

    val stringArray = arrayListOf(
        FeaturedDetailsItem(
            detailsAmount = "₹6000",
            detailsCompanyLogo = R.drawable.merch_logo_swiggy,
            detailsLogo = R.drawable.merch_illustration_subway,
            chipsPrice = "₹1"
        ),
        FeaturedDetailsItem(
            detailsAmount = "₹6000",
            detailsCompanyLogo = R.drawable.merch_logo_swiggy,
            detailsLogo = R.drawable.merch_illustration_subway,
            chipsPrice = "₹1"
        ),
        FeaturedDetailsItem(
            detailsAmount = "₹6000",
            detailsCompanyLogo = R.drawable.merch_logo_swiggy,
            detailsLogo = R.drawable.merch_illustration_subway,
            chipsPrice = "₹1"
        )
    )

    private fun initExploreVouchersRecyclerView() {

        val data = arrayListOf<ExploreVouchersData>(
            ExploreVouchersData(
                exploreVouchersTitle = "Food",
                exploreVouchersIcon = R.drawable.food
            ),
            ExploreVouchersData(
                exploreVouchersTitle = "Shopping",
                exploreVouchersIcon = R.drawable.food
            ),
            ExploreVouchersData(
                exploreVouchersTitle = "Travel",
                exploreVouchersIcon = R.drawable.food
            ),
            ExploreVouchersData(
                exploreVouchersTitle = "See All",
                exploreVouchersIcon = R.drawable.food
            )
        )

        val exploreVouchersAdapter = BaseAdapter<ExploreVouchersData>(
            data,
            R.layout.explore_vouchers_item,
            exploreVouchersBindingInterface
        )
        binding.exploreVouchersRv.adapter = exploreVouchersAdapter
    }

    val exploreVouchersBindingInterface =
        object : GenericSimpleRecyclerBindingInterface<ExploreVouchersData> {

            override fun bindData(data: ExploreVouchersData, itemView: View) {
                val exploreVouchersIcon: ImageView =
                    itemView.findViewById(R.id.explore_vouchers_icon)
                val exploreVouchersTitle: TextView =
                    itemView.findViewById(R.id.explore_vouchers_text)
                exploreVouchersIcon.setImageResource(data.exploreVouchersIcon)
                exploreVouchersTitle.text = data.exploreVouchersTitle

            }
        }

    private fun initParentRecyclerView() {

        val stringParentArray = arrayListOf(
            FeaturedDetailsData(
                featuredDetailsTitle = "Featured Details",
                innerRecyclerView = stringArray,
                backgroundImage = ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.featured_categories_background
                )!!,
                isChipPriceVisible = true
            ),
            FeaturedDetailsData(
                featuredDetailsTitle = "Other Featured Details",
                innerRecyclerView = stringArray,
                backgroundImage = ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.other_featured_details_background
                )!!,
                isChipPriceVisible = false
            )
        )

        val adapter = BaseAdapter<FeaturedDetailsData>(
            stringParentArray,
            R.layout.featured_deals,
            parentBindingInterface
        )
        binding.fdRv.adapter = adapter
        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        context?.let {
            ContextCompat.getDrawable(it, R.drawable.item_divider)
                ?.let { divider.setDrawable(it) }
        }

        binding.fdRv.addItemDecoration(divider)
    }

    private val parentBindingInterface =
        object : GenericSimpleRecyclerBindingInterface<FeaturedDetailsData> {

            override fun bindData(parentData: FeaturedDetailsData, itemView: View) {
                val featuredDealsType: TextView = itemView.findViewById(R.id.featured_details_title)
                val recyclerView: RecyclerView = itemView.findViewById(R.id.featured_details_rv_box)
                val layout =
                    itemView.findViewById<CardView>(R.id.featured_details_price_per_coin_include)
                layout.visibility = if (parentData.isChipPriceVisible) View.VISIBLE else View.GONE
                itemView.background = (parentData.backgroundImage)
                featuredDealsType.text = parentData.featuredDetailsTitle
                val childAdapter = BaseAdapter<FeaturedDetailsItem>(
                    parentData.innerRecyclerView,
                    R.layout.featured_details_item,
                    bindingInterface
                )
                recyclerView.adapter = childAdapter
            }

            val bindingInterface =
                object : GenericSimpleRecyclerBindingInterface<FeaturedDetailsItem> {

                    override fun bindData(item: FeaturedDetailsItem, view: View) {
                        val detailsAmount: TextView = view.findViewById(R.id.featured_details_price)
                        val detailsCompanyLogo: ImageView = view.findViewById(R.id.swiggy_image)
                        val detailsLogo: ImageView = view.findViewById(R.id.food_image)
                        val chipsPrice: TextView = view.findViewById(R.id.chip_price)

                        detailsAmount.text = item.detailsAmount
                        detailsCompanyLogo.setImageResource(item.detailsCompanyLogo)
                        detailsLogo.setImageResource(item.detailsLogo)
                        chipsPrice.text = item.chipsPrice
                    }

                }
        }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RewardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RewardFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }
}