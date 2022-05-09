package pl.nebraszka.selfaid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.emotion_journal_menu.*

class EmotionsJournalMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_journal_menu)


        btnEJNewPage.setOnClickListener{
            val intent = Intent(this, EmotionsJournalEntry::class.java)
            startActivity(intent)
        }
    }
}