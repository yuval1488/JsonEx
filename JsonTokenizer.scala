

case class JsonTokenizer(str: String) {
  var tokens: List[String] = str.split("").toList

  def hasNext: Boolean = if (tokens.nonEmpty) true else false
  def advance(): Unit = { tokens = tokens.tail }
  def next: String = {
    val head = tokens.head
    tokens = tokens.tail
    head
  }
  def peek: String = {
    tokens.head
  }
}