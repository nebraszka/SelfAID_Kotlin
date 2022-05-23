package pl.nebraszka.selfaid.adapters.exercises

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.nebraszka.selfaid.enums.ExerciseType

abstract class ExerciseViewHolderGenerator(
    val parent: ViewGroup
){
    protected var layoutId = ExerciseType.VIEW_QUESTION.layoutId

    abstract fun createViewHolder(): ExerciseViewHolder

    fun inflateLayout(): View {
        return LayoutInflater.from(parent.context)
            .inflate(layoutId, parent, false)
    }
}