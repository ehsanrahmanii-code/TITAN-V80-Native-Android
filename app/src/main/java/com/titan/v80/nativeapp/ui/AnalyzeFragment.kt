package com.titan.v80.nativeapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.titan.v80.nativeapp.R
import com.titan.v80.nativeapp.engine.LocalAnalyzer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AnalyzeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_analyze, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val input = view.findViewById<EditText>(R.id.edtSymbol)
        val btn = view.findViewById<Button>(R.id.btnAnalyze)
        val result = view.findViewById<TextView>(R.id.txtResult)
        val progress = view.findViewById<ProgressBar>(R.id.progress)

        btn.setOnClickListener {
            val symbol = input.text.toString().trim().uppercase().ifEmpty { "BTCUSDT" }
            progress.visibility = View.VISIBLE
            result.text = "در حال تحلیل $symbol …"
            viewLifecycleOwner.lifecycleScope.launch {
                val report = withContext(Dispatchers.Default) {
                    LocalAnalyzer.analyze(symbol)
                }
                progress.visibility = View.GONE
                result.text = report
            }
        }
    }
}
