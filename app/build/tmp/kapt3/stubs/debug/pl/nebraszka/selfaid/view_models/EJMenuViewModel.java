package pl.nebraszka.selfaid.view_models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lpl/nebraszka/selfaid/view_models/EJMenuViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lpl/nebraszka/selfaid/repositories/SelfAIDRepository;", "(Lpl/nebraszka/selfaid/repositories/SelfAIDRepository;)V", "allEntries", "Landroidx/lifecycle/LiveData;", "", "Lpl/nebraszka/selfaid/entities/EJEntry;", "getAllEntries", "()Landroidx/lifecycle/LiveData;", "deleteByEntryId", "Lkotlinx/coroutines/Job;", "entryId", "", "app_debug"})
public final class EJMenuViewModel extends androidx.lifecycle.ViewModel {
    private final pl.nebraszka.selfaid.repositories.SelfAIDRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<pl.nebraszka.selfaid.entities.EJEntry>> allEntries = null;
    
    public EJMenuViewModel(@org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.repositories.SelfAIDRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<pl.nebraszka.selfaid.entities.EJEntry>> getAllEntries() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteByEntryId(int entryId) {
        return null;
    }
}