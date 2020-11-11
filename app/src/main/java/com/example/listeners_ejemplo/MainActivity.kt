package com.example.listeners_ejemplo

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.set

class MainActivity : AppCompatActivity() {
    // Dos botones ( + y - ) que al ser pulsados suman o restan
    // el valor que encontremos en el TextView.

    // Añade un EditText. Cuando el EditText tenga el focus activo,
    // los botones deben cambiar de color.

    // Cuando el focus no esté activo deben volver a su color original

    // Si el usuario escribe un número en el EditText entonces,
    // el TextView debe mostrar ese número.

    // TODO: El número que aparece en el TextView no puede ser negativo.


    // Investigar como hacer: private var colorOriginal: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAdd = findViewById<Button>(R.id.bAdd)
        val textViewNumber = findViewById<TextView>(R.id.tvNumber)
        val buttonRemove = findViewById<Button>(R.id.bRemove)
        val editTextNumero = findViewById<EditText>(R.id.etNumero)

        // Consigo el color del background actual del botón
        /*val background : Drawable = buttonAdd.background
        if (background is ColorDrawable) {
            colorOriginal = background.color
        }*/

        buttonAdd.setOnClickListener {  //it es el buttonAdd
            var numero : Int = textViewNumber.text.toString().toInt() //Asegurar que tengo un número en el TextView
            numero++
            textViewNumber.text = numero.toString()
        }

        buttonRemove.setOnClickListener {  //it es el buttonAdd
            var numero : Int = Integer.valueOf(textViewNumber.text.toString()) //Asegurar que tengo un número en el TextView
            numero--
            textViewNumber.text = numero.toString()
        }

        editTextNumero.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                buttonAdd.setBackgroundColor(Color.parseColor("#ffffff"))
            } else {
                Log.w("Comprobar si funciona", "Hola")
                buttonAdd.setBackgroundColor(Color.YELLOW)
                //buttonAdd.setBackgroundColor(colorOriginal)
            }
        }

        //Listener en TextWatcher
        editTextNumero.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                //si s no es null
                s?.let {
                    if (it.isNotEmpty())
                        textViewNumber.text = it
                }
            }
        })
    }
}