package pl.nebraszka.selfaid.emotions_journal.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.emotion_journal_entry.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDApplication
import pl.nebraszka.selfaid.adapters.entries_list.EmotionSelectedListener
import pl.nebraszka.selfaid.adapters.exercises.ExerciseAdapter
import pl.nebraszka.selfaid.emotions_journal.EmotionSectionManager
import pl.nebraszka.selfaid.emotions_journal.RespondsHandler
import pl.nebraszka.selfaid.entities.*
import pl.nebraszka.selfaid.tools.*
import pl.nebraszka.selfaid.tools.date.DateEditor
import pl.nebraszka.selfaid.tools.date.DatePickerHandler
import pl.nebraszka.selfaid.view_models.EJEntryViewModel
import pl.nebraszka.selfaid.view_models.EJEntryViewModelFactory

class EJNewEntry : AppCompatActivity() {

    private val viewModel: EJEntryViewModel by viewModels {
        EJEntryViewModelFactory((application as SelfAIDApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_journal_entry)

        manageButtonsVisibility()

        btnEJDatePicker.setOnClickListener {
            DatePickerHandler.changeTextViewDate(this, tvEJChosenDate)
        }

        setUpEmotionSection()
        prepareListOfExercises()

        btnEJSaveEntry.setOnClickListener {
            saveResponds()
            val intent = Intent(this, EJMenu::class.java)
            startActivity(intent)
        }
    }

    private fun manageButtonsVisibility() {
        val buttons: List<Button> = listOf(btnEJSaveEntry, btnEJAddEmotion)

        tvEJChosenDate.doOnTextChanged { _, _, _, _ ->
            ViewVisibilityManager.manage(buttons, true)
        }
    }

    private fun prepareListOfExercises() {
        val adapter = ExerciseAdapter(this)
        viewModel.allEJExercise.observe(this) {
            adapter.submitList(it)
            rvEJTasks.layoutManager = LinearLayoutManager(this)
            rvEJTasks.adapter = adapter
        }
    }

    private fun setUpEmotionSection() {
        spnEJEmotions.onItemSelectedListener = EmotionSelectedListener(viewModel, this)

        viewModel.allEmotions.observe(this, Observer<List<Emotion>> {
            EmotionSectionManager.initiateEmotionSpinner(this, it, spnEJEmotions)
        })

        btnEJEmotionInfo.setOnClickListener {
            startActivity(
                EmotionSectionManager.emotionInfoIntent(
                    this, viewModel.chosenEmotion!!
                )
            )
        }
    }

    private fun saveResponds() { // TODO: przesunąć odpowiedzialność na inną klasę?
        val date = tvEJChosenDate.text.toString()
        val title = etEJTitle.text.toString()

        viewModel.addEntry(
            EJEntry(
                DateEditor.reverseDate(date),
                title ?: this.resources.getString(R.string.Blank_Topic)
            )
        )

        viewModel.entryId.observe(this, Observer<Long> {
            viewModel.addPage(EntryPage(1, viewModel.chosenEmotion!!.id, it.toInt()))
        })

        viewModel.pageId.observe(this, Observer<Long> {
            viewModel.addResponds(
                RespondsHandler.getResponds(
                    findViewById(R.id.rvEJTasks),
                    it.toInt()
                ) as MutableList<EJRespond>
            )
        })
    }
}

