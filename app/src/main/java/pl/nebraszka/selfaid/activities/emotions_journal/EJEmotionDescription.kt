package pl.nebraszka.selfaid.activities.emotions_journal

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.emotion_describtion.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDApplication
import pl.nebraszka.selfaid.view_models.EJEntryViewModel
import pl.nebraszka.selfaid.view_models.EJEntryViewModelFactory

class EJEmotionDescription: AppCompatActivity() {

    private val emotionViewModel: EJEntryViewModel by viewModels{
        EJEntryViewModelFactory((application as SelfAIDApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_describtion)

        val emotionName: String = intent.getStringExtra("EXTRA_EMOTION")!!

        tvEmotionName.text = emotionName

        tvEmotionDescribtion.text = intent.getStringExtra("EXTRA_DESCRIPTION")!! // TODO: może to trzeba pobierać z model view?

        btnEmotionDescribtionBack.setOnClickListener{
            this.finish()
        }
    }
}