import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.godaddy.namesearch.PaymentMethod
import com.godaddy.namesearch.databinding.ItemCartBinding

class CartRecyclerAdapter: RecyclerView.Adapter<MainViewHolder>() {

    var methods = mutableListOf<PaymentMethod>()

    fun setMethodList(methods: List<PaymentMethod>) {
        this.methods = methods.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = inflater.inflate(viewType, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val method = methods[position]
        holder.binding.nameTextView.text = method.name

    }

    override fun getItemCount(): Int {
        return methods.size
    }
}

class MainViewHolder(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root) {

}