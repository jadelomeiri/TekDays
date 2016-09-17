package com.tekdays

class TekUser {
	
	String fullName
	String userName
	String password
	String email
	String wesbite
	String bio
	
	static searchable = true
	
    static constraints = {
		fullName()
		userName()
		email()
		wesbite()
		bio maxSize: 5000
    }
	
	String toString() { fullName }
}
