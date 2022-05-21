package pl.nebraszka.selfaid.view_models

import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow
import pl.nebraszka.selfaid.dao.AnswerSuggestionDao
import pl.nebraszka.selfaid.entities.AnswerSuggestion
import pl.nebraszka.selfaid.entities.Emotion
import pl.nebraszka.selfaid.entities.EJExercise
import pl.nebraszka.selfaid.repositories.SelfAIDRepository
import kotlin.IllegalArgumentException

class EJEntryViewModel(private val repository: SelfAIDRepository): ViewModel() {
    companion object{
        var chosenEmotion: Emotion? = null
    }
    val allEmotions: LiveData<List<Emotion>> = repository.allEmotions.asLiveData()
    val allEJExercise: LiveData<List<EJExercise>> = repository.allExercises.asLiveData()
    val allAnswerSuggestions: LiveData<List<AnswerSuggestion>> = repository.allAnswerSuggestions.asLiveData()


    fun getEmotion(name: String) : LiveData<Emotion>{
        return repository.getEmotion(name).asLiveData()
    }

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