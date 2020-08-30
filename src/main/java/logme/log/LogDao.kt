package logme.log

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LogDao {
    @Query("SELECT * FROM logs")
    fun getAllLogs(): List<LogModel>

    @Insert
    fun insertAll(vararg logs: LogModel)

    @Delete
    fun delete(log: LogModel)
}