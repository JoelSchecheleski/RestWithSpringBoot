package br.com.uppertools.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.uppertools.data.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}