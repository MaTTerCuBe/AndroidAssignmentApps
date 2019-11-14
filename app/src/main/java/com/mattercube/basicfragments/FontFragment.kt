package com.mattercube.basicfragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_font.*

// @Author: R Khamov

class FontFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_font, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

     /*******Defining all the buttons ************************************************************/

        //TypeFace buttons
        val defaultButton: Button? = view!!.findViewById(R.id.default_button)
        val monospaceButton: Button? = view!!.findViewById(R.id.monospace_button)
        val serifButton: Button? = view!!.findViewById(R.id.serif_button)
        // Style Buttons
        val normalButton: Button? = view!!.findViewById(R.id.normal_button)
        val boldButton: Button? = view!!.findViewById(R.id.bold_button)
        val italicButton: Button? = view!!.findViewById(R.id.default_button)
        // Size Buttons
        val smallButton: Button? = view!!.findViewById(R.id.small_button)
        val mediumButton: Button? = view!!.findViewById(R.id.medium_button)
        val largeButton: Button? = view!!.findViewById(R.id.large_button)
        // Color Buttons
        val blackButton: Button? = view!!.findViewById(R.id.black_button)
        val greentButton: Button? = view!!.findViewById(R.id.green_button)
        val redButton: Button? = view!!.findViewById(R.id.red_button)

     /*************************all the listeners**************************************************/

        // TypeFace Listeners
        defaultButton?.setOnClickListener {
            type_face_view.setTypeface(android.graphics.Typeface.DEFAULT)
            style_view.setTypeface(android.graphics.Typeface.DEFAULT)
            size_view.setTypeface(android.graphics.Typeface.DEFAULT)
            color_view.setTypeface(android.graphics.Typeface.DEFAULT)
        }
        monospaceButton?.setOnClickListener {
            type_face_view.setTypeface(android.graphics.Typeface.MONOSPACE)
            style_view.setTypeface(android.graphics.Typeface.MONOSPACE)
            size_view.setTypeface(android.graphics.Typeface.MONOSPACE)
            color_view.setTypeface(android.graphics.Typeface.MONOSPACE)
        }
        serifButton?.setOnClickListener {
            type_face_view.setTypeface(android.graphics.Typeface.SERIF)
            style_view.setTypeface(android.graphics.Typeface.SERIF)
            size_view.setTypeface(android.graphics.Typeface.SERIF)
            color_view.setTypeface(android.graphics.Typeface.SERIF)
        }
        // Style Listeners
        normalButton?.setOnClickListener {
            
        }
        boldButton?.setOnClickListener {

        }
        italicButton?.setOnClickListener {

        }
        // Size Listeners
        smallButton?.setOnClickListener {

        }
        mediumButton?.setOnClickListener {

        }
        largeButton?.setOnClickListener {

        }
        // Color Listeners
        blackButton?.setOnClickListener {

        }
        greentButton?.setOnClickListener {

        }
        redButton?.setOnClickListener {

        }
    }
}
