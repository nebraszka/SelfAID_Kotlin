package pl.nebraszka.selfaid.adapters.exercises

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import pl.nebraszka.selfaid.enums.ExerciseType

class QuestionViewHolder(
    view: View, owner: LifecycleOwner, id: Int, exerciseType: Int, topic: String
): ExerciseViewHolderBinder(view, owner, id, exerciseType, topic) {

    override fun bind() {
        bindTopic()
    }
}
