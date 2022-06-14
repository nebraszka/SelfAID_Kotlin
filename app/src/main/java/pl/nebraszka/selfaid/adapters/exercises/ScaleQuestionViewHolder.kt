package pl.nebraszka.selfaid.adapters.exercises

import android.view.View
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import kotlinx.android.synthetic.main.row_scale_question.view.*
import pl.nebraszka.selfaid.entities.EJExercise
import pl.nebraszka.selfaid.tools.SeekBarDescriptionChanger

class ScaleQuestionViewHolder(
    view: View, owner: LifecycleOwner, exercise: EJExercise
) : ExerciseViewHolderBinder(view, owner, exercise) {

    private fun bindProgressInfo() {
        val answer: TextView = view.tvScaleAnswer
        view.scaleQuestionRow.setOnSeekBarChangeListener(
            SeekBarDescriptionChanger(view.scaleQuestionRow, answer)
        )
    }

    override fun bind() {
        bindProgressInfo()
        bindTopicAndId()
    }
}