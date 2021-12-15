package com.cypher.br.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cypher.br.model.Client;
import com.cypher.br.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	public List<Client> listClient() {
		return clientRepository.findAll();
	}
	
	
	public String registerClient(Client client) throws SQLException {
			
		this.validatorName(client.getName());
		this.validatorAge(client.getAge());
		
		clientRepository.save(client);
			
			return "Cliente cadastrado com sucesso!";
	}
	
	public String deleteClient (Client client) {
		
		clientRepository.deleteById(client.getId());
		
			return "Cliente deletado com sucesso!";
		
	}

	
	public String editCLient (Client client) throws SQLException {
		
		this.validatorName(client.getName());
		this.validatorAge(client.getAge());
		
		clientRepository.save(client);
		
		return "Cliente editado com sucesso!";
	}
	
	
	/* METODOS */
	/**
	 *
	 * @param name - Nome do cliente
	 * @return - Retorna Ok ou erro, de acordo com a condição
	 * @throws SQLException - Retorna erro caso for vazio ou nulo
	 */
	public String validatorName(String name) throws SQLException {
		if(name.equals(null) || name.equals("")) {
			throw new SQLException("Nome deve estar preenchido!");
		}
		return "Ok";
	}
	
	public String validatorAge(int age) throws SQLException {
		
		if(age == 0) {
			throw new SQLException("Idade deve ser maior que 0!");
		}
		
		return "Ok";
	}
}
