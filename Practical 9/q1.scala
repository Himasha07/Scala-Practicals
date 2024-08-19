object q1 extends App {
  val calInterest = (amount: Double) =>
    amount match {
      case x if x <= 20000   => x * 0.02
      case x if x <= 200000  => x * 0.04
      case x if x <= 2000000 => x * 0.035
      case x if x > 2000000  => x * 0.065
      case _                 => 0
    }

  print("Enter the deposited amount: ")
  val deposit = scala.io.StdIn.readLine().toDouble

  println("Interest: " + calInterest(deposit))

}
