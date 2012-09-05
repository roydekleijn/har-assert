package harMatchers;

import org.browsermob.core.har.Har;
import org.browsermob.core.har.HarCookie;
import org.browsermob.core.har.HarEntry;
import org.browsermob.core.har.HarNameValuePair;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class HarResponseMatchers {

	public static Matcher<Har> urlResponseStatus(final Matcher<String> url,
			final Matcher<Integer> status) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url).appendText(" and response status ")
						.appendValue(status);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (url.matches(element.getRequest().getUrl())
							&& status
									.matches(element.getResponse().getStatus())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> urlResponseStatus(final Matcher<Integer> status) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a response status ")
						.appendValue(status);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (status.matches(element.getResponse().getStatus())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> urlResponseStatusText(final Matcher<String> url,
			final Matcher<String> statusText) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(" and response status text ")
						.appendValue(statusText);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (url.matches(element.getRequest().getUrl())
							&& statusText.matches(element.getResponse()
									.getStatusText())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> urlResponseHttpVersion(
			final Matcher<String> url, final Matcher<String> httpVersion) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(" and response HTTP Version ")
						.appendValue(httpVersion);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (url.matches(element.getRequest().getUrl())
							&& httpVersion.matches(element.getResponse()
									.getHttpVersion())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> urlResponseCookieName(final Matcher<String> url,
			final Matcher<String> cookieName) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(" and response cookie name ")
						.appendValue(cookieName);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getResponse().getCookies()) {
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

	public static Matcher<Har> urlResponseCookieValue(
			final Matcher<String> url, final Matcher<String> cookieValue) {
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
					for (HarCookie cookie : element.getResponse().getCookies()) {
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

	public static Matcher<Har> urlResponseCookiePath(final Matcher<String> url,
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
					for (HarCookie cookie : element.getResponse().getCookies()) {
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

	public static Matcher<Har> urlResponseCookieDomain(
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
					for (HarCookie cookie : element.getResponse().getCookies()) {
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

	public static Matcher<Har> urlResponseCookieExpires(
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
					for (HarCookie cookie : element.getResponse().getCookies()) {
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

	public static Matcher<Har> urlResponseCookieHttpOnly(
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
					for (HarCookie cookie : element.getResponse().getCookies()) {
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

	public static Matcher<Har> urlResponseRedirectUrl(
			final Matcher<String> url, final Matcher<String> redirectUrl) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description
						.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(
								" and redirection target URL from the Location response header ")
						.appendValue(redirectUrl);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (url.matches(element.getRequest().getUrl())
							&& redirectUrl.matches(element.getResponse()
									.getRedirectURL())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> urlResponseHeaderSize(final Matcher<String> url,
			final Matcher<Integer> headerSize) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description
						.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(
								" and the total number of bytes from the start of the HTTP response message until (and including) the double CRLF before the body ")
						.appendValue(headerSize);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (url.matches(element.getRequest().getUrl())
							&& headerSize.matches((int) element.getResponse()
									.getHeadersSize())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> urlResponseBodySize(final Matcher<String> url,
			final Matcher<Integer> bodySize) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description
						.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(
								" and size of the received response body in bytes ")
						.appendValue(bodySize);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (url.matches(element.getRequest().getUrl())
							&& bodySize.matches((int) element.getResponse()
									.getBodySize())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> urlResponseHeaderNameValue(
			final Matcher<String> url, final Matcher<String> headerName,
			final Matcher<String> headerValue) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(" and response header name ")
						.appendValue(headerName)
						.appendText(" and response header value ")
						.appendValue(headerValue);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarNameValuePair pair : element.getResponse()
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

	public static Matcher<Har> urlResponseContentSize(
			final Matcher<String> url, final Matcher<Integer> contentSize) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description
						.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(
								" and length of the returned content in bytes ")
						.appendValue(contentSize);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (url.matches(element.getRequest().getUrl())
							&& contentSize.matches((int) element.getResponse()
									.getContent().getSize())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> urlResponseContentCompression(
			final Matcher<String> url, final Matcher<String> contentCompression) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(" and number of bytes saved ")
						.appendValue(contentCompression);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (url.matches(element.getRequest().getUrl())
							&& contentCompression.matches(element.getResponse()
									.getContent().getCompression())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> urlResponseContentMimeType(
			final Matcher<String> url, final Matcher<Integer> contentMimeType) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(" and MIME type of the response text ")
						.appendValue(contentMimeType);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (url.matches(element.getRequest().getUrl())
							&& contentMimeType.matches(element.getResponse()
									.getContent().getMimeType())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> urlResponseContentText(
			final Matcher<String> url, final Matcher<String> contentText) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description
						.appendText("a absolute URL of the request ")
						.appendValue(url)
						.appendText(
								" and response body sent from the server or loaded from the browser cache ")
						.appendValue(contentText);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (url.matches(element.getRequest().getUrl())
							&& contentText.matches(element.getResponse()
									.getContent().getText())) {
						return true;
					}
				}
				return false;
			}
		};
	}
}
