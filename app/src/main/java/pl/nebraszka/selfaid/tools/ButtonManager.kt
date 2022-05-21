package pl.nebraszka.selfaid.tools

import android.view.View
import android.widget.Button

class ButtonManager {

    companion object{
        fun manageButtonVisibility(btn : Button, visible: Boolean){
            if(visible == false) {
                btn.isClickable = false
                btn.visibility = View.GONE
            }
            else{
                btn.isClickable = true
                btn.visibility = View.VISIBLE
            }
        }
    }
}