package pl.nebraszka.selfaid.adapters.entries_list;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lpl/nebraszka/selfaid/adapters/entries_list/EntryAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lpl/nebraszka/selfaid/entities/EJEntry;", "Lpl/nebraszka/selfaid/adapters/entries_list/EntryViewHolder;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "viewModel", "Lpl/nebraszka/selfaid/view_models/EJMenuViewModel;", "(Landroidx/lifecycle/LifecycleOwner;Lpl/nebraszka/selfaid/view_models/EJMenuViewModel;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "EntryComparator", "app_debug"})
public final class EntryAdapter extends androidx.recyclerview.widget.ListAdapter<pl.nebraszka.selfaid.entities.EJEntry, pl.nebraszka.selfaid.adapters.entries_list.EntryViewHolder> {
    private final androidx.lifecycle.LifecycleOwner owner = null;
    private final pl.nebraszka.selfaid.view_models.EJMenuViewModel viewModel = null;
    
    public EntryAdapter(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.view_models.EJMenuViewModel viewModel) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public pl.nebraszka.selfaid.adapters.entries_list.EntryViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.adapters.entries_list.EntryViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lpl/nebraszka/selfaid/adapters/entries_list/EntryAdapter$EntryComparator;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lpl/nebraszka/selfaid/entities/EJEntry;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class EntryComparator extends androidx.recyclerview.widget.DiffUtil.ItemCallback<pl.nebraszka.selfaid.entities.EJEntry> {
        
        public EntryComparator() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        pl.nebraszka.selfaid.entities.EJEntry oldItem, @org.jetbrains.annotations.NotNull()
        pl.nebraszka.selfaid.entities.EJEntry newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        pl.nebraszka.selfaid.entities.EJEntry oldItem, @org.jetbrains.annotations.NotNull()
        pl.nebraszka.selfaid.entities.EJEntry newItem) {
            return false;
        }
    }
}