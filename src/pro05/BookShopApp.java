package pro05;

import java.util.List;
import java.util.Scanner;

import com.javaex.vo.AuthorVo;

public class BookShopApp {

	public static void main(String[] args) {
		
		BookShopDao dao = new BookShopDao();
		BookVo vo = new BookVo();
		
		vo.setTitle( "트와일라잇" );
		vo.setAuthorname( "스테파니메이어" );
		dao.insert( vo );

		vo.setTitle( "뉴문" );
		vo.setAuthorname( "스테파니메이어" );
		dao.insert( vo );

		vo.setTitle( "이클립스" );
		vo.setAuthorname( "스테파니메이어" );
		dao.insert( vo );
		
		vo.setTitle( "트와일라잇" );
		vo.setAuthorname( "스테파니메이어" );
		dao.insert( vo );

		vo.setTitle( "브레이킹던" );
		vo.setAuthorname( "스테파니메이어" );
		dao.insert( vo );

		vo.setTitle( "아리랑" );
		vo.setAuthorname( "조정래" );
		dao.insert( vo );

		vo.setTitle( "젊은그들" );
		vo.setAuthorname( "김동인" );
		dao.insert( vo );

		vo.setTitle( "아프니까 청춘이다" );
		vo.setAuthorname( "김난도" );
		dao.insert( vo );

		vo.setTitle( "귀천" );
		vo.setAuthorname( "천상병" );
		dao.insert( vo );

		vo.setTitle( "태백산맥" );
		vo.setAuthorname( "조정래" );
		dao.insert( vo );

		vo.setTitle( "풀하우스" );
		vo.setAuthorname( "원수연" );
		dao.insert( vo );
		
		Scanner key = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요.:");
		int num = key.nextInt();
		
		
		/*
		 * 여기에 입력받은 책번호와 일치하는  BookShopDao의 rent()를 호출하는 코드를 작성하세요.
		 *  
		 */
		
		displayBookInfo();
	}
	
	public static void displayBookInfo() {
		System.out.println("*****도서 정보 출력하기******");

	}	

}
