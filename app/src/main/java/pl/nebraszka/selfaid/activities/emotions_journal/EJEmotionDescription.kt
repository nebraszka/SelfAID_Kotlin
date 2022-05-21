package pl.nebraszka.selfaid.activities.emotions_journal

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.emotion_describtion.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.SelfAIDApplication
import pl.nebraszka.selfaid.entities.Emotion
import pl.nebraszka.selfaid.view_models.EJEntryViewModel
import pl.nebraszka.selfaid.view_models.EJEntryViewModelFactory

class EJEmotionDescription: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_describtion)

        val chosenEmotion: Emotion = EJEntryViewModel.chosenEmotion!!
        tvEmotionName.text = chosenEmotion.emotion
        tvEmotionDescribtion.text = chosenEmotion.description

        btnEmotionDescribtionBack.setOnClickListener{
            this.finish()
        }
    }
}