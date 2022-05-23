package pl.nebraszka.selfaid.adapters.exercises

import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.asLiveData
import kotlinx.android.synthetic.main.row_choose_option.view.*
import pl.nebraszka.selfaid.SelfAIDDatabase
import pl.nebraszka.selfaid.entities.AnswerSuggestion
import pl.nebraszka.selfaid.enums.ExerciseType

class ChooseAnswerViewHolder(
    parent: ViewGroup,
    private val owner: LifecycleOwner,
    private val database: SelfAIDDatabase,
    private val multipleChoice: Boolean
): ExerciseViewHolderGenerator(parent) {
    lateinit var view: View

    override fun createViewHolder(): ExerciseViewHolder {
        layoutId = ExerciseType.VIEW_CHOOSE_OPTION.layoutId
        view = inflateLayout()

        val answSugg = database.answerSuggestionDao()
            .getAllAnswerSuggestions().asLiveData()

        answSugg.observe(owner){ answSugg->
            attachAnswers(answSugg, multipleChoice)
        }
        return ExerciseViewHolder(view)
    }

    private fun attachAnswers(answSugg: List<AnswerSuggestion>, multipleChoice: Boolean){
        if(multipleChoice) {
            for(a in answSugg){
                val checkBox: CheckBox = CheckBox(parent.context)
                checkBox.text = a.answer
                checkBox.id = View.generateViewId()
                view.llAnswerSuggestions.addView(checkBox)
            }
        }
        else {
            val radioGroup: RadioGroup = RadioGroup(parent.context)
            view.llAnswerSuggestions.addView(radioGroup)

            for(a in answSugg){
                val btn: RadioButton = RadioButton(parent.context)
                btn.text = a.answer
                btn.id = View.generateViewId()
                radioGroup.addView(btn)
            }
            // TODO: Sprawdź, czy działa jednokrotny wybór
        }
    }
}