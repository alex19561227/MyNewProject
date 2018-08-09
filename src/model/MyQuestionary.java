package model;

public class MyQuestionary {
	private boolean state= false;
	private Long questionaryId;
	private MySubject subjectId;
	private String questionary;
	
	

	
	public MyQuestionary(boolean state, Long questionaryId, MySubject subjectId, String questionary) {
		super();
		this.state = state;
		this.questionaryId = questionaryId;
		this.subjectId = subjectId;
		this.questionary = questionary;
	}


	public MyQuestionary() {
		super();
	}


	public String getQuestionary() {
		return questionary;
	}


	public void setQuestionary(String questionary) {
		this.questionary = questionary;
	}


	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Long getQuestionaryId() {
		return questionaryId;
	}

	public void setQuestionaryId(Long questionaryId) {
		this.questionaryId = questionaryId;
	}

	public MySubject getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(MySubject subjectId) {
		this.subjectId = subjectId;
	}
	
	
}

