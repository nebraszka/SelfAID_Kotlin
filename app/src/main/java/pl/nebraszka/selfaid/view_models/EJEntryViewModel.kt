package pl.nebraszka.selfaid.view_models

import androidx.lifecycle.*
import kotlinx.android.synthetic.main.row_question.view.*
import kotlinx.coroutines.launch
import pl.nebraszka.selfaid.entities.*
import pl.nebraszka.selfaid.repositories.SelfAIDRepository

class EJEntryViewModel(private val repository: SelfAIDRepository) : ViewModel() {
    var chosenEmotion: Emotion? = null
    val allEmotions: LiveData<List<Emotion>> = repository.allEmotions.asLiveData()
    val allEJExercise: LiveData<List<EJExercise>> = repository.allExercises.asLiveData()

    var entryId = MutableLiveData<Long>()
    var pageId = MutableLiveData<Long>()

    fun getEmotion(name: String): LiveData<Emotion> {
        return repository.getEmotion(name).asLiveData()
    }

    fun addEntry(ejEntry: EJEntry){
        viewModelScope.launch {
            entryId.postValue(repository.insertEntry(ejEntry))
        }
    }

    fun addPage(page: EntryPage){
        viewModelScope.launch {
            pageId.postValue(repository.insertEntryPage(page))
        }
    }

    fun addResponds(responds: List<EJRespond>) {
        viewModelScope.launch {
            repository.insertResponds(responds)
        }
    }
}

class EJEntryViewModelFactory(private val repository: SelfAIDRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EJEntryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EJEntryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}