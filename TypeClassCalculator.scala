object TypeClassCalculator {

  implicit class IntOprator(value: Int) {
    def add(other: Int): Int = value + other
    def sub(other: Int): Int = value - other
    def mul(other: Int): Int = value * other
  }

  implicit class FloatOprator(value: Double) {
    def add(other: Double): Double = value + other
    def sub(other: Double): Double = value - other
    def mul(other: Double): Double = value * other
  }

  def main(args: Array[String]): Unit = {

    val a: Int = 5
    val b: Int = 3

    println(3 add 3)  // => new BinaryOperator(3).add(3)
    println(3 sub 2)
    println(3 mul 2)
    println(1.1 add 2.3)
    println(4.4 sub 1.2)
    println(4.0 mul 1.5)

  }

}
