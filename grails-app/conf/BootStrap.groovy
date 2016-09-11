import com.tekdays.Sponsor
import com.tekdays.Sponsorship
import com.tekdays.TekEvent
import com.tekdays.TekUser

class BootStrap {

    def init = { servletContext ->
		println "creating demo users"
		def user1 = new TekUser(fullName: 'John Doe',
								userName: 'johndoe',
								password: 'p@$$w0rd',
								email: 'me@johndoe.com',
								wesbite: 'www.johndoe.com',
								bio: 'John Doe is a java dev with more than 15 years experience')
		if(!user1.save()) {
			user1.errors.allErrors.each {error ->
				println "An error occurend with user1: ${error}"
				}
		}
							
		def user2 = new TekUser(fullName: 'Adam Smith',
								userName: 'adam.smith',
								password: 'adam123123',
								email: 'adam.smith@gmail.com',
								wesbite: 'n/a',
								bio: 'no bio yet')
		if(!user2.save()) {
			user2.errors.allErrors.each {error ->
				println "An error occurend with user2: ${error}"
			}
		}
		
		println "creating demo events"
		def event1 = new TekEvent(name: 'Java Code Camp',
								city: 'San Francisco',
								organizer: TekUser.findByFullName('John Doe'),
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
								organizer: TekUser.findByFullName('Adam Smith'),
								venue: 'The Apprentice Venue',
								startDate: new Date('12/06/2016'),
								endDate: new Date('12/06/2016'),
								description: "description not yet available")
		if(!event2.save()) {
			event2.errors.allErrors.each {error ->
				println "An error occurend with event2: ${error}"
			}
		}
		
		
/*		println "adding demo volunteers"
		def g1 = TekEvent.findByName('Groovy Days') as TekEvent
		g1.addToVolunteers(new TekUser(fullName: 'Sarah Martin',
									userName: 'sarah.m',
									password: 'sarah.m123!',
									email: 'sarah.m@gmail.com',
									wesbite: 'n/a',
									bio: 'no bio yet'))
		g1.addToVolunteers(new TekUser(fullName: 'Bill Yoda',
									userName: 'b.yoda',
									password: 'billyoda111',
									email: 'b.yoda1@gmail.com',
									wesbite: 'n/a',
									bio: 'no bio yet'))
		g1.save()*/
		
		
		def s1 = new Sponsor(name:'Contegix',
			website:'http://www.contegix.com',
			description:'Beyond Managed Hosting for your Enterprise').save()

		def sp1 = new Sponsorship(event:event1,
			sponsor:s1,
			contributionType:'Other',
			description:'Cool T-Shirts').save()
							
    }
    def destroy = {
    }
}
