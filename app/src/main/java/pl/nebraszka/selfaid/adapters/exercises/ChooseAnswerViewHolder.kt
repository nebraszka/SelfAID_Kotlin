package pl.nebraszka.selfaid.adapters.exercises

import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.asLiveData
import kotlinx.android.synthetic.main.row_choose_option.view.*
import pl.nebraszka.selfaid.SelfAIDDatabase
import pl.nebraszka.selfaid.entities.AnswerSuggestion
import pl.nebraszka.selfaid.entities.EJExercise

class ChooseAnswerViewHolder(
    view: View, owner: LifecycleOwner, exercise: EJExercise, private val multipleChoice: Boolean
) : ExerciseViewHolderBinder(view, owner, exercise) {

    private val database = SelfAIDDatabase.getDatabase(view.context)

    private fun bindSuggestedAnswers() {
        val answerSuggestions = database.answerSuggestionDao()
            .getAllAnswerSuggestions(exercise.id).asLiveData()

        answerSuggestions.observe(owner) {
            attachAnswers(it)
        }
    }

    private fun attachAnswers(answerSuggestions: List<AnswerSuggestion>) {
        if (multipleChoice) {
            for (answer in answerSuggestions) {
                val checkBox = CheckBox(view.context)
                checkBox.text = answer.answer
                checkBox.id = answer.id
                view.llAnswerSuggestions.addView(checkBox)
            }
        } else {
            val radioGroup: RadioGroup = RadioGroup(view.context)
            view.llAnswerSuggestions.addView(radioGroup)

            for (answer in answerSuggestions) {
                val btn= RadioButton(view.context)
                btn.text = answer.answer
                btn.id = answer.id
                radioGroup.addView(btn)
            }
        }
    }

    override fun bind() {
        bindTopicAndId()
        bindSuggestedAnswers()
    }
}