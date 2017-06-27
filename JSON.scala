/**
  * Created by yuvals on 27/06/2017.
  */

object JSON {

  trait Value {
    override def toString: String
    def toPrettyString(indent: Int = 0): String = getIndent(indent) + toString

    def getIndent(indent: Int): String = {
      val temp = for (i <- 1 to indent) yield "\t"
      temp.mkString("")
    }
  }

  case class JsonString(value: String) extends Value {
    override def toString: String = s""""$value""""
  }

  case class JsonDouble(value: Double) extends Value {
    override def toString: String = value.toString
  }

  case class JsonInt(value: Int) extends Value {
    override def toString: String = value.toString
  }

  object JsonTrue extends Value {
    override def toString: String = "true"
  }

  object JsonFalse extends Value {
    override def toString: String = "false"
  }

  object JsonNull extends Value {
    override def toString: String = "null"
  }

  case class JsonArray[T <: Value](value: Seq[T]) extends Value {
    override def toString: String = value.mkString("[", ",", "]")

    override def toPrettyString(indent: Int = 0): String = {
      val ind = getIndent(indent)
      value.map(v => v.toPrettyString(indent + 1)).mkString("[\n", ",\n", "\n" + ind + "]")
    }
  }

  case class JsonObject(var value: Map[String, Value]) extends Value {
    override def toString: String = value
      .map { case (key, v) => s""""$key":$v""" }
      .mkString("{", ",", "}")

    override def toPrettyString(indent: Int = 0): String = {
      val ind = getIndent(indent)
      val temp = value.map { case (key, v) => getIndent(indent + 1) + s""""$key" : ${v.toPrettyString(indent+ 1)}""" }
      temp.mkString("{\n", ",\n", "\n" + ind + "}")
    }

    def addField(key: String, v: Value): Unit = value = value + (key -> v)

    def replaceField(key: String, newVal: Value): Unit = value.updated(key, newVal)
  }


  def main(args: Array[String]): Unit = {

    val s1 = JsonString("yuval")
    val s2 = JsonString("Shavit")
    val arr = JsonArray(Seq(s1, s2))
    var obj1 = JsonObject(Map("aaa" -> arr))
    val obj2 = JsonObject(Map("bbb" -> obj1))

    val obj = JsonArray(Seq(obj1, obj2, arr, s1))

    println(obj2)
    println(obj2.toPrettyString())
  }

}