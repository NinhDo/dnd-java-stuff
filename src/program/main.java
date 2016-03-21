package program;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.corba.se.impl.orbutil.ObjectWriter;
import monsterObject.monsterObject;


public class main {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		monsterObject mo = new monsterObject();

		try {
			String jsonInString = mapper.writeValueAsString(mo);
			System.out.println(jsonInString);

			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mo);
			System.out.println(jsonInString);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}
}
