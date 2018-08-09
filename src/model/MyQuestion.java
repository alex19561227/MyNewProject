package model;

import java.util.ArrayList;

public class MyQuestion {
	private Long questionId;
	private String question;
	private MyQuestionary quizzId;
	private Boolean state;
	private ArrayList<MyAnswer> mesReponses;
	
	public ArrayList<MyAnswer> getMesReponses() {
		return mesReponses;
	}

	public void setMesReponses(ArrayList<MyAnswer> mesReponses) {
		this.mesReponses = mesReponses;
	}

	public MyQuestion() {
		
	}
	
	public MyQuestion(Long questionId, String question, MyQuestionary quizzId,
			Boolean state) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.quizzId = quizzId;
		this.state = state;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	

	public MyQuestionary getQuizzId() {
		return quizzId;
	}

	public void setQuizzId(MyQuestionary quizzId) {
		this.quizzId = quizzId;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
	
}
