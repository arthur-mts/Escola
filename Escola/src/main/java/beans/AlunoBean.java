package beans;

import java.io.Serializable;
import java.util.Set;

import entities.Aluno;

public class AlunoBean implements Serializable{
	private Aluno aluno = new Aluno();
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
	private Set<Aluno> alunos;
}
