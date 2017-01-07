package service;

import java.util.List;

import model.Film;

public interface FilmService {

	public int insert(Film film);
	
	public int update(Film film);
	
	public int delete(int id);
	
	public List<Film> select(int offset,int pageSize);
	
	public int count();
	
	public Film select(int id);
	
}
