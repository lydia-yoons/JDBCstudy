package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConn;

public class ScoreDAO
{
	private Connection conn;
	
	public ScoreDAO()
	{
		conn = DBConn.getConnection();
	}
	
	// 데이터 입력 insert
	public int add(ScoreDTO dto) throws SQLException
	{
		int result = 0;
		
		Statement stmt = conn.createStatement();
		
		// 쿼리문 준비
		String sql = String.format("INSERT INTO TBL_SCORE(SID, NAME, KOR, ENG, MAT)"
								+ "VALUES(SCORESEQ.NEXTVAL, '%s', %d, %d, %d)"
							, dto.getName(), dto.getKor(), dto.getEng(), dto.getMat());
		
		result = stmt.executeUpdate(sql);
		
		stmt.close();
		
		return result;		
	}// end add()
	
	
	// 전체 인원수 확인
	public int count() throws SQLException
	{
		int result = 0;
		
		Statement stmt = conn.createStatement();
		
		//쿼리문
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_SCORE";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			result = rs.getInt("COUNT");			
		}
		
		rs.close();
		stmt.close();				
		
		return result;
	}
	
	
	// 전체 리스트 조회
	public ArrayList<ScoreDTO> lists() throws SQLException
	{
		ArrayList<ScoreDTO> result = new ArrayList<ScoreDTO>();
		
		Statement stmt = conn.createStatement();
		
		// 쿼리문 준비
		// 번호, 이름, 국, 영, 수, 총점, 평균
		String sql = "SELECT SID, NAME, KOR, ENG, MAT, (KOR+ENG+MAT) AS TOT,(KOR+ENG+MAT)/3 AS AVG FROM TBL_SCORE ORDER BY SID";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			ScoreDTO dto = new ScoreDTO();
			
			dto.setSid(rs.getString("SID"));
			dto.setName(rs.getString("NAME"));
			dto.setKor(rs.getInt("KOR"));
			dto.setEng(rs.getInt("ENG"));
			dto.setMat(rs.getInt("MAT"));
			dto.setTot(rs.getInt("TOT"));
			dto.setAvg(rs.getDouble("AVG"));
			
			result.add(dto);
		}
		
		rs.close();
		stmt.close();
		
		return result;

	}// end lists
	
	
	public void close()
	{
		DBConn.close();
	}

}
