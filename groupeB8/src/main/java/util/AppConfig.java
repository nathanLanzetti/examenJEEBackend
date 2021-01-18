package util;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

// Configure la route pour tout les futurs appels à l'api
// groupeB8/api/
@ApplicationPath("api")
public class AppConfig extends Application {
	// Cette classe permet de configurer l'api
	// Il faut qu'une classe dans le projet hérite d'Application 
}
