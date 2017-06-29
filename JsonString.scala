

case class JsonString(value: String) extends JsonValue {
  override def toString: String = s""""$value""""
}
object JsonString {
  def parse(tokenizer: JsonTokenizer): JsonString = {
    var result: String = ""
    tokenizer.advance() //"
    while (tokenizer.hasNext && tokenizer.peek != "\"") {
      result += tokenizer.next
    }
    tokenizer.advance() //"
    JsonString(result)
  }
}