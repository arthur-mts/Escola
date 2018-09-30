package beans;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import entities.Disciplina;
import services.DisciplinaService;

@SessionScoped
@Named
public class DisciplinaBean {
	private Disciplina disciplina = new Disciplina();
	private Set<Disciplina> disciplinas;
	private DisciplinaService service;

	@PostConstruct
	private void init() {
		// TODO Auto-generated method stub

	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public DisciplinaService getService() {
		return service;
	}

	public void setService(DisciplinaService service) {
		this.service = service;
	}
}
