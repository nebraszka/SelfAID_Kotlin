package pl.nebraszka.selfaid.activities.emotions_journal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.emotion_description.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.entities.Emotion


class EJEmotionDescription : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_description)

        val gson = Gson()
        val chosenEmotion: Emotion = gson.fromJson<Emotion>(intent.getStringExtra("EXTRA_EMOTION"), Emotion::class.java)
        tvEmotionName.text = chosenEmotion.emotion
        tvEmotionDescribtion.text = chosenEmotion.description

        btnEmotionDescribtionBack.setOnClickListener {
            this.finish()
        }
    }
}