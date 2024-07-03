package afternoon.nested.local.ex1.library;

import java.util.Scanner;

public class Library {
    Book[] books;
    int bookCount;
    static final int LIBRARY_SIZE = 4;

    class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }

    public Library() {
        this.books = new Book[LIBRARY_SIZE];
        bookCount = 0;
    }

    public void addBook() {
        if (bookCount >= LIBRARY_SIZE) {
            System.out.println("더 이상 책을 보관할 수 없습니다");
        } else {
            Scanner scanner = new Scanner(System.in);

            System.out.print("책 제목을 입력하세요 : ");
            String bookTitle = scanner.nextLine();

            System.out.print("책 저자를 입력하세요 : ");
            String bookAuthor = scanner.nextLine();

            books[bookCount] = new Book(bookTitle, bookAuthor);
            bookCount++;

            System.out.println("보관 된 책의 수는 : " + bookCount);

            System.out.println("=== 책 보관 완료 ===");
        }
    }

    public void showBooks() {
        System.out.println("=== 책 목록 출력 ===");
        System.out.println("*** 총 보관 책의 수는 : " + bookCount + " 입니다");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(i + 1 + ". 제목 : " + books[i].title + " / 저자 : " + books[i].author);
        }
    }
}
