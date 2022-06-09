package pl.nebraszka.selfaid.adapters.entries_list

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import pl.nebraszka.selfaid.entities.EJEntry

class EntryAdapter(private val owner: LifecycleOwner) : ListAdapter<EJEntry, EntryViewHolder>(
    EntryComparator()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        return EntryViewHolder.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current, owner, position)
        holder.setUpClickListener()
    }

    class EntryComparator : DiffUtil.ItemCallback<EJEntry>() {
        override fun areItemsTheSame(oldItem: EJEntry, newItem: EJEntry): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: EJEntry, newItem: EJEntry): Boolean {
            return oldItem.date == newItem.date
        }
    }
}