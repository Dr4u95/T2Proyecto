package es.iessaladillo.com.proyecto.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import es.iessaladillo.com.proyecto.R
import java.util.Locale

class EnemyAdapter(context: Context,private var originalValues: List<Pair<String, String>>) :
    ArrayAdapter<Pair<String, String>>(context, -1, originalValues) {

    private var filteredValues : MutableList<Pair<String, String>> = originalValues.toMutableList()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView = convertView ?: inflater.inflate(R.layout.item_enemy, parent, false)

        val textView = rowView.findViewById<TextView>(R.id.nameItemEnemy)
        val imageView = rowView.findViewById<ImageView>(R.id.imgItemEnemy)

        textView.text = filteredValues[position].first
        Glide.with(context).load(filteredValues[position].second).into(imageView)
        return rowView
    }

    override fun getCount(): Int {
        return filteredValues.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val results = FilterResults()

                if (constraint.isNullOrBlank()) {
                    results.values = originalValues.toList()
                } else {
                    val filterPattern = constraint.toString().lowercase(Locale.getDefault())
                    val filteredList = originalValues.filter {
                        it.first.lowercase(Locale.getDefault()).contains(filterPattern)
                    }
                    results.values = filteredList
                }

                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                results?.let {
                    filteredValues.clear()
                    filteredValues.addAll(it.values as List<Pair<String, String>>)
                    notifyDataSetChanged()
                }
            }
        }
    }
}
