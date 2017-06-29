

case class JsonField(key: JsonString, value: JsonValue) extends JsonValue {
  override def toString: String = s"""$key:$value"""
}
object JsonField {
  def parse(tokenizer: JsonTokenizer): JsonField = {
    val key = JsonString.parse(tokenizer)
    tokenizer.advance() //:
    val value: JsonValue = tokenizer.peek match {
      case "f" => JsonFalse.parse(tokenizer)
      case "n" => JsonNull.parse(tokenizer)
      case "t" => JsonTrue.parse(tokenizer)
      case "{" => JsonObject.parse(tokenizer)
      case "[" => JsonArray.parse(tokenizer)
      case "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9" | "-" => JsonNumber.parse(tokenizer)
      case "\"" => JsonString.parse(tokenizer)
      case _ => null
    }

    JsonField(key, value)
  }
}