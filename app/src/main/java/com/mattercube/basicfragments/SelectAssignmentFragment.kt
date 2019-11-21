package com.mattercube.basicfragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.select_assignment_fragment.*

// @Author: R Khamov

class SelectAssignmentFragment : Fragment() {

    private lateinit var clickCheck: ApAssignmentClicks

    // Val that will determine which "approve" button will be changed when
    var whichApprove = 0

    public var assignment2Approve: TextView? = null
    public var assignment3Approve: TextView? = null
    var assignment3Link: TextView?    = null

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

        assignment2Approve = view?.findViewById(R.id.assignmnet_2_approve)
        assignment3Approve = view?.findViewById(R.id.assignmnet_3_approve)
        assignment3Link = view?.findViewById(R.id.assignment_3)

        assignment2Approve?.setOnClickListener {
            whichApprove = 2
            Log.i("SelAssFrag", "whichApprove should be 2")
            clickCheck.approveSelected()

        }

        assignment3Approve?.setOnClickListener {
            whichApprove = 3
            Log.i("SelAssFrag", "whichApprove should be 3")
            clickCheck.approveSelected()

        }

        assignment3Link?.setOnClickListener {
            clickCheck.assThreeSelected()
        }


    }

    fun updateApprove(approved: Boolean) {

        Log.i("Approve", "In function")

        if (approved) {

            Log.i("Approve", "In true block")

            if (whichApprove == 2) {    // The approve button for Assignment two was selected

                Log.i("Approve", "In whichApprove 2")

                assignment2Approve?.setBackgroundColor(resources.getColor(R.color.approved))
                assignment2Approve?.setText(getText(R.string.approved))
            }

            if (whichApprove == 3) {    // The approve button for Assignment three was selected

                Log.i("Approve", "In whichApprove 3")

                assignment3Approve?.setBackgroundColor(resources.getColor(R.color.approved))
                assignment3Approve?.setText(getText(R.string.approved))
            }
        }

        else {

            Log.i("Approve", "In else block")

            if (whichApprove == 2) {    // The approve button for Assignment two was selected

                Log.i("Approve", "In whichApprove 2")

                assignment2Approve?.setBackgroundColor(resources.getColor(R.color.not_approved))
                assignment2Approve?.setText(getText(R.string.not_approved))
            }

            if (whichApprove == 3) {    // The approve button for Assignment three was selected

                Log.i("Approve", "In whichApprove 3")

                assignment3Approve?.setBackgroundColor(resources.getColor(R.color.not_approved))
                assignment3Approve?.setText(getText(R.string.not_approved))
            }
        }
    }

    interface ApAssignmentClicks {
        fun approveSelected()
        fun assThreeSelected()
    }
}
