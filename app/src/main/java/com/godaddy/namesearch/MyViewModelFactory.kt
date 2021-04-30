import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.godaddy.namesearch.NameSearchRepository

class MyViewModelFactory constructor(private val repository: NameSearchRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}