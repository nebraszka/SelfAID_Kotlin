package pl.nebraszka.selfaid.tools

import android.view.View
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.RadioGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_choose_option.view.*
import kotlinx.android.synthetic.main.row_question.view.*
import kotlinx.android.synthetic.main.row_scale_question.view.*
import kotlinx.android.synthetic.main.row_todo_task.view.*
import pl.nebraszka.selfaid.entities.EJRespond
import pl.nebraszka.selfaid.enums.ExerciseType

class RespondsHandler {

    companion object {
        fun getResponds(recyclerView: RecyclerView, pageId: Int): List<EJRespond> {
            val responds: MutableList<EJRespond> = mutableListOf()

            for (i in 0 until recyclerView.childCount) {
                val child: View = recyclerView.getChildAt(i)
                val viewHolder = recyclerView.getChildViewHolder(child)
                val exerciseType = ExerciseType.findById(viewHolder.itemViewType)

                when (exerciseType) {
                    ExerciseType.VIEW_QUESTION -> {
                        val answer = child.etQuestionRow.text.toString()
                        if (answer.isEmpty())
                            continue
                        else
                            responds += EJRespond(
                                child.id,
                                pageId.toInt(),
                                null,
                                answer
                            )
                    };
                    ExerciseType.VIEW_CHOOSE_OPTION -> {
                        val chosenAnswer = getChosenAnswer(child.llAnswerSuggestions)
                        if (chosenAnswer == null)
                            continue
                        else
                            responds += EJRespond(
                                child.id,
                                pageId.toInt(),
                                chosenAnswer,
                                null
                            )
                    };
                    ExerciseType.VIEW_MULTICHOOSE_OPTION -> {
                        val checkedBoxes = getCheckedBoxes(child.llAnswerSuggestions)
                        if (checkedBoxes.isEmpty())
                            continue
                        else {
                            for (checkedBox in checkedBoxes) {
                                responds += EJRespond(
                                    child.id,
                                    pageId.toInt(),
                                    checkedBox,
                                    null
                                )
                            }
                        }
                    };
                    ExerciseType.VIEW_SCALE_QUESTION -> {
                        val answer = child.scaleQuestionRow.progress
                        responds += EJRespond(
                            child.id,
                            pageId.toInt(),
                            null,
                            answer.toString()
                        )
                    }
                    ExerciseType.VIEW_TODO_TASK -> {
                        val isDone = child.checkBoxTaskRow.isChecked
                        if (isDone) {
                            responds += EJRespond(
                                child.id,
                                pageId.toInt(),
                                null,
                                isDone.toString()
                            )
                        }
                    }
                    else -> continue;
                }
            }
            return responds
        }

        private fun getChosenAnswer(ll: LinearLayout): Int? {
            val radioGroup: RadioGroup = ll.getChildAt(0) as RadioGroup
            val checkedId = radioGroup.checkedRadioButtonId
            return if (checkedId == -1)
                null
            else
                radioGroup.checkedRadioButtonId
        }

        private fun getCheckedBoxes(ll: LinearLayout): MutableList<Int> {
            val chosenAnswers: MutableList<Int> = mutableListOf()
            val childrenNo = ll.childCount
            for (i in 0 until childrenNo) {
                val checkBox = ll.getChildAt(i) as CheckBox
                if (checkBox.isChecked)
                    chosenAnswers += checkBox.id
            }
            return chosenAnswers
        }
    }
}