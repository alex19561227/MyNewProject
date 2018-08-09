package model;

import java.util.Date;

public class MyUser {
	private Long userId;
	private String lName;
	private String fName;
	private String society;
	private String tel;
	private String email;
	private String password;
	private Date date;	
	private boolean state;
	private boolean role;
	
		public MyUser() {
		super();
	}
		
	public MyUser(Long userId) {
			super();
			this.userId = userId;
		}

	public MyUser(String lName, String fName) {
			super();
			this.lName = lName;
			this.fName = fName;
		}

	public MyUser(Long userId, String lName, String fName, String society, String tel, String email, String password, boolean state, Date date) {
			super();
			this.userId = userId;
			this.lName = lName;
			this.fName = fName;
			this.society = society;
			this.tel = tel;
			this.email = email;
			this.password = password;
			this.state = state;
			this.date = date;
		}
	
	
	public MyUser(String lName, String fName, String society, String tel, String email, String password, Date date,
			boolean state, boolean role) {
		super();
		this.lName = lName;
		this.fName = fName;
		this.society = society;
		this.tel = tel;
		this.email = email;
		this.password = password;
		this.date = date;
		this.state = state;
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRole() {
		return role;
	}

	public MyUser(String lName, String fName, String society, String tel, String email,
				boolean role) {
			super();
			this.lName = lName;
			this.fName = fName;
			this.society = society;
			this.tel = tel;
			this.email = email;
			this.role = role;
		}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getSociety() {
		return society;
	}

	public void setSociety(String society) {
		this.society = society;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + (role ? 1231 : 1237);
		result = prime * result + ((society == null) ? 0 : society.hashCode());
		result = prime * result + (state ? 1231 : 1237);
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyUser other = (MyUser) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (role != other.role)
			return false;
		if (society == null) {
			if (other.society != null)
				return false;
		} else if (!society.equals(other.society))
			return false;
		if (state != other.state)
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyUser [userId=" + userId + ", lName=" + lName + ", fName=" + fName + ", society=" + society
				+ ", tel=" + tel + ", date=" + date + ", state=" + state + "]";
	}
	
}

