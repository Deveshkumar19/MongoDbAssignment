package com.devesh.Project.MongoDbAssignment.Repository;

import com.devesh.Project.MongoDbAssignment.Model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,String> {
   public  Book findByName(String name);
}
