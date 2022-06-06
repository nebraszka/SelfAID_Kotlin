package pl.nebraszka.selfaid.adapters.entries_list

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_entry.view.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDDatabase
import pl.nebraszka.selfaid.activities.emotions_journal.EJSavedEntry

class EntryViewHolder(itemView: View, private val myContext: Context) :RecyclerView.ViewHolder(itemView){

    private val database = SelfAIDDatabase.getDatabase(itemView.context)
    private val entries = database.ejEntryDao().getEntries().asLiveData()

    companion object{
        fun createViewHolder(parent: ViewGroup): EntryViewHolder{
            val view: View = LayoutInflater.from(parent.context).inflate(
                R.layout.row_entry, parent, false)
            return EntryViewHolder(view, parent.context)
        }
    }
    fun bind(id: Int, owner: LifecycleOwner, position: Int) {
        entries.observe(owner, Observer {
            for(entry in it){
                if(entry.id == id){
                    itemView.id = id
                    itemView.btnEntry.text =
                        if(entry.title.isNullOrBlank())
                            reverseDate(entry.date)
                        else
                            entry.title + "\n" + reverseDate(entry.date)
                }
            }
        })
        if(position%2 == 0){
            itemView.btnEntry.setBackgroundColor(itemView.btnEntry.getContext().getResources().getColor(R.color.said_peach));
        }
    }

    fun reverseDate(date: String): String{
        return (date.substring(8,10) + " / " + date.substring(5,7) + " / " + date.substring(0,4))
    }

    fun setUpClickListener(){
        itemView.btnEntry.setOnClickListener {
            val intent = Intent(myContext, EJSavedEntry::class.java)
            intent.putExtra("EXTRA_ENTRY_ID", itemView.id)
            myContext.startActivity(intent)
        }
    }

}