package MyProject;

import javax.swing.*;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class User{
	   static private String uName;
	   static private String pWord;
	    private String PIN ="";
	   public User() {
		   
	   }
	public User(String uName, String pWord) {
		User.uName = uName;
		User.pWord = pWord;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		User.uName = uName;
	}

	public String getpWord() {
		return pWord;
	}

	public void setpWord(String pWord) {
		User.pWord = pWord;
	}

	public String getPIN() {
		return PIN;
	}

	public void setPIN(String PIN) {
		this.PIN = PIN;
	}	
	public boolean checkPIN(String PIN) {
		if(PIN.equals(this.PIN)) {
			return true;
		}else {
			return false;
		}
	}
	   public  boolean authenticate(String uName,String pWord) {
		  
		   	if(!uName.equals(User.uName) || !pWord.equals(User.pWord)) return false;
                        else {
                            return true;
               }
	   }
	   
	   
   }