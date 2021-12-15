package com.example.gastodeviagem

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_calcular.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.bt_calcular) {
            calculate()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calculate() {
        if (validationOk()) {
            try {
                val distance = edt_distancia.text.toString().toFloat()
                val price = edt_preco.text.toString().toFloat()
                val autonomy = edt_autonomia.text.toString().toFloat()

                val totalValue = (distance * price) / autonomy
                if (totalValue == Float.POSITIVE_INFINITY || totalValue == Float.NEGATIVE_INFINITY){
                    throw ArithmeticException()
                }
                tv_resultado_do_valor.text = "R$ ${"%.2f".format(totalValue)}"
            } catch (ae: ArithmeticException){
                Toast.makeText(this, getString(R.string.campos_validos), Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, getString(R.string.preencher_campos), Toast.LENGTH_LONG).show()
        }
    }

    private fun validationOk(): Boolean {
        return (edt_distancia.text.toString() != ""
                && edt_preco.text.toString() != ""
                && edt_autonomia.text.toString() != "")
    }
}