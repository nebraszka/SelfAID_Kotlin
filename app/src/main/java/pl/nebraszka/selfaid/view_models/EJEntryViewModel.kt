package pl.nebraszka.selfaid.view_models

import androidx.lifecycle.*
import pl.nebraszka.selfaid.entities.Emotion
import pl.nebraszka.selfaid.entities.Exercise
import pl.nebraszka.selfaid.repositories.SelfAIDRepository
import kotlin.IllegalArgumentException

class EJEntryViewModel(private val repository: SelfAIDRepository): ViewModel() {

    val allEmotions: LiveData<List<Emotion>> = repository.allEmotions.asLiveData()
    val allExercise: LiveData<List<Exercise>> = repository.allExercises.asLiveData()

}

class EJEntryViewModelFactory(private val repository: SelfAIDRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EJEntryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EJEntryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}