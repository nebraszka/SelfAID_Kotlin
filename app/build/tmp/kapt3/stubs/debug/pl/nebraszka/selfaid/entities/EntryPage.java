package pl.nebraszka.selfaid.entities;

import java.lang.System;

@androidx.room.Entity(tableName = "TB_Entry_Pages", foreignKeys = {@androidx.room.ForeignKey(entity = pl.nebraszka.selfaid.entities.Emotion.class, childColumns = {"emotion_id"}, onDelete = 5, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = pl.nebraszka.selfaid.entities.EJEntry.class, childColumns = {"entry_id"}, onDelete = 5, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\b\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\b\u00a8\u0006\u001a"}, d2 = {"Lpl/nebraszka/selfaid/entities/EntryPage;", "", "pageNo", "", "emotionId", "entryId", "(III)V", "getEmotionId", "()I", "getEntryId", "setEntryId", "(I)V", "id", "getId", "setId", "getPageNo", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class EntryPage {
    @androidx.room.ColumnInfo(name = "page_number", index = true)
    private final int pageNo = 0;
    @androidx.room.ColumnInfo(name = "emotion_id", index = true)
    private final int emotionId = 0;
    @androidx.room.ColumnInfo(name = "entry_id", index = true)
    private int entryId;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final pl.nebraszka.selfaid.entities.EntryPage copy(@androidx.annotation.NonNull()
    int pageNo, @androidx.annotation.NonNull()
    int emotionId, @androidx.annotation.NonNull()
    int entryId) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public EntryPage(@androidx.annotation.NonNull()
    int pageNo, @androidx.annotation.NonNull()
    int emotionId, @androidx.annotation.NonNull()
    int entryId) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getPageNo() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getEmotionId() {
        return 0;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getEntryId() {
        return 0;
    }
    
    public final void setEntryId(int p0) {
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
}