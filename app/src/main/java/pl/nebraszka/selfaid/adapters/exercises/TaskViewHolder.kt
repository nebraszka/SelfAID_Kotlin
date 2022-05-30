package pl.nebraszka.selfaid.adapters.exercises

import android.view.View
import androidx.lifecycle.LifecycleOwner

class TaskViewHolder(
    view: View, owner: LifecycleOwner, id: Int, exerciseType: Int, topic: String
) : ExerciseViewHolderBinder(view, owner, id, exerciseType, topic) {

    override fun bind() {
        bindTopic()
    }
}