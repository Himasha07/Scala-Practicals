object q2 {
  def main(args: Array[String]): Unit = {
    if (args.isEmpty) {
      println("Provide input: ")
    } else {
      val input = args(0).toInt

      val func1 = (num: Int) =>
        num match {
          case x if x < 0      => "Negative"
          case x if x == 0     => "Zero"
          case x if x % 2 == 0 => "Even"
          case _               => "Odd"
        }
      println(func1(input))
    }
  }
}
