package pl.nebraszka.selfaid.adapters.entry_answers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_answer.view.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDDatabase
import pl.nebraszka.selfaid.entities.EJExercise
import pl.nebraszka.selfaid.enums.ExerciseType

class AnswersViewHolder(itemView: View, private val entryId: Int) :
    RecyclerView.ViewHolder(itemView) {

    private val database = SelfAIDDatabase.getDatabase(itemView.context)

    companion object {
        fun createViewHolder(parent: ViewGroup, viewType: Int, entryId: Int): AnswersViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_answer, parent, false)

            return AnswersViewHolder(view, entryId)
        }
    }

    fun bind(exercise: EJExercise, owner: LifecycleOwner) {
        itemView.tvExerciseTopic.text = exercise.topic

        val responds = database.ejRespondDao()
            .getRespondsForExercise(entryId, 1, exercise.id).asLiveData()

        val resources =  itemView.context.resources
        responds.observe(owner) {
            itemView.tvAnswer.text =
                when (exercise.exerciseType) {

                    ExerciseType.VIEW_QUESTION.id -> {
                        if (it.isEmpty()) {
                            resources.getString(R.string.No_Respond)
                        } else {
                            it[0].text_answer!!
                        }
                    };

                    ExerciseType.VIEW_TODO_TASK.id -> {
                        if (it.isNotEmpty())
                           resources.getString(R.string.Checked)
                        else
                           resources.getString(R.string.Unchecked)
                    };

                    ExerciseType.VIEW_SCALE_QUESTION.id -> {
                        it[0].text_answer!! + " / " + itemView.context.resources.getInteger(R.integer.EJ_Entry_Max_Scale_Value)
                    };

                    ExerciseType.VIEW_CHOOSE_OPTION.id -> {
                        if (it.isEmpty()) {
                            resources.getString(R.string.No_Respond)
                        } else {
                            it[0].answer
                        }
                    };

                    ExerciseType.VIEW_MULTICHOOSE_OPTION.id -> {
                        if (it.isNotEmpty()) {
                            var answer = ""
                            for (elem in it) {
                                answer += elem.answer + "\n"
                            }
                            answer

                        } else {
                            resources.getString(R.string.None_Checked)
                        }
                    };
                    else -> {resources.getString(R.string.No_Respond)}
                }
        }
    }
}


