package com.cypher.br.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


/**
 * @Getter e @Setter - São notações lombok para a classe ter get e set.
 * @Entity - Notação do JPA para dizer que a classe é uma entidade para ser mapeada para o banco de dados
 * isso vai fazer que vai ter uma tabela chamada "Client" no BD.
 * @author Winicius
 * @EqualsAndHashCode - Gera equals and hash code e @exclude exclui as variaveis que deseja
 *
 */
@Entity
@Data
public class Client {
	
	/**
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) - Delegando a funçao de incrementar o ID pro banco de dados.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(nullable = false)
	private String name;
	
	@Column(length = 3, nullable = false)
	private int age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

}
