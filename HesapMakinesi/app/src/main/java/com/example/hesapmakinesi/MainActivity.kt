package com.example.hesapmakinesi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hesapmakinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var birinciSayi: Double = 0.0
    private var ikinciSayi: Double = 0.0
    private var yedekText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewSonuc.text = "0"

        binding.buttonSifir.setOnClickListener {sayiEkle("0")}
        binding.buttonBir.setOnClickListener {sayiEkle("1")}
        binding.buttonIki.setOnClickListener {sayiEkle("2")}
        binding.buttonUc.setOnClickListener {sayiEkle("3")}
        binding.buttonDort.setOnClickListener {sayiEkle("4")}
        binding.buttonBes.setOnClickListener {sayiEkle("5")}
        binding.buttonAlti.setOnClickListener {sayiEkle("6")}
        binding.buttonYedi.setOnClickListener {sayiEkle("7")}
        binding.buttonSekiz.setOnClickListener {sayiEkle("8")}
        binding.buttonDokuz.setOnClickListener {sayiEkle("9")}

        binding.buttonTemizle.setOnClickListener {
            this.birinciSayi = 0.0
            this.ikinciSayi = 0.0
            this.yedekText = ""
            binding.textViewSonuc.text = "0"
        }

        binding.buttonTopla.setOnClickListener {
            if(yedekText.isNotEmpty()) {

                this.birinciSayi += yedekText.toDouble()
                this.yedekText = ""


                binding.textViewSonuc.text = "$birinciSayi +"

            }
        }

        binding.buttonSonuc.setOnClickListener {
            if(yedekText.isNotEmpty()) {
                this.ikinciSayi = yedekText.toDouble()
                this.birinciSayi += ikinciSayi
                this.yedekText = "$birinciSayi"
                binding.textViewSonuc.text = "$yedekText"
            }
        }

        binding.buttonSil.setOnClickListener {
            if(yedekText.isNotEmpty()) {
                this.yedekText = yedekText.dropLast(1)
            }
            binding.textViewSonuc.text = this.yedekText
        }

    }

    private fun sayiEkle(number: String) {

        this.yedekText += number
        binding.textViewSonuc.text = yedekText
    }
}