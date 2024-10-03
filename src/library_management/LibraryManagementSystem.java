
package library_management;

import java.util.Scanner;

public class LibraryManagementSystem {
    private static final int MAX_BORROWERS = 100;
    private static final int MAX_BOOKS = 100;
    
    private Borrower[] borrowers = new Borrower[MAX_BORROWERS];
    private Book[] books = new Book[MAX_BOOKS];
    private int borrowerCount = 0;
    private int bookCount = 0;
    private Scanner scanner = new Scanner(System.in);

    public void borrowerMenu() {
        int choice;
        do {
            System.out.println("----------- Borrower Menu -----------");
            System.out.println("1. Add Borrower");
            System.out.println("2. View Borrowers");
            System.out.println("3. Edit Borrower");
            System.out.println("4. Delete Borrower");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                addBorrower();
            } else if (choice == 2) {
                viewBorrowers();
            } else if (choice == 3) {
                editBorrower();
            } else if (choice == 4) {
                deleteBorrower();
            }
        } while (choice != 5);
    }

    public void bookMenu() {
        int choice;
        do {
            System.out.println("----------- Book Menu -----------");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Edit Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                addBook();
            } else if (choice == 2) {
                viewBooks();
            } else if (choice == 3) {
                editBook();
            } else if (choice == 4) {
                deleteBook();
            }
        } while (choice != 5);
    }

    private void addBorrower() {
        if (borrowerCount < MAX_BORROWERS) {
            System.out.print("Enter Borrower ID: ");
            int borrowerId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Borrower Name: ");
            String name = scanner.nextLine();
            borrowers[borrowerCount++] = new Borrower(borrowerId, name);
            System.out.println("Borrower added successfully.");
        } else {
            System.out.println("Maximum number of borrowers reached.");
        }
    }

    private void viewBorrowers() {
        System.out.println("----------- Borrowers List -----------");
        for (int i = 0; i < borrowerCount; i++) {
            System.out.printf("ID: %d, Name: %s\n", borrowers[i].borrowerId, borrowers[i].name);
        }
    }

    private void editBorrower() {
        System.out.print("Enter Borrower ID to edit: ");
        int borrowerId = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < borrowerCount; i++) {
            if (borrowers[i].borrowerId == borrowerId) {
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                borrowers[i].name = newName;
                System.out.println("Borrower updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Borrower not found.");
        }
    }

    private void deleteBorrower() {
        System.out.print("Enter Borrower ID to delete: ");
        int borrowerId = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < borrowerCount; i++) {
            if (borrowers[i].borrowerId == borrowerId) {
                for (int j = i; j < borrowerCount - 1; j++) {
                    borrowers[j] = borrowers[j + 1]; // Shift left
                }
                borrowers[--borrowerCount] = null; // Optional: clear last element
                System.out.println("Borrower deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Borrower not found.");
        }
    }

    private void addBook() {
        if (bookCount < MAX_BOOKS) {
            System.out.print("Enter Book ID: ");
            int bookId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Book Title: ");
            String title = scanner.nextLine();
            System.out.print("Enter Author: ");
            String author = scanner.nextLine();
            books[bookCount++] = new Book(bookId, title, author);
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Maximum number of books reached.");
        }
    }

    private void viewBooks() {
        System.out.println("----------- Books List -----------");
        for (int i = 0; i < bookCount; i++) {
            System.out.printf("ID: %d, Title: %s, Author: %s\n", books[i].bookId, books[i].title, books[i].author);
        }
    }

    private void editBook() {
        System.out.print("Enter Book ID to edit: ");
        int bookId = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < bookCount; i++) {
            if (books[i].bookId == bookId) {
                System.out.print("Enter new title: ");
                String newTitle = scanner.nextLine();
                System.out.print("Enter new author: ");
                String newAuthor = scanner.nextLine();
                books[i].title = newTitle;
                books[i].author = newAuthor;
                System.out.println("Book updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    private void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int bookId = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < bookCount; i++) {
            if (books[i].bookId == bookId) {
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1]; // Shift left
                }
                books[--bookCount] = null; // Optional: clear last element
                System.out.println("Book deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }
    private void borrowBook() {
        System.out.print("Enter Book ID to borrow: ");
        int bookId = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < bookCount; i++) {
            if (books[i].bookId == bookId) {
                if (!books[i].isBorrowed) {
                    books[i].isBorrowed = true;
                    System.out.println("Book borrowed successfully.");
                } else {
                    System.out.println("Book is already borrowed.");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }
    
    private void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int bookId = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < bookCount; i++) {
            if (books[i].bookId == bookId) {
                if (books[i].isBorrowed) {
                    books[i].isBorrowed = false;
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book was not borrowed.");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }
    
    private void viewBorrowedBooks() {
        System.out.println("----------- Borrowed Books -----------");
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isBorrowed) {
                System.out.printf("ID: %d, Title: %s, Author: %s\n", 
                    books[i].bookId, books[i].title, books[i].author);
            }
        }
    }
    
    private void viewReturnedBooks() {
        System.out.println("----------- Returned Books -----------");
        for (int i = 0; i < bookCount; i++) {
            if (!books[i].isBorrowed) {
                System.out.printf("ID: %d, Title: %s, Author: %s\n", 
                    books[i].bookId, books[i].title, books[i].author);
            }
        }
    }

    
    private void viewPenalties() {
        System.out.println("----------- Penalties -----------");
        // For simplicity, let's assume a fixed penalty for demonstration
        int penaltyAmount = 5; // Example penalty amount
        System.out.println("Each overdue book incurs a penalty of $" + penaltyAmount + ".");
    }
    
    
    public void mainMenu() {
        int choice;
        do {
            System.out.println("----------- Main Menu -----------");
            System.out.println("1. Books");
            System.out.println("2. Borrowers");
            System.out.println("3. Borrow Books");
            System.out.println("4. Return Books");
            System.out.println("5. View Borrowed Books");
            System.out.println("6. View Returned Books");
            System.out.println("7. View Penalties");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice == 1) {
                bookMenu();
            } else if (choice == 2) {
                borrowerMenu();
            } else if (choice == 3) {
                borrowBook();
            } else if (choice == 4) {
                returnBook();
            } else if (choice == 5) {
                viewBorrowedBooks();
            } else if (choice == 6) {
                viewReturnedBooks();
            } else if (choice == 7) {
                viewPenalties();
            }
        } while (choice != 8);

        System.out.println("Exiting... Thank you for using the system!");
        scanner.close();
    }
}