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
import pl.nebraszka.selfaid.entities.EJRespond

class ChooseAnswerViewHolder(
    view: View,
    owner: LifecycleOwner,
    id: Int,
    exerciseType: Int,
    topic: String,
    private val multipleChoice: Boolean
) : ExerciseViewHolderBinder(view, owner, id, exerciseType, topic) {

    private val database = SelfAIDDatabase.getDatabase(view.context)

    private fun bindSuggestedAnswers() {
        view.id = id
        val answSugg = database.answerSuggestionDao()
            .getAllAnswerSuggestions(id).asLiveData()

        answSugg.observe(owner) {
            attachAnswers(it, multipleChoice)
        }
    }

    private fun attachAnswers(answSugg: List<AnswerSuggestion>, multipleChoice: Boolean) {
        if (multipleChoice) {
            for (a in answSugg) {
                val checkBox: CheckBox = CheckBox(view.context)
                checkBox.text = a.answer
                checkBox.id = a.id
                view.llAnswerSuggestions.addView(checkBox)
            }
        } else {
            val radioGroup: RadioGroup = RadioGroup(view.context)
            view.llAnswerSuggestions.addView(radioGroup)

            for (a in answSugg) {
                val btn: RadioButton = RadioButton(view.context)
                btn.text = a.answer
                btn.id = a.id
                radioGroup.addView(btn)
            }
        }
    }

    override fun bind() {
        bindTopic()
        bindSuggestedAnswers()
    }
}