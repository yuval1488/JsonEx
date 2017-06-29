import scala.collection.mutable

object TypeClassSort {

  trait Compare[T] {
    def compare(left: T, right: T): Boolean
  }

  def bubbleSort[T](arr: Seq[T])
                   (implicit comp: Compare[T]): Seq[T] = {
    val tempArr = mutable.Seq[T](arr:_*)

    for {
      i <- 1 until tempArr.size
      j <- 0 until tempArr.size - i
    } if (comp.compare(tempArr(j), tempArr(j + 1))) {
      val temp = tempArr(j)
      tempArr(j) = tempArr(j + 1)
      tempArr(j + 1) = temp
    }

    tempArr.toSeq
  }

  case class Car(name: String, price: Int)

  implicit def carCompare = new Compare[Car] {
    override def compare(left: Car, right: Car): Boolean = left.price > right.price
  }

  implicit def intCompare = new Compare[Int] {
    override def compare(left: Int, right: Int): Boolean = left > right
  }


  def main(args: Array[String]): Unit = {

    val c1 = Car("honda", 100)
    val c2 = Car("volvo", 200)
    val c3 = Car("suzuki", 50)
    val c4 = Car("mazda", 150)
    val c5 = Car("siat", 10)


    val arr = Seq[Car](c1, c2, c3, c4, c5)
    print(bubbleSort(arr))

  }

}