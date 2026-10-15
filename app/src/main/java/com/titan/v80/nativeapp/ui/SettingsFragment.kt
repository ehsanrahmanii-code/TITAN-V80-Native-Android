package com.titan.v80.nativeapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.titan.v80.nativeapp.R

class SettingsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_settings, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.txtSettings).text = """
            TITAN PRO V80 Native
            نسخه: 80.0.0
            حالت: Analysis-only
            موتور: Local Kotlin engine
            
            این یک اپلیکیشن بومی اندروید است
            (Kotlin + Material 3)
            نه WebView و نه Termux.
        """.trimIndent()
    }
}
