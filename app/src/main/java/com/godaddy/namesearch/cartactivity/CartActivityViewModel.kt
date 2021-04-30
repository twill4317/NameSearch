import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.godaddy.namesearch.NameSearchRepository
import com.godaddy.namesearch.PaymentMethod
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartActivityViewModel constructor(private val nameSearchRepository: NameSearchRepository)  : ViewModel() {

    val paymentMethods = MutableLiveData<List<PaymentMethod>>()
    val errorMessage = MutableLiveData<String>()


    fun getPaymentMethods() {
        val response = nameSearchRepository.getPaymentMethods()
        response.enqueue(object : Callback<List<PaymentMethod>> {
            override fun onResponse(call: Call<List<PaymentMethod>>, response: Response<List<PaymentMethod>>) {
                paymentMethods.postValue(response.body())
            }

            override fun onFailure(call: Call<List<PaymentMethod>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}