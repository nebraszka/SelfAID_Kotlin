package pl.nebraszka.selfaid.adapters.exercises;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lpl/nebraszka/selfaid/adapters/exercises/ExerciseAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lpl/nebraszka/selfaid/entities/EJExercise;", "Lpl/nebraszka/selfaid/adapters/exercises/ExerciseViewHolder;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getItemViewType", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ExerciseComparator", "app_debug"})
public final class ExerciseAdapter extends androidx.recyclerview.widget.ListAdapter<pl.nebraszka.selfaid.entities.EJExercise, pl.nebraszka.selfaid.adapters.exercises.ExerciseViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LifecycleOwner owner = null;
    
    public ExerciseAdapter(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LifecycleOwner getOwner() {
        return null;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public pl.nebraszka.selfaid.adapters.exercises.ExerciseViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.adapters.exercises.ExerciseViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lpl/nebraszka/selfaid/adapters/exercises/ExerciseAdapter$ExerciseComparator;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lpl/nebraszka/selfaid/entities/EJExercise;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class ExerciseComparator extends androidx.recyclerview.widget.DiffUtil.ItemCallback<pl.nebraszka.selfaid.entities.EJExercise> {
        
        public ExerciseComparator() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        pl.nebraszka.selfaid.entities.EJExercise oldItem, @org.jetbrains.annotations.NotNull()
        pl.nebraszka.selfaid.entities.EJExercise newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        pl.nebraszka.selfaid.entities.EJExercise oldItem, @org.jetbrains.annotations.NotNull()
        pl.nebraszka.selfaid.entities.EJExercise newItem) {
            return false;
        }
    }
}