package com.hexstudio;

public class GlobalVariableObject {
	
	private String currentUser;
	
	public void setCurrentUser(String currentUser) {
	      this.currentUser = currentUser;
	}
	
	public String getCurrentUser() {
	      return currentUser;
	}
	
	private static GlobalVariableObject instance = null;
	   protected GlobalVariableObject() {
	      // Exists only to defeat instantiation.
	   }
	   public static GlobalVariableObject getInstance() {
	      if(instance == null) {
	         instance = new GlobalVariableObject();
	      }
	      return instance;
	   }
}
