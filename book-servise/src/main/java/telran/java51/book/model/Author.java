package telran.java51.book.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "name")
@Entity
@Getter
@Embeddable
public class Author implements Serializable{

	private static final long serialVersionUID = -8428841473039448125L;
	
	@Id
	String name;
	LocalDate birthDate;
}
