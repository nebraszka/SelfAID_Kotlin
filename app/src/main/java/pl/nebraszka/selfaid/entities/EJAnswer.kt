package pl.nebraszka.selfaid.entities

class EJAnswer(
    val text_answer: String?,
    val answer: String?)
{
    override fun toString(): String {
        return "\n\n$text_answer $answer\n\n"
    }
}