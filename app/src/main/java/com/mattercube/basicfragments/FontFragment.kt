package com.mattercube.basicfragments


import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_font.*

// @Author: R Khamov

class FontFragment : Fragment() {

    /*******Defining all the style values********************************************************/

    // Defining all of the typeFace values
    val defaultFace = android.graphics.Typeface.DEFAULT
    val monoFace = android.graphics.Typeface.MONOSPACE
    val serifFace = android.graphics.Typeface.SERIF

    // Defning all of the style values
    val normalStyle = android.graphics.Typeface.NORMAL
    val boldStyle = android.graphics.Typeface.BOLD
    val italicStyle = android.graphics.Typeface.ITALIC

    val appDefaultTypeface = getCurrentTypeface(font_fragment_description)
    // We will be changing this frequently, but mind as well initialize now
    var currentTypeface = getCurrentTypeface(font_fragment_description)

    // Getting text sizes
    val medium = style_view.textSize
    val small = medium * .5
    val large = medium * 2

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
            type_face_view.setTypeface(appDefaultTypeface)
            style_view.setTypeface(appDefaultTypeface)
            size_view.setTypeface(appDefaultTypeface)
            color_view.setTypeface(appDefaultTypeface)
        }
        monospaceButton?.setOnClickListener {
            type_face_view.setTypeface(monoFace)
            style_view.setTypeface(monoFace)
            size_view.setTypeface(monoFace)
            color_view.setTypeface(monoFace)
        }
        serifButton?.setOnClickListener {
            type_face_view.setTypeface(serifFace)
            style_view.setTypeface(serifFace)
            size_view.setTypeface(serifFace)
            color_view.setTypeface(serifFace)
        }
        // Style Listeners
        normalButton?.setOnClickListener {

            currentTypeface = getCurrentTypeface(type_face_view)

            type_face_view.setTypeface(currentTypeface, normalStyle)
            style_view.setTypeface(currentTypeface , normalStyle)
            size_view.setTypeface(currentTypeface , normalStyle)
            color_view.setTypeface(currentTypeface , normalStyle)
        }
        boldButton?.setOnClickListener {

            currentTypeface = getCurrentTypeface(type_face_view)

            type_face_view.setTypeface(currentTypeface ,boldStyle)
            style_view.setTypeface(currentTypeface ,boldStyle)
            size_view.setTypeface(currentTypeface ,boldStyle)
            color_view.setTypeface(currentTypeface ,boldStyle)
        }
        italicButton?.setOnClickListener {
            type_face_view.setTypeface(currentTypeface , italicStyle)
            style_view.setTypeface(currentTypeface , italicStyle)
            size_view.setTypeface(currentTypeface , italicStyle)
            color_view.setTypeface(currentTypeface , italicStyle)
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

    fun getCurrentTypeface(thisView: TextView?): Typeface? {
        return thisView?.typeface
    }

}
