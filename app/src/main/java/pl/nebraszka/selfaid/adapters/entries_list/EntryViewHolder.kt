package pl.nebraszka.selfaid.adapters.entries_list

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
import java.text.FieldPosition

class EntryViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

    private val database = SelfAIDDatabase.getDatabase(itemView.context)
    val entries = database.ejEntryDao().getEntries().asLiveData()

    companion object{
        fun createViewHolder(parent: ViewGroup): EntryViewHolder{
            val view: View = LayoutInflater.from(parent.context).inflate(
                R.layout.row_entry, parent, false)
            return EntryViewHolder(view)
        }
    }
    fun bind(id: Int, owner: LifecycleOwner, position: Int) {
        entries.observe(owner, Observer {
            for(entry in it){
                if(entry.id == id){
                    itemView.btnEntry.text =
                        if(entry.title.isNullOrBlank())
                            entry.date
                        else
                            entry.title + "\n" + entry.date
                }
            }
        })
        if(position%2 == 0){
            itemView.btnEntry.setBackgroundColor(itemView.btnEntry.getContext().getResources().getColor(R.color.said_peach));
        }
    }
}