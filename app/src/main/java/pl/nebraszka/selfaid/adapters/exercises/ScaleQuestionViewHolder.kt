package pl.nebraszka.selfaid.adapters.exercises

import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import kotlinx.android.synthetic.main.row_scale_question.view.*
import pl.nebraszka.selfaid.enums.ExerciseType
import pl.nebraszka.selfaid.tools.SeekBarDescribtionChanger

class ScaleQuestionViewHolder(
    view: View, owner: LifecycleOwner, id: Int, exerciseType: Int, topic: String
): ExerciseViewHolderBinder(view, owner, id, exerciseType, topic) {

    fun bindProgressInfo(){
        val info: TextView = view.tvScaleAnswer
        view.scaleQuestionRow.setOnSeekBarChangeListener(
            SeekBarDescribtionChanger(view.scaleQuestionRow, info)
        )
    }

    override fun bind() {
        bindProgressInfo()
        bindTopic()
    }
}