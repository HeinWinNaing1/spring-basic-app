package com.hostmdy.jpa.data;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.hostmdy.jpa.entity.Author;
import com.hostmdy.jpa.entity.Book;
import com.hostmdy.jpa.repository.AuthorRepository;
import com.hostmdy.jpa.repository.BookRepository;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	
	

	public InitialDataLoader(BookRepository bookRepository, AuthorRepository authorRepository) {
		super();
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initialize();
		
	}
	
	private void initialize() {
		Book book1 = new Book("Domain Driver Design","Programming", 34.5);
		Author author1 = new Author("Eric","Evan",60,"eric.even@gmail.com");
		
		//Many to Many Connect
		book1.getAuthors().add(author1);
		
		author1.getBooks().add(book1);
		authorRepository.save(author1);
		bookRepository.save(book1);//Create/Insert
		
		
		Book book2 = new Book("Java 8 in Action","Programming", 50.5);
		Author author2 = new Author("Jhon","Doe",40,"jd@gmail.com");
		
		//Many to Many Connect
		book2.getAuthors().add(author2);
		
		author2.getBooks().add(book2);
		authorRepository.save(author2);
		bookRepository.save(book2);//Create/Insert
		
		
		Book book3 = new Book("Model Design","Programming", 50.5);
		Author author3 = new Author("Ma","Sapal",40,"ms@gmail.com");
		
		//Many to Many Connect
		book3.getAuthors().add(author3);
		
		author3.getBooks().add(book3);
		authorRepository.save(author3);
		bookRepository.save(book3);//Create/Insert
		
		Book book4 = new Book("Java Multitreading","Programming",40.6);
		book4.getAuthors().add(author1);
		book4.getAuthors().add(author2);
		book4.getAuthors().add(author3);
		
		authorRepository.save(author1);
		authorRepository.save(author2);
		authorRepository.save(author3);
		
		bookRepository.save(book4);
		
		
	}

}
