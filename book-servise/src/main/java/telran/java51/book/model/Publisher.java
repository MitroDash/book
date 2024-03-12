package telran.java51.book.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "publisherName")
@Entity
public class Publisher implements Serializable{
	
	private static final long serialVersionUID = -232655132943852677L;
	
	@Id
	String publisherName;

	@Override
	public String toString() {
		return publisherName;
	}
	
	

}