package pl.nebraszka.selfaid.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.main_menu.*
import pl.nebraszka.selfaid.R
import pl.nebraszka.selfaid.activities.emotions_journal.EJMenu

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)

        btnEmotionsJournal.setOnClickListener {
            val intent = Intent(this, EJMenu::class.java)
            startActivity(intent)
        }
    }
}