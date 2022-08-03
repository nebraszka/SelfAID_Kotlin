package pl.nebraszka.selfaid.entities;

import java.lang.System;

@androidx.room.Entity(tableName = "TB_EJ_Responds", foreignKeys = {@androidx.room.ForeignKey(entity = pl.nebraszka.selfaid.entities.AnswerSuggestion.class, childColumns = {"chosen_answer"}, onDelete = 5, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = pl.nebraszka.selfaid.entities.EntryPage.class, childColumns = {"page_id"}, onDelete = 5, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = pl.nebraszka.selfaid.entities.EJExercise.class, childColumns = {"exercise_id"}, onDelete = 5, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J:\u0010\u0019\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0007H\u00d6\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lpl/nebraszka/selfaid/entities/EJRespond;", "", "exerciseId", "", "pageId", "choosenAnsw", "textAnsw", "", "(IILjava/lang/Integer;Ljava/lang/String;)V", "getChoosenAnsw", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExerciseId", "()I", "id", "getId", "setId", "(I)V", "getPageId", "getTextAnsw", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(IILjava/lang/Integer;Ljava/lang/String;)Lpl/nebraszka/selfaid/entities/EJRespond;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class EJRespond {
    @androidx.room.ColumnInfo(name = "exercise_id", index = true)
    private final int exerciseId = 0;
    @androidx.room.ColumnInfo(name = "page_id", index = true)
    private final int pageId = 0;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "chosen_answer", index = true)
    private final java.lang.Integer choosenAnsw = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "text_answer")
    private final java.lang.String textAnsw = null;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final pl.nebraszka.selfaid.entities.EJRespond copy(@androidx.annotation.NonNull()
    int exerciseId, @androidx.annotation.NonNull()
    int pageId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer choosenAnsw, @org.jetbrains.annotations.Nullable()
    java.lang.String textAnsw) {
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
    
    public EJRespond(@androidx.annotation.NonNull()
    int exerciseId, @androidx.annotation.NonNull()
    int pageId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer choosenAnsw, @org.jetbrains.annotations.Nullable()
    java.lang.String textAnsw) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getExerciseId() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getPageId() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getChoosenAnsw() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTextAnsw() {
        return null;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
}