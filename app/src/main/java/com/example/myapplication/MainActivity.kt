package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvClear: TextView
    private var operand = 0.0
    private var operation = ""
    private var text = ""
    private var number = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)

    }

    fun numberclick(clickedView: View) {

        if (clickedView is TextView) {
            text = tvResult.text.toString()

            number = clickedView.text.toString()

            if (text == "0"){
                text = ""
            }

            val result = text + number
            tvResult.text = result
        }
    }

    fun pointclick (clickedView: View){
        if (clickedView is TextView){
            if (tvResult.text.toString() != ""){

                tvResult.text = text + number + "."

                var counter = 0

                for (a in tvResult.text) {
                    if (a == '.') {
                        counter ++
                    }

                    if(counter >= 2){
                        Toast.makeText(this, "araswori ricxvi", Toast.LENGTH_SHORT).show()
                        tvResult.text = tvResult.text.dropLast(1)
                    }
                }
            } else {
                tvResult.text= "0."
            }
        }
    }

    fun operationclick(clickedView: View){


        if (clickedView is TextView ) {
            if (tvResult.text.toString() != "") {
                operand = tvResult.text.toString().toDouble()
                operation = clickedView.text.toString()
                tvResult.text = ""
            } else {

                operation = clickedView.text.toString()
            }


        }

    }

    fun equalclick (clickedView: View) {

        if (tvResult.text == "") {

            Toast.makeText(this, "araswori operacia", Toast.LENGTH_SHORT).show()
            clear(clickedView)
        } else {

            val secondOperand = tvResult.text.toString().toDouble()
            when (operation) {
                "+" -> tvResult.text = (operand + secondOperand).toString()
                "-" -> tvResult.text = (operand - secondOperand).toString()
                "*" -> tvResult.text = (operand * secondOperand).toString()
                "/" -> tvResult.text = (operand / secondOperand).toString()
            }

            if (tvResult.text.toString().takeLast(2) == ".0") {
                tvResult.text = tvResult.text.toString().dropLast(2)
            }

            operation = ""
            operand = 0.0
            number = "0"
            text = ""
        }
    }

    fun clear(clickedView: View) {
        tvResult.text = "0"
        operation = ""
        operand = 0.0
        number = "0"
        text = ""
    }
    fun delastclick(clickedView: View){

        if (clickedView is TextView){
            if(tvResult.text != "") {

                tvResult.text = tvResult.text.dropLast(1) 
            }
        }
    }

}
