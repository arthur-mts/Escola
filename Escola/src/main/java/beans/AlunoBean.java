package beans;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import entities.Aluno;
import services.AlunoService;
@SessionScoped
@Named
public class AlunoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Aluno aluno = new Aluno();
	private Set<Aluno> alunos;	
	private AlunoService service;

	@PostConstruct
	private void init() {
		setService(new AlunoService());
	}
	
	private void salvarAluno() {
		service.save(aluno);
		aluno = new Aluno();

	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	public AlunoService getService() {
		return service;
	}

	public void setService(AlunoService service) {
		this.service = service;
	}

}
