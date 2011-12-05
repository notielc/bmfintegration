package br.com.bexsbanco.pojos;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BMFBCMSG")
public class BcMsgPojo {

	@XStreamAlias("UserInfo")
	private UserInfoPojo userInfo = new UserInfoPojo();

	public UserInfoPojo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfoPojo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "BcMsgPojo [userInfo=" + userInfo + "]";
	}
	
	

}
