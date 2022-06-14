package pl.nebraszka.selfaid.emotions_journal.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.emotion_description.*
import pl.nebraszka.selfaid.R

// TODO: może zrobić z tego fragment?
class EJEmotionDescription : AppCompatActivity() {

    private val extraEmotionName = "EXTRA_EMOTION_NAME"
    private val extraEmotionDescription = "EXTRA_EMOTION_DESCRIPTION"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_description)

        tvEmotionName.text = intent.getStringExtra(extraEmotionName)
        tvEmotionDescribtion.text = intent.getStringExtra(extraEmotionDescription)

        btnEmotionDescribtionBack.setOnClickListener {
            this.finish()
        }
    }
}