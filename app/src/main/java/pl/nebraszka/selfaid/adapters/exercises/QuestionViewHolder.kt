package pl.nebraszka.selfaid.adapters.exercises

import android.view.View
import androidx.lifecycle.LifecycleOwner
import kotlinx.android.synthetic.main.row_question.view.*
import pl.nebraszka.selfaid.entities.EJRespond

class QuestionViewHolder(
    view: View, owner: LifecycleOwner, id: Int, exerciseType: Int, topic: String
) : ExerciseViewHolderBinder(view, owner, id, exerciseType, topic) {

    override fun bind() {
        bindTopic()
    }
}
