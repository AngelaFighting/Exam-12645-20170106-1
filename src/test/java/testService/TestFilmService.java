package testService;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Film;
import model.Language;
import service.FilmService;

public class TestFilmService {

	public static void main(String args[]){
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		FilmService filmService = 
				(FilmService) applicationContext.getBean("filmService");
//		Language language=new Language();
//		language.setLanguageId(2);
//		Film film=new Film();
//		film.setTitle("test");
//		film.setDescription("test");
//		film.setLanguage(language);
//		System.out.println(filmService.insert(film));//1
		
		Language language=new Language();
		language.setLanguageId(4);
		Film film=new Film();
		film.setFilmId(1002);
		film.setLanguage(language);
		System.out.println(filmService.update(film));//1
		
//		System.out.println(filmService.delete(1001));
		
//		List<Film> films=filmService.select(0, 10);
//		for(Film film: films){
//			System.out.println(film);
//		}
		
//		System.out.println(filmService.count());
		
//		System.out.println(filmService.select(1));
		
	}
}
