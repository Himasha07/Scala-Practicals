object convert extends App {

  def toUpper(str: String): String = {
    str.toUpperCase()
  }
  def toLower(str: String): String = {
    str.toLowerCase()
  }
  def formatNames(name: String)(format_fun: String => String): String = {
    format_fun(name)
  }

  val names = List(
    ("Benny", toUpper),
    (
      "Niroshan",
      (s: String) => s.substring(0, 2).toUpperCase() + s.substring(2)
    ),
    ("Saman", toLower),
    (
      "Kumara",
      (s: String) =>
        s.substring(0, 1).toUpperCase() + s
          .substring(1, s.length - 1) + s.substring(s.length - 1).toUpperCase()
    )
  )

  names.foreach(name => println(formatNames(name._1)(name._2)))

}
