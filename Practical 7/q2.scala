object q2 extends App {
  def calculateSquare(numbers: List[Int]): List[Int] = {
    numbers.map(num => num * num)
  }

  val input = List(1, 2, 3, 4, 5)
  val output = calculateSquare(input)
  println(s"Input: $input")
  println(s"Output: $output")
}
