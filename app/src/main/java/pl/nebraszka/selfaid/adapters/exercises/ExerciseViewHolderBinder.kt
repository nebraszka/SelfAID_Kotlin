package pl.nebraszka.selfaid.adapters.exercises

import android.view.View
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import pl.nebraszka.selfaid.enums.ExerciseType

abstract class ExerciseViewHolderBinder(
    val view: View,
    val owner: LifecycleOwner,
    val id: Int,
    val exerciseType: Int,
    val topic: String
){

    fun bindTopic(){
        var tvTopic: TextView?
        val exercise: ExerciseType = ExerciseType.findById(exerciseType)!!
        tvTopic = view.findViewById(exercise.topicTextView)
        tvTopic.text = topic
    }

    abstract fun bind()
}