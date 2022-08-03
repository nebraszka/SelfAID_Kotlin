package pl.nebraszka.selfaid.emotions_journal;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lpl/nebraszka/selfaid/emotions_journal/EmotionSectionManager;", "", "()V", "Companion", "app_debug"})
public final class EmotionSectionManager {
    @org.jetbrains.annotations.NotNull()
    public static final pl.nebraszka.selfaid.emotions_journal.EmotionSectionManager.Companion Companion = null;
    
    public EmotionSectionManager() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ$\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\r\u001a\u00020\u000e\u00a8\u0006\u000f"}, d2 = {"Lpl/nebraszka/selfaid/emotions_journal/EmotionSectionManager$Companion;", "", "()V", "emotionInfoIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "emotion", "Lpl/nebraszka/selfaid/entities/Emotion;", "initiateEmotionSpinner", "", "emotions", "", "spinner", "Landroid/widget/Spinner;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Intent emotionInfoIntent(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        pl.nebraszka.selfaid.entities.Emotion emotion) {
            return null;
        }
        
        public final void initiateEmotionSpinner(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.util.List<pl.nebraszka.selfaid.entities.Emotion> emotions, @org.jetbrains.annotations.NotNull()
        android.widget.Spinner spinner) {
        }
    }
}