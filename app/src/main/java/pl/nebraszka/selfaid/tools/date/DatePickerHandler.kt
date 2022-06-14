package pl.nebraszka.selfaid.tools.date

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
        private var chosenYear = date[Calendar.YEAR].toInt()
        private var chosenMonth = date[Calendar.MONTH].toInt()
        private var chosenDay = date[Calendar.DAY_OF_MONTH].toInt()

        fun changeTextViewDate(context: Context, tv: TextView) {
            Locale.setDefault(Locale.forLanguageTag("pl"))

            val dataPickerDialog = Dialog(context)
            dataPickerDialog.setContentView(datePickerDialog)
            dataPickerDialog.setCancelable(false)

            dataPickerDialog.EJDatePicker.init(
                chosenYear, chosenMonth, chosenDay, DatePicker.OnDateChangedListener
                { _, thisYear, thisMonth, thisDay ->
                    chosenDay = thisDay
                    chosenMonth = thisMonth
                    chosenYear = thisYear
                })

            dataPickerDialog.tvDatePickerSave.setOnClickListener {
                tv.text = context.getString(
                    R.string.Date,
                    DateEditor.addZeroIfNeeded(chosenDay),
                    DateEditor.addZeroIfNeeded(chosenMonth + 1),
                    chosenYear
                )

                dataPickerDialog.dismiss()
            }
            dataPickerDialog.tvDatePickerCancel.setOnClickListener {
                dataPickerDialog.dismiss()
            }
            dataPickerDialog.show()
        }
    }
}