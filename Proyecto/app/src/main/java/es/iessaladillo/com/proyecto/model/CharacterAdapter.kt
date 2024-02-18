package es.iessaladillo.com.proyecto.model

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.iessaladillo.com.proyecto.R
import es.iessaladillo.com.proyecto.databinding.ItemCharacterBinding
import es.iessaladillo.com.proyecto.view.ui.app.AppActivity
import es.iessaladillo.com.proyecto.view.ui.register_login.MainActivity

class CharacterAdapter (
    private val characters: List<UserCharacter>,
    private val onClickListener: (UserCharacter) -> Unit,
    private val onClickDelete:(Int) -> Unit
) :RecyclerView.Adapter<CharacterAdapter.MyViewHolder>(){
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemCharacterBinding.bind(itemView)
        fun bind(
            character: UserCharacter,
            onClickListener: (UserCharacter) -> Unit,
            onClickDelete: (Int) -> Unit
        ) {
            binding.nameItem.text = character.name
            binding.btnGo.setOnClickListener{
                val intent = Intent(it.context, AppActivity::class.java)
                it.context.startActivity(intent)
            }
            itemView.setOnClickListener{onClickListener(character)}
            binding.btnDelete.setOnClickListener{ onClickDelete(bindingAdapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(characters[position],onClickListener,onClickDelete)
    }

    override fun getItemCount(): Int = characters.size
}

