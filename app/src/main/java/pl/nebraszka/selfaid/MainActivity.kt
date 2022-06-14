package pl.nebraszka.selfaid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.main_menu.*
import pl.nebraszka.selfaid.emotions_journal.activities.EJMenu

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)

        btnEmotionsJournal.setOnClickListener {
            val intent = Intent(this, EJMenu::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}