package pl.edu.pw.ee.passdatabetweenactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SavedTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val name = intent.getStringExtra("EXTRA_TEXT")

        tvSavedText.text = name

        btnEdit.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                it.putExtra("EXTRA_TO_EDIT", name)
                startActivity(it)
            }
        }
    }
}