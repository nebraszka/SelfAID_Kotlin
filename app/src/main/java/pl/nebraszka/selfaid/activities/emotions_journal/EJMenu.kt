package pl.nebraszka.selfaid.activities.emotions_journal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.emotion_journal_menu.*
import pl.nebraszka.selfaid.R

class EJMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emotion_journal_menu)


        btnEJFirstPage.setOnClickListener{
            val intent = Intent(this, EJEntry::class.java)
            startActivity(intent)
        }
    }
}