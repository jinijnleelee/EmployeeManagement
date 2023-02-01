package edu.kh.emp.view;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

import edu.kh.emp.model.dao.EmployeeDAO;
//import edu.kh.emp.model.dao.EmployeeDAO;
import edu.kh.emp.model.vo.Employee;

// 화면용 클래스( 입력(Scanner) / 출력(print()) )
public class EmployeeView {

	private Scanner sc = new Scanner(System.in);
	
	// DAO 객체 생성
	private EmployeeDAO dao = new EmployeeDAO();
	
	
	
	
	
	
	
	
//	
//	
//	Connection conn = null;
//	Statement stmt = null;
//	ResultSet rs = null;
//	
//	
//	
	
	
	// 메인 메뉴
	public void displayMenu() {
		
		int input = 0;
		
		do {
			try {
				System.out.println("---------------------------------------------------------");
				System.out.println("----- 사원 관리 프로그램 -----");
				System.out.println("1. 새로운 사원 정보 추가");
				System.out.println("2. 전체 사원 정보 조회");
				System.out.println("3. 사번이 일치하는 사원 정보 조회");
				System.out.println("4. 사번이 일치하는 사원 정보 수정");
				System.out.println("5. 사번이 일치하는 사원 정보 삭제");
				
				System.out.println("6. 입력 받은 부서와 일치하는 모든 사원 정보 조회");
				// selectDeptEmp()
				
				System.out.println("7. 입력 받은 급여 이상을 받는 모든 사원 정보 조회");
				// selectSalaryEmp()
				
				System.out.println("8. 부서별 급여 합 전체 조회");
				// selectDeptTotalSalary()
				// DB 조회 결과를 HashMap<String, Integer>에 옮겨 담아서 반환
				// 부서코드, 급여 합 조회
				
				System.out.println("9. 주민등록번호가 일치하는 사원 정보 조회");
				
				System.out.println("10. 직급별 급여 평균 조회");
				// selectJobAvgSalary()
				// DB 조회 결과를 HashMap<String, Double>에 옮겨 담아서 반환 
				// 직급명, 급여 평균(소수점 첫째자리) 조회
				
				
				System.out.println("0. 프로그램 종료");
				
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); //  추가!
				
				
				System.out.println();				
				
				
				switch(input) {
				case 1:  insertEmployee();   break; //잘됨
				case 2:  selectAll();  break; // 잘됨
				case 3:  selectEmpId();   break; // 완 
				case 4:  updateEmployee();   break; //잘됨
				case 5:  deleteEmployee();   break; // 잘됨 
				case 6:  selectDeptEmp();   break;
				case 7:  selectSalaryEmp();   break;
				case 8:  selectDeptTotalSalary();   break; //안해도됨 
				case 9:  selectEmpNo();   break; // 잘됨 
				case 10: selectJobAvgSalary();   break; //안해도됨 
				
				case 0:  System.out.println("프로그램을 종료합니다...");   break;
				default: System.out.println("메뉴에 존재하는 번호만 입력하세요.");
				}
				
				
			}catch(InputMismatchException e) {
				System.out.println("정수만 입력해주세요.");
				input = -1; // 반복문 첫 번째 바퀴에서 잘못 입력하면 종료되는 상황을 방지
				sc.nextLine(); // 입력 버퍼에 남아있는 잘못 입력된 문자열 제거해서
							   // 무한 반복 방지
			}
			
		}while(input != 0);
		
	}
	
	
	/**
	 * 전체 사원 정보 조회
	 */
	public void selectAll() { // 잘돌아감 
		
		System.out.println("<전체 사원 정보 조회>");
		//DB에서 전체 사원 정보를 조회하여 List<Employee>형태로 반환하는
		//dao.selectAll 메서드 호출 
		List<Employee> empList = dao.selectAll();
		
		printAll(empList);
		
	}
		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			
//			
//			String type = "jdbc:oracle:thin:@"; // JDBC 드라이버의 종류
//			
//			String ip = "localhost"; // DB 서버 컴퓨터 IP
//			// localhost == 127.0.0.1 (loop back ip)
//			
//			String port = ":1521"; // 포트번호 1521 (기본값)
//			
//			String sid = ":XE"; // DB 이름
//			
//			String user = "kh";
//			
//			String pw = "kh1234";
//			
//			
//			conn = DriverManager.getConnection(type + ip + port + sid, user, pw);
//			
//			
//		
//
//			
//			
//			String sql = "SELECT EMP_ID , EMP_NAME , EMP_NO , EMAIL , PHONE , SALARY , DEPT_CODE , JOB_CODE ,SAL_LEVEL,  BONUS , MANAGER_ID "
//					+ " FROM EMPLOYEE "
//					+ " JOIN JOB USING(JOB_CODE) "
//					+ " JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) ";
//			
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//
//			
//			
//			List<Employee> list = new ArrayList<>();
//			
//			
//			while(rs.next()) {
//			
//				
//				int empId = rs.getInt("EMP_ID");
//				String empName = rs.getString("EMP_NAME");
//				String empNo = rs.getString("EMP_NO");
//				String email = rs.getString("EMAIL");
//				String phone = rs.getString("PHONE");
//				int salary = rs.getInt("SALARY");
//				String deptCode = rs.getString("DEPT_CODE");
//				String jobCode = rs.getString("JOB_CODE");
//				String salLevel = rs.getString("SAL_LEVEL");
//				double bonus  = rs.getDouble("BONUS");
//				int managerId = rs.getInt("MANAGER_ID");
//				
//				
//				
//			
//				
//				
//
//				list.add(new Employee(empId,empName,empNo,email,phone,salary,deptCode,
//						jobCode,salLevel,bonus,managerId));
//				
//				
//				System.out.println();
//				
//				
//				
//				
//			}
//		
//			
//			
//			
//	if(list.isEmpty()) {//List가 비어있을경우 
//					
//					//isEmpty() : 비어있으면 true
//					
//					System.out.println("조회결과없습니다");
//				}else {
//					
//					//향상된 for문 
//					for(Employee emp : list)
//						System.out.println(emp);
//					
//					
//				}
//			
//			
//		}catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if( rs != null ) rs.close();
//				if( stmt != null ) stmt.close();
//				if( conn != null ) conn.close();
//				
//			}catch(SQLException e) {
//				e.printStackTrace();
//			
//		}
//		
//		}
//		
//		
//	}
//	
//	
	/** 전달받은 사원 List 모두 출력
	 * @param empList
	 */
	public void printAll(List<Employee> empList) {
		
		
		
		if(empList.isEmpty()) {//List가 비어있을경우 
		
		//isEmpty() : 비어있으면 true
		
		System.out.println("조회결과없습니다");
	}else {
		
		System.out.println("사번 |   이름  | 주민 등록 번호 |        이메일        |   전화 번호   | 부서 | 직책 | 급여" );
		System.out.println("------------------------------------------------------------------------------------------------");
		for(Employee emp : empList) { 
			System.out.printf(" %2d  | %4s | %s | %20s | %s | %s | %s | %d\n",
					emp.getEmpId(), emp.getEmpName(), emp.getEmpNo(), emp.getEmail(), 
					emp.getPhone(), emp.getDepartmentTitle(), emp.getJobName(), emp.getSalary());
		}
		
		
	}
		
		
		
	}
	
	/**
	 * 사번이 일치하는 사원 정보 조회
	 */
	public void selectEmpId() { // 

		int empId = inputEmpId();
		
		
	Employee emp	= dao.selectEmpId(empId);
	printOne(emp);

		
//	try {
//		
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		
//		String type = "jdbc:oracle:thin:@"; // JDBC 드라이버의 종류
//		
//		String ip = "localhost"; // DB 서버 컴퓨터 IP
//		// localhost == 127.0.0.1 (loop back ip)
//		
//		String port = ":1521"; // 포트번호 1521 (기본값)
//		
//		String sid = ":XE"; // DB 이름
//		
//		String user = "kh";
//		
//		String pw = "kh1234";
//		
//		conn = DriverManager.getConnection(type + ip + port + sid, user, pw);

//		String sql = "SELECT EMP_ID,EMP_NAME,EMP_NO,EMAIL,PHONE,DEPT_TITLE,JOB_NAME,SALARY "
//				+ " FROM EMPLOYEE "
//				+ " JOIN JOB USING(JOB_CODE) "
//				+ " JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) "
//				+ " WHERE EMP_ID = " + inputEmpId;
//		
//		stmt = conn.createStatement();
//		rs = stmt.executeQuery(sql);
//		
//		List<Employee> list = new ArrayList<>();
//		
//		while(rs.next()) {
//			
//			
//			Employee em = new Employee();
//
//			em.setEmpId(rs.getInt("EMP_ID"));
//			em.setEmpName(rs.getString("EMP_NAME"));
//			em.setEmpNo(rs.getString("EMP_NO"));
//			em.setEmail(rs.getString("EMAIL"));
//			em.setPhone(rs.getString("PHONE"));
//			em.setDepartmentTitle(rs.getString("DEPT_TITLE"));
//			em.setJobName(rs.getString("JOB_NAME"));
//			em.setSalary(rs.getInt("SALARY"));
//			
//			list.add(em);
//		}
//			
//		
//		if(list.isEmpty()) {
//			System.out.println("조회결과없");
//		
//		}else {
//			
//			for(Employee em: list)
//				System.out.println(em);
//		}
//		
//				
//				
				
//				
//	}catch(ClassNotFoundException e) {
//		e.printStackTrace();
//	}catch(SQLException e) {
//		e.printStackTrace();
//	}finally {
//		try {
//			if(rs !=null) rs.close();
//			if(stmt != null) stmt.close();
//			if(conn != null) conn.close();
//			
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//			
//		}
//			
//		}
//		
//	
		
}
		
	
	
	
	/** 사번을 입력 받아 반환하는 메서드
	 * @return empId
	 */
	public int inputEmpId() {
		System.out.println("사번입력");
		int empId = sc.nextInt();
		sc.nextLine();
		return empId;
	}
	
	
	/** 사원 1명 정보 출력
	 * @param emp
	 */
	public void printOne(Employee emp) { 
		
		if(emp == null) {
			System.out.println("조회된 사원 정보가 없습니다.");
			
		} else {
			System.out.println("사번 |   이름  | 주민 등록 번호 |        이메일        |   전화 번호   | 부서 | 직책 | 급여" );
			System.out.println("------------------------------------------------------------------------------------------------");
			
			System.out.printf(" %2d  | %4s | %s | %20s | %s | %s | %s | %d\n",
					emp.getEmpId(), emp.getEmpName(), emp.getEmpNo(), emp.getEmail(), 
					emp.getPhone(), emp.getDepartmentTitle(), emp.getJobName(), emp.getSalary());
		}

		
		
		
	}
	
	
	/**
	 * 주민등록번호가 일치하는 사원 정보 조회
	 */
	public void selectEmpNo() { 
		
		
			
			System.out.println("주민번호가 일치하는 사람 정보 조회");
			System.out.println("주민번호입력 : ");
			String inputEmpNo = sc.next();
			
		Employee emp	= dao.selectEmpNo(inputEmpNo);
		printOne(emp);
	
	}
	
	
	/**
	 * 사원 정보 추가
	 */
	public void insertEmployee() { //잘 돌아감 
		
		System.out.println("<사원정보추가>");
		
		
		
		
		int empId = inputEmpId(); // 사번 입력
		System.out.println("이름 :");
		String empName = sc.next();
		
		System.out.println("주민번호 :");
		String empNo = sc.next();
		
		
		System.out.println("이메일 :");
		String email = sc.next();
		
		System.out.println("휴대폰 :");
		String phone = sc.next();
		

		
		System.out.println("부서코드 :");
		String deptCode = sc.next();
		
		System.out.println("직급코드 :");
		String jobCode = sc.next();
		
	
		
		System.out.println("급여등급 :");
		String salLevel = sc.next();
		
		System.out.println("급여 :");
		int salary = sc.nextInt();
		
		System.out.println("보너스 : ");
		double bonus = sc.nextDouble();
		
		System.out.println("사수번호  :");
		int managerId = sc.nextInt();
		
		
		//입력받은 값을
		//Employee 객체에 담아서 DAO로 전달
		Employee emp =  new Employee(empId, empName, empNo, email, phone, salary, deptCode, jobCode, salLevel, bonus, managerId);
	
	
	int result = dao.insertEmployee(emp);
		//INSERT UPDATE DELETE  같은 DML 구문은
		//수행 후 테이블에 반영된 행의 개수를 반환함 
	//★가
		if(result > 0 ) { // DML구문 성공시 
			
			System.out.println("사원정보추가성공");
		}else {// DML구문 실패시 
			System.out.println("사원정보추가실패");
	
		}
	
	
	
	
	
	}
	
	
	/**
	 * 사번이 일치하는 사원 정보 수정(이메일, 전화번호, 급여)
	 */
	public void updateEmployee() {
		
		
		int empId = inputEmpId(); // 사번 입력
		System.out.println("이메일 : ");
		String emailString = sc.next();
		
		System.out.println("전화번호 : ");
		String Phone = sc.next();
		
		System.out.println("급여 : ");
		int salary = sc.nextInt();
		
		//기본생성자로 객체 생성후 setter 를 이용 초기회
		Employee emp = new Employee();
		
		emp.setEmpId(empId);
		emp.setEmail(emailString);
		emp.setPhone(Phone);
		emp.setSalary(salary);
		
		int result = dao.updateEmployee(emp); 
		if(result > 0) {
			System.out.println(" 정보수정"); // UPDATE(DML) > 반영된 행의 갯수 반환 
		
		}else {
			System.out.println("존재안함");
		}
	}
	
	/**
	 * 사번이 일치하는 사원 정보 삭제
	 */
	public void deleteEmployee() {
		
		System.out.println("사번이 일치하는 사원 정보 삭제 ");
		
		int empid = inputEmpId();//사번 입력
		
		System.out.println("정말 삭제 하시겠습니까? (Y/N) : ");
		char input = sc.next().toUpperCase().charAt(0);
		//Y/N 대소문자 구분없이 입력
		//->모두 대문자 변환 
		
		if(input == 'Y') {
			
			int result = dao.deleteEmployee(empid);
			if(result > 0 ) {
				System.out.println("삭제되었습니다.");
			}else {
				System.out.println("사번이 일치하는 사원이 존재하지 않습니다.");
			}
			
			
		}else {
			System.out.println("취소되었습니다");
		}
		
		
	}
	
	
	/**
	 * 입력 받은 부서와 일치하는 모든 사원 정보 조회
	 */
	public void selectDeptEmp() {
	System.out.println("입력받은 부서와 일치하는 모든 사원 정보 조회");
	
	System.out.println("부서명 : ");
	String departmentTitle = sc.nextLine();
	
	List<Employee> empList = dao.selectDeptEmp(departmentTitle);
	
	printAll(empList);
	}
	
	/**
	 * 입력 받은 급여 이상을 받는 모든 사원 정보 조회
	 */
	public void selectSalaryEmp() {
		
	}
	
	/**
	 * 부서별 급여 합 전체 조회
	 */
	public void selectDeptTotalSalary() {
		
	}
	
	/**
	 * 직급별 급여 평균 조회
	 */
	public void selectJobAvgSalary() {
		
		
	}
	
	
	
}