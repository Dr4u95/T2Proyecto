package es.iessaladillo.com.proyecto.view.ui.character_list

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import es.iessaladillo.com.proyecto.model.CharacterAdapter
import es.iessaladillo.com.proyecto.databinding.ActivityCharacterBinding
import es.iessaladillo.com.proyecto.model.UserCharacter
import es.iessaladillo.com.proyecto.model.UserCharacterProvider
import es.iessaladillo.com.proyecto.view.ui.create_character.CreateCharacterActivity
class CharacterActivity : AppCompatActivity() {
    companion object {
        const val KEY_EMAIL : String = "EMAIL"
    }
    private lateinit var binding: ActivityCharacterBinding
    private lateinit var userList: MutableList<UserCharacter>
    private lateinit var adapter: CharacterAdapter
    private lateinit var email:String
    private val startForResult: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            if(result.data!=null && result.data!!.getParcelableExtra<UserCharacter>(CreateCharacterActivity.KEY_CHARACTER)!=null){
                val character:UserCharacter = result.data!!.getParcelableExtra(CreateCharacterActivity.KEY_CHARACTER)!!
                addToList(character)
            }
        }
    }
    private fun addToList(character: UserCharacter) {
        userList.add(character)
        adapter.notifyItemInserted(userList.size-1)
        isEmptyList()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentInfo()
        binding.btnAdd.setOnClickListener{
            createUser()
        }
    }
    private fun createUser() {
        val intent = Intent(this, CreateCharacterActivity::class.java)
        intent.putExtra(KEY_EMAIL,email)
        startForResult.launch(intent)
    }
    private fun getIntentInfo() {
         email = intent.getStringExtra("user_email").toString()
        initRecyclerView(email)
    }
    private fun initRecyclerView(email:String){
        if(UserCharacterProvider.filterCharactersByEmail(email).isEmpty()){
            binding.emptyListTextView.visibility = View.VISIBLE
        }else{
            binding.emptyListTextView.visibility = View.GONE
        }
        userList = UserCharacterProvider.filterCharactersByEmail(email).toMutableList()
        adapter = CharacterAdapter(
            userList,
            { character -> onItemSelected(character) },
            { characterPosition -> onItemDeleted(characterPosition) },)
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this,manager.orientation)
        binding.RecyclerCharacter.addItemDecoration(decoration)
        binding.RecyclerCharacter.layoutManager = manager
        binding.RecyclerCharacter.adapter = adapter
    }
    private fun onItemSelected(character: UserCharacter) {
        Toast.makeText(this,character.name,Toast.LENGTH_SHORT).show()
    }
    private fun onItemDeleted(position:Int){
        userList.removeAt(position)
        adapter.notifyItemRemoved(position)
        isEmptyList()
    }
    private fun isEmptyList(){
        if(userList.isEmpty()){
            binding.emptyListTextView.visibility = View.VISIBLE
        }else{
            binding.emptyListTextView.visibility = View.GONE
        }
    }
}

