package telran.java51.book.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(of = "publisherName")
@Entity
@Getter
public class Publisher implements Serializable{
	
	private static final long serialVersionUID = -232655132943852677L;
	
	@Id
	String publisherName;
	@OneToMany(mappedBy = "publisher")
	Set<Book> books;

	@Override
	public String toString() {
		return publisherName;
	}

	public Publisher(String publisherName) {
		super();
		this.publisherName = publisherName;
	}
	
	

}
