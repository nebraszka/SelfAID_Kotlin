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
import pl.nebraszka.selfaid.adapters.exercises.ExerciseAdapter
import pl.nebraszka.selfaid.tools.ButtonManager
import pl.nebraszka.selfaid.view_models.EJMenuViewModel
import pl.nebraszka.selfaid.view_models.EJMenuViewModelFactory

class EJMenu : AppCompatActivity() {
    private val viewModel: EJMenuViewModel by viewModels {
        EJMenuViewModelFactory((application as SelfAIDApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_journal_menu)

        viewModel.numberOfEntries.observe(this, Observer {
            if( it > 0){
                ButtonManager.manageButtonVisibility(btnEJFirstEntry, false)
                rvEntriesList.visibility = View.VISIBLE
                ButtonManager.manageButtonVisibility(btnEJNewPage, true)

                val adapter = EntryAdapter(this)
                viewModel.allEntries.observe(this) {
                    adapter.submitList(it)
                }
                rvEntriesList.layoutManager = LinearLayoutManager(this)
                rvEntriesList.adapter = adapter
            }
        })

        btnEJNewPage.setOnClickListener {
            val intent = Intent(this, EJEntry::class.java)
            startActivity(intent)
        }

        btnEJFirstEntry.setOnClickListener {
            val intent = Intent(this, EJEntry::class.java)
            startActivity(intent)
        }
    }
}
