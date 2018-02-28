class PhoneNumber(private val _number: String) {
    val number: String? = _number.filter { it.isDigit() }
                .let { it.drop(if (it.startsWith('1')) 1 else 0) }
                .let { if ( isValid(it) ) it else null }
        
    fun isValid(s: String): Boolean = 
        s.length == 10
            && !"01".contains(s[0])
            && !"01".contains(s[3])
}