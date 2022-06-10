package pl.nebraszka.selfaid.emotions_journal.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.emotion_journal_menu.*
import kotlinx.android.synthetic.main.row_entry.view.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDApplication
import pl.nebraszka.selfaid.adapters.entries_list.EntryAdapter
import pl.nebraszka.selfaid.tools.ViewVisibilityManager
import pl.nebraszka.selfaid.view_models.EJMenuViewModel
import pl.nebraszka.selfaid.view_models.EJMenuViewModelFactory

class EJMenu : AppCompatActivity() {

    private val viewModel: EJMenuViewModel by viewModels {
        EJMenuViewModelFactory((application as SelfAIDApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_journal_menu)

        prepareListOfEntries()

        btnEJFirstEntry.setOnClickListener {
            val intent = Intent(this, EJNewEntry::class.java)
            startActivity(intent)
        }
    }

    private fun prepareListOfEntries() {
        val adapter = EntryAdapter(this, viewModel)
        viewModel.allEntries.observe(this, Observer {
            if (!it.isNullOrEmpty()) {
                adapter.submitList(it)
                rvEntriesList!!.layoutManager = LinearLayoutManager(this)
                rvEntriesList!!.adapter = adapter
                showMenuWithEntries()
            } else {
                showMenuWithoutEntries()
            }
        })
    }

    private fun showMenuWithEntries() {
        ViewVisibilityManager.manage(btnEJFirstEntry, false)
        ViewVisibilityManager.manage(btnEJNewEntry, true)
        ViewVisibilityManager.manage(rvEntriesList, true)

        btnEJNewEntry!!.setOnClickListener {
            val intent = Intent(this, EJNewEntry::class.java)
            startActivity(intent)
        }
    }

    private fun showMenuWithoutEntries(){
        ViewVisibilityManager.manage(btnEJFirstEntry, true)
        ViewVisibilityManager.manage(btnEJNewEntry, false)
        ViewVisibilityManager.manage(rvEntriesList, false)
    }
}
