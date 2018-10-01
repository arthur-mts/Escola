package beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import entities.Disciplina;
import entities.Professor;
import services.DisciplinaService;

@SessionScoped
@Named
public class DisciplinaBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Disciplina disciplina = new Disciplina();
	private Collection<Disciplina> disciplinas;
	@Inject
	private DisciplinaService service;
	@ManagedProperty(value="#{professorBean}")
	private ProfessorBean profBean;

	@PostConstruct
	public void init() {
		service = new DisciplinaService();
	}

	public void salvarDisc() {
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

	
	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public DisciplinaService getService() {
		return service;
	}

	public void setService(DisciplinaService service) {
		this.service = service;
	}

	public Collection<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Collection<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
}
