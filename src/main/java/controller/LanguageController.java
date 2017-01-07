package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Language;
import service.LanguageService;

@RestController
@RequestMapping("/language")
public class LanguageController {

	@Autowired
	private LanguageService languageService;
	
	@RequestMapping("/list")
	public List<Language> listLanguage(){
		List<Language> languages=null;
		try{
			languages=languageService.getAllLanguage();
		}catch(Exception e){
			e.printStackTrace();
		}
		return languages;
	}
	
}
