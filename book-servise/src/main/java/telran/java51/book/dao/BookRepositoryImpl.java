package telran.java51.book.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import telran.java51.book.model.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Stream<Book> findByAuthorsName(String author) {
		TypedQuery<Book> query = em.createQuery(
		        "SELECT b FROM Book b JOIN b.authors a WHERE a.name = :author", Book.class);
		    query.setParameter("author", author);
		    List<Book> resultList = query.getResultList();
		    return resultList.stream();
	}

	@Override
	public Stream<Book> findByPublisherPublisherName(String publisher) {
		 TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.publisher.publisherName = :publisher", Book.class);
		    query.setParameter("publisher", publisher);
		    List<Book> resultList = query.getResultList();
		    return resultList.stream();
	}

	@Override
	public void deleteByAuthorsName(String author) {
		List<Book> booksToDelete = em.createQuery(
	            "SELECT b FROM Book b JOIN b.authors a WHERE a.name = :author", Book.class)
	            .setParameter("author", author)
	            .getResultList();

	    for (Book book : booksToDelete) {
	        em.remove(book);
	    }

	}

	@Override
	public Book save(Book book) {
		em.merge(book);
		return book;
	}

	@Override
	public Optional<Book> findById(String isbn) {
		return Optional.ofNullable(em.find(Book.class, isbn));
	}

	@Override
	public boolean existsById(String isbn) {
		return em.find(Book.class, isbn) != null;
	}

	@Override
	public void deleteById(String isbn) {
		Optional<Book> book = Optional.ofNullable(em.find(Book.class, isbn));
		em.remove(book);

	}

}
