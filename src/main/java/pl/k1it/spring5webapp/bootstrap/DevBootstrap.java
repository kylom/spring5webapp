package pl.k1it.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.k1it.spring5webapp.model.Author;
import pl.k1it.spring5webapp.model.Book;
import pl.k1it.spring5webapp.model.Publisher;
import pl.k1it.spring5webapp.repositories.AuthorRepository;
import pl.k1it.spring5webapp.repositories.BookRepository;
import pl.k1it.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //  Publisher
        Publisher publisher = new Publisher();
        publisher.setName("publisher");

        publisherRepository.save(publisher);

        // Eric
        Author author = new Author("Eric", "Evans");
        Book book = new Book( "książka A", "1234", publisher);
        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book);

        // Rod
        Author author2 = new Author("Rod", "Johnson");
        Book book2 = new Book( "książka B", "5234", publisher);
        author2.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);
    }
}
