package kr.ac.shinhan.csp;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class UserAccount {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	// 아 저장되는 필드구나
	private Long key; // 프라이머리

	@Persistent
	private String userID;

	@Persistent
	private String password;

	@Persistent
	private String name;

	public UserAccount(String userID, String password, String name) {
		super();
		this.userID = userID;
		this.password = password;
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getKey() {
		return key;
	}

	public String getUserID() {
		return userID;
	}
}
