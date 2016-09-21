package tekdays

class SecurityFilters {

    def filters = {
		doLogin(controller:'*', action:'*'){
			before = {
				if (!controllerName)
					return true
				
<<<<<<< HEAD
				def allowedActions = ['show', 'index', 'login', 'validate', 'search']
=======
				def allowedActions = ['show', 'index', 'login','validate']
>>>>>>> d898b22c23835e9a2f6c835002067b8736fd5b88

				if (!session.user && !allowedActions.contains(actionName)){
					
					redirect(controller:'tekUser', action:'login',
						params:['cName': controllerName, 'aName':actionName])
					
					return false
					
				}
			}
		}
	}
	
}
