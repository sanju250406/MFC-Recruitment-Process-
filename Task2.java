
import java.util.*;                                       //We have 3 classes i.e Book class,Member class and Library class along with their needed attributes
class Book{                                               //Class Book has 4 attributes which are name,author,idno,and a boolean variable on whether it is available or not
	String name_of_book;
	String author;
	int idno;
	boolean isavailable;
	Book(int idno,String name_of_book,String author){
		this.name_of_book=name_of_book;
		this.author=author;
		this.idno=idno;
		this.isavailable=true;
	}
}
class Member{                                            //Member class has 3 attributes which is his name,his id and list of books he has read which are stored in form of idno of book
	String name;
	int idno;
	ArrayList<Integer> readBooks=new ArrayList<>();
	Member(String name,int idno){
		this.name=name;
		this.idno=idno;
		this.readBooks=new ArrayList<>();
	}
	public void addReadBook(int bookid) {             //basically adds this book to have been read by that member and prints it to the console
		if(!readBooks.contains(bookid)) {
			readBooks.add(bookid);
			System.out.println(this.name+" has read book with ID: "+bookid);
		}
	}
}
class Library{                                        //Library class has 2 attributes a list of books and a list of members
	HashSet<Book> books=new HashSet<>();
	HashSet<Member> members=new HashSet<>();
	Scanner sc=new Scanner(System.in);
	Library(){
		books=new HashSet<>();
		members=new HashSet<>();
	}
	public void addBook(Book book) {             //Adds book to the library it means now that book is available in the library
        for (Book b : books) {
            if (b.idno == book.idno) {
                System.out.println("Book ID already exists in the system");
                return;
            }
        }
        books.add(book);
        System.out.println("Book added: " + book.name_of_book);
    }
 
	public void deleteBook(int bookId) {                 //Deletes book that means book is no longer available in the library
        books.removeIf(book -> book.idno == bookId);
        System.out.println("Book with ID " + bookId + " has been removed.");
    }
	 public void addMember(Member member) {               //adds member that means this person now has a library membership
	        for (Member m : members) {
	            if (m.idno == member.idno) {
	                System.out.println("A member with this ID already exists.");
	                return;
	            }
	            if (m.name.equals(member.name)) {
	                System.out.println("A member with this name already exists.");
	                return;
	            }
	        }
	        members.add(member);
	        System.out.println("Member added: " + member.name);
	    }
	public void borrowBook(int bookId,int memberId) {           //member wants to borrow a book and can only if it is available  and if it is then that book is added to his readbook list
		for(Book b:books) {
			if(b.idno==bookId) {
				if(b.isavailable) {
					b.isavailable=false;
					System.out.println(b.name_of_book+" has been borrowed succesfully by member "+memberId);
					updateReadBook(bookId,memberId);
				}
				else {
					System.out.println("Sorry,this book had been already borrowed");
				}
				return;
			}
		}
		System.out.println("Sorry, book not found");     //book not available in the library
	}
	public void returnBook(int bookId) {        //the member now returns the book and therefore the book will now become available 
		for(Book b:books) {
			if(b.idno==bookId) {
				if(!b.isavailable) {
				b.isavailable=true;
				System.out.println(b.name_of_book+" has been succesfully returned");
				}
				else {
					System.out.println(b.name_of_book+" was not borrowed"); 
				}
				return;
			}
		}
		System.out.println("Sorry,book not registered in library");
	}
	public void updateReadBook(int bookId,int memberId) {        //adds that this member has now read this book
		for(Member m:members) {
			if(m.idno==memberId) {
				m.addReadBook(bookId);
				return;
			}
		}
		System.out.println("Sorry, this person is not a member of this library");  // in case of invalid memberId
	}
}
public class Task2 {
	public static void main(String[] args) {
		 Library library = new Library();
		Scanner sc=new Scanner(System.in);
		/*
		 * while we can certainly take input dynamically using Scanner,I have chosen
		 * to structure the input in a predefined manner to maintain a cleaner and more 
		 * controlled output presentation.Dynamic input can be easily implemented if
		 * needed
		 */
	        library.addBook(new Book(1, "Treasure Island", "Robert Louis Stevenson"));
	        library.addBook(new Book(2, "Death on the Nile", "Agatha Christie"));
	        
	        library.addMember(new Member("Ajay",101));
	        library.addMember(new Member("Ishaan",102));
	        
	        library.borrowBook(1, 101);
	        library.borrowBook(1, 102);
	        library.returnBook(1);
	        library.borrowBook(1, 102);
	}
}
