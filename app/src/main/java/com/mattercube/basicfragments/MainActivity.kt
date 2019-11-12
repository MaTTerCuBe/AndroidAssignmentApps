package com.mattercube.basicfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.select_assignment_fragment.*

class MainActivity : AppCompatActivity(), SelectAssignmentFragment.ApAssignmentClicks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val selectAssignmentFragment = SelectAssignmentFragment()
        val approveAssignmentFragment = ApproveAssignmentFragment()

        supportFragmentManager.beginTransaction().add(R.id.selectAssignmentFragment, selectAssignmentFragment)
            .commit()

    }

    override fun appTwoSelected() {
        assignmnet_2_approve.setOnClickListener() {
            supportFragmentManager.beginTransaction().add(R.id.approveAssignmentFragment, approveAssignmentFragment)
                .commit()
        }
    }
}

