package br.com.bexsbanco.pojos;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("UserInfo")
public class UserInfoPojo {

	@XStreamAlias("UserID")
	private String userId;
	@XStreamAlias("Password")
	private String passowrd;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassowrd() {
		return passowrd;
	}

	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}

	@Override
	public String toString() {
		return "UserInfoPojo [userId=" + userId + ", passowrd=" + passowrd
				+ "]";
	}
	
	

}
