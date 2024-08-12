object q2 {
  def main(args: Array[String]): Unit = {
    if (args.isEmpty) {
      println("Please provide an integer as input.")
    } else {
      val input = args(0).toInt

      val categorize: Int => String = {
        case x if x % 3 == 0 && x % 5 == 0 => "Multiple of Both Three and Five"
        case x if x % 3 == 0               => "Multiple of Three"
        case x if x % 5 == 0               => "Multiple of Five"
        case _                             => "Not a Multiple of Three or Five"
      }

      println(categorize(input))
    }
  }
}
