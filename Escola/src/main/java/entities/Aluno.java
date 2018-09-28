package entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Aluno implements Identificavel{
	private String nome;
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_seq_gen")
	@SequenceGenerator(name = "aluno_seq_gen", sequenceName = "aluno_id_seq")
	@Id
	private Long id;
	private String dataDeNasc;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDataDeNasc() {
		return dataDeNasc;
	}
	public void setDataDeNasc(String dataDeNasc) {
		this.dataDeNasc = dataDeNasc;
	}
}
