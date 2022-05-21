package pl.nebraszka.selfaid.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.core.view.children
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.asLiveData
import kotlinx.android.synthetic.main.row_choose_option.view.*
import pl.nebraszka.selfaid.SelfAIDDatabase
import pl.nebraszka.selfaid.entities.AnswerSuggestion
import pl.nebraszka.selfaid.enums.ExerciseType

class ChooseOptionQuestionHandler {

    lateinit var viewChooseOption: View
    lateinit var parentt: ViewGroup

    fun createChooseOptionQuestion(owner: LifecycleOwner, parent: ViewGroup, multipleChoice: Boolean
    ): ExerciseViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(ExerciseType.VIEW_CHOOSE_OPTION.layoutId, parent, false)

        viewChooseOption = view
        parentt = parent

        val db = SelfAIDDatabase.getDatabase(parent.context)
        val answSugg = db.answerSuggestionDao().getAllAnswerSuggestions().asLiveData()

        answSugg.observe(owner){ answSugg->
            answSugg.let {
                attachAnswers(it, parentt)
            }
        }
        return ExerciseViewHolder(view)
    }

    fun attachAnswers( answSugg: List<AnswerSuggestion>, parent: ViewGroup){
        for(a in answSugg){
            val btn: CheckBox = CheckBox(parent.context)
            btn.text = a.answer
            btn.id = View.generateViewId()
            viewChooseOption.llCheckBoxes.addView(btn)
        }
    }
}