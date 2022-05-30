package pl.nebraszka.selfaid.tools

import android.view.View
import android.widget.Button
import android.widget.ImageButton

class ButtonManager {

    companion object {
        fun manageButtonVisibility(btn: Button, visible: Boolean) {
            if (visible == false) {
                btn.isClickable = false
                btn.visibility = View.GONE
            } else {
                btn.isClickable = true
                btn.visibility = View.VISIBLE
            }
        }

        fun manageButtonVisibility(btn: ImageButton, visible: Boolean) {
            if (visible == false) {
                btn.isClickable = false
                btn.visibility = View.GONE
            } else {
                btn.isClickable = true
                btn.visibility = View.VISIBLE
            }
        }

        fun manageButtonVisibility(btns: List<Button>, visible: Boolean) {
            for(btn in btns){
                manageButtonVisibility(btn, visible)
            }
        }
    }
}