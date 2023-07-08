package com.example.cheqq.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cheqq.R
import com.example.cheqq.data.BankData
import com.example.cheqq.databinding.FragmentHomeBinding
import com.example.cheqq.ui.adapter.BaseAdapter
import com.example.cheqq.ui.adapter.GenericSimpleRecyclerBindingInterface
import com.example.cheqq.ui.viewModel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val homeFragmentViewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        observeTotalDueLiveData()
        return binding.root
    }

    private fun observeTotalDueLiveData() {
        homeFragmentViewModel.totalDueCardData.observe(viewLifecycleOwner) { data ->
            if (data != null) {
                initRecyclerView(data)
            } else {
                Log.d("Cheq", "data is null")
            }
        }
    }

    private fun initRecyclerView(data: ArrayList<BankData>) {
        val adapter = BaseAdapter(
            data,
            R.layout.total_due_recycler_view_item,
            bindingInterface
        )
        binding.totalDueLayout.totalDueRv.adapter = adapter
    }

    private val bindingInterface = object : GenericSimpleRecyclerBindingInterface<BankData> {
        override fun bindData(item: BankData, view: View) {
            val bankName: TextView = view.findViewById(R.id.bank_name)
            val bankCardType: TextView = view.findViewById(R.id.bank_card_type)
            val bankAmountPayable: TextView = view.findViewById(R.id.bank_amount_payable)
            val bankDueDays: TextView = view.findViewById(R.id.bank_due_days)
            bankName.text = item.bankName
            bankCardType.text = item.bankCardType
            bankAmountPayable.text = item.bankAmountPayable
            bankDueDays.text = item.bankDueDays
        }
    }
}