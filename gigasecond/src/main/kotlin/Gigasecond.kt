import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(dateIn: Any) {

    val birthDateTime = 
        when(dateIn) {
            is LocalDate -> dateIn.atStartOfDay()
            is LocalDateTime -> dateIn
            else -> throw IllegalArgumentException("input date needs to be LocalDate or LocalDateTime")
        }

    val gigasecond = 1_000_000_000L

    val date = birthDateTime.plusSeconds(gigasecond)
}