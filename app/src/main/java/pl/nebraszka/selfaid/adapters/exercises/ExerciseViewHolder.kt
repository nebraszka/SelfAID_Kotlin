package pl.nebraszka.selfaid.adapters.exercises

import android.view.View
import android.view.ViewGroup
import pl.nebraszka.selfaid.enums.ExerciseType
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import pl.nebraszka.selfaid.SelfAIDDatabase
import java.lang.Exception

class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var tvTopic: TextView

    companion object {
        fun createViewHolder(
            parent: ViewGroup,
            owner: LifecycleOwner,
            viewType: Int
        ): ExerciseViewHolder {
            val db: SelfAIDDatabase = SelfAIDDatabase.getDatabase(parent.context)

            when (viewType) {
                ExerciseType.VIEW_SCALE_QUESTION.id ->
                    return ScaleQuestionViewHolder(parent).createViewHolder();
                ExerciseType.VIEW_CHOOSE_OPTION.id ->
                    return ChooseAnswerViewHolder(
                        parent, owner, db, false
                    ).createViewHolder();
                ExerciseType.VIEW_TODO_TASK.id ->
                    return TaskViewHolder(parent).createViewHolder();
                ExerciseType.VIEW_QUESTION.id ->
                    return QuestionViewHolder(parent).createViewHolder();
                ExerciseType.VIEW_MULTICHOOSE_OPTION.id ->
                    return ChooseAnswerViewHolder(
                        parent, owner, db, true
                    ).createViewHolder();
                else ->
                    throw IllegalArgumentException("Wrong type of exercise!")
                    //TODO: wlasny wyjatek
            }
        }
    }

    fun bind(text: String?, exerciseType: Int) {

        val viewId: Int? = ExerciseType.findById(exerciseType)?.topicTextView
        try{
            tvTopic = itemView.findViewById(viewId!!)
        }catch(e: Exception){
            // TODO: mój wyjątek
        }

        tvTopic.text = text
    }
}

