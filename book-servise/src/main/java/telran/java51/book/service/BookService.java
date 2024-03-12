package telran.java51.book.service;

import telran.java51.book.dto.AuthorDto;
import telran.java51.book.dto.BookDto;

public interface BookService {
	
	Boolean addBook(BookDto bookDto);
	
	BookDto findBookByIsbn(String isbn);
	
	BookDto removeBook(String isbn);
	
	BookDto updateBookTitle(String isbn, String newTitle);
	
	Iterable<BookDto> findBooksByAuthor(String author);
	
	Iterable<BookDto> findBooksByPublisher(String publisher);
	
	Iterable<AuthorDto> findBookAuthors(String isbn);
	
	Iterable<String> findPublishersByAuthor(String author);
	
	AuthorDto removeAuthor(String author);

}
