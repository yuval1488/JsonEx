import scala.collection.mutable

/**
  * Created by yuvals on 26/06/2017.
  */
object test {

  case class Node(value: Int, left: Option[Node], right: Option[Node])

  def dfs(head: Option[Node]): Unit = {
    head match {
      case Some(Node(data, left, right)) =>
        println(data)
        dfs(left)
        dfs(right)
      case None =>
    }

  }

  def bfs(head: Option[Node]): Unit = {
    var queue: mutable.Queue[Option[Node]] = new mutable.Queue()
    queue.enqueue(head)

    while (queue.nonEmpty) {
      val node = queue.dequeue()
      node match {
        case Some(Node(data, left, right)) =>
          println(data)
          queue.enqueue(left)
          queue.enqueue(right)
        case None =>
      }
    }

  }

  def main(args: Array[String]): Unit = {

    val six = Node(6, None, None)
    val five = Node(5, None, None)
    val four = Node(4, None, None)
    val three = Node(3, None, Option(six))
    val two = Node(2, Option(four), Option(five))
    val one = Node(1, Option(two), Option(three))

    dfs(Option(one))
    bfs(Option(one))

  }
}