
package com.db.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
  private int uId;
  private String uName;
public int getuId() {
	return uId;
}
public void setuId(int uId) {
	this.uId = uId;
}
public String getuName() {
	return uName;
}
public void setuName(String uName) {
	this.uName = uName;
}
  

}
