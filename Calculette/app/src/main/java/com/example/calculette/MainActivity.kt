package com.example.calculatrice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.calculette.R
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    lateinit var calcule: TextView
    lateinit var affichage: TextView
    lateinit var button0: Button
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button
    lateinit var button7: Button
    lateinit var button8: Button
    lateinit var button9: Button
    lateinit var button14: Button
    lateinit var buttonequal: Button
    lateinit var buttonadd: Button
    lateinit var buttonsub: Button
    lateinit var buttonmul: Button
    lateinit var buttondiv: Button
    lateinit var buttonclear: Button
    lateinit var buttonopen: Button
    lateinit var buttonclose: Button
    lateinit var buttonback: Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button0 = findViewById(R.id.button15)
        button1 = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonadd = findViewById(R.id.button10)
        buttonsub = findViewById(R.id.button11)
        buttonmul = findViewById(R.id.button12)
        buttondiv = findViewById(R.id.button13)
        button14 = findViewById(R.id.button14)
        buttonequal = findViewById(R.id.button16)
        buttonclear = findViewById(R.id.buttonclear)
        buttonclose = findViewById(R.id.buttonclose)
        buttonopen = findViewById(R.id.buttonopen)
        buttonback = findViewById(R.id.buttonback)

        affichage = findViewById(R.id.textView)
        calcule = findViewById(R.id.editText)


        // click listener
        button0.setOnClickListener { appendOnExpression("0") }
        button1.setOnClickListener { appendOnExpression("1") }
        button2.setOnClickListener { appendOnExpression("2") }
        button3.setOnClickListener { appendOnExpression("3") }
        button4.setOnClickListener { appendOnExpression("4") }
        button5.setOnClickListener { appendOnExpression("5") }
        button6.setOnClickListener { appendOnExpression("6") }
        button7.setOnClickListener { appendOnExpression("7") }
        button8.setOnClickListener { appendOnExpression("8") }
        button9.setOnClickListener { appendOnExpression("9") }
        button14.setOnClickListener { appendOnExpression(".") }
        buttonadd.setOnClickListener { appendOnExpression("+") }
        buttonsub.setOnClickListener { appendOnExpression("-") }
        buttonmul.setOnClickListener { appendOnExpression("*") }
        buttondiv.setOnClickListener { appendOnExpression("/") }
        buttonopen.setOnClickListener { appendOnExpression("(") }
        buttonclose.setOnClickListener { appendOnExpression(")") }

        buttonclear.setOnClickListener{
            affichage.text = ""
            calcule.text = ""
        }

        buttonback.setOnClickListener{
            val string = calcule.text.toString()
            if(string.isNotEmpty()){
                calcule.text = string.substring(0,string.length-1)
            }
            affichage.text = ""
        }
        

        buttonequal.setOnClickListener{

            try{
                val expression = ExpressionBuilder(calcule.text.toString()).build()
                val resultat = expression.evaluate()
                affichage.text = resultat.toString()
            }catch (e:Exception){
                Log.d("Exception","message"+e.message)
            }


        }


    }

    /*private fun onClick(view: View){
        if(view is Button){

           calcule.text.toString() + view.text
        }


    }*/

    fun appendOnExpression(str:String){

        if(affichage.text == ""){
            calcule.append(str)
        }
        else {
            if(str == "+" || str == "-" || str == "*" || str == "/"){
                calcule.text = ""
                calcule.append(affichage.text)
                calcule.append(str)
                affichage.text = ""
            }
            else {
                calcule.text = ""
                affichage.text = ""
                calcule.append(str)
            }
        }




    }



}
