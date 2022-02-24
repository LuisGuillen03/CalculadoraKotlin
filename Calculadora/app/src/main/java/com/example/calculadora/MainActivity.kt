package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int=0
    private var cantsig: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        uno.setOnClickListener { numeroPresionado("1") }
        dos.setOnClickListener { numeroPresionado("2") }
        tres.setOnClickListener { numeroPresionado("3") }
        cuatro.setOnClickListener { numeroPresionado("4") }
        cinco.setOnClickListener { numeroPresionado("5") }
        seis.setOnClickListener { numeroPresionado("6") }
        siete.setOnClickListener { numeroPresionado("7") }
        ocho.setOnClickListener { numeroPresionado("8") }
        nueve.setOnClickListener { numeroPresionado("9") }
        cero.setOnClickListener { numeroPresionado("0") }

        mas.setOnClickListener{operacionPresionada(SUMA)}
        menos.setOnClickListener{operacionPresionada(RESTA)}
        por.setOnClickListener{operacionPresionada(MULTI)}
        entre.setOnClickListener{operacionPresionada(DIVI)}

        clear.setOnClickListener{
            num1=0.0
            num2=0.0
            result.text=""
            operacion= VACIO
        }

        igual.setOnClickListener {
            var result= when(operacion){
                SUMA -> num1+num2
                RESTA->num1 - num2
                MULTI -> num1 * num2
                DIVI -> num1/num2
                else ->0
            }
            proceso.text=""
            this.result.text= result.toString()
            num1=this.result.text.toString().toDouble()
            operacion=VACIO
        }

    }
    private fun numeroPresionado(digito: String){
        result?.text= "${result?.text}$digito"
        if(operacion== VACIO){
            num1=result.text.toString().toDouble()
            proceso?.text= "${proceso?.text}$num1"
        }
        else
            num2=result.text.toString().toDouble()
            proceso?.text= "${proceso?.text}$num2"
    }
    private fun operacionPresionada(operacion: Int){
        this.operacion=operacion
        var signo="";
        if (operacion==1) signo= "+"
        else if (operacion==2) signo= "-"
        else if (operacion==3) signo= "*"
        else signo= "/"
        proceso?.text= "${proceso?.text}$signo"
        result.text=""
    }
    companion object{
        const val SUMA=1
        const val RESTA=2
        const val MULTI=3
        const val DIVI=4
        const val VACIO=0
    }
}