package logme.log

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.mattcarroll.hover.Content
import io.mattcarroll.hover.HoverMenu
import java.util.*

class HoverLogMenu(activity: Activity) : HoverMenu() {

    private var mContext: Context = activity
    private var mSection: Section

    init {
        val view = ImageView(mContext)
        view.scaleType = ImageView.ScaleType.CENTER_INSIDE
        view.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_hover_menu))
        mSection = Section(
                SectionId("1"),
                view,
                object : Content {
                    override fun getView(): View {
                        val root = LayoutInflater.from(mContext).inflate(R.layout.hover_log, null)
                        val rvLogs = root.findViewById<RecyclerView>(R.id.rv_logs)
                        val adapterLogs = LogsAdapter()
                        rvLogs.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
                        rvLogs.adapter = adapterLogs
                        Thread {
                            val logs = Logme.DatabaseTree.instance.db.logDao().getAllLogs()
                            activity.runOnUiThread {
                                adapterLogs.logs = logs
                            }
                        }.start()
                        return root
                    }

                    override fun onShown() {

                    }

                    override fun onHidden() {

                    }

                    override fun isFullscreen(): Boolean {
                        return false;
                    }
                }
        )
    }

    override fun getSections(): MutableList<Section> {
        return Collections.singletonList(mSection)
    }

    override fun getId(): String {
        return "1"
    }

    override fun getSection(index: Int): Section? {
        return mSection
    }

    override fun getSection(sectionId: SectionId): Section? {
        return mSection
    }

    override fun getSectionCount(): Int {
        return 1
    }
}