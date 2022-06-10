package pl.nebraszka.selfaid.adapters.exercises

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import pl.nebraszka.selfaid.entities.EJExercise
import pl.nebraszka.selfaid.enums.ExerciseType
import pl.nebraszka.selfaid.exceptions.UnknownExerciseTypeException

class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun createViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
            lateinit var view: View

            val layoutId: Int? = ExerciseType.findById(viewType)?.layoutId
            try {
                view = LayoutInflater.from(parent.context)
                    .inflate(layoutId!!, parent, false)

            } catch (e: Exception) {
                throw UnknownExerciseTypeException()
            }
            return ExerciseViewHolder(view)
        }
    }

    fun bind(exercise: EJExercise, owner: LifecycleOwner) {
        when (exercise.exerciseType) {
            ExerciseType.VIEW_TODO_TASK.id ->
                TaskViewHolder(itemView, owner, exercise).bind();
            ExerciseType.VIEW_QUESTION.id ->
                QuestionViewHolder(itemView, owner, exercise).bind();
            ExerciseType.VIEW_SCALE_QUESTION.id ->
                ScaleQuestionViewHolder(itemView, owner, exercise).bind();
            ExerciseType.VIEW_CHOOSE_OPTION.id ->
                ChooseAnswerViewHolder(itemView, owner, exercise, false).bind();
            ExerciseType.VIEW_MULTICHOOSE_OPTION.id ->
                ChooseAnswerViewHolder(itemView, owner, exercise, true).bind();
            else ->
                throw Exception("todo: twoj wyjatek");
            // TODO : wyjątek
        }
    }
}

