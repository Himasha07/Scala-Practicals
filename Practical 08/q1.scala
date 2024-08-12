object q1 extends App {
  def encrypt(text: String, shift: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        val start = if (char.isLower) 'a' else 'A'

        ((char - start + shift) % 26 + start).toChar
      } else {
        char
      }
    }
  }

  def decrypt(text: String, shift: Int): String = {
    encrypt(text, -shift)
  }

  def ceasarCipher(
      text: String,
      shift: Int,
      operation: (String, Int) => String
  ): String = {
    operation(text, shift)
  }

  val text = "Hello, World!"
  val shift = 2

  val encryptedText = q1.ceasarCipher(text, shift, q1.encrypt)
  println(s"Encrypted Text: $encryptedText")

  val decryptedText = q1.ceasarCipher(encryptedText, shift, q1.decrypt)
  println(s"Decrypted Text: $decryptedText")

}
