package com.example.cheqq.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cheqq.data.BankData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _totalDueCardData : MutableLiveData<ArrayList<BankData>> = MutableLiveData(null)
    var totalDueCardData : LiveData<ArrayList<BankData>> = _totalDueCardData

    init{
        getTotalDueCardData()
    }

    private fun getTotalDueCardData(){
        viewModelScope.launch {
            _totalDueCardData.value = getListOfTotalDueCard()
        }
    }

   private  fun getListOfTotalDueCard() = arrayListOf(
       BankData(
           bankAmountPayable = "₹60000",
           bankCardType = "Credit Card",
           bankDueDays = "Overdue by 1 day",
           bankName = "Axis Platinum"
       ),
       BankData(
           bankAmountPayable = "₹60000",
           bankCardType = "Credit Card",
           bankDueDays = "Due in 3 days",
           bankName = "SBI Simply Click"
       ),
       BankData(
           bankAmountPayable = "₹60000",
           bankCardType = "Credit Card",
           bankDueDays = "Due in 3 days",
           bankName = " BOB Credit Platinum"
       ),
   )
}



