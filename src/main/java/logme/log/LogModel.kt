package logme.log

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.joda.time.DateTime

@Entity(tableName = "logs")
data class LogModel(
        @PrimaryKey(autoGenerate = true) val uid: Int?,
        @ColumnInfo(name = "message") val message: String?,
        @ColumnInfo(name = "priority") val priority: Int?,
        @ColumnInfo(name = "date") val date: DateTime?
) {
    constructor(message: String?, priority: Int?, date: DateTime?) : this(null, message, priority, date)
}