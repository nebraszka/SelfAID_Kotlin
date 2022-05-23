package pl.nebraszka.selfaid.adapters.exercises

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.nebraszka.selfaid.enums.ExerciseType

class TaskViewHolder(parent: ViewGroup ) : ExerciseViewHolderGenerator(parent) {
    lateinit var view: View

    override fun createViewHolder(): ExerciseViewHolder {
        layoutId = ExerciseType.VIEW_TODO_TASK.layoutId
        view = inflateLayout()

        return ExerciseViewHolder(view)
    }
}