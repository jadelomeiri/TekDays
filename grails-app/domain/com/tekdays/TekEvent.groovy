package com.tekdays

class TekEvent {

	String city
	String name
	TekUser organizer
	String venue
	Date startDate
	Date endDate
	String description
	//TekUser volunteers
	//String respondents
	//Sponsorship sponsorships
	//Task tasks
	//TekMessage messages
	
	static searchable = {
		organizer component: true
		volunteers component: true
	}
	
	static hasMany = [volunteers: TekUser,
						respondents: String,
						sponsorships: Sponsorship,
						tasks: Task,
						messages: TekMessage]
	
	static constraints = {
		name()
		city()
		description maxSize: 5000
		organizer()
		venue()
		startDate()
		endDate()
		volunteers nullable: true
		respondents nullable: true
		sponsorships nullable: true
		tasks nullable: true
		messages nullable: true
	}
	
	String toString() {
		"$name, $city"
	}
}
