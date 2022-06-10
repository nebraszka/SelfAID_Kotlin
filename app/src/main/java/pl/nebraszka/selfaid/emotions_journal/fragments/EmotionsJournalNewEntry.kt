package pl.nebraszka.selfaid.emotions_journal.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_emotions_journal_new_entry.*
import kotlinx.android.synthetic.main.fragment_emotions_journal_new_entry.view.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDApplication
import pl.nebraszka.selfaid.adapters.entries_list.EmotionSelectedListener
import pl.nebraszka.selfaid.adapters.exercises.ExerciseAdapter
import pl.nebraszka.selfaid.emotions_journal.EmotionSectionManager
import pl.nebraszka.selfaid.emotions_journal.RespondsHandler
import pl.nebraszka.selfaid.entities.EJEntry
import pl.nebraszka.selfaid.entities.EJRespond
import pl.nebraszka.selfaid.entities.Emotion
import pl.nebraszka.selfaid.entities.EntryPage
import pl.nebraszka.selfaid.tools.ViewVisibilityManager
import pl.nebraszka.selfaid.tools.date.DateEditor
import pl.nebraszka.selfaid.tools.date.DatePickerHandler
import pl.nebraszka.selfaid.view_models.EJEntryViewModel
import pl.nebraszka.selfaid.view_models.EJEntryViewModelFactory

class EmotionsJournalNewEntry : Fragment() {

    private val viewModel: EJEntryViewModel by viewModels {
        EJEntryViewModelFactory((requireActivity().application as SelfAIDApplication).repository)
    }

    lateinit var myView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        myView = inflater.inflate(R.layout.fragment_emotions_journal_new_entry, container, false)

        myView.btnEJDatePicker.setOnClickListener {
            DatePickerHandler.changeTextViewDate(requireContext(), myView.tvEJChosenDateSaved)
        }

        setUpEmotionSection()
        prepareListOfExercises()
        manageButtonsVisibility()

        myView.btnEJSaveEntry.setOnClickListener {
            saveResponds()
            val fragment = EmotionsJournalMenu()
            val transaction = fragment.fragmentManager?.beginTransaction()
            transaction?.replace(R.id.mainContainerView, fragment)?.commit()
        }

        return myView
    }

    private fun manageButtonsVisibility() {
        val buttons: List<Button> = listOf(myView.btnEJSaveEntry, myView.btnEJAddEmotion)

        myView.tvEJChosenDateSaved.doOnTextChanged { _, _, _, _ ->
            ViewVisibilityManager.manage(buttons, true)
        }
    }

    private fun prepareListOfExercises() {
        val adapter = ExerciseAdapter(viewLifecycleOwner)
        viewModel.allEJExercise.observe(requireActivity()) {
            adapter.submitList(it)
            myView.rvEJTasks.layoutManager = LinearLayoutManager(requireContext())
            myView.rvEJTasks.adapter = adapter
        }
    }

    private fun setUpEmotionSection() {
        myView.spnEJEmotions.onItemSelectedListener =
            EmotionSelectedListener(viewModel, viewLifecycleOwner)

        viewModel.allEmotions.observe(viewLifecycleOwner, Observer<List<Emotion>> {
            EmotionSectionManager.initiateEmotionSpinner(requireContext(), it, spnEJEmotions)
        })

        myView.btnEJEmotionInfo.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("EXTRA_EMOTION_NAME", viewModel.chosenEmotion!!.emotion)
            bundle.putString("EXTRA_EMOTION_DESCRIPTION", viewModel.chosenEmotion!!.description)
            val fragment = EmotionDescription()
            fragment.arguments = bundle
            val transaction = fragment.fragmentManager?.beginTransaction()
            transaction?.replace(R.id.mainContainerView, fragment)?.commitAllowingStateLoss()
        }
    }

    private fun saveResponds() { // TODO: przesunąć odpowiedzialność na inną klasę?
        val date = tvEJChosenDateSaved.text.toString()
        val title = etEJTitle.text.toString()

        viewModel.addEntry(
            EJEntry(
                DateEditor.reverseDate(date),
                title ?: this.resources.getString(R.string.Blank_Topic)
            )
        )

        viewModel.entryId.observe(viewLifecycleOwner, Observer<Long> {
            viewModel.addPage(EntryPage(1, viewModel.chosenEmotion!!.id, it.toInt()))
        })

        viewModel.pageId.observe(viewLifecycleOwner, Observer<Long> {
            viewModel.addResponds(
                RespondsHandler.getResponds(
                    requireView().findViewById(R.id.rvEJTasks),
                    it.toInt()
                ) as MutableList<EJRespond>
            )
        })
    }
}