/* =================
 *  DBConn.java
 * ================= */

package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn
{
	// 변수 선언
	private static Connection dbConn;
	// -- 자동으로 null 초기화
	
	// 메소드 정의 → 연결
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		if (dbConn == null)
		{
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
								
			String user = "scott";	//-- 오라클 사용자 계정(scott) 이름
			String pwd = "tiger";	//-- 오라클 사용자 계정(scott) 암호
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//-- OracleDriver 클래스에 대한 객체 생성
			
			dbConn = DriverManager.getConnection(url, user, pwd);
			//-- 오라클 서버 실제 연결
					
		}
		
		return dbConn;
		//-- 구성된 연결 객체 반환
	}
	
	// getConnection() 메소드의 오버로딩 → 연결
	public static Connection getConnection(String url, String user, String pwd) throws ClassNotFoundException, SQLException
	{
		if (dbConn == null)
		{					
			Class.forName("oracle.jdbc.driver.OracleDriver");
			dbConn = DriverManager.getConnection(url, user, pwd);			
		}
		
		return dbConn;
	}
	
	// 메소드 정의 → 연결 종료
	public static void close() throws SQLException
	{
		if (dbConn != null)
		{
			
			if (!dbConn.isClosed())
				dbConn.close();		//-- 연결 객체의 close		
		}
		
		dbConn = null;
		//-- 연결 객체 초기화
	}
}