package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.FilmMapper;
import model.Film;
import service.FilmService;

@Service("filmService")
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmMapper filmMapper;
	
	@Override
	public int insert(Film film) {
		return filmMapper.insertFilm(film);
	}

	@Override
	public int update(Film film) {
		return filmMapper.updateFilm(film);
	}

	@Override
	public int delete(int id) {
		return filmMapper.deleteFilm(id);
	}
	
	@Override
	public List<Film> select(int offset,int pageSize){
		return filmMapper.selectFilmsByPage(offset, pageSize);
	}

	@Override
	public int count() {		
		return filmMapper.countFilm();
	}

	@Override
	public Film select(int id) {
		return filmMapper.selectFilmById(id);
	}

}
