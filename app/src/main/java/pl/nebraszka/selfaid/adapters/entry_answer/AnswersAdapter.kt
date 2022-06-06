package pl.nebraszka.selfaid.adapters.entry_answer

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import pl.nebraszka.selfaid.adapters.entry_answer.AnswersViewHolder
import pl.nebraszka.selfaid.adapters.exercises.ExerciseAdapter
import pl.nebraszka.selfaid.adapters.exercises.ExerciseViewHolder
import pl.nebraszka.selfaid.entities.EJExercise
import pl.nebraszka.selfaid.entities.EJRespond

class AnswersAdapter(val owner: LifecycleOwner, private val entryId: Int) : ListAdapter<EJExercise, AnswersViewHolder>(
    ExerciseAdapter.ExerciseComparator()
) {

    override fun getItemViewType(position: Int): Int {
        val myModel = getItem(position)
        return myModel.exerciseType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswersViewHolder {
        return AnswersViewHolder.createViewHolder(parent, viewType, entryId)
    }

    override fun onBindViewHolder(holder: AnswersViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.id, current.exerciseType, current.topic, owner)
    }
}

