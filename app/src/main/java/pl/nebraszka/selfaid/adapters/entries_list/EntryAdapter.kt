package pl.nebraszka.selfaid.adapters.entries_list

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import pl.nebraszka.selfaid.entities.EJEntry
import pl.nebraszka.selfaid.view_models.EJMenuViewModel

class EntryAdapter(private val owner: LifecycleOwner, private val viewModel: EJMenuViewModel) : ListAdapter<EJEntry, EntryViewHolder>(
    EntryComparator()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        return EntryViewHolder.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current, owner, position)
        holder.setUpEntryClickListener()
        holder.setUpDeleteClickListener(viewModel)
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