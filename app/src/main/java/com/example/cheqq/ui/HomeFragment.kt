package com.example.cheqq.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.cheqq.R
import com.example.cheqq.data.BankData
import com.example.cheqq.databinding.FragmentHomeBinding
import com.example.cheqq.ui.adapter.BaseAdapter
import com.example.cheqq.ui.adapter.GenericSimpleRecyclerBindingInterface

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding : FragmentHomeBinding

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        initRecyclerView()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun initRecyclerView() {
         val stringArray = arrayListOf(
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
        val adapter =  BaseAdapter<BankData>(stringArray, R.layout.total_due_recycler_view_item, bindingInterface)
        binding.featuredDetailsRv.adapter = adapter
    }

    val bindingInterface = object: GenericSimpleRecyclerBindingInterface<BankData> {

        override fun bindData(data: BankData, itemView: View) {
            val bankName : TextView = itemView.findViewById(R.id.bank_name)
            val bankCardType : TextView = itemView.findViewById(R.id.bank_card_type)
            val  bankAmountPayable : TextView = itemView.findViewById(R.id.bank_amount_payable)
            val  bankDueDays : TextView = itemView.findViewById(R.id.bank_due_days)
            bankName.text = data.bankName
            bankCardType.text = data.bankCardType
            bankAmountPayable.text = data.bankAmountPayable
            bankDueDays.text = data.bankDueDays
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }
}