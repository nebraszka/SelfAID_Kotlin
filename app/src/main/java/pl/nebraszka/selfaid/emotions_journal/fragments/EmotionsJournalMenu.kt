package pl.nebraszka.selfaid.emotions_journal.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.emotion_journal_menu.*
import kotlinx.android.synthetic.main.fragment_emotions_journal_menu.view.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDApplication
import pl.nebraszka.selfaid.adapters.entries_list.EntryAdapter
import pl.nebraszka.selfaid.tools.ViewVisibilityManager
import pl.nebraszka.selfaid.view_models.EJMenuViewModel
import pl.nebraszka.selfaid.view_models.EJMenuViewModelFactory

class EmotionsJournalMenu : Fragment() {

    private val viewModel: EJMenuViewModel by viewModels {
        EJMenuViewModelFactory((requireActivity().application as SelfAIDApplication).repository)
    }

    private lateinit var myView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        myView = inflater.inflate(R.layout.fragment_emotions_journal_menu, container, false)

        myView.btnnEJFirstEntry.setOnClickListener {
            val fragment = EmotionsJournalNewEntry()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.mainContainerView, fragment)?.commit()
        }

        prepareListOfEntries()

        return myView
    }

    private fun prepareListOfEntries() {
        val adapter = EntryAdapter(this)
        viewModel.allEntries.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                adapter.submitList(it)
                rvEntriesList!!.layoutManager = LinearLayoutManager(context)
                rvEntriesList!!.adapter = adapter
                showMenuWithEntries()
            }
        })
    }

    private fun showMenuWithEntries() {
        ViewVisibilityManager.manage(btnnEJFirstEntry, false)
        ViewVisibilityManager.manage(btnEJNewEntry, true)
        ViewVisibilityManager.manage(rvEntriesList, true)


        myView.btnEJNewEntry!!.setOnClickListener {
            val fragment = EmotionsJournalNewEntry()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.mainContainerView, fragment)?.commit()
        }
    }

    fun onEntryClicked(entryId: Int){
        val bundle = Bundle()
        bundle.putInt("EXTRA_ENTRY_ID", entryId)
        val fragment = EmotionsJournalSavedEntry()
        fragment.arguments = bundle
        val transaction = fragment.fragmentManager?.beginTransaction()
        transaction?.replace(R.id.mainContainerView, fragment)?.commit()
    }
}