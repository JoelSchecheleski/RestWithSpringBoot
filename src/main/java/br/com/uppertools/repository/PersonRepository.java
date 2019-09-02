package br.com.uppertools.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.uppertools.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
