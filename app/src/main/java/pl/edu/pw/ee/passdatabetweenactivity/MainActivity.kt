package pl.edu.pw.ee.passdatabetweenactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toEdit : String? = intent.getStringExtra("EXTRA_TO_EDIT")
        etTextField.text.append(toEdit ?: "")

        btnSave.setOnClickListener {
            val savedText = etTextField.text.toString()

            Intent(this, SavedTextActivity::class.java).also {
                it.putExtra("EXTRA_TEXT", savedText)
                startActivity(it)
            }
        }
    }
}