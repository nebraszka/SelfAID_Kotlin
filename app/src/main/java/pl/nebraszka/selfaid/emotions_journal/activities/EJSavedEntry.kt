package pl.nebraszka.selfaid.emotions_journal.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.emotion_journal_entry.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDApplication
import pl.nebraszka.selfaid.adapters.entry_answers.AnswersAdapter
import pl.nebraszka.selfaid.emotions_journal.EmotionSectionManager
import pl.nebraszka.selfaid.entities.Emotion
import pl.nebraszka.selfaid.tools.ViewVisibilityManager
import pl.nebraszka.selfaid.view_models.EJSavedEntryViewModel
import pl.nebraszka.selfaid.view_models.EJSavedEntryViewModelFactory

// TODO: zrobic z tego fragment
class EJSavedEntry() : AppCompatActivity() {

    private val extraEntryId = "EXTRA_ENTRY_ID"
    private val viewModel: EJSavedEntryViewModel by viewModels {
        EJSavedEntryViewModelFactory((application as SelfAIDApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_journal_entry)

        val entryId = intent.extras!!.getInt(extraEntryId)

        manageButtonsVisibility()
        attachEntryInfo(entryId)

        viewModel.getEntryEmotion(entryId).observe(this, Observer {
            bindEmotionInfo(it, entryId)
        })
    }

    private fun manageButtonsVisibility() {
        ViewVisibilityManager.manage(
            listOf(
                btnEJDatePicker,
                etEJTitle,
                spnEJEmotions,
                btnEJSaveEntry,
                btnEJAddEmotion
            ), false
        )

        ViewVisibilityManager.manage(
            listOf(
                tvEJTitle,
                tvChooseEmotion,
                tvChosenEmotion
            ), true
        )
    }

    private fun attachEntryInfo(entryId: Int) {
        viewModel.getEntryInfo(entryId).observe(this, Observer {
            tvEJChosenDate.text = it.date
            tvEJTitle.text = it.title
        })
        prepareListOfResponds(entryId)
    }

    private fun prepareListOfResponds(entryId: Int) {
        val adapter = AnswersAdapter(this, entryId)
        viewModel.allEJExercise.observe(this) {
            adapter.submitList(it)
            rvEJTasks.layoutManager = LinearLayoutManager(this)
            rvEJTasks.adapter = adapter
        }
    }

    private fun bindEmotionInfo(emotion: Emotion, entryId: Int) {
        tvChooseEmotion.text =
            this.resources.getString(R.string.EJ_SavedEntry_ChosenEmotion)
        tvChosenEmotion.text = emotion.emotion

        btnEJEmotionInfo.setOnClickListener {
            startActivity(
                EmotionSectionManager.emotionInfoIntent(
                    this, emotion
                )
            )
        }
    }
}

