package es.iessaladillo.com.proyecto.view.ui.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import es.iessaladillo.com.proyecto.R
import es.iessaladillo.com.proyecto.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
        loadFragment(HomeFragment.newInstance())
    }
    private fun setupViews() {
        configureBottomNavigationView()
    }

    private fun configureBottomNavigationView() {
        binding.bottomBar.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.home -> {
                    loadFragment(HomeFragment.newInstance())
                    true
                }
                R.id.battle -> {
                    loadFragment(BattleFragment.newInstance())
                    true
                }
                R.id.info -> {
                    loadFragment(InfoFragment.newInstance())
                    true}
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}