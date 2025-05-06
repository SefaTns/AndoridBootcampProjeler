package com.example.navigationcomponentkullanimi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationcomponentkullanimi.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {

    private lateinit var binding:FragmentAnasayfaBinding
    // layout dosyasındaki fragment_anasayfa.xml dosyasına bağlanmak için kullanılır.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)
        // inflate metodu, View Binding'in layout dosyasını bağlayarak (inflate ederek) bir FragmentAnasayfaBinding nesnesi oluşturmasını sağlar.

        binding.buttonDetay.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(mesaj = "Nasılsın", sayi = 99)
            // Directions yapısı veri gönderelicek sayfanın yapısını tanımlar
            Navigation.findNavController(it).navigate(gecis)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Uygulamayı çalıştırdığımızda 1 kere çalışır.
        Log.e("Yaşam Döngüsü", "onCreate")
    }

    override fun onResume() {
        super.onResume()
        //Sayfa her göründüğünde çalışır.
        //Bu sayfaya geri dönüldüğünde çalışır.
        Log.e("Yaşam Döngüsü", "onResume")
    }

    override fun onPause() {
        super.onPause()
        //Sayfa her görünmez olduğunda çalışır.
        Log.e("Yaşam Döngüsü", "onPause")
    }
}