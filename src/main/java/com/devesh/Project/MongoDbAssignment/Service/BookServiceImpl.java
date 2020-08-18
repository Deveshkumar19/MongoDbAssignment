package com.devesh.Project.MongoDbAssignment.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.devesh.Project.MongoDbAssignment.Model.Book;
import com.devesh.Project.MongoDbAssignment.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl {

    @Autowired
    BookRepository bookRepository;

    /**
     * @param book Insert book
     */
    public void insert(Book book){
        bookRepository.save(book);
    }

    /**
     * @return Retrieve book from DB
     */
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    /**
     * Get book By Author Name
     * @param name
     * @return
     */
    public Book getBookName(String name) {
      return   bookRepository.findByName(name);

    }

    /**
     * Bulk insert of Book into DB
     * @param lstBook
     */
    public void bulkInsert(List<Book> lstBook) {
        bookRepository.saveAll(lstBook);
    }

    /**
     * Insert book using save method using parallel thread for each book object
     * @param lstBook
     * @throws InterruptedException
     */
    public void insertBookThread(List<Book> lstBook) throws InterruptedException {

        int bookSize = lstBook.size();
        MyThread[] threads = new MyThread[bookSize];


        for (int i=0;i<bookSize;i++){
            threads[i]=new MyThread(lstBook.get(i));
            threads[i].start();
        }

        for (int i = 0; i< bookSize; i++){
            threads[i].join(30);
        }
    }

    /**
     * My thread class to perform save operation for all threads parralely
     */
        private  class MyThread extends Thread {

            Book book;
            public MyThread(Book book){
                   this.book=book;
            }
            @Override
            public void run(){
                try {
                    bookRepository.save(book);
                }catch(Exception ex){
                    System.out.println("exception occurred");
                }
            }
        }

}
