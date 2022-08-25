package com.shalyapin.library.Controllers;

import com.shalyapin.library.dto.BookDTO;
import com.shalyapin.library.entity.Book;
import com.shalyapin.library.exception.BookException;
import com.shalyapin.library.repository.AuthorRepository;
import com.shalyapin.library.repository.BookRepository;
import com.shalyapin.library.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Правильно я понимаю что без спринг веб контроллеры не пишутся?
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/book")
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String title, @RequestParam(required = false) Long author_id) {
        if(title==null&&author_id==null) return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);
        else if (title==null) return new ResponseEntity<>(bookService.getBooksByAuthorId(author_id),HttpStatus.OK);
        else if (author_id==null) return new ResponseEntity<>(bookService.getBooksByTitle(title),HttpStatus.OK);
        else return new ResponseEntity<>(bookService.getBooksByTitleAndAuthorId(title,author_id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody BookDTO bookDTO) {
        return new ResponseEntity<>(bookService.createBook(bookDTO), HttpStatus.OK);
    }
  /* @PostMapping
   public ResponseEntity<Book> addBook(@RequestBody Book book) {
       return new ResponseEntity<>(bookService.createBookTest(book), HttpStatus.OK);
   }*/
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bookService.getBook(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody BookDTO book) {
        return new ResponseEntity<>(bookService.updateBook(id,book),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") Long id) {
      if (bookService.deleteBook(id)) return new ResponseEntity<>(HttpStatus.OK); else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    //Нужно ли обновлять только тайтл ? Нужно ли делать значение стринга как отдельный класс?
    @PatchMapping("/{id}")
    public ResponseEntity<Book> updateTitleById(@PathVariable("id") Long id, @RequestBody(required = true) String title ) {

        return new ResponseEntity<>(bookService.updateBookTitle(id,title),HttpStatus.OK);
    }
}


