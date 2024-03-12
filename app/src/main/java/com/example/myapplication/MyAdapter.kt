import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Product
import com.example.myapplication.R

class MyAdapter(private val context: Context, private val data: List<Product>, private val itemClickListener: ItemClickListener) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.myTextView.text = item.productName
        holder.desc.text = item.productDescription
        holder.price.text = "$"+item.cost
        
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val myTextView: TextView = itemView.findViewById(R.id.tvProductName)
        val desc: TextView = itemView.findViewById(R.id.tvProductDescription)
        val price: TextView = itemView.findViewById(R.id.tvProductPrice)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            itemClickListener.onItemClick(view, adapterPosition)
        }
    }

    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }
}
