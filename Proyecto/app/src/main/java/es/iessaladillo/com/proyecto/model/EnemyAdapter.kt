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

class EnemyAdapter(context: Context, private val values: ArrayList<String>, private val imageUrls: ArrayList<String>) :
    ArrayAdapter<String>(context, -1, values) {

    private var filteredValues = values.toList()
    private var filteredImageUrls = imageUrls.toList()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView = convertView ?: inflater.inflate(R.layout.item_enemy, parent, false)

        val textView = rowView.findViewById<TextView>(R.id.nameItemEnemy)
        val imageView = rowView.findViewById<ImageView>(R.id.imgItemEnemy)

        textView.text = filteredValues[position]
        Glide.with(context).load(filteredImageUrls[position]).into(imageView)
        return rowView
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val results = FilterResults()

                val filteredList = if (constraint.isNullOrBlank()) {
                    values.toList()
                } else {
                    val filterPattern = constraint.toString().lowercase(Locale.getDefault())
                    values.filter { it.lowercase(Locale.getDefault()).contains(filterPattern) }
                }

                results.values = filteredList
                results.count = filteredList.size
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                results?.let {
                    filteredValues = it.values as List<String>
                    notifyDataSetChanged()
                }
            }
        }
    }
}
