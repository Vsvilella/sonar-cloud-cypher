package com.cypher.br.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cypher.br.model.Client;
import com.cypher.br.service.ClientService;


/**
 * 
 * @author Winicius
 * @RestController - Notação responsável por falar que a classe é o controlador REST que recebe os endpoints.
 * @RequestMapping - Notação que mapeia os endpoints e que diz que vão receber req. atraves do 
 * "/clientes" ou qualquer outro nome que queira.
 */
@RestController
@RequestMapping("/clientes")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public List<Client> list() {
		return this.clientService.listClient();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String register(@RequestBody Client client) {
		try {
			return clientService.registerClient(client);
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	@DeleteMapping
	public String delete(@RequestBody Client client) {
		return clientService.deleteClient(client);
		
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String edit(@RequestBody Client client) {
		try {
			return clientService.editCLient(client);
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
}
