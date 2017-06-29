

case class JsonObject(value: JsonField*) extends JsonValue {
  override def toString: String = value.mkString("{", ",", "}")
}
object JsonObject {
  def parse(tokenizer: JsonTokenizer): JsonObject = {

    tokenizer.advance() // {

    var arr: Seq[JsonField] = Seq.empty

    while (tokenizer.hasNext && tokenizer.peek != "}") {

      arr = arr :+ JsonField.parse(tokenizer)
      if (tokenizer.peek == ",") tokenizer.advance() // ,

    }
    tokenizer.advance() // }
    JsonObject(arr:_*)
  }
}