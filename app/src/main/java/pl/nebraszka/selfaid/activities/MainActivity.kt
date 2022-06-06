package pl.nebraszka.selfaid.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.main_menu.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.activities.emotions_journal.EmotionsJournalActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)

        btnEmotionsJournal.setOnClickListener {
            val intent = Intent(this, EmotionsJournalActivity::class.java)
            startActivity(intent)
        }
    }

}