package jaxrs;
import java.io.FileReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.parser.JSONParser;

/**
 * Classe ressource qui récupère les données des champions
 * depuis l'import d'un fichier json
 * @author Quang LE
 *
 */
@Path("/champions")
public class ChampionsRessource {
	
	/**
	 * Méthode GET pour obtenir le json dans une uri à partir d'un fichier json
	 * @return Du Json le contenu du fichier json importé
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMessage() {
		JSONParser parser = new JSONParser();
		Object obj = null;
        try {
            obj = parser.parse(new FileReader("json/champions.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
		return obj.toString();
	}
}
