package logme.log

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = arrayOf(LogModel::class), version = 1)
@TypeConverters(Converters::class)
abstract class LogsDatabase : RoomDatabase() {
    abstract fun logDao(): LogDao
}