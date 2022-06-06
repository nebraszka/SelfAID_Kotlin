package pl.nebraszka.selfaid.activities.emotions_journal

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.emotion_journal_entry.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDApplication
import pl.nebraszka.selfaid.adapters.entry_answer.AnswersAdapter
import pl.nebraszka.selfaid.adapters.exercises.ExerciseAdapter
import pl.nebraszka.selfaid.enums.ExerciseType
import pl.nebraszka.selfaid.tools.ButtonManager
import pl.nebraszka.selfaid.view_models.EJSavedEntryViewModel
import pl.nebraszka.selfaid.view_models.EJSavedEntryViewModelFactory
// TODO: zrobic z tego fragment
class EJSavedEntry(): AppCompatActivity(){
    private val viewModel: EJSavedEntryViewModel by viewModels {
        EJSavedEntryViewModelFactory((application as SelfAIDApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_journal_entry)

        val entryId = intent.extras!!.getInt("EXTRA_ENTRY_ID")

        val adapter = AnswersAdapter(this, entryId)
        viewModel.allEJExercise.observe(this) {
            adapter.submitList(it)
        }

        initiateRecyclerView(this, adapter)

        ButtonManager.manageButtonVisibility(btnEJDatePicker, false)
        etEJTitle.visibility = View.GONE
        tvEJTitle.visibility = View.VISIBLE

        viewModel.getEntryInfo(entryId).observe(this, Observer {
            tvEJChosenDate.text = it.date
            tvEJTitle.text = it.title
        })

        tvChooseEmotion.text = "Wybrana emocja"
        spnEJEmotions.visibility = View.GONE
        tvChosenEmotion.visibility = View.VISIBLE
        // TODO: emocja i opcja wejscia w jej opis

        ButtonManager.manageButtonVisibility(listOf(btnEJSaveEntry, btnEJAddEmotion), false)
    }

    private fun initiateRecyclerView(context: Context, adapter: AnswersAdapter) {
        rvEJTasks.layoutManager = LinearLayoutManager(context)
        rvEJTasks.adapter = adapter
    }
}

