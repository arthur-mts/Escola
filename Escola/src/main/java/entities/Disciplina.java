package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Disciplina implements Identificavel {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disc_seq_gen")
	@SequenceGenerator(name = "disc_seq_gen", sequenceName = "disc_id_seq")
	@Id
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getDescri() {
		return descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}
	
	public Disciplina() {
		super();
	}

	private String nome;
	private String descri;
	@ManyToOne
	@JoinColumn(name = "id_prof_disc")
	private Professor prof;
	@ManyToMany(mappedBy = "discs", cascade = CascadeType.ALL)
	private Set<Aluno> alunos;

}
