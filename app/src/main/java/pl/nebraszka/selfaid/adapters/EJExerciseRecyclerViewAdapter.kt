package pl.nebraszka.selfaid.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.entities.Exercise

class ExerciseAdapter : ListAdapter<Exercise, ExerciseAdapter.ExerciseViewHolder>(WordsComparator()) {

    companion object {
        const val VIEW_SCALE_QUESTION = 1
        const val VIEW_QUESTION = 4

    }

    override fun getItemViewType(position: Int): Int {
        val myModel = getItem(position)
        return myModel.exerciseType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        when(viewType){
            VIEW_QUESTION -> return ExerciseViewHolder.createQuestion(parent);
            VIEW_SCALE_QUESTION -> return ExerciseViewHolder.createScaleQuestion(parent);
            else -> return ExerciseViewHolder.createQuestion(parent);
        }
    }

    override fun onBindViewHolder(holder:ExerciseViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.topic, current.exerciseType)
    }

    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var questionItemView: TextView

        fun bind(text: String?, exerciseType: Int) {

            when (exerciseType) {
                VIEW_QUESTION -> questionItemView = itemView.findViewById(R.id.tvQuestionRow);
                VIEW_SCALE_QUESTION -> questionItemView = itemView.findViewById(R.id.tvScaleQuestionRow);
            }
            questionItemView.text = text
        }

        companion object{
            fun createQuestion(parent: ViewGroup): ExerciseViewHolder{
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.row_question, parent, false)

                return ExerciseViewHolder(view)
            }

            fun createScaleQuestion(parent: ViewGroup): ExerciseViewHolder{
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.row_scale_question, parent, false)

                return ExerciseViewHolder(view)
            }
        }
    }

    class WordsComparator : DiffUtil.ItemCallback<Exercise>() {
        override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
            return oldItem.topic.equals(newItem.topic)
        }
    }
}

