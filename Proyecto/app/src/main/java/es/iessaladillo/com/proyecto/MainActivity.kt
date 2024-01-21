package es.iessaladillo.com.proyecto
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.iessaladillo.com.proyecto.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViews()
    }

    private fun setUpViews() {
        binding.txt1.text = "Hola Mundo"
    }
}