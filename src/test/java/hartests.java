import static harMatchers.HarBrowserMatchers.logBrowserName;
import static harMatchers.HarBrowserMatchers.logBrowserVersion;
import static harMatchers.HarEntryMatchers.entryServerIpAddress;
import static harMatchers.HarEntryMatchers.entryTime;
import static harMatchers.HarLogMatchers.logVersion;
import static harMatchers.HarPageMatchers.pageId;
import static harMatchers.HarPageMatchers.pageTitle;
import static harMatchers.HarRequestMatchers.requestUrlCookieName;
import static harMatchers.HarRequestMatchers.requestUrlMethod;
import static harMatchers.HarResponseMatchers.urlResponseStatus;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;

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
	public void harLogVersion() throws JsonGenerationException,
			JsonMappingException, IOException {
		assertThat(HarUtil.toString(har), har, logVersion(is("1.2")));
	}

	@Test
	public void harLogBrowser() throws JsonGenerationException,
			JsonMappingException, IOException {
		assertThat(
				HarUtil.toString(har),
				har,
				allOf(logBrowserName(is(equalTo("Firefox"))),
						logBrowserVersion(is(equalTo("12.1")))));
	}

	@Test
	public void harEntryTime() {
		assertThat(har, entryTime(is(Long.valueOf(25))));
	}

	@Test
	public void harEntryServerIpAddress() {
		assertThat(har, entryServerIpAddress(is("123.321.25.36")));
	}

	@Test
	public void harPageId() {
		assertThat(har, pageId(is("some page id")));
	}

	@Test
	public void harPageTitle() {
		assertThat(har, pageTitle(is("some page id")));
	}

	@Test
	public void harRequestUrlWithMethod() {
		assertThat(har,
				requestUrlMethod(startsWith("http://www.gofeogle"), is("GET")));
	}

	@Test
	public void harContainsResponseStatusCodesGreaterThan404()
			throws JsonGenerationException, JsonMappingException, IOException {
		assertThat(
				HarUtil.toString(har),
				har,
				urlResponseStatus(startsWith("http://www.google"),
						is(greaterThan(404))));
	}

	@Test
	public void harContainsRequestUrlWithMethod()
			throws JsonGenerationException, JsonMappingException, IOException {
		assertThat(
				HarUtil.toString(har),
				har,
				requestUrlCookieName(startsWith("http://www.google"), is("GET")));
	}

	@Test
	public void harContainsRequestUrlWithCookieName()
			throws JsonGenerationException, JsonMappingException, IOException {
		assertThat(
				HarUtil.toString(har),
				har,
				requestUrlCookieName(startsWith("http://www.google"),
						is("NIDe")));
	}
}
