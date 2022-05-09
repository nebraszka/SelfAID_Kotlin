package pl.nebraszka.selfaid

import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.dialog_date_picker.*
import kotlinx.android.synthetic.main.emotion_journal_entry.*
import java.util.*

class EmotionsJournalEntry : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_journal_entry)

        btnEJDatePicker.setOnClickListener {
            changeDate(tvEJChosenDate)
        }
    }

    fun changeDate(tv : TextView) {

        var date: Calendar = Calendar.getInstance()
        var thisAYear = date.get(Calendar.YEAR).toInt()
        var thisAMonth = date.get(Calendar.MONTH).toInt()
        var thisADay = date.get(Calendar.DAY_OF_MONTH).toInt()

        val dataPickerDialog = Dialog(this)
        dataPickerDialog.setContentView(R.layout.dialog_date_picker)
        dataPickerDialog.setCancelable(false)
        dataPickerDialog.EJDatePicker.init(thisAYear, thisAMonth, thisADay, DatePicker.OnDateChangedListener{ view2, thisYear, thisMonth, thisDay ->
            thisAMonth = thisMonth + 1
            thisADay = thisDay
            thisAYear = thisYear

        })
        dataPickerDialog.tvDatePickerSave.setOnClickListener{
            tv.text = "$thisADay / $thisAMonth / $thisAYear"
            dataPickerDialog.dismiss()
        }
        dataPickerDialog.tvDatePickerCancel.setOnClickListener{
            dataPickerDialog.dismiss()
        }

        dataPickerDialog.show()
    }

}