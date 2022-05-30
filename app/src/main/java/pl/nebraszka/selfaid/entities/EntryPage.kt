package pl.nebraszka.selfaid.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "TB_Entry_Pages",
    foreignKeys = arrayOf(
        ForeignKey(
            entity = Emotion::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("emotion_id"),
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = EJEntry::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("entry_id"),
            onDelete = CASCADE
        )
    )
)
data class EntryPage(
    @NonNull
    @ColumnInfo(name = "page_number", index = true) val pageNo: Int,
    @NonNull
    @ColumnInfo(name = "emotion_id", index = true) val emotionId: Int,
    @NonNull
    @ColumnInfo(name = "entry_id", index = true) var entryId: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}