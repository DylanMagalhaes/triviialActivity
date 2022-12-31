package com.example.trivialactivity

import android.graphics.Color
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var numberLabel: TextView
    lateinit var addButton: Button
    lateinit var deductButton: Button
    lateinit var growButton: Button
    lateinit var shrinkButton: Button
    lateinit var hideShowButton: Button
    lateinit var resetButton: Button
    lateinit var colorButton: Button

    private var count: Int = 0
    private var textSize: Float = 12.0f
    private var showHideButtonState = ShowHideButtonState.Show

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberLabel = findViewById(R.id.numberLabel)
        addButton = findViewById(R.id.addButton)
        deductButton = findViewById(R.id.deductButton)
        growButton = findViewById(R.id.growButton)
        shrinkButton = findViewById(R.id.shrinkButton)
        hideShowButton = findViewById(R.id.hideButton)
        resetButton = findViewById(R.id.resetButton)
        colorButton = findViewById(R.id.colorButton)

        addButton.setOnClickListener { showAddOne(count++) }
        deductButton.setOnClickListener { showReductOne(count--) }

        growButton.setOnClickListener { growSize() }
        shrinkButton.setOnClickListener { shrinkSize() }

        hideShowButton.setOnClickListener { onShowHideButtonClick() }
        resetButton.setOnClickListener { onResetButtonClick() }

        colorButton.setOnClickListener {
            val color = Random.nextColor()
            numberLabel.setTextColor(color)
            colorButton.setBackgroundColor(color)
        }

    }

    private fun showAddOne(count: Int) {
        numberLabel.text = "$count"
    }

    private fun showReductOne(count: Int) {
        numberLabel.text = "$count"
    }

    private fun growSize() {
        textSize += 10
        numberLabel.textSize = textSize
    }

    private fun shrinkSize() {
        textSize -= 10
        numberLabel.textSize = textSize
    }

    private fun onHideButtonClick() {
        hideNumberLabel()
        changeHideButtonToShow()
        showHideButtonState = ShowHideButtonState.Hide
    }

    private fun onShowButtonClick() {
        showNumberLabel()
        changeShowButtonToHide()
        showHideButtonState = ShowHideButtonState.Show
    }

    private fun hideNumberLabel() {
        numberLabel.visibility = INVISIBLE
    }

    private fun showNumberLabel() {
        numberLabel.visibility = VISIBLE
    }

    private fun changeHideButtonToShow() {
        hideShowButton.text = "Show"
    }

    private fun changeShowButtonToHide() {
        hideShowButton.text = "Hide"
    }

    private fun onShowHideButtonClick() {
        when (showHideButtonState) {
            ShowHideButtonState.Show -> onHideButtonClick()
            ShowHideButtonState.Hide -> onShowButtonClick()
        }
    }

    enum class ShowHideButtonState {
        Show,
        Hide
    }

    private fun onResetButtonClick() {
        count = 0
        numberLabel.text = "$count"
        textSize = 12.0f
        numberLabel.textSize = textSize

    }

    private fun Random.nextColor() =
        Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256),
        )
}





