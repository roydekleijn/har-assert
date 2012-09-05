package harMatchers;

import org.browsermob.core.har.Har;
import org.browsermob.core.har.HarEntry;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.testng.annotations.Optional;

public class HarMatchers {

	
	
	
	/*
	 * Pages matchers
	 */
	
	//-"startedDateTime": "2009-04-16T12:07:25.123+01:00",
    //-"id": "page_0",
    //-"title": "Test Page",
    //-"pageTimings": {...},
    //--"onContentLoad": 1720,
    //--"onLoad": 2500,
	
	/*
	 * Entries matchers
	 */
	
	//-"pageref": "page_0",
    //-"startedDateTime": "2009-04-16T12:07:23.596Z",
    //-"time": 50,
    //-"request": {...},
    //-"response": {...},
    //-"cache": {...},
    //-"timings": {},
    //--"blocked": 0,
    //--"dns": -1,
    //--"connect": 15,
    //--"send": 20,
    //--"wait": 38,
    //--"receive": 12,
    //--"ssl": -1,
    //-"serverIPAddress": "10.0.0.1",
    //-"connection": "52492",
    
	/*
	 * Request matchers
	 */
	
	//-"method": "GET",
    //-"url": "http://www.example.com/path/?param=value",
    //-"httpVersion": "HTTP/1.1",
    //-"cookies": [],
	 //--"name": "TestCookie",
     //--"value": "Cookie Value",
     //--"path": "/",
     //--"domain": "www.janodvarko.cz",
     //--"expires": "2009-07-24T19:20:30.123+02:00",
     //--"httpOnly": false,
     //--"secure": false,
    //-"headers": [],
	//--"name": "Accept-Encoding",
    //--"value": "gzip,deflate",
    //-"queryString" : [],
	//--"name": "Accept-Encoding",
    //--"value": "gzip,deflate",
    //-"postData" : {},
    //--"mimeType": "multipart/form-data",
    //--"params": [],
    //--"text" : "plain posted data",
    //-"headersSize" : 150,
    //-"bodySize" : 0,
	
	/*
	 * Response matchers
	 */
	
    //-"status": 200,
    //-"statusText": "OK",
    //-"httpVersion": "HTTP/1.1",
    //-"cookies": [],
	//--"name": "TestCookie",
    //--"value": "Cookie Value",
    //--"path": "/",
    //--"domain": "www.janodvarko.cz",
    //--"expires": "2009-07-24T19:20:30.123+02:00",
    //--"httpOnly": false,
    //--"secure": false,
    //-"headers": [],
	//--"name": "Accept-Encoding",
    //--"value": "gzip,deflate",
    //-"content": {},
    //--"size": 33,
    //--"compression": 0,
    //--"mimeType": "text/html; charset=utf-8",
    //--"text": "\n",
    //-"redirectURL": "",
    //-"headersSize" : 160,
    //-"bodySize" : 850,

	
	public static Matcher<Har> responseStatusCodes(
			final Matcher<Integer> statusCode) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a http response with statusCode ")
						.appendValue(statusCode);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (statusCode.matches(element.getResponse().getStatus())) {
						return true;
					}
				}
				return false;
			}
		};
	}

}
