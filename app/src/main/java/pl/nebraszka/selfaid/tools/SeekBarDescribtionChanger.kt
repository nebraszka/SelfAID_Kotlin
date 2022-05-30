package pl.nebraszka.selfaid.tools

import android.widget.SeekBar
import android.widget.TextView

class SeekBarDescribtionChanger(val sb: SeekBar, var tvDescription: TextView) :
    SeekBar.OnSeekBarChangeListener {

    init {
        tvDescription.text = "${sb.progress}/${sb.max}"
    }

    override fun onProgressChanged(sb: SeekBar, progress: Int, fromUser: Boolean) {
        tvDescription.text = "$progress/${sb.max}"
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }
}