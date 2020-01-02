방법 1

`C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6.jar`

file을

`C:\Program Files\Java\jdk1.8.0_231\jre\lib\ext`로 복사.

해당 경로는 장치 드라이버와 관련된 내부 라이브러리가 저장된 공간으로 자동으로 로딩된다.

> `C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6_g.jar`
>
> -> linux



방법 2

방법 1로 안될 경우 방법 2 사용.

위 jar 파일을

`C:\Program Files\Java\jre1.8.0_231\lib\ext` 경로로 복사



---

`dbConn.util`

```java
public class ConnectionHelper {
    public static Connection getConnection(String dsn, String user, String pwd) {
		
		Connection conn = null;
		
		try {
			
			if(dsn.equals("mysql")) {
				
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/{db_name}", 
						user, pwd);
				
			} else if(dsn.equals("oracle")) {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe", 
						user, pwd);
				System.out.println("success");
				
			} // if
			
		} catch (Exception e) {

		} finally {
			return conn;
		} // try
				
	} // getConnection()
    
}
```

`ex01.jdbc`

``` java
public class JDBCProjectEx2 extends JFrame implements ActionListener{
    
    //.....
    
	Connection conn;
	Statement stmt;
	PreparedStatement pstmtInsert, pstmtDelete;
	PreparedStatement pstmtTotal, pstmtTotalScroll;
	PreparedStatement pstmtSearch, pstmtSearchScroll;
	
	private String sqlInsert =	"INSERT INTO CUSTOMERS VALUES(?, ?, ?, ?_)";
	private String sqlDelete =	"DELETE FROM CUSTOMERS WHERE NAME = ?";
	private String sqlTotal  =	"SELECT * FROM CUSTOMERS";
	private String sqlSearch =	"SELECT * FROM CUSTOMERS WHERE NAME = ?";
	
	public void dbConnect() {
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			pstmtInsert = conn.prepareStatement(sqlInsert);
			pstmtDelete = conn.prepareStatement(sqlDelete);
			pstmtTotal = conn.prepareStatement(sqlTotal);
			pstmtSearch = conn.prepareStatement(sqlSearch);

			pstmtTotalScroll = conn.prepareCall(sqlTotal, 
					ResultSet.TYPE_SCROLL_SENSITIVE,
                      // cursor moving free, adapting update
					ResultSet.CONCUR_UPDATABLE
                      // set possible to change of resultset
					);	// <-> ResultSet.CONCUR_READ_ONLY
			pstmtSearchScroll = conn.prepareCall(sqlSearch,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE
					);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // dbConnect()
    
    // .....
    
}
```

