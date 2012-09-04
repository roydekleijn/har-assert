import static harunit.HarMatchers.responseStatusCodes;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.startsWith;
import static harunit.HarMatchers.requestUrlMethod;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.browsermob.core.har.Har;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class hartests {
	protected Har har;

	@BeforeClass
	public void setupTest() throws JsonParseException, JsonMappingException,
			IOException {
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
	public void harContainsResponseStatusCodesGreaterThan404() throws JsonGenerationException, JsonMappingException, IOException {
		assertThat(HarUtil.toString(har), har, responseStatusCodes(is(greaterThan(404))));
	}
	
	@Test
	public void harContainsRequestUrlWithMethod() throws JsonGenerationException, JsonMappingException, IOException {
		assertThat(HarUtil.toString(har), har, requestUrlMethod(startsWith("http://www.google"), is("GET")));
	}

}
