/* ==========================
 *  DBConn.java
 *  - try ~ catch 로 예외처리
 * =========================== */

package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn
{
	// 변수 선언
	private static Connection dbConn;
	// -- 자동으로 null 초기화
	
	// 메소드 정의 → 연결
	public static Connection getConnection()
	{
		
		if (dbConn == null)
		{
			try
			{
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "scott";	//-- 오라클 사용자 계정(scott) 이름
				String pwd = "tiger";	//-- 오라클 사용자 계정(scott) 암호
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//-- OracleDriver 클래스에 대한 객체 생성
				
				dbConn = DriverManager.getConnection(url, user, pwd);
			
			} catch (Exception e)
			{
				System.out.println(e.toString());
				//-- 오라클 서버 연결 실패시 오류 메세지 출력 부분
			}
		}
		
		return dbConn;
		//-- 구성된 연결 객체 반환
	}
	
	// getConnection() 메소드의 오버로딩 → 연결
	public static Connection getConnection(String url, String user, String pwd)
	{
		if (dbConn == null)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				dbConn = DriverManager.getConnection(url, user, pwd);
				
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
		
		return dbConn;
	}
	
	// 메소드 정의 → 연결 종료
	public static void close()
	{
		if (dbConn != null)
		{
			try
			{
				if (!dbConn.isClosed())
				{
					dbConn.close();
					//-- 연결 객체의 close
				}
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
		
		dbConn = null;
		//-- 연결 객체 초기화
	}
}