package com.mattercube.basicfragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class ApproveAssignmentFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("AppAssFrag", "We about to inflate view")
        return inflater.inflate(R.layout.fragment_approve_assignment, container, false)
    }



}
