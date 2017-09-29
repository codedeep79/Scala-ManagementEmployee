import java.sql.DriverManager
import java.sql.Connection


object ScalaApp {

  def main(args: Array[String]) {
    // connect to the database named "mysql" on the localhost
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/csv"
    val username = "root"
    val password = ""

    // there's probably a better way to do this
    var connection:Connection = null

    try {
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * FROM csv")
      while ( resultSet.next() ) {
        val lastname = resultSet.getString("last")
        val firstname = resultSet.getString("first")
        println("Ho Va Ten: " + lastname + " " + firstname)
      }
    }
    catch {
      case e => e.printStackTrace
    }
    connection.close()
  }

}