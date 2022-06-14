package pl.nebraszka.selfaid.adapters.exercises

import android.view.View
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import pl.nebraszka.selfaid.entities.EJExercise
import pl.nebraszka.selfaid.enums.ExerciseType

abstract class ExerciseViewHolderBinder(
    val view: View,
    val owner: LifecycleOwner,
    val exercise: EJExercise
) {

    fun bindTopicAndId() {
        val exerciseType: ExerciseType = ExerciseType.findById(exercise.exerciseType)!!
        val tvTopic = view.findViewById<TextView>(exerciseType.topicTextView)
        tvTopic.text = exercise.topic
        view.id = exercise.id
    }

    abstract fun bind()
}