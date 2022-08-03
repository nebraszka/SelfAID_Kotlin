package pl.nebraszka.selfaid.adapters.exercises;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H&J\u0006\u0010\u0011\u001a\u00020\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lpl/nebraszka/selfaid/adapters/exercises/ExerciseViewHolderBinder;", "", "view", "Landroid/view/View;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "exercise", "Lpl/nebraszka/selfaid/entities/EJExercise;", "(Landroid/view/View;Landroidx/lifecycle/LifecycleOwner;Lpl/nebraszka/selfaid/entities/EJExercise;)V", "getExercise", "()Lpl/nebraszka/selfaid/entities/EJExercise;", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getView", "()Landroid/view/View;", "bind", "", "bindTopicAndId", "app_debug"})
public abstract class ExerciseViewHolderBinder {
    @org.jetbrains.annotations.NotNull()
    private final android.view.View view = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LifecycleOwner owner = null;
    @org.jetbrains.annotations.NotNull()
    private final pl.nebraszka.selfaid.entities.EJExercise exercise = null;
    
    public ExerciseViewHolderBinder(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.entities.EJExercise exercise) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LifecycleOwner getOwner() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final pl.nebraszka.selfaid.entities.EJExercise getExercise() {
        return null;
    }
    
    public final void bindTopicAndId() {
    }
    
    public abstract void bind();
}