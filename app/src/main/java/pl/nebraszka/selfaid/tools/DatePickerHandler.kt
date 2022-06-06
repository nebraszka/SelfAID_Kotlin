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

                tv.text = "${addZeroIfNeeded(chosenDay)} / ${addZeroIfNeeded(chosenMonth+1)} / $chosenYear"

                dataPickerDialog.dismiss()
            }
            dataPickerDialog.tvDatePickerCancel.setOnClickListener {
                dataPickerDialog.dismiss()
            }
            dataPickerDialog.show()
        }

        private fun addZeroIfNeeded(dayOrMonth: Int): String{
            return if(dayOrMonth < 10){
                "0${dayOrMonth}"
            }
            else {
                dayOrMonth.toString()
            }
        }
    }

}