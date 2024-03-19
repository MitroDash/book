package telran.java51.book.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import telran.java51.book.model.Publisher;

@Repository
public class PublisherRepositoryImpl implements PublisherRepository {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<String> findPublishersByAuthor(String author) {
		TypedQuery<String> query = em.createQuery(
	            "SELECT DISTINCT b.publisher.publisherName FROM Book b JOIN b.authors a WHERE a.name = :author",
	            String.class);
	    query.setParameter("author", author);
	    return query.getResultList();
	}

	@Override
	public Stream<Publisher> findDistinctByBooksAuthorsName(String authorName) {
		 TypedQuery<Publisher> query = em.createQuery(
		            "SELECT DISTINCT b.publisher FROM Book b JOIN b.authors a WHERE a.name = :authorName", 
		            Publisher.class);
		    query.setParameter("authorName", authorName);
		    return query.getResultStream();
	}

	@Override
	public Optional<Publisher> findById(String publisher) {
		return Optional.ofNullable(em.find(Publisher.class, publisher));
	}

	@Transactional
	@Override
	public Publisher save(Publisher publisher) {
		em.merge(publisher);
		return publisher;
	}

}
