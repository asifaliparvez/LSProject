package com.example.lsproject.Package

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lsproject.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.firebase.database.collection.LLRBNode

class BarChartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_barchart, container, false)
        val barChart = rootView.findViewById<BarChart>(R.id.barChart)
        setupBarChart(barChart)
        return rootView
    }

    private fun setupBarChart(barChart: BarChart) {
        val entries = listOf(
            BarEntry(1f, 10f),
            BarEntry(2f, 20f),
            BarEntry(3f, 30f),
            BarEntry(4f, 40f)
        )

        val dataSet = BarDataSet(entries, "Number repeated series")
        val data = BarData(dataSet)
        barChart.data = data

        // Customize chart appearance
        barChart.setDrawGridBackground(false)
        barChart.setDrawBorders(false)
        barChart.description.isEnabled = true
        barChart.description.text="THIS NUMBER PLAYED MOST"
      barChart.description.textSize= 12f
        barChart.description.textColor = Color.BLACK
        barChart.legend.isEnabled = false
        barChart.xAxis.isEnabled = false
        barChart.axisLeft.setDrawGridLines(false)
        barChart.axisRight.setDrawGridLines(false)

        barChart.invalidate() // Refreshes the chart
    }
}

