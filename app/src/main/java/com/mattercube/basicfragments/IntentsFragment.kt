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

        // Setting request code values, these will be used with each text view.
        val REQUEST_ONE = 1
        val REQUEST_TWO = 2

        // Setting onClickListeners
        sample_one_view?.setOnClickListener {

            Log.i("Intent check", "TextView one pressed")
            changeFont(REQUEST_ONE)
            viewChosen = 1

        }

        sample_two_view?.setOnClickListener {
            changeFont(REQUEST_TWO)
            viewChosen = 2
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
            applyFont(sample_one_view, fontValue)
        }
        else if (viewChosen == 2) {
            applyFont(sample_two_view, fontValue)
        }
    }

    fun applyFont(viewCode: TextView?, fontCode: Int?) {

        if (fontCode == 1) {
            //viewCode.typeface = Typeface.DEFAULT
            viewCode?.setTypeface(viewCode.typeface, Typeface.BOLD)
            viewCode?.setTextColor(resources.getColor(R.color.not_approved))
            viewCode?.text = getString(R.string.style_one_text)
            //viewCode.setTypeface(null, 2)
        }

        else if (fontCode == 2) {
            //viewCode.typeface = Typeface.DEFAULT
            viewCode?.setTypeface(viewCode.typeface, Typeface.ITALIC)
            viewCode?.setTextColor(resources.getColor(R.color.approved))
            viewCode?.text = getString(R.string.style_two_text)
        }

        else {
            viewCode?.setTypeface(viewCode.typeface, Typeface.BOLD_ITALIC)
            viewCode?.setTextColor(resources.getColor(R.color.colorPrimaryDark))
            viewCode?.text = getString(R.string.style_three_text)
        }

    }
}
