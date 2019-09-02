package br.com.uppertools.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uppertools.exception.ResourceNotFoundException;
import br.com.uppertools.model.Person;
import br.com.uppertools.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository repository;

	/**
	 * Create new register
	 * 
	 * @param person Body object to insert
	 * @return Return Object person
	 */
	public Person create(Person person) {
		return repository.save(person);
	}

	/**
	 * Update exist value
	 * 
	 * @param person Objeto person to update
	 * @return Return person updated
	 */
	public Person update(Person person) {
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGenger(person.getGenger());
		return repository.save(entity);
	}

	/**
	 * Delete object with id
	 * 
	 * @param id Id object to delete
	 */
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
		repository.delete(entity);
	}

	/**
	 * Find by id value
	 * 
	 * @param id Id to search object
	 * @return Object with id
	 */
	public Person findbyId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
	}

	public List<Person> findAll() {
		return repository.findAll();
	}

}
