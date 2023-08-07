
import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class
	//Instance variables 
	String address;
	ArrayList<Book> books;	
	
	//Create new library
	public Library(String libraryAddress) {
		this.address=libraryAddress;
		this.books=new ArrayList<>();
		
	}
	//method to print the open hours
	public static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}
	
	//method to print the address
	public void printAddress() {
		System.out.println(address);
	}
	// method to add book to library
	public void addBook(Book book) {
		books.add(book);
	}
	
	//method to borrow a book from the Library
		public void borrowBook(String title){
			for(int i=0; i<books.size(); i++){
				if(books.get(i).getTitle().equals(title)){
					if(books.get(i).isBorrowed()){
						System.out.println ("Sorry, this book is already borrowed.");
					}else {
						books.get(i).borrowed();
						System.out.println ("You successfully borrowed " + title);
					}
					return;
				}
			}
			System.out.println ("Sorry, this book is not in our catalog.");
		}
		
		//method to print all the available books of the Library
		public void printAvailableBooks(){
			if(books.size()==0){
				System.out.println ("No book in catalog");
				return;
			}
			for(int i=0; i<books.size(); i++){
				if(!books.get(i).isBorrowed())
				System.out.println (books.get(i).getTitle());
			}
		}
		
		//method to return a book to the Library
		public void returnBook(String title){
			for(int i=0; i<books.size(); i++){
				Book b = books.get(i);
				if(b.isBorrowed() && b.getTitle().equals(title)){
					books.get(i).returned();
					System.out.println ("You successfully returned " + title);
					break;
				}
			}
		}

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}