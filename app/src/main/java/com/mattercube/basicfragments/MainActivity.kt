package com.mattercube.basicfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.select_assignment_fragment.*

// @Author: R Khamov

class MainActivity : AppCompatActivity(), SelectAssignmentFragment.ApAssignmentClicks,
    ApproveAssignmentFragment.Confirm {

    private val selectAssignmentFragment = SelectAssignmentFragment()
    private val approveAssignmentFragment = ApproveAssignmentFragment()
    private val selectAssignmentFont = FontFragment()
    private val helpFragment = HelpFragment()
    private val manager = supportFragmentManager

    var whichThingy: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager.beginTransaction()
            .add(R.id.mainFragmentArea, selectAssignmentFragment)
            .commit()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.help_button -> {

            manager.beginTransaction()
                .replace(R.id.mainFragmentArea, helpFragment)
                .addToBackStack(null)
                .commit()

            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun approveSelected() {

        manager.beginTransaction()
            .replace(R.id.mainFragmentArea, approveAssignmentFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun assThreeSelected() {
        manager.beginTransaction()
            .replace(R.id.mainFragmentArea, selectAssignmentFont)
            .addToBackStack(null)
            .commit()
    }

    override fun approved() {

        Log.i("In Main", "assignment approved, starting approve function.")

        manager.beginTransaction().remove(approveAssignmentFragment).commit()
        //updateApprove(true)
        //selectAssignmentFragment.updateApprove(true)
        if (selectAssignmentFragment.whichApprove == 2) {    // The approve button for Assignment two was selected

            Log.i("Approve", "In whichApprove 2")

            assignmnet_2_approve?.setBackgroundColor(resources.getColor(R.color.approved))
            assignmnet_2_approve?.setText(getText(R.string.approved))
        }

        if (selectAssignmentFragment.whichApprove == 3) {    // The approve button for Assignment three was selected

            Log.i("Approve", "In whichApprove 3")

            assignmnet_3_approve?.setBackgroundColor(resources.getColor(R.color.approved))
            assignmnet_3_approve?.setText(getText(R.string.approved))
        }

    }

    override fun denied() {
        //whichThingy = selectAssignmentFragment.whichApprove


        Log.i("In Main", "assignment denied, starting approve function")

        manager.beginTransaction().remove(approveAssignmentFragment).commit()
        //updateApprove(false)
        //selectAssignmentFragment.updateApprove(false)
        if (selectAssignmentFragment.whichApprove == 2) {    // The approve button for Assignment two was selected

            Log.i("Approve", "In whichApprove 2")

            assignmnet_2_approve?.setBackgroundColor(resources.getColor(R.color.not_approved))
            assignmnet_2_approve?.setText(getText(R.string.not_approved))
        }

        if (selectAssignmentFragment.whichApprove == 3) {    // The approve button for Assignment three was selected

            Log.i("Approve", "In whichApprove 3")

            assignmnet_3_approve?.setBackgroundColor(resources.getColor(R.color.not_approved))
            assignmnet_3_approve?.setText(getText(R.string.not_approved))
        }

    }

    fun updateApprove(approved: Boolean) {

        Log.i("Approve", "In function")

        if (approved) {

            Log.i("Approve", "In true block")

            if (selectAssignmentFragment.whichApprove == 2) {    // The approve button for Assignment two was selected

                Log.i("Approve", "In whichApprove 2")

                selectAssignmentFragment.assignmnet_2_approve?.setBackgroundColor(resources.getColor(R.color.approved))
                selectAssignmentFragment.assignmnet_2_approve?.setText(getText(R.string.approved))
            }

            if (selectAssignmentFragment.whichApprove == 3) {    // The approve button for Assignment three was selected

                Log.i("Approve", "In whichApprove 3")

                selectAssignmentFragment.assignmnet_3_approve?.setBackgroundColor(resources.getColor(R.color.approved))
                selectAssignmentFragment.assignmnet_3_approve?.setText(getText(R.string.approved))
            }
        }

        else {

            Log.i("Approve", "In else block")

            if (selectAssignmentFragment.whichApprove == 2) {    // The approve button for Assignment two was selected

                Log.i("Approve", "In whichApprove 2")

                selectAssignmentFragment.assignmnet_2_approve?.setBackgroundColor(resources.getColor(R.color.not_approved))
                selectAssignmentFragment.assignmnet_2_approve?.setText(getText(R.string.not_approved))
            }

            if (selectAssignmentFragment.whichApprove == 3) {    // The approve button for Assignment three was selected

                Log.i("Approve", "In whichApprove 3")

                selectAssignmentFragment.assignmnet_3_approve?.setBackgroundColor(resources.getColor(R.color.not_approved))
                selectAssignmentFragment.assignmnet_3_approve?.setText(getText(R.string.not_approved))
            }
        }
    }
}

