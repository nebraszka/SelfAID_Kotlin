package pl.nebraszka.selfaid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.nebraszka.selfaid.emotions_journal.fragments.MainMenu

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        supportFragmentManager.beginTransaction().replace(R.id.mainContainerView, MainMenu()).commit()
    }
}