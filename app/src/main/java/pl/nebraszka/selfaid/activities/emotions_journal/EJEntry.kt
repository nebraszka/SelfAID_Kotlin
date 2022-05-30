package pl.nebraszka.selfaid.activities.emotions_journal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.emotion_journal_entry.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDApplication
import pl.nebraszka.selfaid.adapters.exercises.ExerciseAdapter
import pl.nebraszka.selfaid.entities.*
import pl.nebraszka.selfaid.entities.EJEntry
import pl.nebraszka.selfaid.tools.ButtonManager
import pl.nebraszka.selfaid.tools.DatePickerHandler
import pl.nebraszka.selfaid.tools.RespondsHandler
import pl.nebraszka.selfaid.view_models.EJEntryViewModel
import pl.nebraszka.selfaid.view_models.EJEntryViewModelFactory

class EJEntry : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private val viewModel: EJEntryViewModel by viewModels {
        EJEntryViewModelFactory((application as SelfAIDApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_journal_entry)

        setUpButtonsVisibility()

        btnEJDatePicker.setOnClickListener {
            DatePickerHandler.changeTextViewDate(this, tvEJChosenDate)
        }

        spnEJEmotions.onItemSelectedListener = this

        viewModel.allEmotions.observe(this, Observer<List<Emotion>>{
            inititateEmotionSpinner(it, spnEJEmotions)
            viewModel.chosenEmotion = it[0]
        })

        btnEJEmotionInfo.setOnClickListener {
            val intent = Intent(this, EJEmotionDescription::class.java)
            val gson = Gson()
            val emotion: String = gson.toJson(viewModel.chosenEmotion)
            intent.putExtra("EXTRA_EMOTION", emotion)

            startActivity(intent)
        }

        val adapter = ExerciseAdapter(this)
        viewModel.allEJExercise.observe(this) {
            adapter.submitList(it)
        }

        initiateRecyclerView(this, adapter)


        btnEJSaveEntry.setOnClickListener {
            var newEntry = EJEntry(tvEJChosenDate.text.toString(), etEJTitle.text.toString())
            viewModel.addEntry(newEntry)

            viewModel.entryId.observe(this, Observer<Long> {
                viewModel.addPage(EntryPage(1, viewModel.chosenEmotion!!.id, it.toInt()))
            })

            viewModel.pageId.observe(this, Observer<Long> {
                viewModel.addResponds(
                    RespondsHandler.getResponds(
                        findViewById(R.id.rvEJTasks),
                        it.toInt()
                    ) as MutableList<EJRespond>)
            })

            val intent = Intent(this, EJMenu::class.java)
            startActivity(intent)

        }
    }

    private fun inititateEmotionSpinner(emotions: List<Emotion>, spinner: Spinner) {
        val emotionsNames = emotions.map { it.emotion }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, emotionsNames)
        spinner.adapter = adapter
    }

    private fun initiateRecyclerView(context: Context, adapter: ExerciseAdapter) {
        rvEJTasks.layoutManager = LinearLayoutManager(context)
        rvEJTasks.adapter = adapter
    }

    private fun setUpButtonsVisibility() {
        val buttons: List<Button> = listOf(btnEJSaveEntry, btnEJAddEmotion)
        ButtonManager.manageButtonVisibility(buttons, false)

        tvEJChosenDate.doOnTextChanged { _, _, _, _ ->
            ButtonManager.manageButtonVisibility(buttons, true)
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        viewModel.getEmotion(parent!!.getItemAtPosition(pos).toString())
            .observe(this) {
                viewModel.chosenEmotion = it
            }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}

