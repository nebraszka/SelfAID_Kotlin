package pl.nebraszka.selfaid.tools

import android.app.Dialog
import android.content.Context
import android.widget.DatePicker
import android.widget.TextView
import kotlinx.android.synthetic.main.dialog_date_picker.*
import pl.nebraszka.selfaid.R
import java.util.*

class DatePickerHandler {

    companion object {

        private const val datePickerDialog: Int = R.layout.dialog_date_picker

        private var date: Calendar = Calendar.getInstance()
        private var chosenYear = date.get(Calendar.YEAR).toInt()
        private var chosenMonth = date.get(Calendar.MONTH).toInt()
        private var chosenDay = date.get(Calendar.DAY_OF_MONTH).toInt()

        fun changeTextViewDate(context: Context, tv: TextView) {
            val dataPickerDialog = Dialog(context)
            dataPickerDialog.setContentView(datePickerDialog)
            dataPickerDialog.setCancelable(false)

            dataPickerDialog.EJDatePicker.init(
                chosenYear, chosenMonth, chosenDay, DatePicker.OnDateChangedListener
                { view2, thisYear, thisMonth, thisDay ->
                    chosenMonth = thisMonth + 1
                    chosenDay = thisDay
                    chosenYear = thisYear
                })

            dataPickerDialog.tvDatePickerSave.setOnClickListener {
                tv.text = "$chosenDay / $chosenMonth / $chosenYear"
                dataPickerDialog.dismiss()
            }
            dataPickerDialog.tvDatePickerCancel.setOnClickListener {
                dataPickerDialog.dismiss()
            }
            dataPickerDialog.show()
        }
    }
}