import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(birthDateTime: LocalDateTime) {

    constructor(birthDate: LocalDate) : this(birthDate.atStartOfDay()) 

    val gigasecond = 1_000_000_000L

    val date = birthDateTime.plusSeconds(gigasecond)
}