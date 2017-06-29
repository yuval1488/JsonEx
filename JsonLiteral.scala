

trait JsonLiteral extends JsonValue

object JsonTrue extends JsonLiteral {
  override def toString: String = "true"

  def parse(tokenizer: JsonTokenizer): JsonTrue.type = {
    tokenizer.advance() // t
    tokenizer.advance() // r
    tokenizer.advance() // u
    tokenizer.advance() // e
    this
  }
}

object JsonFalse extends JsonLiteral {
  override def toString: String = "false"

  def parse(tokenizer: JsonTokenizer): JsonFalse.type = {
    tokenizer.advance() // f
    tokenizer.advance() // a
    tokenizer.advance() // l
    tokenizer.advance() // s
    tokenizer.advance() // e
    this
  }
}

object JsonNull extends JsonLiteral {
  override def toString: String = "null"

  def parse(tokenizer: JsonTokenizer): JsonNull.type = {
    tokenizer.advance() // n
    tokenizer.advance() // u
    tokenizer.advance() // l
    tokenizer.advance() // l
    this
  }
}