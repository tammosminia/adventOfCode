import java.security._

val input = "bgvyzdsv"

def md5(s: String): String = {
  val bytesOfMessage = s.getBytes("UTF-8")

  val md = MessageDigest.getInstance("MD5")
  val md5Bytes = md.digest(bytesOfMessage)
  md5Bytes.map("%02X" format _).mkString
}

md5("abcdef609043")
md5("pqrstuv1048970")

def mine(secret: String, start: String = "00000", i: Int = 0): Int = {
  val m = md5(secret + i.toString)
  if (m.startsWith(start)) {
    i
  } else {
    mine(secret, start, i + 1)
  }
}

mine("abcdef")
mine("pqrstuv")
mine(input)
mine(input, "000000")

