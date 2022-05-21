package pl.nebraszka.selfaid.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TB_EJ_Entries")
data class EJEntry(
    @NonNull
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(defaultValue = "NULL", name = "title") val title: String?
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 1
}