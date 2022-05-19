package pl.nebraszka.selfaid.activities.emotions_journal

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.dialog_date_picker.*
import kotlinx.android.synthetic.main.emotion_journal_entry.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDApplication
import pl.nebraszka.selfaid.adapters.ExerciseAdapter
import pl.nebraszka.selfaid.entities.Emotion
import pl.nebraszka.selfaid.entities.Exercise
import pl.nebraszka.selfaid.view_models.*
import java.util.*
import kotlin.collections.ArrayList

class EJEntry : AppCompatActivity() { // TODO: tytul, tak zeby sie zamrazal gdy juz cos wpiszemy

    private var emotionsList: List<Emotion> = ArrayList<Emotion>()
    private var exercisesList: List<Exercise> = ArrayList<Exercise>()

    private val viewModel: EJEntryViewModel by viewModels{
        EJEntryViewModelFactory((application as SelfAIDApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_journal_entry)

        btnEJDatePicker.setOnClickListener {
            changeDate(tvEJChosenDate)
        }

        viewModel.allEmotions.observe(owner = this) { emotions ->
            emotions.let {
                createEmotionAdapter(it, spnEJEmotions)
            }
        }

        var ex: Exercise = Exercise("lala", 1)
        var adapter = ExerciseAdapter()

        viewModel.allExercise.observe(owner = this) { exercises ->
            exercises.let {
                for(e in it)
                    println("--------------------" + e.topic + "-------------------")
                adapter.submitList(it)
            }
        }

        rvEJTasks.layoutManager  = LinearLayoutManager(this)
        rvEJTasks.adapter = adapter

        btnEJEmotionInfo.setOnClickListener {
            val intent = Intent(this, EJEmotionDescription::class.java)
            val choosenEmotion = spnEJEmotions.selectedItem.toString()
            //TODO: rejestrować to jakoś w view model?
            intent.putExtra("EXTRA_EMOTION", choosenEmotion)

            var description = emotionsList.filter { it.emotion.equals(choosenEmotion)}
            if(description.size == 0 || description.size > 1) {
                throw IllegalArgumentException("Each emotion must have description; descriptions must be unique!")
            //TODO: zrob wlasny wyjatek
            }
            else{
                intent.putExtra("EXTRA_DESCRIPTION", description.get(0).description)
                startActivity(intent)
            }
        }
    }

    fun createEmotionAdapter(emotions: List<Emotion>, spinner: Spinner){
        emotionsList = emotions

        var emotionsNames = emotions.map { it.emotion }

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, emotionsNames)
        spinner.adapter = adapter
    }

    // TODO : to chyba do innych klas

    fun changeDate(tv : TextView) {

        var date: Calendar = Calendar.getInstance()
        var thisAYear = date.get(Calendar.YEAR).toInt()
        var thisAMonth = date.get(Calendar.MONTH).toInt()
        var thisADay = date.get(Calendar.DAY_OF_MONTH).toInt()

        val dataPickerDialog = Dialog(this@EJEntry)
        dataPickerDialog.setContentView(R.layout.dialog_date_picker)
        dataPickerDialog.setCancelable(false)

        dataPickerDialog.EJDatePicker.init(thisAYear, thisAMonth, thisADay, DatePicker.OnDateChangedListener
        { view2, thisYear, thisMonth, thisDay ->
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

    fun manageButtonVisibility(btn : Button, visible: Boolean){
        if(visible == false) {
            btn.isClickable = false
            btn.visibility = View.GONE
        }
        else{
            btn.isClickable = true
            btn.visibility = View.VISIBLE
        }
    }
}

