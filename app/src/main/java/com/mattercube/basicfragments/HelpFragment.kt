package com.mattercube.basicfragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.RenderProcessGoneDetail
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_help.*

class HelpFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        
        var isHidden = false

        hide_button.setOnClickListener {
            if (!isHidden) {
                app_description.visibility = View.INVISIBLE
                isHidden = true
            }

            else {
                app_description.visibility = View.VISIBLE
                isHidden = false
            }
        }
    }
}
