import java.util.*;
import java.util.Arrays;
import java.io.*;
import java.lang.*;

class Library{

	int n=20,m=100;
	private String libName;
	private int floorNumber;
	private Member members []=new Member[n];
	private Book books []=new Book[m];
	
	Library(String libName,int floorNumber){

		this.libName=libName;
		this.floorNumber=floorNumber;
		
	}
	
	void addMembers(Member member){

		Member members[]=this.members;
		
		for(int i=0;i<n;i++){

			if(members[i]==null){
				this.members[i]=member;
				break;
			}
		}
	}

	void addBooks(Book book){

		Book books[]=this.books;

		for(int j=0;j<m;j++){

			if(books[j]==null){
				this.books[j]=book;
				break;
			}
		}
	}

	public Member verifyMember(String memberUsername){

		for(int i=0;i<members.length;i++){
			Member obj =  this.members[i];

			if(obj.getuserName().equals(memberUsername)){
				return obj;
			}
		}
	return null;
	}

	public Book verifyBook(String lendBook){

		for(int j=0;j<books.length;j++){
			Book obj1=this.books[j];

			if(obj1.getbookName().equals(lendBook)){
				return obj1;
			}
		}
	return null;
	}
			
}

class Member{
	
	private String userName;
	private String password;
	private int mobNum;

	Member( String userName,String password,int mobNum){

		this.userName=userName;
		this.password=password;
		this.mobNum=mobNum;

	}

	public String getuserName(){
	 	return userName;
	}
	
	public void setuserName(String userName){
		this.userName=userName;
	}

	public String getpassword(){
		return password;
	}

	public void setpassword(String password){
		this.password=password;
	}
	
}

class Book{

	private String bookName,author;
	private int quantity;
	
	Book(String bookName,String author,int quantity){
		this.bookName=bookName;
		this.author=author;
		this.quantity=quantity;
	}

	public String getbookName(){
		return bookName;
	}

	public void setbookName(String bookName){
		this.bookName=bookName;
	}
	
	public String getauthor(){
		return author;
	}

	public void setauthor(){
		this.author=author;
	}

	public int getQuantity(){
		return quantity;
	}
	
	public void setQuantity(){
		this.quantity=quantity;
	}

}
	
class Librarysystem{

	public static void main(String args[]){

		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the library name:");
		String libName=scanner.nextLine();
		System.out.println("enter the floor number:");
		int floorNumber=scanner.nextInt();
		
		Library library=new Library(libName, floorNumber);
		int option=0;boolean terminate=false;boolean logout=false;

		do{
			boolean nextStep=false;
			if(nextStep==true){
				break;
			}

			System.out.println("choose an option based on your wish: 1.Register 2.Login 3.Exit");
			option=scanner.nextInt();
			Scanner scanner1=new Scanner(System.in);

			switch(option){

				case 1:

				System.out.println("enter the details below to register yourself:");
				System.out.println("enter the username:");
				String userName=scanner1.nextLine();
				System.out.println("enter the password:");
				String password=scanner1.nextLine();
				System.out.println("enter the mobile number:");
				int mobNum=scanner1.nextInt();
				Member member=new Member(userName,password,mobNum);
				library.addMembers(member);
				nextStep=true;
				break;
				
				case 2:
				
				System.out.println("enter the login details:");
				System.out.println("enter the member username:");
				String memberUsername=scanner1.nextLine();
				Member memberObj = library.verifyMember(memberUsername);

				if(memberObj == null) {
					System.out.println("there is no such member in this library");
					break;
				}
				
				System.out.println("enter the member password:");
				String memberPassword=scanner1.nextLine();

				if(memberObj.getpassword().equals(memberPassword)){
				System.out.println("login accepted");
				}
				nextStep=true;
				break;

				case 3:
				System.out.println("exiting the library");
				terminate=true;
				break;

				default:
				System.out.println("invalid option");
				nextStep=true;
				break;
				}
		
				
			while(true){

				if(logout==true){
					break;
				}
				
				if(terminate==true){
					break;
				}

				Scanner scanner2=new Scanner(System.in);
				System.out.println("choose the next option:1.Donate Books 2.Lend Books 3.log out");
				int nextOption=scanner2.nextInt();
		
				switch(nextOption){

					case 1:
					Scanner scanner3=new Scanner(System.in);
					System.out.println("enter the book name that you want to donate:");
					String donateBook=scanner3.nextLine();
					System.out.println("enter the author of the book:");
					String donateAuthor=scanner3.nextLine();
					System.out.println("enter the quantity of books that you want to donate:");
					int quantity=scanner3.nextInt();
					Book book=new Book(donateBook,donateAuthor,quantity);
					library.addBooks(book);
					break;
					
					case 2:
					Scanner scanner4=new Scanner(System.in);
					System.out.println("enter the name of the book that you want to lend:");
					String lendBook=scanner4.nextLine();
					Book bookObj=library.verifyBook(lendBook);

					if(bookObj==null){
						System.out.println("the book you asked for is not available in the library");
						break;
				
					}

					System.out.println("enter the author of the book:");
					String authorName=scanner4.nextLine();
					if(bookObj.getauthor().equals(authorName)){
						System.out.println("the book and the author matched!");
					}
					
					System.out.println("enter the quantity of books that you want to lend:");
					int quantity1=scanner4.nextInt();

					if(quantity1>bookObj.getQuantity()){
						System.out.println("the quantity you require is not not available in the library:");
						break;
					}

					break;

					case 3:
					System.out.println("logging out");
					logout=true;
					break;
		
					default:
					System.out.println("enter a valid option");
					
					}
			}
		}
		while(option<3);
	}
}

