package services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import dao.DisciplinaDAO;
import entities.Disciplina;
import util.TransacionalCdi;

public class DisciplinaService implements Serializable, Service<Disciplina> {
	@Inject
	private DisciplinaDAO dao;

	@Override
	@TransacionalCdi

	public void save(Disciplina e) {
		dao.save(e);

	}

	@Override
	@TransacionalCdi

	public void update(Disciplina e) {
		dao.update(e);

	}

	@Override
	@TransacionalCdi

	public void remove(Disciplina e) {
		dao.remove(e);

	}

	@Override
	public Disciplina getByID(long userId) {
		return dao.getByID(userId);
	}

	@Override
	public List<Disciplina> getAll() {
		return dao.getAll();
	}

}
