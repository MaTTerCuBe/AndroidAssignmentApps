package com.mattercube.basicfragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class ApproveAssignmentFragment : Fragment() {

    private lateinit var checkClicks: Confirm

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_approve_assignment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        checkClicks = context as Confirm

        val passButton: Button? = view!!.findViewById(R.id.pass_button)
        val denyButton: Button? = view!!.findViewById(R.id.fail_button)

        passButton?.setOnClickListener{
            checkClicks.approved()
        }

        denyButton?.setOnClickListener {
            checkClicks.denied()
        }

    }
    interface Confirm {
        fun approved()
        fun denied()
    }

}
