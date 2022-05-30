package pl.nebraszka.selfaid.view_models

import androidx.lifecycle.*
import kotlinx.android.synthetic.main.row_question.view.*
import kotlinx.coroutines.launch
import pl.nebraszka.selfaid.entities.*
import pl.nebraszka.selfaid.repositories.SelfAIDRepository

class EJMenuViewModel(private val repository: SelfAIDRepository) : ViewModel() {
    var numberOfEntries = repository.countEntries().asLiveData()
    val allEntries = repository.allEntries.asLiveData()
}

class EJMenuViewModelFactory(private val repository: SelfAIDRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EJMenuViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EJMenuViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}