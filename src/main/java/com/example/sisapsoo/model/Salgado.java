package com.example.sisapsoo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Salgado")
public class Salgado {
	/* VARIÁVEIS DA CLASSE */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salg_sequence")
    @SequenceGenerator(sequenceName = "salg_sequence", name = "salg_seq")
    @Column(name = "id")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "preco")
	private Double preco;

	@Column(name = "qtd_dispo")
	private Integer qtd_dispo;

	/* CONSTRUTOR */

	public Salgado(){
		
	}

	public Salgado(String nome, Double preco, Integer qtd_dispo){
		this.nome = nome;
		this.preco = preco;
		this.qtd_dispo = qtd_dispo;
	}

	/* GETTER */
	public Integer getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public Double getPreco() {
		return this.preco;
	}

	public Integer getQuantidade() {
		return this.qtd_dispo;
	}

	/* SETTER */
	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void setQuantidade(Integer qtd) {
		this.qtd_dispo = qtd;
	}

}
