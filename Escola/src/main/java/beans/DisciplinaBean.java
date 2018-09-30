package beans;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;

import entities.Disciplina;
import entities.Professor;
import services.DisciplinaService;

@SessionScoped
@Named
public class DisciplinaBean {
	private Disciplina disciplina = new Disciplina();
	private Set<Disciplina> disciplinas;
	private DisciplinaService service;
	@ManagedProperty(value="#{professorBean}")
	private ProfessorBean profBean;

	@PostConstruct
	private void init() {
		service = new DisciplinaService();
	}

	private void salvarDisc() {
		for(Professor p: profBean.getProfs()) {
			if(disciplina.getProf().getId() == p.getId()) {
				disciplina.setProf(p);
			}
		}
		service.save(disciplina);
		disciplina = new Disciplina();
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
