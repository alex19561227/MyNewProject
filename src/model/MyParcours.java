package model;

import java.util.ArrayList;

public class MyParcours {
	private Long parcoursId;
	private MyQuestionary parcQuiz;
	private int score;
	private Long timeSpent;
	private MyUser parcUser;
	private ArrayList<MyAnswer> listAnswers = null;

	public Long getParcoursId() {
		return parcoursId;
	}

	public MyParcours(Long parcoursId, MyQuestionary parcQuiz, int score, Long timeSpent, MyUser parcUser) {
		super();
		this.parcoursId = parcoursId;
		this.parcQuiz = parcQuiz;
		this.score = score;
		this.timeSpent = timeSpent;
		this.parcUser = parcUser;
	}

	public ArrayList<MyAnswer> getListAnswers() {
		return listAnswers;
	}

	public void setListAnswers(ArrayList<MyAnswer> listAnswers) {
		this.listAnswers = listAnswers;
	}

	public MyQuestionary getParcQuiz() {
		return parcQuiz;
	}

	public void setParcQuiz(MyQuestionary parcQuiz) {
		this.parcQuiz = parcQuiz;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void calculerScore() {
		int resultat = 0;
		if (listAnswers != null)
			for (int i = 0; i < listAnswers.size(); i++) {

				if (listAnswers.get(i).isCorrectAnswer())
					resultat += 1;
			}
		else System.out.println("La liste des reponses n'est pas encore initialisée");

		this.setScore(resultat);
	}

	public Long getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(Long timeSpent) {
		this.timeSpent = timeSpent;
	}

	public MyUser getParcUser() {
		return parcUser;
	}

	public void setParcUser(MyUser parcUser) {
		this.parcUser = parcUser;
	}

	public void setParcoursId(Long parcoursId) {
		this.parcoursId = parcoursId;
	}

	public MyParcours() {
		super();
	}

	public MyParcours(Long parcoursId, Long quiz, int score, Long timeSpent, Long utilisateur) {
		// TODO Auto-generated constructor stub
	}

}
