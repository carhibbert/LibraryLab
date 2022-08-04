import java.util.ArrayList;

public class Library extends Book {
    // Add the missing implementation to this class

    String libAddress; 
    ArrayList<Book> Books;


    // Add address and books to library
    public Library(String address){
        super(address);
        libAddress = address;
        Books = new ArrayList<Book>();
      
    }

    // Return library address
    public void printAddress(){
        System.out.println(libAddress);
    }

    // Return library opening hours
    public static void printOpeningHours(){
        System.out.println("Libraries are open daily from 9 AM to 5 PM.");
    }

    public void addBook(Book Book){
       Books.add(Book);
    }
    // Print all available books in library
    public void printAvailableBooks() {
        Book libraryBook;
        boolean libraryEmpty = true;

        // Cycle through books in each library and print contents 
        for(int i=0; i<Books.size(); i++) {
            libraryBook = Books.get(i);

            if(!(libraryBook.isBorrowed())){
                System.out.println(libraryBook.getTitle());
                libraryEmpty = false;
            }
        } if(libraryEmpty){
            System.out.println("No book in catalog");
        }
    }

    // Borrow a book from library
    public String borrowBook(String bookTitle){
        Book libraryBook;
        String title;
       boolean contains = false;

        
          
        // Cycle through Books array and mark selected book as borrowed
        for (int i = 0; i<Books.size(); i++){
            libraryBook = Books.get(i);
            title = libraryBook.getTitle();
            

            if (bookTitle.equals(title)){
                if(!libraryBook.isBorrowed()){
                    libraryBook.borrowed();
                    System.out.println("You successfully borrowed " + title);
                    return null;
                } else {
                    System.out.println("Sorry, " + title + " is already borrowed.");
                   
                    return null;

                }
            } 
        }  
        System.out.println("Sorry, this book is not in our catalog.");
        return null;
    }

    // Return a book to library
    public String returnBook(String bookTitle){
        Book libraryBook;
        String title;
          
        // Cycle through Books array and mark selected book as borrowed
        for (int i = 0; i<Books.size(); i++){
            libraryBook = Books.get(i);
            title = libraryBook.getTitle();
            

            if (bookTitle.equals(title)){
                if(libraryBook.isBorrowed()){
                    libraryBook.returned();
                    System.out.println("You successfully returned " + title);
                    return null;
                } else {
                    System.out.println("Sorry, we have not loaned out " + title);
                
                    return null;

                }
            } 
        }  
        System.out.println("Sorry, this book is not in our catalog.");
        return null;
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

    //     // Print opening hours and the addresses
         System.out.println("Library hours:");
         printOpeningHours();
         System.out.println();

         System.out.println("Library addresses:");
         firstLibrary.printAddress();
         secondLibrary.printAddress();
         System.out.println();

    //     // Try to borrow The Lords of the Rings from both libraries
         System.out.println("Borrowing The Lord of the Rings:");
         firstLibrary.borrowBook("The Lord of the Rings");
         firstLibrary.borrowBook("The Lord of the Rings");
         secondLibrary.borrowBook("The Lord of the Rings");
         System.out.println();

    //     // Print the titles of all available books from both libraries
         System.out.println("Books available in the first library:");
         firstLibrary.printAvailableBooks();
         System.out.println();
         System.out.println("Books available in the second library:");
         secondLibrary.printAvailableBooks();
         System.out.println();

    //     // Return The Lords of the Rings to the first library
         System.out.println("Returning The Lord of the Rings:");
         firstLibrary.returnBook("The Lord of the Rings");
         System.out.println();

    //     // Print the titles of available from the first library
         System.out.println("Books available in the first library:");
         firstLibrary.printAvailableBooks();
    }
} 