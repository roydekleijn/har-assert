package harMatchers;

import org.browsermob.core.har.Har;
import org.browsermob.core.har.HarCookie;
import org.browsermob.core.har.HarEntry;
import org.browsermob.core.har.HarNameValuePair;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class HarRequestMatchers {

	public static Matcher<Har> requestUrlMethod(final Matcher<String> url,
			final Matcher<String> method) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url).appendText(" and request method ")
						.appendValue(method);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (url.matches(element.getRequest().getUrl())
							&& method.matches(element.getRequest().getMethod())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrl(final Matcher<String> url) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (url.matches(element.getRequest().getUrl())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlHttpVersion(final Matcher<String> url,
			final Matcher<String> httpVersion) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(" and request HTTP version ")
						.appendValue(httpVersion);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (url.matches(element.getRequest().getUrl())
							&& httpVersion.matches(element.getRequest()
									.getHttpVersion())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlCookieName(final Matcher<String> url,
			final Matcher<String> cookieName) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url).appendText(" and cookie name ")
						.appendValue(cookieName);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getRequest().getCookies()) {
						if (url.matches(element.getRequest().getUrl())
								&& cookieName.matches(cookie.getName())) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlCookieValue(final Matcher<String> url,
			final Matcher<String> cookieValue) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url).appendText(" and cookie value ")
						.appendValue(cookieValue);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getRequest().getCookies()) {
						if (url.matches(element.getRequest().getUrl())
								&& cookieValue.matches(cookie.getValue())) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlCookiePath(final Matcher<String> url,
			final Matcher<String> cookiePath) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(" and path pertaining to the cookie ")
						.appendValue(cookiePath);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getRequest().getCookies()) {
						if (url.matches(element.getRequest().getUrl())
								&& cookiePath.matches(cookie.getPath())) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlCookieDomain(
			final Matcher<String> url, final Matcher<String> cookieDomain) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(" and host of the cookie ")
						.appendValue(cookieDomain);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getRequest().getCookies()) {
						if (url.matches(element.getRequest().getUrl())
								&& cookieDomain.matches(cookie.getDomain())) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlCookieExpires(
			final Matcher<String> url, final Matcher<String> cookieExpires) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(" and cookie expiration time ")
						.appendValue(cookieExpires);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getRequest().getCookies()) {
						if (url.matches(element.getRequest().getUrl())
								&& cookieExpires.matches(cookie.getExpires())) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlCookieHttpOnly(
			final Matcher<String> url, final Matcher<Boolean> cookieHttpOnly) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(" and cookie is HTTP only ")
						.appendValue(cookieHttpOnly);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getRequest().getCookies()) {
						if (url.matches(element.getRequest().getUrl())
								&& cookieHttpOnly.matches(cookie.getHttpOnly())) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlHeaderNameValue(
			final Matcher<String> url, final Matcher<String> headerName,
			final Matcher<String> headerValue) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url).appendText(" and header name ")
						.appendValue(headerName)
						.appendText(" and header value ")
						.appendValue(headerValue);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarNameValuePair pair : element.getRequest()
							.getHeaders()) {
						if (url.matches(element.getRequest().getUrl())
								&& headerName.matches(pair.getName())
								&& headerValue.matches(pair.getValue())) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlQueryNameValue(
			final Matcher<String> url, final Matcher<String> queryName,
			final Matcher<String> queryValue) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url).appendText(" and query name ")
						.appendValue(queryName).appendText(" and query value ")
						.appendValue(queryValue);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarNameValuePair pair : element.getRequest()
							.getQueryString()) {
						if (url.matches(element.getRequest().getUrl())
								&& queryName.matches(pair.getName())
								&& queryValue.matches(pair.getValue())) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlHeaderSize(final Matcher<String> url,
			final Matcher<Integer> headerSize) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description
						.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(
								"the total number of bytes from the start of the HTTP request message until (and including) the double CRLF before the body ")
						.appendValue(headerSize);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (url.matches(element.getRequest().getUrl())
							&& headerSize.matches((int) element.getRequest()
									.getHeadersSize())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlBodySize(final Matcher<String> url,
			final Matcher<Integer> bodySize, final Matcher<String> queryValue) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description
						.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(
								" and the size of the request body (POST data payload) in bytes ")
						.appendValue(bodySize);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (url.matches(element.getRequest().getUrl())
							&& queryValue.matches((int) element.getRequest()
									.getBodySize())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	// -"postData" : {},
	// --"mimeType": "multipart/form-data",
	// --"params": [],
	//---"name": "paramName",
    //---"value": "paramValue",
    //---"fileName": "example.pdf",
    //---"contentType": "application/pdf",
	// --"text" : "plain posted data",

}
