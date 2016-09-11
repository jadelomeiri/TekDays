import com.tekdays.TekEvent

class BootStrap {

    def init = { servletContext ->
		def event1 = new TekEvent(name: 'Java Code Camp',
							city: 'San Francisco',
							organizer: 'John Doe',
							venue: 'TBD',
							startDate: new Date('11/27/2016'),
							endDate: new Date('11/28/2016'),
							description: '''a code camp for java devs of all levels.
										Join us for free. For more details contact me
										at me@johndoe.com''')
		if(!event1.save()) {
			event1.errors.allErrors.each {error ->
				println "An error occurend with event1: ${error}"
			}
		}
		
		def event2 = new TekEvent(name: 'Groovy days',
			city: 'New York City',
			organizer: 'Adam Smith',
			venue: 'The Apprentice Venue',
			startDate: new Date('12/06/2016'),
			endDate: new Date('12/06/2016'),
			description: "description not yet available")
		if(!event2.save()) {
			event2.errors.allErrors.each {error ->
				println "An error occurend with event2: ${error}"
			}
		}
    }
    def destroy = {
    }
}
