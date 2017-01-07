package model;

public class Language {

	private Integer languageId;
	private String name;
	
	public Integer getLanguageId() {
		return languageId;
	}
	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Language [languageId=" + languageId + ", name=" + name + "]";
	}
	
}
