package br.com.uppertools.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uppertools.model.Person;
import br.com.uppertools.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;

	/**
	 * Busca todos os registros
	 * 
	 * @return Retorna uma lista com todos os registros
	 */
	@GetMapping
	public List<Person> findAll() {
		return service.findAll();
	}

	/**
	 * Busca por id
	 * 
	 * @param id Informar o id para busca
	 * @return Retorna objeto da pesquisa
	 */
	@GetMapping(value = "/{id}")
	public Person findById(@PathVariable("id") Long id) {
		return service.findbyId(id);
	}

	/**
	 * Cria um novo registro
	 * 
	 * @param person Informar o objeto para inserção
	 * @return Retorna o objeto inserido
	 */
	@PostMapping
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}

	/**
	 * Update oject
	 * 
	 * @param person Object Person to update
	 * @return Object person updated
	 */
	@PutMapping
	public Person update(@RequestBody Person person) {
		return service.update(person);
	}

	/**
	 * Delete register 
	 * 
	 * @param id Object to delete
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
