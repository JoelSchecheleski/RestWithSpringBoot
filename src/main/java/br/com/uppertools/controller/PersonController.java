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

import br.com.uppertools.data.vo.PersonVO;
import br.com.uppertools.services.PersonService;

@RestController
@RequestMapping("api/person/v1")
public class PersonController {

	@Autowired
	private PersonService service;

	/**
	 * Busca todos os registros
	 * 
	 * @return Retorna uma lista com todos os registros
	 */
	@GetMapping
	public List<PersonVO> findAll() {
		return service.findAll();
	}

	/**
	 * Busca por id
	 * 
	 * @param id Informar o id para busca
	 * @return Retorna objeto da pesquisa
	 */
	@GetMapping(value = "/{id}")
	public PersonVO findById(@PathVariable("id") Long id) {
		return service.findbyId(id);
	}

	/**
	 * Cria um novo registro
	 * 
	 * @param PersonVO Informar o objeto para inserção
	 * @return Retorna o objeto inserido
	 */
	@PostMapping
	public PersonVO create(@RequestBody PersonVO person) {
		return service.create(person);
	}

	/**
	 * Cria um novo registro
	 * 
	 * @param PersonVO Informar o objeto para inserção
	 * @return Retorna o objeto inserido
	 */
	@PostMapping
	public PersonVO createV2(@RequestBody PersonVO person) {
		return service.create(person);
	}
	
	/**
	 * Update oject
	 * 
	 * @param PersonVO Object Person to update
	 * @return Object person updated
	 */
	@PutMapping
	public PersonVO update(@RequestBody PersonVO person) {
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
