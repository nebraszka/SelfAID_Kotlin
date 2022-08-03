package pl.nebraszka.selfaid.view_models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\u000b\u001a\u00020\u0014J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\u0006\u0010\u000b\u001a\u00020\u0014R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lpl/nebraszka/selfaid/view_models/EJSavedEntryViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lpl/nebraszka/selfaid/repositories/SelfAIDRepository;", "(Lpl/nebraszka/selfaid/repositories/SelfAIDRepository;)V", "allEJExercises", "Landroidx/lifecycle/LiveData;", "", "Lpl/nebraszka/selfaid/entities/EJExercise;", "getAllEJExercises", "()Landroidx/lifecycle/LiveData;", "entryId", "Landroidx/lifecycle/MutableLiveData;", "", "getEntryId", "()Landroidx/lifecycle/MutableLiveData;", "setEntryId", "(Landroidx/lifecycle/MutableLiveData;)V", "getEntryEmotion", "Lpl/nebraszka/selfaid/entities/Emotion;", "", "getEntryInfo", "Lpl/nebraszka/selfaid/entities/EJEntry;", "app_debug"})
public final class EJSavedEntryViewModel extends androidx.lifecycle.ViewModel {
    private final pl.nebraszka.selfaid.repositories.SelfAIDRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<pl.nebraszka.selfaid.entities.EJExercise>> allEJExercises = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Long> entryId;
    
    public EJSavedEntryViewModel(@org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.repositories.SelfAIDRepository repository) {
        super();
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
    public final androidx.lifecycle.LiveData<pl.nebraszka.selfaid.entities.EJEntry> getEntryInfo(int entryId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<pl.nebraszka.selfaid.entities.Emotion> getEntryEmotion(int entryId) {
        return null;
    }
}