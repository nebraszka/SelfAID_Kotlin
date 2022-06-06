package pl.nebraszka.selfaid.adapters.entry_answer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_answer.view.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDDatabase
import pl.nebraszka.selfaid.enums.ExerciseType
import pl.nebraszka.selfaid.exceptions.UnknownExerciseTypeException

class AnswersViewHolder(itemView: View, private val entryId: Int) : RecyclerView.ViewHolder(itemView) {

    private lateinit var tvTopic: TextView
    private val database = SelfAIDDatabase.getDatabase(itemView.context)

    companion object {
        fun createViewHolder(parent: ViewGroup, viewType: Int, entryId: Int): AnswersViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.row_answer, parent, false)

            return AnswersViewHolder(view, entryId)
        }
    }

    fun bind(id: Int, exerciseType: Int, topic: String, owner: LifecycleOwner) {
        itemView.tvExerciseTopic.text = topic
        val responds = database.ejRespondDao()
            .getRespondsForExercise(entryId, 1, id).asLiveData()

        responds.observe(owner){
                if(it.isEmpty()){
                    itemView.tvAnswer.text ="Brak odpowiedzi"
                }
                else{
                    itemView.tvAnswer.text =
                    when(exerciseType){
                        ExerciseType.VIEW_QUESTION.id -> {
                            if(it.isEmpty()){
                                "Brak odpowiedzi"
                            }
                            else{
                                it[0].text_answer!!
                            }
                        };
                        ExerciseType.VIEW_TODO_TASK.id ->{
                            if(it[0].text_answer == "true")
                                "Zaznaczono"
                            else
                                "Nie zaznaczono"
                        };
                        ExerciseType.VIEW_SCALE_QUESTION.id ->{
                            it[0].text_answer!!
                        };
                        ExerciseType.VIEW_CHOOSE_OPTION.id ->{
                            it[0].answer
                        };
                        ExerciseType.VIEW_MULTICHOOSE_OPTION.id ->{
                            var answer = ""
                            for(elem in it){
                                answer += elem.answer + "\n"
                            }
                            answer
                        };
                        else -> {""}
                    }
            }
        }
    }
}

