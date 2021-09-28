package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Vinod Kris on 28/09/21
 */

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric","Evans");
        Book book  = new Book("Domain Drive Design","001");
        Publisher publisher = new Publisher("Penguin","Snakes Lane","London","IG8");
        publisherRepository.save(publisher);

        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(eric);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        System.out.println("Started in BootStrap!!");
        System.out.println("Number of Books are " + bookRepository.count());
        System.out.println("Number of Publishers are " + publisherRepository.count());
        System.out.println("Number of book for publisher " + publisher.getBooks().size());


    }
}
