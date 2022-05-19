package pl.nebraszka.selfaid.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TB_Emotions_Journal")
data class EmotionsJournal(
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(defaultValue = "NULL", name = "title") val title: String?
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 1
}