

trait JsonNumber extends JsonValue
object JsonNumber {
  private def isNumber(num: String): Boolean = {
    if (num == "0" |
      num == "1" |
      num == "2" |
      num == "3" |
      num == "4" |
      num == "5" |
      num == "6" |
      num == "7" |
      num == "8" |
      num == "9" |
      num == "-") true else false
  }

  def parse(tokenizer: JsonTokenizer): JsonNumber = {
    var result = ""
    while (tokenizer.hasNext && isNumber(tokenizer.peek)) result += tokenizer.next
    if (tokenizer.peek != ".") JsonInt(result.toInt) else {
      result += tokenizer.next //.
      while (tokenizer.hasNext && isNumber(tokenizer.peek)) result += tokenizer.next
      JsonDouble(result.toDouble)
    }
  }

}

case class JsonDouble(value: Double) extends JsonNumber{
  override def toString: String = value.toString
}
object JsonDouble {
  implicit def doubleToJsonDouble(value: Double): JsonDouble = JsonDouble(value)
}

case class JsonInt(value: Int) extends JsonNumber{
  override def toString: String = value.toString
}
object JsonInt {
  implicit def intToJsonInt(value: Int): JsonInt = JsonInt(value)
}
