

case class JsonArray(value: Seq[JsonValue]) extends JsonValue {
  override def toString: String = value.mkString("[", ",", "]")
}

object JsonArray {
  def parse(tokenizer: JsonTokenizer): JsonArray = {
    tokenizer.advance() // [

    var arr: Seq[JsonValue] = Seq.empty

    while (tokenizer.hasNext && tokenizer.peek != "]") {

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

      arr = arr :+ value

      if (tokenizer.peek == ",") tokenizer.advance() // ,
    }

    tokenizer.advance() // ]
    JsonArray(arr)
  }

}