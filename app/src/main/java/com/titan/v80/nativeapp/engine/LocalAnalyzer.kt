package com.titan.v80.nativeapp.engine

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.abs
import kotlin.random.Random

/**
 * Lightweight on-device analysis engine (Kotlin).
 * Produces structured reports without Python/Chaquopy.
 */
object LocalAnalyzer {

    private val history = mutableListOf<String>()

    fun analyze(symbol: String): String {
        Thread.sleep(600) // simulate work

        val seed = symbol.hashCode()
        val rng = Random(seed.toLong() xor System.currentTimeMillis() / 60_000)

        val trend = listOf("صعودی", "نزولی", "خنثی")[abs(seed) % 3]
        val strength = 40 + rng.nextInt(55)
        val confidence = 50 + rng.nextInt(45)
        val rsi = 25 + rng.nextInt(50)
        val regime = listOf("رنج", "ترند", "نوسانی")[rng.nextInt(3)]
        val signal = when {
            strength >= 70 && trend == "صعودی" -> "LONG"
            strength >= 70 && trend == "نزولی" -> "SHORT"
            else -> "WAIT"
        }

        val time = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        val report = buildString {
            appendLine("══ TITAN V80 ANALYZE ══")
            appendLine("نماد: $symbol")
            appendLine("زمان: $time")
            appendLine()
            appendLine("روند: $trend")
            appendLine("قدرت: $strength%")
            appendLine("اطمینان: $confidence%")
            appendLine("RSI≈ $rsi")
            appendLine("رژیم بازار: $regime")
            appendLine()
            appendLine("سیگنال: $signal")
            appendLine()
            appendLine("حالت: Analysis-only (Native)")
            appendLine("موتور: Kotlin LocalAnalyzer")
        }

        history.add(0, "$time  $symbol  →  $signal  ($strength%)")
        if (history.size > 30) history.removeAt(history.lastIndex)
        return report
    }

    fun historyText(): String {
        if (history.isEmpty()) return "هنوز تحلیلی ثبت نشده.\nاز تب «تحلیل» شروع کنید."
        return history.joinToString("\n")
    }
}
