package br.com.uppertools.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uppertools.converter.DozerConverter;
import br.com.uppertools.data.model.Person;
import br.com.uppertools.data.vo.PersonVO;
import br.com.uppertools.exception.ResourceNotFoundException;
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
	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parserObject(person, Person.class);
		var vo = DozerConverter.parserObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	/**
	 * List all register
	 * 
	 * @return
	 */
	public List<PersonVO> findAll() {
		return DozerConverter.parserListObjects(repository.findAll(), PersonVO.class);
	}

	/**
	 * Find by id value
	 * 
	 * @param id Id to search object
	 * @return Object with id
	 */
	public PersonVO findbyId(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
		return DozerConverter.parserObject(entity, PersonVO.class);
	}

	/**
	 * Update exist value
	 * 
	 * @param person Objeto person to update
	 * @return Return person updated
	 */
	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGenger(person.getGenger());
		var vo = DozerConverter.parserObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	/**
	 * Delete object with id
	 * 
	 * @param id Id object to delete
	 */
	public void delete(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
		repository.delete(entity);
	}

}
