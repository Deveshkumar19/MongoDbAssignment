package com.devesh.Project.MongoDbAssignment.Controller;

import com.devesh.Project.MongoDbAssignment.Model.Book;
import com.devesh.Project.MongoDbAssignment.Service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookServiceImpl bookService;


    /**
     * @param book  @{@link Book}
     *
     */
    @RequestMapping (value="/insertBook", method=RequestMethod.POST)
    public void insertBook(@RequestBody Book book){

        bookService.insert(book);
    }

    /**
     * @param lstBook
     */
    @RequestMapping (value="/insertBulkBook", method=RequestMethod.POST)
    public void insertBulkBook(@RequestBody List<Book>lstBook){

        bookService.bulkInsert(lstBook);
    }

    /**
     * @param lstBook 
     */
    @RequestMapping (value="/insertBookThread", method=RequestMethod.POST)
    public void insertBookInThread(@RequestBody List<Book> lstBook)  {
        System.out.println("inside");
        try {
            bookService.insertBookThread(lstBook);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     */
    @RequestMapping (value="/getBook", method=RequestMethod.GET)
    public List<Book> getBook(){

       return  bookService.getBooks();
    }


    /**
     * @param name
     * @return
     */
    @GetMapping("/book/{name}")
    public Book getBookByName(@PathVariable String name){
        return bookService.getBookName(name);
    }
}
