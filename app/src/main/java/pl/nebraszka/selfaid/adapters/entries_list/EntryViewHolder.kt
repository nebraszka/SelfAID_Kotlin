package pl.nebraszka.selfaid.adapters.entries_list

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_entry.view.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDDatabase
import pl.nebraszka.selfaid.emotions_journal.activities.EJSavedEntry
import pl.nebraszka.selfaid.entities.EJEntry
import pl.nebraszka.selfaid.tools.date.DateEditor

class EntryViewHolder(itemView: View, private val context: Context) :
    RecyclerView.ViewHolder(itemView) {

    private val database = SelfAIDDatabase.getDatabase(itemView.context)
    private val entries = database.ejEntryDao().getAllEntries().asLiveData()

    companion object {
        fun createViewHolder(parent: ViewGroup): EntryViewHolder {
            val view: View = LayoutInflater.from(parent.context).inflate(
                R.layout.row_entry, parent, false
            )
            return EntryViewHolder(view, parent.context)
        }
    }

    fun bind(entry: EJEntry, owner: LifecycleOwner, position: Int) {
        itemView.id = entry.id
        val reverseDate = DateEditor.reverseDate(entry.date)

        itemView.btnEntry.text =
            if (entry.title.isNullOrBlank())
                reverseDate
            else
                entry.title + '\n' + reverseDate

        val color =
            if (position % 2 == 0 && position % 3 != 0) {
                R.color.said_peach
            } else if (position % 3 == 0) {
                R.color.said_pink_light
            } else {
                R.color.said_pink_dark
            }

        itemView.btnEntry.setBackgroundColor(
            itemView.btnEntry.context.resources.getColor(color)
        );
    }

    fun setUpClickListener() {
        itemView.btnEntry.setOnClickListener {
            val intent = Intent(context, EJSavedEntry::class.java)
            intent.putExtra("EXTRA_ENTRY_ID", itemView.id)
            context.startActivity(intent)
        }
    }
}