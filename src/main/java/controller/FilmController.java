package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Film;
import service.FilmService;

//捕获异常com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: 
//Cannot add or update a child row: a foreign key constraint fails (`sakila`.`film`, 
//		CONSTRAINT `fk_film_language` FOREIGN KEY (`language_id`) REFERENCES 
//		`language` (`language_id`) ON UPDATE CASCADE)

@RestController
@RequestMapping("/film")
public class FilmController {

	@Autowired
	private FilmService filmService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Film> list(@RequestParam(value="offset", required = false, defaultValue = "0") int offset,
			@RequestParam(value="pageSize", required = false, defaultValue = "1") int pageSize){
		List<Film> films=filmService.select(offset,pageSize);
		return films;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public int add(Film film){
		int result=0;
		try{
			result=filmService.insert(film);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public int edit(Film film){
//		System.out.println(film);
//		System.out.println(film.getLanguage().getLanguageId());
		int result=0;
		try{
			result=filmService.update(film);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping(value="edit/{id}",method=RequestMethod.GET)
	public Film edit(@PathVariable("id") int id){
		Film film=null;
		try{
			film=filmService.select(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return film;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public int delete(@PathVariable("id") int id){
		int result=0;
		try{
			result= filmService.delete(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/count")
	public int count(){
		int result=0;
		try{
			result= filmService.count();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
}
