package es.iessaladillo.com.proyecto.view.ui.create_character

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import android.widget.Toast
import es.iessaladillo.com.proyecto.R
import es.iessaladillo.com.proyecto.databinding.ActivityCreateCharacterBinding
import es.iessaladillo.com.proyecto.model.UserCharacter
import es.iessaladillo.com.proyecto.view.ui.character_list.CharacterActivity

class CreateCharacterActivity : AppCompatActivity() {
    companion object {
        const val KEY_CHARACTER :String = "CHARACTER"
    }
    private lateinit var binding: ActivityCreateCharacterBinding
    private lateinit var email:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViews()
    }
    private fun setUpViews() {
        getIntentInfo()
        configureAutoComplete()
        configureMultiAutoComplete()
        configureNumberPicker()
        configureRatingBar()
        configureBtnExit()
    }

    private fun configureRatingBar() {
        binding.ratingValorCabeza.setOnRatingBarChangeListener{ _, rating, _ ->
            Toast.makeText(this, "El valor de su cabeza es: $rating",Toast.LENGTH_SHORT).show()
        }
    }

    private fun configureBtnExit() {
        binding.btnAddandExit.setOnClickListener{
            val intent = Intent()
            val name:String = binding.nameCharacterInputLayout.editText?.text.toString()
            if(name.isEmpty()){
                Toast.makeText(this,"Introduzca un nombre",Toast.LENGTH_SHORT).show()
            }else{
                intent.putExtra(KEY_CHARACTER,UserCharacter(name,email))
                setResult(RESULT_OK,intent)
                finish()
            }
        }
    }
    private fun configureNumberPicker() {
        with(binding){
            nPickerAltura.minValue = 90
            nPickerAltura.maxValue = 228
            nPickerAltura.value = 170
            nPickerPeso.minValue = 20
            nPickerPeso.maxValue = 300
            nPickerPeso.value = 100
        }

    }
    private fun configureMultiAutoComplete() {
        val armamentoArray:Array<String> = resources.getStringArray(R.array.armamento_star_wars)
        val adapterArmamento = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,armamentoArray)
        binding.atvArmamento.setAdapter(adapterArmamento)
        binding.atvArmamento.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
    }

    private fun configureAutoComplete() {
        val mundosArray:Array<String> = resources.getStringArray(R.array.mundos_star_wars)
        val adapaterMundos = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,mundosArray)
        binding.atvMundoNatal.setAdapter(adapaterMundos)
    }

    private fun getIntentInfo() {
        email = intent.getStringExtra(CharacterActivity.KEY_EMAIL).toString()
    }
}