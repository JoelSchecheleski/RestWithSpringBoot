package br.com.uppertools.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<PersonVO> findAll() {
		List<PersonVO> persons = service.findAll();
		persons.stream()
				.forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
		return persons;
	}

	/**
	 * Busca por id
	 * 
	 * @param id Informar o id para busca
	 * @return Retorna objeto da pesquisa
	 */
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public PersonVO findById(@PathVariable("id") Long id) {
		PersonVO personVO = service.findbyId(id);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel()); // auto relacionamento
		return personVO;
	}

	/**
	 * Cria um novo registro
	 * 
	 * @param PersonVO Informar o objeto para inserção
	 * @return Retorna o objeto inserido
	 */
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public PersonVO create(@RequestBody PersonVO person) {
		PersonVO personVO = service.create(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel()); // auto
																											// relacionamento
		return personVO;
	}

	/**
	 * Update oject
	 * 
	 * @param PersonVO Object Person to update
	 * @return Object person updated
	 */
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public PersonVO update(@RequestBody PersonVO person) {
		PersonVO personVO = service.create(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel()); // auto
																											// relacionamento
		return personVO;
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
