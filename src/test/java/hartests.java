import static harMatchers.HarBrowserMatchers.logBrowserName;
import static harMatchers.HarBrowserMatchers.logBrowserVersion;
import static harMatchers.HarEntryMatchers.entryServerIpAddress;
import static harMatchers.HarEntryMatchers.*;
import static harMatchers.HarLogMatchers.logVersion;
import static harMatchers.HarPageMatchers.*;
import static harMatchers.HarPageMatchers.pageTitle;
import static harMatchers.HarRequestMatchers.*;
import static harMatchers.HarRequestMatchers.requestUrlMethod;
import static harMatchers.HarResponseMatchers.*;
import static harMatchers.HarCreatorMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;
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

	/*
	 * Log Matchers
	 */

	@Test
	public void harLogVersion() throws JsonGenerationException,
			JsonMappingException, IOException {
		assertThat(har, logVersion(is("1.2")));
	}

	/*
	 * Browser Matchers
	 */
	@Test
	public void harLogBrowserAndVersion() throws JsonGenerationException,
			JsonMappingException, IOException {
		assertThat(
				har,
				allOf(logBrowserName(is(equalTo("Firefox"))),
						logBrowserVersion(is(equalTo("12.1")))));
	}

	@Test
	public void harLogBrowserVersion() {
		assertThat(har, logBrowserVersion(is("15.0")));
	}

	@Test
	public void harLogBrowserName() {
		assertThat(har, logBrowserName(is("Firefox")));
	}

	/*
	 * Creator Matchers
	 */

	@Test
	public void harCreatorName() {
		assertThat(har,
				creatorName(is("The name of the creator of this HAR file")));
	}

	@Test
	public void harCreatorVersion() {
		assertThat(
				har,
				creatorVersion(is("The version of the creator of this HAR file")));
	}

	@Test
	public void harCreatorNameAndVersion() {
		assertThat(
				har,
				allOf(creatorName(is("The name of the creator of this HAR file")),
						creatorVersion(is("The version of the creator of this HAR file"))));
	}

	/*
	 * Entry Matchers
	 */
	@Test
	public void harEntryPageref() {
		assertThat(har, entryPageref(is("Page reference")));
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
	public void harEntryAftercacheExpires() {
		assertThat(har, entryAftercacheExpires(is("Some date/timestamp")));
	}

	@Test
	public void harEntryAftercacheLastAccess() {
		assertThat(har, entryAftercacheLastAccess(is("Some date/timestamp")));
	}

	@Test
	public void harEntryAftercacheETag() {
		assertThat(har, entryAftercacheETag(is("Some eTag")));
	}

	@Test
	public void harEntryAftercacheHitcount() {
		assertThat(har, entryAftercacheHitCount(is(equalTo(5))));
	}

	@Test
	public void harEntryBeforecacheExpires() {
		assertThat(har, entryBeforecacheExpires(is("Some date/timestamp")));
	}

	@Test
	public void harEntryBeforecacheLastAccess() {
		assertThat(har, entryBeforecacheLastAccess(is("Some date/timestamp")));
	}

	@Test
	public void harEntryBeforecacheETag() {
		assertThat(har, entryBeforecacheETag(is("Some eTag")));
	}

	@Test
	public void harEntryBeforecacheHitcount() {
		assertThat(har, entryBeforecacheHitCount(is(equalTo(5))));
	}

	@Test
	public void harEntryTimingBlocked() {
		assertThat(har, entryTimingsBlocked(is(greaterThan(6))));
	}

	@Test
	public void harEntryTimingDns() {
		assertThat(har, entryTimingsDns(is(lessThan(6))));
	}

	@Test
	public void harEntryTimingConnect() {
		assertThat(har, entryTimingsConnect(is(lessThan(8))));
	}

	@Test
	public void harEntryTimingSend() {
		assertThat(har, entryTimingsSend(is(lessThan(15))));
	}

	@Test
	public void harEntryTimingWait() {
		assertThat(har, entryTimingsWait(is(lessThan(15))));
	}

	@Test
	public void harEntryTimingReceive() {
		assertThat(har, entryTimingsReceive(is(lessThan(15))));
	}

	/*
	 * Page Matchers
	 */
	@Test
	public void harPageId() {
		assertThat(har, pageId(is("some page id")));
	}

	@Test
	public void harPageTitle() {
		assertThat(har, pageTitle(is("some page title")));
	}

	@Test
	public void harPageTimingOnLoad() {
		assertThat(har, pageTimingOnload(greaterThan(Long.valueOf(14))));
	}

	@Test
	public void harPageTimingOnContentLoad() {
		assertThat(har, pageTimingOnContentLoad(greaterThan(Long.valueOf(15))));
	}

	/*
	 * Request Matchers
	 */
	@Test
	public void harRequestUrlWithMethod() {
		assertThat(har,
				requestUrlMethod(startsWith("http://www.gofeogle"), is("GET")));
	}

	@Test
	public void harRequestUrlWithHttpVersion() {
		assertThat(har, requestUrlHttpVersion(any(String.class), is("HTTP")));
	}

	@Test
	public void harRequestUrlWithCookieName() {
		assertThat(har, requestUrlCookieName(any(String.class), is("NIDc")));
	}

	@Test
	public void harRequestUrlWithCookieValue() {
		assertThat(har, requestUrlCookieValue(any(String.class), is("NIDc")));
	}

	@Test
	public void harRequestUrlWithCookiePath() {
		assertThat(har, requestUrlCookiePath(any(String.class), is("NIDc")));
	}

	@Test
	public void requestUrlWithCookieDomain() {
		assertThat(har,
				requestUrlCookieDomain(any(String.class), is("cookieDomain")));
	}

	@Test
	public void harRequestUrlWithCookieExpires() {
		assertThat(har,
				requestUrlCookieExpires(any(String.class), is("cookieExpires")));
	}

	@Test
	public void harRequestUrlWithCookieHttpOnly() {
		assertThat(har, requestUrlCookieHttpOnly(any(String.class), is(true)));
	}

	@Test
	public void harRequestUrlWithHeaderName() {
		assertThat(har,
				requestUrlHeaderName(any(String.class), is("headerName")));
	}

	@Test
	public void harRequestUrlWithHeaderValue() {
		assertThat(har,
				requestUrlHeaderValue(any(String.class), is("headerValue")));
	}

	@Test
	public void harRequestUrlWithQuerystringName() {
		assertThat(
				har,
				requestUrlQuerystringName(any(String.class),
						is("querystringName")));
	}

	@Test
	public void harRequestUrlWithQuerystringValue() {
		assertThat(
				har,
				requestUrlHeaderValue(any(String.class), is("querystringValue")));
	}

	@Test
	public void harRequestUrlWithPostdataMimetype() {
		assertThat(har,
				requestUrlPostdataMimetype(any(String.class), is("mimetype")));
	}

	@Test
	public void harRequestUrlWithPostdataText() {
		assertThat(har, requestUrlPostdataText(any(String.class), is("text")));
	}

	@Test
	public void harRequestUrlWithPostdataParamsName() {
		assertThat(
				har,
				requestUrlPostdataParamsName(any(String.class), is("paramName")));
	}

	@Test
	public void harRequestUrlWithPostdataParamsValue() {
		assertThat(
				har,
				requestUrlPostdataParamsValue(any(String.class),
						is("paramValue")));
	}

	@Test
	public void harRequestUrlWithPostdataParamsFilename() {
		assertThat(
				har,
				requestUrlPostdataParamsFilename(any(String.class),
						is("paramsFilename")));
	}

	@Test
	public void harRequestUrlWithPostdataParamsContentType() {
		assertThat(
				har,
				requestUrlPostdataParamsContentType(any(String.class),
						is("paramsContentType")));
	}

	@Test
	public void harRequestUrlWithHeaderSize() {
		assertThat(
				har,
				requestUrlHeaderSize(any(String.class),
						is(lessThan(Long.valueOf(25)))));
	}

	@Test
	public void harRequestUrlWithBodysize() {
		assertThat(
				har,
				requestUrlBodysize(any(String.class),
						is(lessThan(Long.valueOf(25)))));
	}

	/*
	 * Response Matchers
	 */

	@Test
	public void harResponseUrlWithStatus() {
		assertThat(har, requestUrlResponseStatus(is("http://www.google.nl/images/srpr/logo3w.png"), is(200)));
	}

	@Test
	public void harResponseUrlWithStatusText() {
		assertThat(har, requestUrlResponseStatusText(is("http://www.google.nl/images/srpr/logo3w.png"), is("OK")));
	}

	@Test
	public void harResponseUrlWithHttpVersion() {
		assertThat(har, requestUrlResponseHttpVersion(is("http://www.google.nl/images/srpr/logo3w.png"), is("HTTP")));
	}
	
	@Test
	public void harResponseUrlWithRedirectUrl() {
		assertThat(har, requestUrlResponseRedirectUrl(is("http://www.google.nl/images/srpr/logo3w.png"), is("")));
	}
	
	@Test
	public void harResponseUrlWithHeadersSize() {
		assertThat(har, requestUrlResponseHeadersSize(is("http://www.google.nl/images/srpr/logo3w.png"), is(lessThan(Long.valueOf(45)))));
	}
	
	@Test
	public void harResponseUrlWithBodySize() {
		assertThat(har, requestUrlResponseBodySize(is("http://www.google.nl/images/srpr/logo3w.png"), is(lessThan(Long.valueOf(45)))));
	}

}
