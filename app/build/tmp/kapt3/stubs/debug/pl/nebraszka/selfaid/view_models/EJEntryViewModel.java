package pl.nebraszka.selfaid.view_models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\u0014\u0010$\u001a\u00020\u001e2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0007J\u0014\u0010\'\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010(\u001a\u00020)R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lpl/nebraszka/selfaid/view_models/EJEntryViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lpl/nebraszka/selfaid/repositories/SelfAIDRepository;", "(Lpl/nebraszka/selfaid/repositories/SelfAIDRepository;)V", "allEJExercises", "Landroidx/lifecycle/LiveData;", "", "Lpl/nebraszka/selfaid/entities/EJExercise;", "getAllEJExercises", "()Landroidx/lifecycle/LiveData;", "allEmotions", "Lpl/nebraszka/selfaid/entities/Emotion;", "getAllEmotions", "chosenEmotion", "getChosenEmotion", "()Lpl/nebraszka/selfaid/entities/Emotion;", "setChosenEmotion", "(Lpl/nebraszka/selfaid/entities/Emotion;)V", "entryId", "Landroidx/lifecycle/MutableLiveData;", "", "getEntryId", "()Landroidx/lifecycle/MutableLiveData;", "setEntryId", "(Landroidx/lifecycle/MutableLiveData;)V", "pageId", "getPageId", "setPageId", "addEntry", "", "ejEntry", "Lpl/nebraszka/selfaid/entities/EJEntry;", "addPage", "page", "Lpl/nebraszka/selfaid/entities/EntryPage;", "addResponds", "responds", "Lpl/nebraszka/selfaid/entities/EJRespond;", "getEmotion", "name", "", "app_debug"})
public final class EJEntryViewModel extends androidx.lifecycle.ViewModel {
    private final pl.nebraszka.selfaid.repositories.SelfAIDRepository repository = null;
    @org.jetbrains.annotations.Nullable()
    private pl.nebraszka.selfaid.entities.Emotion chosenEmotion;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<pl.nebraszka.selfaid.entities.Emotion>> allEmotions = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<pl.nebraszka.selfaid.entities.EJExercise>> allEJExercises = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Long> entryId;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Long> pageId;
    
    public EJEntryViewModel(@org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.repositories.SelfAIDRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final pl.nebraszka.selfaid.entities.Emotion getChosenEmotion() {
        return null;
    }
    
    public final void setChosenEmotion(@org.jetbrains.annotations.Nullable()
    pl.nebraszka.selfaid.entities.Emotion p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<pl.nebraszka.selfaid.entities.Emotion>> getAllEmotions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<pl.nebraszka.selfaid.entities.EJExercise>> getAllEJExercises() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Long> getEntryId() {
        return null;
    }
    
    public final void setEntryId(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Long> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Long> getPageId() {
        return null;
    }
    
    public final void setPageId(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Long> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<pl.nebraszka.selfaid.entities.Emotion> getEmotion(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    public final void addEntry(@org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.entities.EJEntry ejEntry) {
    }
    
    public final void addPage(@org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.entities.EntryPage page) {
    }
    
    public final void addResponds(@org.jetbrains.annotations.NotNull()
    java.util.List<pl.nebraszka.selfaid.entities.EJRespond> responds) {
    }
}