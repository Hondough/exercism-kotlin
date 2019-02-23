

class Robot {
  var name = findName()
    private set

  init {
    names += name
  }
  
  // don't remove the current name right away to ensure that the new name
  // generated isn't the same.
  fun reset(): Unit {
    var oldName = name
    name = findName()
    names -= oldName
    names += name
  }

  companion object {
    val chars = ('A'..'Z')
    val nums = ('0'..'9')
    val format = listOf(chars, chars, nums, nums, nums)
    val names = HashSet<String>()

    fun findName():String = generateSequence { createName() }
      .filterNot { names.contains(it) }
      .first()
    
    fun createName() = format.map { it.random() } .joinToString("")
  }
}