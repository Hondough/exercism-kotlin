class Anagram(val key: String) {
  fun match(possibiles: List<String>): Set<String> = 
    possibiles
      .filterNot { it.equals(key, true) }
      .filter { it.toLowerCase().groupBy { it } == key.toLowerCase().groupBy { it } }
      .toSet()
}