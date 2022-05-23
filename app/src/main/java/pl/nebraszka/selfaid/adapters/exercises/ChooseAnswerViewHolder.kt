package pl.nebraszka.selfaid.adapters.exercises

import android.view.LayoutInflater
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

class ChooseAnswerViewHolder: ExerciseViewHolderGenerator{

    private lateinit var parent: ViewGroup
    private lateinit var db: SelfAIDDatabase
    private lateinit var view: View

    fun createChooseOptionQuestion(
        owner: LifecycleOwner,
        parent: ViewGroup,
        multipleChoice: Boolean
    ): ExerciseViewHolder {
        this.parent = parent
        db = SelfAIDDatabase.getDatabase(parent.context)

        val view: View = LayoutInflater.from(parent.context)
            .inflate(ExerciseType.VIEW_CHOOSE_OPTION.layoutId, parent, false)

        this.view = view
        val answSugg = db.answerSuggestionDao().getAllAnswerSuggestions().asLiveData()

        answSugg.observe(owner){ answSugg->
            answSugg.let {
                attachAnswers(it, multipleChoice)
            }
        }
        return ExerciseViewHolder(view)
    }

    fun attachAnswers(answSugg: List<AnswerSuggestion>, multipleChoice: Boolean){
        if(multipleChoice == true){
            for(a in answSugg){
                val checkBox: CheckBox = CheckBox(parent.context)
                checkBox.text = a.answer
                checkBox.id = View.generateViewId()
                view.llAnswerSuggestions.addView(checkBox)
            }
        } else {
            var radioGroup: RadioGroup = RadioGroup(parent.context)
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

    override fun createViewHolde(owner: LifecycleOwner, parent: ViewGroup): ExerciseViewHolder {
        TODO("Not yet implemented")
    }
}