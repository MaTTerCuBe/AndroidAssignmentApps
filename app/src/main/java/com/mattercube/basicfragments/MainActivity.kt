package com.mattercube.basicfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity(), SelectAssignmentFragment.ApAssignmentClicks {

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
}

