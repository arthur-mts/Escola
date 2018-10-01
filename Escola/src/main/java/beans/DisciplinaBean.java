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
import services.DisciplinaService;
import services.ProfessorService;

@SessionScoped
@Named
public class DisciplinaBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Disciplina disciplina = new Disciplina();
	private Collection<Disciplina> disciplinas;
	@Inject
	private ProfessorService profService;
	@Inject
	private DisciplinaService service;
	@Inject
	@ManagedProperty(value = "#{professorBean}")
	private ProfessorBean profBean;

	@PostConstruct
	public void init() {
		limpar();
		disciplina.getProf().setId(0L);
	}

	private void limpar() {
		disciplina = new Disciplina();
		disciplinas = service.getAll();
	}

	public void salvarDisc() {
		disciplina.setProf(profService.getByID(disciplina.getProf().getId()));
		service.save(disciplina);
		limpar();
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

	public ProfessorService getProfService() {
		return profService;
	}

	public void setProfService(ProfessorService profService) {
		this.profService = profService;
	}
}
