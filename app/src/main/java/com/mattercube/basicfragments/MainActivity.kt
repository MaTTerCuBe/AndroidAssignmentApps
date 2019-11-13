package com.mattercube.basicfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.select_assignment_fragment.*


class MainActivity : AppCompatActivity(), SelectAssignmentFragment.ApAssignmentClicks,
    ApproveAssignmentFragment.Confirm {

    private val selectAssignmentFragment = SelectAssignmentFragment()
    private val approveAssignmentFragment = ApproveAssignmentFragment()
    private val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager.beginTransaction()
            .add(R.id.selectAssignmentFragment, selectAssignmentFragment)

            .commit()

    }

    override fun appTwoSelected() {

        Log.i("MainActivity", "appTwoSelected about to be called")
        manager.beginTransaction()
            .replace(R.id.selectAssignmentFragment, approveAssignmentFragment)
            .addToBackStack(null)
            .commit()
        Log.i("MainActivity", "appTwoSelect has finished")
    }

    override fun returnHere() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun approved() {
        Log.i("SelAssFragL", "trying to get colors")
        assignmnet_2_approve.setBackgroundColor(resources.getColor(R.color.approved))
        assignmnet_2_approve.setText(getText(R.string.approved))
        manager.beginTransaction().remove(approveAssignmentFragment).commit()
    }

    override fun deneid() {
        Log.i("SelAssFragL", "trying to get colors")
        assignmnet_2_approve.setBackgroundColor(resources.getColor(R.color.not_approved))
        assignmnet_2_approve.setText(getText(R.string.not_approved))
        manager.beginTransaction().remove(approveAssignmentFragment).commit()
    }
}

