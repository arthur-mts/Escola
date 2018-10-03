package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Aluno implements Identificavel {
	private String nome;
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_seq_gen")
	@SequenceGenerator(name = "aluno_seq_gen", sequenceName = "aluno_id_seq")
	@Id
	private Long id;
	private String dataDeNasc;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "matricula_aluno_disc", joinColumns = { @JoinColumn(name = "disc_aluno_id") }, inverseJoinColumns = {
			@JoinColumn(name = "aluno_disc_id") })
	private Set<Disciplina> discs;

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

	public Aluno() {
		super();
	}

	public Set<Disciplina> getDiscs() {
		return discs;
	}

	public void setDiscs(Set<Disciplina> discs) {
		this.discs = discs;
	}
}
