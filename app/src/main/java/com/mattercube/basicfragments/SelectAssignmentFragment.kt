package com.mattercube.basicfragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.select_assignment_fragment.*

// @Author: R Khamov

class SelectAssignmentFragment : Fragment() {

    private lateinit var clickCheck: ApAssignmentClicks

    companion object {
        fun newInstance() = SelectAssignmentFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.select_assignment_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        clickCheck = context as ApAssignmentClicks

        val assignment2Approve: TextView? = view?.findViewById(R.id.assignmnet_2_approve)
        val assignment3Link: TextView? = view?.findViewById(R.id.assignment_3)

        assignment2Approve?.setOnClickListener {
            Log.i("SelAssFrag", "appTwoSelect about to be called.")
            clickCheck.appTwoSelected()
            Log.i("SelAssFrag", "appTwoSelect has been called.")

        }

        assignment3Link?.setOnClickListener {
            Log.i("SelAssFrag", "assThreeSelected about to be called.")
            clickCheck.assThreeSelected()
            Log.i("SelAssFrag", "assThreeSelected has been called.")

        }
    }

    interface ApAssignmentClicks {
        fun appTwoSelected()
        fun assThreeSelected()
    }
}
