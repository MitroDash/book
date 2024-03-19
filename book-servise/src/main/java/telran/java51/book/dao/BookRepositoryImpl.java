package telran.java51.book.dao;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
		    return query.getResultStream();
	}

	@Override
	public Stream<Book> findByPublisherPublisherName(String publisher) {
		 TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.publisher.publisherName = :publisher", Book.class);
		    query.setParameter("publisher", publisher);
		    return query.getResultStream();
	}

	@Override
	public void deleteByAuthorsName(String author) {
		TypedQuery<Book> query = em.createQuery(
	            "SELECT b FROM Book b JOIN b.authors a WHERE a.name = :author", Book.class)
	            .setParameter("author", author);
		query.executeUpdate();

	}

	@Transactional
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

	@Transactional
	@Override
	public void deleteById(String isbn) {
		Book book = em.find(Book.class, isbn);
		em.remove(book);

	}

}
