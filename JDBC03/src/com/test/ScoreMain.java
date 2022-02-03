/* ==========================
 *  ScoreMain.java
 * =========================== */

/*
 ○ 성적 처리 프로그램 구현 → 데이터베이스 연동 → ScoreDAO, ScoreDTO zmffotm ghkfdyd
 
 	여러 명의 이름, 국어점수, 영어점수, 수학점수를 입력받아
 	총점, 평균을 연산하여 내용을 출력하는 프로그램을 구현한다.
 	출력 시 번호(이름, 총점 등) 오름차순 정렬하여 출력한다.
 	
 실행 예)
 
 1번 학생 성적 입력(이름 국어 영어 수학) : 김진령 80 75 60
 2번 학생 성적 입력(이름 국어 영어 수학) : 이윤서 100 90 80
 3번 학생 성적 입력(이름 국어 영어 수학) : 송해덕 80 85 80
 4번 학생 성적 입력(이름 국어 영어 수학) : .
 
 ----------------------------------------------------
 번호	이름	국어	영어	수학	총점	평균
 ----------------------------------------------------
  1		김진령	 80		 75		 60		xxx		xx.x
  2		이윤서	100		 90		 80		xxx		xx.x
  3		송해덕	 80		 85		 80		xxx		xx.x
 ----------------------------------------------------
 */

package com.test;

import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConn;

public class ScoreMain
{
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			ScoreDAO dao = new ScoreDAO();
			
			int count = dao.count();
			
			do
			{
				System.out.printf("%d번 학생 성적 입력(이름 국어 영어 수학) : ", (++count));
				String name = sc.next();	// 이름받기
				
				if (name.equals("."))	// .을 눌러 종료
					break;
				
				// 국영수 점수 받기
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				int mat = sc.nextInt();
				
				// ScoreDTO 객체 구성
				ScoreDTO dto = new ScoreDTO();
				dto.setName(name);
				dto.setKor(kor);
				dto.setEng(eng);
				dto.setMat(mat);
				
				
				// 데이터 입력하는 메소드 호출
				int result = dao.add(dto);
				
			} while (true);
			
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
			
			// 리스트를 가져와 출력
			for (ScoreDTO obj : dao.lists())
			{
				System.out.printf("%2s %7s\t %d\t %d\t %d\t %d %7.2f"
								, obj.getSid(), obj.getName(), obj.getKor(), obj.getEng()
								, obj.getMat(), obj.getTot(), obj.getAvg());
				System.out.println(); //개행
			}
			
			System.out.println("-----------------------------------------------------");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		finally {
			try
			{
				DBConn.close();
				System.out.println("데이터베이스 연결닫힘, 프로그램 종료");
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
		
		
	}

}
