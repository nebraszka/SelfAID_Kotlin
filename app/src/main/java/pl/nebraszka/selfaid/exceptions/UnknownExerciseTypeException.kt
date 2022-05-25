package pl.nebraszka.selfaid.exceptions

data class UnknownExerciseTypeException(
    override val message: String = "Unknown type of exercise. The program is unable to handle displaying this type. "
) : Exception(message)
