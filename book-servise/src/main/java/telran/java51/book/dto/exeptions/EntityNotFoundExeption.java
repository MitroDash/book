package telran.java51.book.dto.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundExeption extends RuntimeException {

	private static final long serialVersionUID = -233220425004959279L;

}
