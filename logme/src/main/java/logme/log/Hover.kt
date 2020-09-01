package logme.log

import android.app.Activity
import android.content.Context
import android.view.WindowManager
import io.mattcarroll.hover.HoverView
import io.mattcarroll.hover.window.WindowViewController

class Hover {

    companion object {
        @JvmStatic fun openLogme(activity: Activity) {
            val hover = HoverView.createForWindow(activity, WindowViewController((activity.getSystemService(Context.WINDOW_SERVICE) as WindowManager?)!!))
            hover.setOnExitListener {}
            hover.addToWindow()
            hover.setMenu(HoverLogMenu(activity))
            hover.collapse()
        }
    }
}