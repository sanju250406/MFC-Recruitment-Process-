//package Java;
import java.util.*;
class Book{
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
class Member{
	String name;
	int idno;
	ArrayList<Integer> readBooks=new ArrayList<>();
	Member(String name,int idno){
		this.name=name;
		this.idno=idno;
		this.readBooks=new ArrayList<>();
	}
	public void addReadBook(int bookid) {
		if(!readBooks.contains(bookid)) {
			readBooks.add(bookid);
			System.out.println(this.name+" has read book with ID: "+bookid);
		}
	}
}
class Library{
	HashSet<Book> books=new HashSet<>();
	HashSet<Member> members=new HashSet<>();
	Scanner sc=new Scanner(System.in);
	Library(){
		books=new HashSet<>();
		members=new HashSet<>();
	}
	public void addBook(Book book) {
        for (Book b : books) {
            if (b.idno == book.idno) {
                System.out.println("Book ID already exists in the system");
                return;
            }
        }
        books.add(book);
        System.out.println("Book added: " + book.name_of_book);
    }

	public void deleteBook(int bookId) {
        books.removeIf(book -> book.idno == bookId);
        System.out.println("Book with ID " + bookId + " has been removed.");
    }
	 public void addMember(Member member) {
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
	public void borrowBook(int bookId,int memberId) {
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
		System.out.println("Sorry, book not found");
	}
	public void returnBook(int bookId) {
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
	public void updateReadBook(int bookId,int memberId) {
		for(Member m:members) {
			if(m.idno==memberId) {
				m.addReadBook(bookId);
				return;
			}
		}
		System.out.println("Sorry, this person is not a member of this library");
	}
}
public class Task2 {
	public static void main(String[] args) {
		 Library library = new Library();
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
//--> I need a book class and i need a member class along with a Library class
//book class attributes--> name,author,idno,available or not
//member class attributes--> name,idno,borrowedbooks list
//library class attributes--->books available,
