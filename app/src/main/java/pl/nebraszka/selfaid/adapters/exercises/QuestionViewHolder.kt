package pl.nebraszka.selfaid.adapters.exercises

import android.view.View
import androidx.lifecycle.LifecycleOwner
import pl.nebraszka.selfaid.entities.EJExercise

class QuestionViewHolder(
    view: View, owner: LifecycleOwner, exercise: EJExercise
) : ExerciseViewHolderBinder(view, owner, exercise) {

    override fun bind() {
        bindTopicAndId()
    }
}
