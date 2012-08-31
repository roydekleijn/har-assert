
import harunit.ContainsStatusCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.browsermob.core.har.Har;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static harunit.ContainsStatusCode.containsStatusCode;

public class hartests {
	protected Har har;
	
	@BeforeClass
	public void setupTest() throws JsonParseException, JsonMappingException, IOException {
		File file = new File("src/test/resources/har.json");
		StringBuffer contents = new StringBuffer();
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;

			// repeat until all lines is read
			while ((text = reader.readLine()) != null) {
				contents.append(text).append(
						System.getProperty("line.separator"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		ObjectMapper mapper = new ObjectMapper();
		har = mapper.readValue(contents.toString(), Har.class);

	}

	@Test
	public void test() {
		assertThat(har, Matchers.not(containsStatusCode(404)));
	}

}
