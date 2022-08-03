package pl.nebraszka.selfaid.tools

import android.app.Dialog
import android.content.Context
import kotlinx.android.synthetic.main.dialog_delete.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.view_models.EJMenuViewModel

class DeleteEntryPickerHandler {

    companion object {

        private const val deleteDialogLayout: Int = R.layout.dialog_delete

        fun deleteEntry(context: Context, viewModel: EJMenuViewModel, entryId: Int) {

            val deletePickerDialog = Dialog(context)
            deletePickerDialog.setContentView(deleteDialogLayout)
            deletePickerDialog.setCancelable(false)

            deletePickerDialog.tvDeleteCancel.setOnClickListener {
                deletePickerDialog.dismiss()
            }
            deletePickerDialog.tvDeleteConfirm.setOnClickListener {
                viewModel.deleteByEntryId(entryId)
                deletePickerDialog.dismiss()
            }

            deletePickerDialog.show()
        }
    }
}