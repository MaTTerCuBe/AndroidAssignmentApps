package com.mattercube.basicfragments


import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_intents.*
import android.widget.Toast

private const val ACTION_RETRIEVE_FONT = "com.mattercube.basicfragments.RETRIEVE_FONT"
private const val EXTRA_FONT_VALUE = "com.mattercube.basicfragments.FONT_VALUE"

class IntentsFragment : Fragment() {

    // defining our text views
    //val sampleOne: TextView? = view?.findViewById(R.id.sample_one_view)
    private var sampleTwo: TextView? = null

    private var fontValue: Int? = 0;  // The companion App will change this value, and result in different fonts

    private var viewChosen: Int? = 0    // Which view's button was pressed

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intents, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val defaultFace = android.graphics.Typeface.DEFAULT

        // Assigning TextViews by finding them in our XML layout
        //val sampleOne: TextView? = view?.findViewById(R.id.sample_one_view)
        sampleTwo = view?.findViewById(R.id.sample_two_view)

        // Setting request code values, these will be used with each text view.
        val REQUEST_ONE = 1
        val REQUEST_TWO = 2

        // Setting onClickListeners
        sample_one_view?.setOnClickListener {

            Log.i("Intent check", "TextView one pressed")
            changeFont(REQUEST_ONE)
            viewChosen = 1

        }

        sampleTwo?.setOnClickListener {
            changeFont(REQUEST_TWO)
            //
        }

        fun applyFont(fontCode: Int, viewCode: TextView) {
            when (fontCode == 1) {

            }
        }

    }

    // Function to send our intent
    fun changeFont(requestCode: Int) {

        val fontIntent = Intent(ACTION_RETRIEVE_FONT)
        //fontIntent.putExtra(EXTRA_FONT_VALUE, fontValue)

        startActivityForResult(fontIntent, requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.i("Intent check", "in Activity Result")

        fontValue = data?.getIntExtra("FONT_VALUE", 0)

        Log.i("Intent check", "fontValue should be 1, actually is: $fontValue")

        if (viewChosen == 1) {

            if (fontValue == 1) {

                Log.i("Intent check", "In if block for value of 1")

                applyFont2(sample_one_view)
                //sample_one_view.setTypeface(null, Typeface.BOLD)
                //sampleOne?.setTypeface(sampleOne.typeface, Typeface.MONOSPACE)
                //sample_one_view.setTextColor(resources.getColor(R.color.not_approved))
            }

            else if (fontValue == 2) {

                Log.i("Intent check", "In if block for value of 1")

                applyFont2(sample_one_view)
                //sample_one_view.setTypeface(null, Typeface.BOLD)
                //sampleOne?.setTypeface(sampleOne.typeface, Typeface.MONOSPACE)
                //sample_one_view.setTextColor(resources.getColor(R.color.not_approved))
            }
        }
    }

    fun applyFont2(viewCode: TextView?, fontCode: Int) {


            //viewCode.typeface = Typeface.DEFAULT
        viewCode?.setTypeface(viewCode.typeface, Typeface.BOLD)
        viewCode?.setTextColor(resources.getColor(R.color.not_approved))
            //viewCode.setTypeface(viewCode.null, android.graphics.Typeface.BOLD)
            //viewCode.setTypeface(null, 2)

    }
}
