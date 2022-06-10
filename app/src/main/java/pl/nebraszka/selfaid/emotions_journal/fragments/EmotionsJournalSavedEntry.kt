package pl.nebraszka.selfaid.emotions_journal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.emotion_journal_entry.*
import kotlinx.android.synthetic.main.fragment_emotions_journal_new_entry.view.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDApplication
import pl.nebraszka.selfaid.adapters.entry_answers.AnswersAdapter
import pl.nebraszka.selfaid.entities.Emotion
import pl.nebraszka.selfaid.tools.ViewVisibilityManager
import pl.nebraszka.selfaid.view_models.EJSavedEntryViewModel
import pl.nebraszka.selfaid.view_models.EJSavedEntryViewModelFactory

class EmotionsJournalSavedEntry : Fragment() {

    private val extraEntryId = "EXTRA_ENTRY_ID"
    private val viewModel: EJSavedEntryViewModel by viewModels {
        EJSavedEntryViewModelFactory((requireActivity().application as SelfAIDApplication).repository)
    }
    private lateinit var myView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        myView = inflater.inflate(R.layout.fragment_emotions_journal_new_entry, container, false)

        val entryId = requireActivity().intent.extras!!.getInt(extraEntryId)

        manageButtonsVisibility()
        attachEntryInfo(entryId)

        viewModel.getEntryEmotion(entryId).observe(viewLifecycleOwner, Observer {
            bindEmotionInfo(it, entryId)
        })

        return myView
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
        viewModel.getEntryInfo(entryId).observe(viewLifecycleOwner, Observer {
            tvEJChosenDate.text = it.date
            tvEJTitle.text = it.title
        })
        prepareListOfResponds(entryId)
    }

    private fun prepareListOfResponds(entryId: Int) {
        val adapter = AnswersAdapter(this, entryId)
        viewModel.allEJExercise.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            rvEJTasks.layoutManager = LinearLayoutManager(requireContext())
            rvEJTasks.adapter = adapter
        }
    }

    private fun bindEmotionInfo(emotion: Emotion, entryId: Int) {
        tvChooseEmotion.text =
            this.resources.getString(R.string.EJ_SavedEntry_ChosenEmotion)
        tvChosenEmotion.text = emotion.emotion

        btnEJEmotionInfo.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("EXTRA_EMOTION_NAME", emotion.emotion)
            bundle.putString("EXTRA_EMOTION_DESCRIPTION", emotion.description)
            val fragment = EmotionDescription()
            fragment.arguments = bundle
            val transaction = fragment.fragmentManager?.beginTransaction()
            transaction?.replace(R.id.mainContainerView, fragment)?.commit()
        }
    }
}