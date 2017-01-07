package dao;

import java.util.List;

import model.Film;

public interface FilmMapper {

	public List<Film> selectFilmsByPage(int offset,int pageSize);
	
	public int countFilm();
	
	public Film selectFilmById(int id);
	
	public int insertFilm(Film film);
	
	public int updateFilm(Film film);
	
	public int deleteFilm(int id);
	
}
