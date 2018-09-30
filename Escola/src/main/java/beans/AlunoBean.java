package beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


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
	private Collection<Aluno> alunos;
	@Inject
	private AlunoService service;

	@PostConstruct
	private void init() {
		setAlunos(service.getAll());
		setService(new AlunoService());
	}
	
	public void salvarAluno() {
		service.save(aluno);
		aluno = new Aluno();

	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public AlunoService getService() {
		return service;
	}

	public void setService(AlunoService service) {
		this.service = service;
	}

	public Collection<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Collection<Aluno> alunos) {
		this.alunos = alunos;
	}

}
