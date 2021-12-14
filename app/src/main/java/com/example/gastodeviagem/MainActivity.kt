package com.example.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_calcular.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.bt_calcular){
            calculate()
        }
    }

    private fun calculate() {
        val distance = edt_distancia.text.toString().toFloat()
        val price = edt_preco.text.toString().toFloat()
        val autonomy = edt_autonomia.text.toString().toFloat()

        val totalValue = (distance * price) / autonomy
        tv_resultado_do_valor.text = "R$ ${"%.2f".format(totalValue)}"
    }
}