package pl.nebraszka.selfaid.activities.emotions_journal

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.emotion_journal_menu.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDApplication
import pl.nebraszka.selfaid.adapters.entries_list.EntryAdapter
import pl.nebraszka.selfaid.tools.ButtonManager
import pl.nebraszka.selfaid.view_models.EJMenuViewModel
import pl.nebraszka.selfaid.view_models.EJMenuViewModelFactory

class EmotionsJournalActivity : AppCompatActivity(){
    private val viewModel: EJMenuViewModel by viewModels {
        EJMenuViewModelFactory((application as SelfAIDApplication).repository)
    }
    private val adapter = EntryAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_journal_menu)

        viewModel.allEntries.observe(this, Observer {
            if(it.isNotEmpty()){
                adapter.submitList(it)
                changeToListOfEntries()
            }
        })

        btnEJFirstEntry.setOnClickListener {
            val intent = Intent(this, EJNewEntry::class.java)
            startActivity(intent)
        }

        btnEJNewEntry.setOnClickListener {
            val intent = Intent(this, EJNewEntry::class.java)
            startActivity(intent)
        }
    }

    private fun changeToListOfEntries(){
        ButtonManager.manageButtonVisibility(btnEJFirstEntry, false)
        rvEntriesList.visibility = View.VISIBLE
        ButtonManager.manageButtonVisibility(btnEJNewEntry, true)
        rvEntriesList.layoutManager = LinearLayoutManager(this)
        rvEntriesList.adapter = adapter
    }
}
