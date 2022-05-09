package pl.nebraszka.selfaid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.main_menu.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)

        btnEmotionsJournal.setOnClickListener {
            val intent = Intent(this, EmotionsJournalMenu::class.java)
            startActivity(intent)
        }
        }
}