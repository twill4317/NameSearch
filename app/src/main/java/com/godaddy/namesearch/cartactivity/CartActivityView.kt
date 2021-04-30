import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.godaddy.namesearch.NameSearchRepository
import com.godaddy.namesearch.NameSearchServices
import com.godaddy.namesearch.R
import com.godaddy.namesearch.databinding.ActivityCartBinding

class CartActivityView : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityCartBinding

    lateinit var viewModel: CartActivityViewModel

    private val retrofitService = NameSearchServices.getInstance()
    val adapter = CartRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, MyViewModelFactory(NameSearchRepository(retrofitService))).get(CartActivityViewModel::class.java)

        binding.cartItemRecyclerview.adapter = adapter

        viewModel.paymentMethods.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setMethodList(it)
        })

        viewModel.errorMessage.observe(this, Observer {

        })
        viewModel.getPaymentMethods()
    }
}