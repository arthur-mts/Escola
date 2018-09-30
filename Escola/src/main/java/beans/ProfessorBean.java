package beans;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import entities.Professor;
import services.ProfessorService;

@SessionScoped
@Named
public class ProfessorBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Professor professor = new Professor();
	private Set<Professor> profs;
	@Inject
	private ProfessorService service;
	private String confirmSenha;

	@PostConstruct
	private void init() {
		service = new ProfessorService();
	}

	private void salvarProf() {
		if (!professor.getSenha().equals(confirmSenha)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "As senhas não conferem!"));
		} else {
			boolean sameLogin = false;
			for (Professor p : profs) {
				if (professor.getLogin().equals(p.getLogin())) {
					sameLogin = true;
				}
			}
			if (sameLogin) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("ERROR", "Login já esta cadastrado"));
			} else {
				service.save(professor);
				professor = new Professor();
			}
		}

	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Set<Professor> getProfs() {
		return profs;
	}

	public void setProfs(Set<Professor> profs) {
		this.profs = profs;
	}

	public ProfessorService getService() {
		return service;
	}

	public void setService(ProfessorService service) {
		this.service = service;
	}

	public String getConfirmSenha() {
		return confirmSenha;
	}

	public void setConfirmSenha(String confirmSenha) {
		this.confirmSenha = confirmSenha;
	}

}
