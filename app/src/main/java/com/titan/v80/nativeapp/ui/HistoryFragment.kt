package com.titan.v80.nativeapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.titan.v80.nativeapp.R
import com.titan.v80.nativeapp.engine.LocalAnalyzer

class HistoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_history, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.txtHistory).text =
            LocalAnalyzer.historyText()
    }

    override fun onResume() {
        super.onResume()
        view?.findViewById<TextView>(R.id.txtHistory)?.text =
            LocalAnalyzer.historyText()
    }
}
