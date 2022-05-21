package pl.nebraszka.selfaid.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import pl.nebraszka.selfaid.enums.ExerciseType
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_choose_option.view.*
import kotlinx.android.synthetic.main.row_scale_question.view.*
import pl.nebraszka.selfaid.tools.SeekBarDescribtionChanger

class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {

        fun createViewHolder(parent: ViewGroup, viewType: Int, owner: LifecycleOwner): ExerciseViewHolder {
            when (viewType) {
                ExerciseType.VIEW_SCALE_QUESTION.id ->
                    return createScaleQuestion(parent);
                ExerciseType.VIEW_CHOOSE_OPTION.id ->
                    return ChooseOptionQuestionHandler().createChooseOptionQuestion(
                        owner, parent, false
                    );
                ExerciseType.VIEW_TODO_TASK.id ->
                    return ExerciseViewHolder.createToDoTask(parent);
                ExerciseType.VIEW_QUESTION.id ->
                    return ExerciseViewHolder.createQuestion(parent);
                ExerciseType.VIEW_MULTICHOOSE_OPTION.id ->
                    return ChooseOptionQuestionHandler().createChooseOptionQuestion(
                        owner, parent, true
                    );
                else ->
                    throw IllegalArgumentException("Wrong type of exercise!") //TODO: wlasny wyjatek
            }
        }

        fun createScaleQuestion(parent: ViewGroup): ExerciseViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(ExerciseType.VIEW_SCALE_QUESTION.layoutId, parent, false)

            view.tvScaleAnswer.text = "0/5"
            view.scaleQuestionRow.setOnSeekBarChangeListener(SeekBarDescribtionChanger(view.tvScaleAnswer))

            return ExerciseViewHolder(view)
        }

        fun createToDoTask(parent: ViewGroup): ExerciseViewHolder {
            // TODO
            val view: View = LayoutInflater.from(parent.context)
                .inflate(ExerciseType.VIEW_TODO_TASK.layoutId, parent, false)

            return ExerciseViewHolder(view)
        }

        fun createQuestion(parent: ViewGroup): ExerciseViewHolder {
            // TODO
            val view: View = LayoutInflater.from(parent.context)
                .inflate(ExerciseType.VIEW_QUESTION.layoutId, parent, false)

            return ExerciseViewHolder(view)
        }
    }

    private lateinit var tvTopic: TextView

    fun bind(text: String?, exerciseType: Int) {

        when (exerciseType) {
            ExerciseType.VIEW_SCALE_QUESTION.id ->
                tvTopic = itemView.findViewById(ExerciseType.VIEW_SCALE_QUESTION.topicTextView);
            ExerciseType.VIEW_CHOOSE_OPTION.id ->
                tvTopic = itemView.findViewById(ExerciseType.VIEW_CHOOSE_OPTION.topicTextView)
            ExerciseType.VIEW_TODO_TASK.id ->
                tvTopic = itemView.findViewById(ExerciseType.VIEW_TODO_TASK.topicTextView)
            ExerciseType.VIEW_QUESTION.id ->
                tvTopic = itemView.findViewById(ExerciseType.VIEW_QUESTION.topicTextView);
            ExerciseType.VIEW_MULTICHOOSE_OPTION.id ->
                tvTopic = itemView.findViewById(ExerciseType.VIEW_MULTICHOOSE_OPTION.topicTextView)
        }
        tvTopic.text = text
    }
}

