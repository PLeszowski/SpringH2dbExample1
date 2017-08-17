package library;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by RENT on 2017-08-16.
 */
@SpringBootApplication(scanBasePackages = "library")
public class LibraryApplication {


	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class);
	}

	@Bean
	public CommandLineRunner demo(LibraryRepository repository) {
		return (args) -> {

			repository.save(new Book("Shinning", "King"));
		};
	}

}
