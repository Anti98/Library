package com.shalyapin.library.service;

import com.shalyapin.library.dto.BookDTO;
import com.shalyapin.library.entity.Author;
import com.shalyapin.library.entity.Book;
import com.shalyapin.library.exception.AuthorException;
import com.shalyapin.library.exception.BookException;
import com.shalyapin.library.mapper.BookBookDTOMapperImpl;
import com.shalyapin.library.repository.AuthorRepository;
import com.shalyapin.library.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    protected BookBookDTOMapperImpl mapper;// = Mappers.getMapper(BookBookDTOMapperImpl.class);

   public Book createBook(BookDTO bookDTO) {
        Author author= authorRepository.findById(bookDTO.getAuthorId()).orElseThrow(()->new AuthorException("No author with that id"));
        Book  book= mapper.BookDTOTOBook(bookDTO);
        book.setAuthor(author);

       return  bookRepository.save(book);
   }

   public Book getBook(Long id) {
       return bookRepository.findById(id).orElseThrow(()->new BookException("No such book id"));
   }
   public Book updateBook(Long book_id,BookDTO bookDTO){
       Book book =mapper.BookDTOTOBook(bookDTO);
       book.setId(book_id);
       book.setAuthor(authorRepository.findById(bookDTO.getAuthorId()).orElseThrow(()->new AuthorException("No author with that id")));
       return bookRepository.save(book);

   }
   public Book updateBookTitle(Long id,String title){
       Book book= bookRepository.findById(id).orElseThrow(()->new BookException("no such book"));
       book.setTitle(title);
       return bookRepository.save(book);
   }
 /*  public Book updateBookTest(Long id,Book book){
       book.setId(id);
       return bookRepository.save(book);
   }
*/ /*  public Book createBookTest(Book book){
     return bookRepository.save(book);
 }*/
   public Boolean deleteBook(Long id) {
       //нужно ли проверять наличие такой книги ?
       bookRepository.deleteById(id);
       return true;
   }
   public List<Book> getAllBooks(){
       return bookRepository.findAll();
   }
    public List<Book> getBooksByTitle(String title){
        return bookRepository.findByTitle(title);
    }
    public List<Book> getBooksByAuthorId(Long id) {
        return bookRepository.findByAuthor_Id(id);
    }
    public List<Book> getBooksByTitleAndAuthorId(String title,Long author_id) {
        return bookRepository.findByTitleAndAuthor_Id(title,author_id);
   }


}
