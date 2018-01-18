package pro03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pro03 {

	public static void main(String[] args) {
		
        //코드 작성

		// 0. import java.sql.*;

		Connection conn = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 얻어오기
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(url, "hr", "hr");
			// 3. SQL문 준비 / 바인딩 / 실행
            String query = " select employee_id," + 
            		       " last_name, " + 
            		       " Email, " + 
            		       " job_title, " + 
            		       " department_name, " + 
            		       " city " + 
            		       " from  employees em, departments de, " + 
            		       " jobs jo, locations lo " + 
            		       " where job_title like 'Purchasing Clerk' " + 
            		       " and city like 'Seattle' " + 
            		       " and em.job_id = jo.job_id " + 
            		       " and em.department_id = de.department_id " + 
            		       " and de.location_id = lo.location_id " +
            		       " order by employee_id desc ";
            
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            System.out.println("EmployeeId |" + "LastName |" + "Email |" + "jobTitle |" + "DepartmentName |" + "City");
            // 4.결과처리
            while(rs.next()) {
            int EmployeeId = rs.getInt("employee_id") ;
            String LastName = rs.getString("last_name");
            String Email = rs.getString("Email");
            String jobTitle = rs.getString("job_title");
            String DepartmentName = rs.getString("department_name");
            String City = rs.getString("city");
            
            System.out.println(EmployeeId+ "|" + LastName + "|" + Email + "|" + jobTitle + "|" + DepartmentName + "|" + City);
            }
            
            
		} catch (ClassNotFoundException e) {

			System.out.println("error: 드라이버 로딩 실패 - " + e);

		} catch (SQLException e) {

			System.out.println("error:" + e);

		} finally {

			// 5. 자원정리

			try {

				if (rs != null) {

					rs.close();

				}

				if (pstmt != null) {

					pstmt.close();

				}

				if (conn != null) {

					conn.close();

				}

			} catch (SQLException e) {

				System.out.println("error:" + e);

			}

		}

	}
}

