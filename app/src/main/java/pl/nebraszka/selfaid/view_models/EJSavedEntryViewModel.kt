package pl.nebraszka.selfaid.view_models

import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow
import pl.nebraszka.selfaid.entities.*
import pl.nebraszka.selfaid.repositories.SelfAIDRepository

class EJSavedEntryViewModel(private val repository: SelfAIDRepository) : ViewModel() {
    val allEmotions: LiveData<List<Emotion>> = repository.allEmotions.asLiveData()
    val allEJExercise: LiveData<List<EJExercise>> = repository.allExercises.asLiveData()
    val allEJEntries: LiveData<List<EJEntry>> = repository.allEntries.asLiveData()

    var entryId = MutableLiveData<Long>()

    fun getEntryInfo(entryId: Int): LiveData<EJEntry>{
        return repository.getEntryInfo(entryId).asLiveData()
    }

    fun getEntryEmotion(entryId: Int): LiveData<Emotion>{
        return repository.getEntryEmotion(entryId).asLiveData()
    }
}

class EJSavedEntryViewModelFactory(private val repository: SelfAIDRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EJSavedEntryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EJSavedEntryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}