package library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by RENT on 2017-08-16.
 */
@Service
public class LibraryService {

	@Autowired
	private LibraryRepository libraryRepository;

	public Book create(String title, String author) {
		Book book = new Book(title, author);
		return libraryRepository.save(book);
	}

	public void delete(long id) {
		libraryRepository.delete(id);
	}

	public Book update(Book book) {
		return libraryRepository.save(book);
	}

	public Book findOne(long id) {
		return libraryRepository.findOne(id);
	}

	public Iterable<Book> getAll() {
		return libraryRepository.findAll();
	}

	public Iterable<Book> findByAuthor(String name){
		return libraryRepository.findByAuthor(name);
	}
}
