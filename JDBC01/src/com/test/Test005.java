/* ==============================
 * 	Test005.java
 *  - 테이블 내의 데이터 읽어오기
 * ============================== */


package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.DBconn;

public class Test005
{
	public static void main(String[] args)
	{
		Connection conn = DBconn.getConnection();
		
		if (conn != null)
		{
			System.out.println("데이터베이스 연결 성공~!");
			
			
			try
			{
				// 작업 객체 생성
				Statement stmt = conn.createStatement();
				
				// 쿼리문 준비
				String sql = "SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID";
				//String sql = "SELECT SID, NAME, TEL"
				//			+ " FROM TBL_MEMBER"
				//			+ " ORDER BY SID";
				
				// ※ 쿼리문 구성 간 공백 처리 check~!!
				//    (분리해서 적을 땐 다음문장에 공백을 줘야한다)
				
				// ※ executeQuery() 메소드를 사용하면
				//	  질의 결과를 ResultSet 객체로 가져올 수 있다.
				//	  하지만, ResultSet 객체가 질의에 대한 결과물 모두를
				//	  한번에 갖고 있는 구조는 아니다.
				//	  단지, 데이터베이스로부터 획득한 질의 결과물에 대한
				//	  관리가 가능한 상태가 되는 것이다.
				//	  이 때문에 데이터베이스와 연결을 끊게되면
				//	  ResultSet 객체는 데이상 질의 결과를 관리할 수 없게 된다.
				
				// 쿼리문 실행 (데이터 베이스에서 select 문을 가져오는거니까 executeQuery)
				ResultSet rs = stmt.executeQuery(sql);
				
				// DBConn.close();
				
				while (rs.next())
				{
					String sid = rs.getString("SID");
					String name = rs.getString("NAME");
					String tel = rs.getString("TEL");
					
					String str = String.format("%3s %8s %12s", sid, name, tel);
					
					System.out.println(str);
					
				}
				
				rs.close();
				stmt.close();
				
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		} // end if
		
		DBconn.close();
		
		System.out.println("데이터베이스 연결 닫힘~!");
		System.out.println("프로그램 종료됨~!");
		
	}
	
}
// 실행 결과
/*
데이터베이스 연결 성공~!
1      이윤서 010-5387-9404
2      채지윤 010-2222-2222
3      김소연 010-3333-3333
4      윤유동 010-4444-4444
5      손다정 010-5555-5555
데이터베이스 연결 닫힘~!
프로그램 종료됨~!
*/