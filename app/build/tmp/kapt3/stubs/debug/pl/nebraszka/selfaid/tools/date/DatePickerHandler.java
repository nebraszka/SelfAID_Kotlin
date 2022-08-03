package pl.nebraszka.selfaid.tools.date;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lpl/nebraszka/selfaid/tools/date/DatePickerHandler;", "", "()V", "Companion", "app_debug"})
public final class DatePickerHandler {
    @org.jetbrains.annotations.NotNull()
    public static final pl.nebraszka.selfaid.tools.date.DatePickerHandler.Companion Companion = null;
    private static final int datePickerDialog = pl.nebraszka.selfaid.R.layout.dialog_date_picker;
    private static java.util.Calendar date;
    private static int chosenYear;
    private static int chosenMonth;
    private static int chosenDay;
    
    public DatePickerHandler() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lpl/nebraszka/selfaid/tools/date/DatePickerHandler$Companion;", "", "()V", "chosenDay", "", "chosenMonth", "chosenYear", "date", "Ljava/util/Calendar;", "datePickerDialog", "changeTextViewDate", "", "context", "Landroid/content/Context;", "tv", "Landroid/widget/TextView;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void changeTextViewDate(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.widget.TextView tv) {
        }
    }
}