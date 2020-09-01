package logme.log

import androidx.room.TypeConverter
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

class Converters {
    companion object {
        @JvmStatic val roomDateTimeFormatter: DateTimeFormatter = DateTimeFormat.forPattern("yyy-MM-dd HH-mm-ss")
    }

    @TypeConverter
    fun fromDateTimeString(value: String): DateTime? {
        return roomDateTimeFormatter.parseDateTime(value);
    }

    @TypeConverter
    fun dateToString(value: DateTime?): String? {
        return roomDateTimeFormatter.print(value)
    }
}