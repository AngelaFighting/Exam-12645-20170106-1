package testService;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Language;
import service.LanguageService;

public class TestLanguageService {

	public static void main(String args[]){
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		LanguageService languageService = 
				(LanguageService) applicationContext.getBean("languageService");
		List<Language> languages=languageService.getAllLanguage();
		for(Language language: languages){
			System.out.println(language);
		}
	}
}
