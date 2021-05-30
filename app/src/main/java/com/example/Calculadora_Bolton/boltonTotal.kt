package com.example.Calculadora_Bolton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_bolton_total.*

class boltonTotal : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.activity_bolton_total,container,false)

        val imgButton: ImageButton = view.findViewById(R.id.imageButtonCalc)

        imgButton.setOnClickListener {
            calcular()
        }

        return view




    }

    fun calcular(){
        val aux1 = editTextInf.text.toString().toFloat()
        val aux2 = editTextSup.text.toString().toFloat()
        val aux3 = (aux1 / aux2) * 100
        editTextResult.text = "Resultado: ${aux3}% "
    }
}