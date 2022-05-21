package pl.nebraszka.selfaid.tools

import android.widget.SeekBar
import android.widget.TextView

class SeekBarDescribtionChanger(var tvDescription: TextView) : SeekBar.OnSeekBarChangeListener {

    override fun onProgressChanged(sb: SeekBar, progress: Int, fromUser: Boolean) {
        tvDescription.text = "$progress/5"
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }
}