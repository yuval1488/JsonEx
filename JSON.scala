/**
  * Created by yuvals on 27/06/2017.
  */

import JsonDouble._
import JsonInt._

object JSON {

  def serialize[T](obj: T)(implicit conv: T => JsonObject): JsonObject = {
    obj
  }

  case class Address(street: String, number: Int, city: String)
  case class Person(name: String, address: Address)


  implicit def addressToJsonObject(addess: Address): JsonObject = {
    JsonObject(
      "street" -> addess.street,
      "number" -> addess.number,
      "city" -> addess.city
    )

  }

  implicit def personToJsonObject(person: Person): JsonObject = {
    JsonObject(
      "name" -> person.name,
      "address" -> person.address
    )
  }

  def main(args: Array[String]): Unit = {



    val yuval = Person("yuval shavit", Address("rabi merir", 15, "Jerusalem"))

    println(serialize(yuval))

//    val j = JsonObject(
//      JsonField("aaa", 4.8),
//      JsonField("bbb", JsonArray(Seq())),
//      JsonField("ccc", JsonObject(
//        JsonField("ddd", JsonArray(Seq(5, JsonString("bla"))))))
//    )
//
//    println(j)
//    val str = j.toString
//
//    var temp = """{"sdsad":[{"yuval":0,"sha    vit":1},[2,4]]}"""
//
//    val o = JsonObject.parse(JsonTokenizer(temp))
//    println(o)
  }

}