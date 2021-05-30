package com.example.Calculadora_Bolton

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.boltonanterior.*

class boltonAnterior: Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         var view: View = inflater.inflate(R.layout.boltonanterior,container,false)

        val imagebtncalc: ImageButton = view.findViewById(R.id.imageButtonCalc)

        imagebtncalc.setOnClickListener {
            calcular()
        }
        return view

    }

    fun calcular(){
        val aux1 = editTextInf?.text.toString().toDouble()
        val aux2 = editTextSup?.text.toString().toDouble()
        val aux3 = (aux1 / aux2) * 100
        editTextResult.text = "Resultado: ${aux3}% "
    }


}