package library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by RENT on 2017-08-16.
 */
@RestController
public class LibraryController {

	@Autowired
	private LibraryService libraryService;

	@RequestMapping("/library")
	public String hello() {
		return "Hello from library!";
	}

	@RequestMapping("/library/findall")
	public Iterable<Book> findAll() {
		return libraryService.getAll();
	}

	@RequestMapping("/library/{name}")
	public Iterable<Book> findByAuthor(@PathVariable("name") String name) {
		return libraryService.findByAuthor(name);
	}

	@RequestMapping("/library/add")
	public ResponseEntity<Long> create(@RequestBody Book book) {
		Book created = libraryService.create(book.getTitle(), book.getAuthor());
		return new ResponseEntity<Long>(created.getId(), HttpStatus.ACCEPTED);
	}
}
