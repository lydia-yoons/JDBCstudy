/* ==================
 * 	Test001.java
 * - 쿼리문 전송 실습
 * ==================
 * */


package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.util.DBConn;

public class test001
{
	public static void main(String[] args)
	{
		try
		{
			Connection conn = DBConn.getConnection();
			
			if (conn != null)
			{
				System.out.println("데이터베이스 연결 성공~~");
				
				try
				{
					/*
					Statement stmt = conn.createStatement();
					
					String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL)"
							+ " VALUES(MEMBERSEQ.NEXTVAL, '정효진', '010-6666-6666')";
					int result = stmt.executeUpdate(sql);
					
					if (result > 0)
						System.out.println("데이터 입력 성공~~");
					
					stmt.close();
					DBConn.close();
					*/
					
					/*
					String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL)"
							+ " VALUES(MEMBERSEQ.NEXTVAL, '손다정', '010-7777-7777')";
					
					Statement stmt = conn.createStatement();
					
					int result = stmt.executeUpdate(sql);
					
					if (result > 0)
						System.out.println("데이터 입력 성공~~");
					
					stmt.close();
					DBConn.close();
					*/
					
					/*
					String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL)"
							+ " VALUES(MEMBERSEQ.NEXTVAL, ?, ?)";
					
					PreparedStatement pstmt = conn.prepareStatement(sql);
					
					// IN 매개변수 넘겨주기
					pstmt.setString(1, "박효빈");
					pstmt.setString(2, "010-8888-8888");
					
					int result = pstmt.executeUpdate();
					
					if (result > 0)
						System.out.println("데이터 입력 성공~~");
					
					pstmt.close();
					DBConn.close();
					*/
					
					String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL)"
							+ " VALUES(MEMBERSEQ.NEXTVAL, ?, ?)";
					
					PreparedStatement pstmt = conn.prepareStatement(sql);
					
					// IN 매개변수 넘겨주기
					pstmt.setString(1, "최현정");
					pstmt.setString(2, "010-9999-9999");
					
					int result = pstmt.executeUpdate();
					
					if (result > 0)
						System.out.println("데이터 입력 성공~~");
					
					pstmt.close();
					DBConn.close();
					
							
				} catch (Exception e)
				{
					System.out.println(e.toString());
				}
			}
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
