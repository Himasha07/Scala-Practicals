object que1 {
  def main(args: Array[String]): Unit = {
    // Defining the rational numbers
    val x = new RationalNum(3, 4) // 3/4
    val y = new RationalNum(5, 8) // 5/8
    val z = new RationalNum(2, 7) // 2/7

    val result1 = y.sub(z) // y - z
    val finalResult = x.sub(result1) // x - (y - z)

    println(s"Result of x - (y - z): $finalResult")
  }
}

class RationalNum(a: Int, b: Int) {
  require(b != 0, "Denominator must not be zero")

  def num: Int = a // Numerator
  def denum: Int = b // Denominator

  def +(r: RationalNum): RationalNum =
    new RationalNum(
      this.num * r.denum + r.num * this.denum,
      this.denum * r.denum
    )

  // Negates the rational number
  def neg: RationalNum = new RationalNum(-this.num, this.denum)

  // Subtraction
  def sub(r: RationalNum): RationalNum =
    new RationalNum(
      this.num * r.denum - r.num * this.denum,
      this.denum * r.denum
    )

  // toString method
  override def toString: String = s"$num/$denum"
}
