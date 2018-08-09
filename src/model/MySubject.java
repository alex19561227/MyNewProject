package model;

public class MySubject {
	private Long subjectId;
	private String subject;
	
	
	public MySubject() {
		super();
	}

	public MySubject(Long subjectId) {
		super();
		this.subjectId=subjectId;
	}

	public MySubject(Long subjectId, String subject) {
		super();
		this.subjectId = subjectId;
		this.subject = subject;
	}


	public Long getSubjectId() {
		return subjectId;
	}


	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}

}
