/* ==============================
 *  Test003.java
 *  - 데이터베이스 연결 실습
 *  - 데이터 입력 실습
 *  ============================= */


package com.test;

import java.sql.Connection;
import java.sql.Statement;

import com.util.DBconn;

public class Test003
{
	public static void main(String[] args)
	{
		Connection conn = DBconn.getConnection();
		
		if (conn == null)
		{
			System.out.println("데이터베이스 연결 실패");
			System.exit(0);
		}
		
		//System.out.println("데이터에이스 연결 성공");
		try
		{
			// 작업 객체 준비
			Statement stmt = conn.createStatement();
			
			// 데이터 입력 쿼리 실행 과정
			// 한 번 실행하면 다시 실행하지 못하는 상황이다.
			// 기본키 제약조건이 설정되어 있으므로
			// 동일한 키 값이 중복될 수 없기 때문이다.
			
			// 쿼리문 준비
			String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(2, '채지윤', '010-2222-2222')";
			//-- 주의~~! 쿼리문 끝에 『;』붙이지 않는다.
			//-- 주의~~! 자바에서 실행한 DML구문은 내부적으로 자동 commit 된다.
			//-- 주의~~! 오라클에서 트랜잭션 처리가 끝나지 않으면
			//			 데이터 액션 처리가 이루어지지 않는다.
			
			
			//stmt.executeQuery()
			//stmt.executeUpdate()
			
			int result = stmt.executeUpdate(sql);
			
			if (result > 0)
			{
				System.out.println("데이터 입력 성공~!");
			}
			else
			{
				System.out.println("데이터 입력 실패 ㅠㅠ");
			}			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		DBconn.close();
		
	}

}

//실행결과
/*
 * 데이터 입력 성공~!
 */
