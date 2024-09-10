object Q1 extends App {

  class Rational(n: Int, d: Int) {
    require(d != 0, "Denominator cannot be zero")

    // To calculate GCD
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    // Calculate gcd
    private val gcdValue: Int = gcd(n.abs, d.abs)

    val numerator: Int = (if (d < 0) -n else n) / gcdValue
    val denominator: Int = d.abs / gcdValue

    //  negate the rational number
    def neg: Rational = new Rational(-numerator, denominator)

    // String representation for easy display
    override def toString: String = s"$numerator/$denominator"
  }

  val x = new Rational(3, 4)
  println(s"x = $x")
  println(s"-x = ${x.neg}")
}
