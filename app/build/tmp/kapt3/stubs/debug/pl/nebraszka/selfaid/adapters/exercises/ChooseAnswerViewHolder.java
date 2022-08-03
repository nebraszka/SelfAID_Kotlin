package pl.nebraszka.selfaid.adapters.exercises;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lpl/nebraszka/selfaid/adapters/exercises/ChooseAnswerViewHolder;", "Lpl/nebraszka/selfaid/adapters/exercises/ExerciseViewHolderBinder;", "view", "Landroid/view/View;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "exercise", "Lpl/nebraszka/selfaid/entities/EJExercise;", "multipleChoice", "", "(Landroid/view/View;Landroidx/lifecycle/LifecycleOwner;Lpl/nebraszka/selfaid/entities/EJExercise;Z)V", "database", "Lpl/nebraszka/selfaid/SelfAIDDatabase;", "attachAnswers", "", "answerSuggestions", "", "Lpl/nebraszka/selfaid/entities/AnswerSuggestion;", "bind", "bindSuggestedAnswers", "app_debug"})
public final class ChooseAnswerViewHolder extends pl.nebraszka.selfaid.adapters.exercises.ExerciseViewHolderBinder {
    private final boolean multipleChoice = false;
    private final pl.nebraszka.selfaid.SelfAIDDatabase database = null;
    
    public ChooseAnswerViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull()
    pl.nebraszka.selfaid.entities.EJExercise exercise, boolean multipleChoice) {
        super(null, null, null);
    }
    
    private final void bindSuggestedAnswers() {
    }
    
    private final void attachAnswers(java.util.List<pl.nebraszka.selfaid.entities.AnswerSuggestion> answerSuggestions) {
    }
    
    @java.lang.Override()
    public void bind() {
    }
}