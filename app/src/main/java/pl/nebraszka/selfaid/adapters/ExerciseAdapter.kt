package pl.nebraszka.selfaid.adapters

import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_scale_question.view.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDApplication
import pl.nebraszka.selfaid.entities.AnswerSuggestion
import pl.nebraszka.selfaid.entities.EJExercise
import pl.nebraszka.selfaid.view_models.EJEntryViewModel
import pl.nebraszka.selfaid.view_models.EJEntryViewModelFactory

class ExerciseAdapter(val owner: LifecycleOwner) : ListAdapter<EJExercise, ExerciseViewHolder>(ExerciseComparator()) {

    override fun getItemViewType(position: Int): Int {
        val myModel = getItem(position)
        return myModel.exerciseType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
       return ExerciseViewHolder.createViewHolder(parent, viewType, owner)
    }

    override fun onBindViewHolder(holder:ExerciseViewHolder, position: Int) {
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

