package com.example.turkcelladapterandspinnerlab

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.turkcelladapterandspinnerlab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  val ilListesi: ArrayList<String> = arrayListOf("Malatya", "Elazig", "Kayseri")
        // val adapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, ilListesi)

        // 1.yol yukaridaki gibi arrayListi buradan tanımlamak.
        // 2.yol string.xml içinden arrayList tanımlayıp çağırmak.
        val adapter = ArrayAdapter.createFromResource(
            this, R.array.ilList, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        )
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "Seçilen Eleman ${binding.spinner.selectedItem}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }


        }
    }


}