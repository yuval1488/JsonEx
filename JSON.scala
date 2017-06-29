/**
  * Created by yuvals on 27/06/2017.
  */

import JsonDouble._
import JsonInt._


object JSON {
  def main(args: Array[String]): Unit = {

    val j = JsonObject(
      JsonField("aaa", 4.8),
      "bbb" -> JsonArray(Seq(-7, JsonTrue)),
      "ccc" -> JsonObject("ddd" -> JsonArray(Seq(JsonInt(5), JsonString("bla"))))
    )

    println(j)
    val str = j.toString

    var temp = """{"sdsad":[{"yuval":0,"sha    vit":1},[2,4]]}"""

    val o = JsonObject.parse(JsonTokenizer(temp))
    println(o)
  }

}