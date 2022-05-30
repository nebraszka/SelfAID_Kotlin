package pl.nebraszka.selfaid.adapters.exercises

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import kotlinx.android.synthetic.main.emotion_journal_entry.view.*
import pl.nebraszka.selfaid.SelfAIDApplication
import pl.nebraszka.selfaid.entities.EJRespond
import pl.nebraszka.selfaid.enums.ExerciseType
import pl.nebraszka.selfaid.view_models.EJEntryViewModel
import pl.nebraszka.selfaid.view_models.EJEntryViewModelFactory

abstract class ExerciseViewHolderBinder(
    val view: View,
    val owner: LifecycleOwner,
    val id: Int,
    val exerciseType: Int,
    val topic: String
) {

    fun bindTopic() {
        val tvTopic: TextView?
        val exercise: ExerciseType = ExerciseType.findById(exerciseType)!!
        tvTopic = view.findViewById(exercise.topicTextView)
        tvTopic.text = topic
    }

    abstract fun bind()

    //abstract fun getRespond(pageId: Int): EJRespond
}