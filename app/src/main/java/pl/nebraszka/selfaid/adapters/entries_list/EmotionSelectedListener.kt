package pl.nebraszka.selfaid.adapters.entries_list

import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.LifecycleOwner
import pl.nebraszka.selfaid.view_models.EJEntryViewModel

class EmotionSelectedListener(
    private val viewModel: EJEntryViewModel,
    private val owner: LifecycleOwner
) : AdapterView.OnItemSelectedListener {

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        viewModel.getEmotion(parent!!.getItemAtPosition(pos).toString())
            .observe(owner) {
                viewModel.chosenEmotion = it
            }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}