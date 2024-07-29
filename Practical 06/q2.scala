import scala.io.StdIn.readLine

object StudentRecords extends App {

  def calculatePercentageAndGrade(
      marks: Int,
      totalMarks: Int
  ): (Double, Char) = {
    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _            => 'D'
    }
    (percentage, grade)
  }

  def validateInput(
      name: String,
      marks: String,
      totalMarks: String
  ): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty"))
    } else {

      val marksInt = marks.toInt
      val totalMarksInt = totalMarks.toInt
      if (marksInt < 0 || marksInt > totalMarksInt) {
        (
          false,
          Some("Marks must be positive and not exceed total possible marks")
        )
      } else {
        (true, None)
      }
    }
  }

  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    val name = readLine("Enter student name: ")
    val marks = readLine("Enter marks obtained: ")
    val totalMarks = readLine("Enter total possible marks: ")

    validateInput(name, marks, totalMarks) match {
      case (true, _) =>
        val marksInt = marks.toInt
        val totalMarksInt = totalMarks.toInt
        val (percentage, grade) =
          calculatePercentageAndGrade(marksInt, totalMarksInt)
        (name, marksInt, totalMarksInt, percentage, grade)
      case (false, Some(errorMessage)) =>
        println(s"Error: $errorMessage")
        getStudentInfo() // retry
      case _ =>
        println("Unexpected validation result")
        getStudentInfo() // retry
    }
  }

  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var isValid = false
    var studentRecord: (String, Int, Int, Double, Char) = ("", 0, 0, 0.0, 'D')

    while (!isValid) {
      val name = readLine("Enter student name: ")
      val marks = readLine("Enter marks obtained: ")
      val totalMarks = readLine("Enter total possible marks: ")

      validateInput(name, marks, totalMarks) match {
        case (true, _) =>
          val marksInt = marks.toInt
          val totalMarksInt = totalMarks.toInt
          val (percentage, grade) =
            calculatePercentageAndGrade(marksInt, totalMarksInt)
          studentRecord = (name, marksInt, totalMarksInt, percentage, grade)
          isValid = true
        case (false, errorMessage) =>
          println(s"Error: $errorMessage")
      }
    }
    studentRecord
  }

  // Function to print student record
  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Name: $name")
    println(s"Marks: $marks/$totalMarks")
    println(f"Percentage: $percentage%.2f%%")
    println(s"Grade: $grade")
  }

  // Main application logic
  println("Enter student details:")
  val studentRecord = getStudentInfoWithRetry()
  println("\nStudent Record:")
  printStudentRecord(studentRecord)
}
