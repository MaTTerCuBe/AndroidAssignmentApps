package com.mattercube.basicfragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val ACTION_RETRIEVE_FONT = "com.mattercube.basicfragments.RETRIEVE_FONT"

class IntentsFragment : Fragment() {

    // defining our text views
    private var sampleOne: TextView? = null
    private var sampleTwo: TextView? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intents, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Assigning TextViews by finding them in our XML layout
        sampleOne = view?.findViewById(R.id.sample_one_view)
        sampleTwo = view?.findViewById(R.id.sample_two_view)

        // Setting onClickListeners
        sampleOne?.setOnClickListener {

        }

        sampleTwo?.setOnClickListener {

        }

        // Function to send our intent
        fun changeFont() {

            val fontIntent = Intent(ACTION_RETRIEVE_FONT)
        }
    }
}
