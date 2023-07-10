package com.example.cheqq.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cheqq.R
import com.example.cheqq.data.ExploreVouchersData
import kotlinx.coroutines.launch

class RewardViewModel : ViewModel() {

    private val _exploreVoucherCardData: MutableLiveData<ArrayList<ExploreVouchersData>> =
        MutableLiveData(null)
    var exploreVoucherCardData: LiveData<ArrayList<ExploreVouchersData>> = _exploreVoucherCardData

    init {
        getExploreVouchersCardData()
    }

    private fun getExploreVouchersCardData() {
        viewModelScope.launch {
            _exploreVoucherCardData.value = getListOfExploreVouchers()
        }
    }

    private fun getListOfExploreVouchers() = arrayListOf<ExploreVouchersData>(
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
}