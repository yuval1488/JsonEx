trait JsonValue {
  override def toString: String
}

object JsonValue {

  implicit def tupleToJsonField[T, R](value: (T, R))(implicit conv: T => JsonString, conv2: R => JsonValue): JsonField =
    JsonField(value._1, value._2)

  implicit def stringToJsonString(value: String): JsonString = JsonString(value)

  implicit def doubleToJsonDouble(value: Double): JsonDouble = JsonDouble(value)
  implicit def intToJsonInt(value: Int): JsonInt = JsonInt(value)
}