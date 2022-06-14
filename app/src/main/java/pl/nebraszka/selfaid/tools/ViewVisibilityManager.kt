package pl.nebraszka.selfaid.tools

import android.view.View
import android.view.ViewGroup

class ViewVisibilityManager {

    companion object {
        fun manage(view: View, visible: Boolean) {
            if (!visible) {
                view.isClickable = false
                view.visibility = View.GONE
            } else {
                view.isClickable = true
                view.visibility = View.VISIBLE
            }
        }

        fun manage(views: List<View>, visible: Boolean) {
            for (view in views) {
                manage(view, visible)
            }
        }

        fun manage(viewGroup: ViewGroup, visible: Boolean) {
            if (!visible) {
                viewGroup.isClickable = false
                viewGroup.visibility = View.GONE
            } else {
                viewGroup.isClickable = true
                viewGroup.visibility = View.VISIBLE
            }
        }
    }
}