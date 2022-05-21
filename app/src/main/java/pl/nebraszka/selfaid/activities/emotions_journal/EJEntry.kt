package pl.nebraszka.selfaid.activities.emotions_journal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.emotion_journal_entry.*
import kotlinx.android.synthetic.main.row_scale_question.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDApplication
import pl.nebraszka.selfaid.adapters.ExerciseAdapter
import pl.nebraszka.selfaid.entities.Emotion
import pl.nebraszka.selfaid.tools.DatePickerHandler
import pl.nebraszka.selfaid.view_models.*

class EJEntry : AppCompatActivity() { // TODO: tytul, tak zeby sie zamrazal gdy juz cos wpiszemy
    private val viewModel: EJEntryViewModel by viewModels{
        EJEntryViewModelFactory((application as SelfAIDApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_journal_entry)

        btnEJDatePicker.setOnClickListener {
            DatePickerHandler.changeTextViewDate(this, tvEJChosenDate)
        }

        viewModel.allEmotions.observe(owner = this) { emotions ->
            emotions.let {
                inititateEmotionSpinner(it, spnEJEmotions)
            }
        }

        val adapter = ExerciseAdapter(this)

        viewModel.allEJExercise.observe(owner = this) { exercises ->
            exercises.let {
                adapter.submitList(it)
            }
        }

        initiateRecyclerView(this, adapter)

        btnEJEmotionInfo.setOnClickListener {
            val intent = Intent(this, EJEmotionDescription::class.java)
            EJEntryViewModel.chosenEmotion = Emotion("empty", "empty")

            viewModel.getEmotion(spnEJEmotions.selectedItem.toString())
                .observe(this){
                 EJEntryViewModel.chosenEmotion = it
            }
            startActivity(intent)
        }

    }

    fun inititateEmotionSpinner(emotions: List<Emotion>, spinner: Spinner){
        var emotionsNames = emotions.map { it.emotion }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, emotionsNames)
        spinner.adapter = adapter
    }

    fun initiateRecyclerView(context: Context, adapter: ExerciseAdapter){
        rvEJTasks.layoutManager  = LinearLayoutManager(context)
        rvEJTasks.adapter = adapter
    }

}

