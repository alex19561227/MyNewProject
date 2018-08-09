package model;

public class MyAnswer {
	private Long answerId;
	private String answer;
	private boolean state= false;
	private boolean correctAnswer= false;
	private MyQuestion questRepId;
	private MyParcours repParcId;
	
	
	public MyAnswer() {
		super();
	}

	public MyAnswer(Long answerId, String answer, boolean state, boolean correctAnswer, MyQuestion questRepId,
			MyParcours repParcId) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.state = state;
		this.correctAnswer = correctAnswer;
		this.questRepId = questRepId;
		this.repParcId = repParcId;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public boolean isCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public MyQuestion getQuestRepId() {
		return questRepId;
	}

	public void setQuestRepId(MyQuestion questRepId) {
		this.questRepId = questRepId;
	}

	public MyParcours getRepParcId() {
		return repParcId;
	}

	public void setRepParcId(MyParcours repParcId) {
		this.repParcId = repParcId;
	}

	
	
	
	
	
	
}
