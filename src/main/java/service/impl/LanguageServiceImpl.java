package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LanguageMapper;
import model.Language;
import service.LanguageService;

@Service("languageService")
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageMapper languageMapper;
	
	@Override
	public List<Language> getAllLanguage() {
		return languageMapper.selectLanguages();
	}

}
