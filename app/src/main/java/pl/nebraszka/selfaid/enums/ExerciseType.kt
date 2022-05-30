package pl.nebraszka.selfaid.enums

import pl.nebraszka.selfaid.R

enum class ExerciseType(val id: Int, val layoutId: Int, val topicTextView: Int, val answerHolderId: Int) {

    VIEW_SCALE_QUESTION(1, R.layout.row_scale_question, R.id.tvScaleQuestionRow, R.id.scaleQuestionRow),
    VIEW_CHOOSE_OPTION(2, R.layout.row_choose_option, R.id.tvChooseAnswerRow, R.id.llAnswerSuggestions),
    VIEW_TODO_TASK(3, R.layout.row_todo_task, R.id.tvTaskRow, R.id.checkBoxTaskRow),
    VIEW_QUESTION(4, R.layout.row_question, R.id.tvQuestionRow, R.id.etQuestionRow),
    VIEW_MULTICHOOSE_OPTION(5, R.layout.row_choose_option, R.id.tvChooseAnswerRow, R.id.llAnswerSuggestions);

    companion object {
        fun findById(id: Int): ExerciseType? {
            return ExerciseType.values().find { it.id == id }
        }
    }
}