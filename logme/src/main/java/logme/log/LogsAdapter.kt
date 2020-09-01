package logme.log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LogsAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    var logs: List<LogModel> = ArrayList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_log, parent, false)
        return LogItemViewHolder(v)
    }

    override fun getItemCount(): Int {
        return logs.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class LogItemViewHolder(itemView: View) : BaseViewHolder(itemView) {

        private var mTvLogPriority: TextView = itemView.findViewById(R.id.tv_log_priority)
        private var mTvLogMessage: TextView = itemView.findViewById(R.id.tv_log_message)

        override fun bind(pos: Int) {
            mTvLogMessage.text = logs[pos].message
            mTvLogPriority.text = logs[pos].priority.toString()
        }

    }
}