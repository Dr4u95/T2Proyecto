package es.iessaladillo.com.proyecto.view.ui.register_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.fragment.app.Fragment
import es.iessaladillo.com.proyecto.R
import es.iessaladillo.com.proyecto.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViews()
        loadFragment(LoginFragment.newInstance())
    }
    private fun setUpViews() {
        binding.tbtnLoginRegister.setOnCheckedChangeListener {_,isChecked ->
            if (isChecked){
                loadFragment(LoginFragment.newInstance())
            }else{
                loadFragment(RegisterFragment.newInstance())
            }
        }
        binding.switchNightMode.setOnCheckedChangeListener{_,isChecked ->
            if (isChecked){
                enableDarkMode()
            }else {
                disableDarkMode()
            }

        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

    private fun enableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        delegate.applyDayNight()
    }

    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        delegate.applyDayNight()

    }
}