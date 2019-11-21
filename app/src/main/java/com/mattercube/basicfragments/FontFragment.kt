package com.mattercube.basicfragments


import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
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

        /*******Defining all the style values********************************************************/

        // Defining all of the typeFace values
        val defaultFace = android.graphics.Typeface.DEFAULT
        val monoFace = android.graphics.Typeface.MONOSPACE
        val serifFace = android.graphics.Typeface.SERIF

        // Defining all of the style values
        val normalStyle = Typeface.NORMAL
        val boldStyle = android.graphics.Typeface.BOLD
        val italicStyle = android.graphics.Typeface.ITALIC

        val appDefaultTypeface = getCurrentTypeface(font_fragment_description)  // This is an attempt to resolve the fact that DEFAULT doesn't change serif...
        // We will be changing this frequently, but mind as well initialize now
        var currentTypeface = getCurrentTypeface(font_fragment_description)

        // Defining text sizes
        val medium = style_view.textSize
        val small = medium / 2
        val large = medium * 2

        // Defining our Colors
        val black = resources.getColor(R.color.android_default)
        val green = resources.getColor(R.color.approved)
        val red =   resources.getColor(R.color.not_approved)

     /*******Defining all the buttons ************************************************************/

        //TypeFace buttons
        val defaultButton: Button? = view!!.findViewById(R.id.default_button)
        val monospaceButton: Button? = view!!.findViewById(R.id.monospace_button)
        val serifButton: Button? = view!!.findViewById(R.id.serif_button)
        // Style Buttons
        val normalButton: Button? = view!!.findViewById(R.id.normal_button)
        val boldButton: Button? = view!!.findViewById(R.id.bold_button)
        val italicButton: Button? = view!!.findViewById(R.id.italic_button)
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

            currentTypeface = getCurrentTypeface(type_face_view)

            type_face_view.setTypeface(defaultFace)
            style_view.setTypeface(defaultFace)
            size_view.setTypeface(defaultFace)
            color_view.setTypeface(defaultFace)
        }
        monospaceButton?.setOnClickListener {

            currentTypeface = getCurrentTypeface(type_face_view)

            type_face_view.setTypeface(monoFace)
            style_view.setTypeface(monoFace)
            size_view.setTypeface(monoFace)
            color_view.setTypeface(monoFace)
        }
        serifButton?.setOnClickListener {

            currentTypeface = getCurrentTypeface(type_face_view)

            type_face_view.setTypeface(serifFace)
            style_view.setTypeface(serifFace)
            size_view.setTypeface(serifFace)
            color_view.setTypeface(serifFace)
        }
        // Style Listeners
        normalButton?.setOnClickListener {

            currentTypeface = getCurrentTypeface(type_face_view)
            Log.i("ButtonTest", "Normal Button")

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

            currentTypeface = getCurrentTypeface(type_face_view)

            type_face_view.setTypeface(currentTypeface , italicStyle)
            style_view.setTypeface(currentTypeface , italicStyle)
            size_view.setTypeface(currentTypeface , italicStyle)
            color_view.setTypeface(currentTypeface , italicStyle)
        }
        // Size Listeners
        smallButton?.setOnClickListener {
            type_face_view.textSize = small
            style_view.textSize = small
            size_view.textSize = small
            color_view.textSize = small
        }
        mediumButton?.setOnClickListener {
            type_face_view.textSize = medium
            style_view.textSize = medium
            size_view.textSize = medium
            color_view.textSize = medium
        }
        largeButton?.setOnClickListener {
            type_face_view.textSize = large
            style_view.textSize = large
            size_view.textSize = large
            color_view.textSize = large
        }
        // Color Listeners
        blackButton?.setOnClickListener {
            type_face_view.setTextColor(black)
            style_view.setTextColor(black)
            size_view.setTextColor(black)
            color_view.setTextColor(black)
        }
        greentButton?.setOnClickListener {
            type_face_view.setTextColor(green)
            style_view.setTextColor(green)
            size_view.setTextColor(green)
            color_view.setTextColor(green)
        }
        redButton?.setOnClickListener {
            type_face_view.setTextColor(red)
            style_view.setTextColor(red)
            size_view.setTextColor(red)
            color_view.setTextColor(red)
        }
    }

    fun getCurrentTypeface(thisView: TextView?): Typeface? {
        return thisView?.typeface
    }

}
