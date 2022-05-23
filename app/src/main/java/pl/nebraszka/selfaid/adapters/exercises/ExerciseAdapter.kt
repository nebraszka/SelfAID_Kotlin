package pl.nebraszka.selfaid.adapters.exercises

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import pl.nebraszka.selfaid.entities.EJExercise

class ExerciseAdapter(val owner: LifecycleOwner) : ListAdapter<EJExercise, ExerciseViewHolder>(
    ExerciseComparator()
) {

    override fun getItemViewType(position: Int): Int {
        val myModel = getItem(position)
        return myModel.exerciseType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
       return ExerciseViewHolder.createViewHolder(parent, owner, viewType)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.topic, current.exerciseType)
    }


    class ExerciseComparator : DiffUtil.ItemCallback<EJExercise>() {
        override fun areItemsTheSame(oldItem: EJExercise, newItem: EJExercise): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: EJExercise, newItem: EJExercise): Boolean {
            return oldItem.topic.equals(newItem.topic)
        }
    }
}

