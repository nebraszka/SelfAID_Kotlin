package pl.nebraszka.selfaid.tools.date

class DateEditor {

    companion object {
        fun reverseDate(date: String): String {
            return if (date[3] == '/') {
                (date.substring(10, 14) + " / "
                        + date.substring(5, 7) + " / "
                        + date.substring(0, 2))
            } else {
                (date.substring(12, 14) + " / "
                        + date.substring(7, 9) + " / "
                        + date.substring(0, 4))
            }
        }

        fun addZeroIfNeeded(dayOrMonth: Int): String {
            return if (dayOrMonth < 10) {
                "0${dayOrMonth}"
            } else {
                dayOrMonth.toString()
            }
        }
    }
}