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
    private var counter1 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)
// tvResult პოულობს ტექსტვიუს აიდით და იძახებს მას

    }

    fun numberclick(clickedView: View) {

        if (clickedView is TextView) {
            text = tvResult.text.toString()
            // tv.Result ზევით ჩაწერილი tvResult = findViewById(R.id.tvResult) კოდის მეშვეობით
            //პოულობს იმ Textview-ს სადაც თავდაპირველად გვიწერია 0 და ამ 0-ს სტრინგის ტიპის ობიექტად აქცევს
            // და გამოდის რომ text არის "0"

            number = clickedView.text.toString()

            // იმ View-ს ,რომელსაც მომხმარებელი დააჭერს იმის ტექსტი გადადის სტრინგში და ეს მნიშვნელობა ენიჭება number-ს
            //ანუ თუ იმ Textview-ს დავაჭერთ, რომელის ტექსტშიც წერია 8 მაშინ number იიღებს 8-ის მნიშვნელობას

            if (text == "0"){
                text = ""
                //თუ თექსტი არის 0 მაშინ ტექსტი მთლიანად იშლება და ხდება ცარიელი სტრინგი
            }

            val result = text + number
            //აქ ცარიელ სტრინგს მიემატება სტრინგი number
            tvResult.text = result
            // და Textview-ში რომლის აიდიცაა tv.Result მაგაში ტესტის ადგილას გამოისახება result
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

        // counter1 ++

        if (clickedView is TextView ) {
            if (tvResult.text.toString() != "") {
                operand = tvResult.text.toString().toDouble()
                operation = clickedView.text.toString()
                tvResult.text = ""
                //carielis gadayvanas cdilobs doubleshi da imitom icrasheba
            } else {

                //operation = ""
                //if (clickedView is TextView){
                // operation = clickedView.text.toString()
                operation = clickedView.text.toString()
            }


            //equalclick(clickedView)//equals click crashavs radgan iqac carielis gadayvanas cdilobs doublshi
            //counter1 = 0

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

        }
    }

    fun clear(clickedView: View) {
        tvResult.text = "0"
        //counter1 = 0
        operation = ""
        operand = 0.0
        number = "0"
    }
    fun delastclick(clickedView: View){

        if (clickedView is TextView){
            if(tvResult.text != "") {
// != არ უდრის
                tvResult.text = tvResult.text.dropLast(1) // წაუშლის ბოლო 1-ს
            }
        }
    }

}
