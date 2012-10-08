package harMatchers;

import org.browsermob.core.har.Har;
import org.browsermob.core.har.HarCookie;
import org.browsermob.core.har.HarEntry;
import org.browsermob.core.har.HarNameValuePair;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class HarResponseMatchers {

	/**
	 * Example usage: assertThat(har, requestUrlResponseStatus(is(
	 * "http://www.google.nl/images/srpr/logo3w.png"), is(200)));
	 * 
	 * @param requestUrl
	 * @param responseStatus
	 * @return
	 */
	public static Matcher<Har> requestUrlResponseStatus(
			final Matcher<String> requestUrl,
			final Matcher<Integer> responseStatus) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response status ")
						.appendValue(responseStatus);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response status ")
						.appendValue(responseStatus);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (requestUrl.matches(element.getRequest().getUrl())
							&& responseStatus.matches(element.getResponse()
									.getStatus())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlResponseStatusText(is(
	 * "http://www.google.nl/images/srpr/logo3w.png"), is("OK")));
	 * 
	 * @param requestUrl
	 * @param responseStatusText
	 * @return
	 */
	public static Matcher<Har> requestUrlResponseStatusText(
			final Matcher<String> requestUrl,
			final Matcher<String> responseStatusText) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response statustext ")
						.appendValue(responseStatusText);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response statustext ")
						.appendValue(responseStatusText);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (requestUrl.matches(element.getRequest().getUrl())
							&& responseStatusText.matches(element.getResponse()
									.getStatusText())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlResponseHttpVersion(is(
	 * "http://www.google.nl/images/srpr/logo3w.png"), is("HTTP")));
	 * 
	 * @param requestUrl
	 * @param responseHttpVersion
	 * @return
	 */
	public static Matcher<Har> requestUrlResponseHttpVersion(
			final Matcher<String> requestUrl,
			final Matcher<String> responseHttpVersion) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response HTTP version ")
						.appendValue(responseHttpVersion);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response HTTP version ")
						.appendValue(responseHttpVersion);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (requestUrl.matches(element.getRequest().getUrl())
							&& responseHttpVersion.matches(element
									.getResponse().getHttpVersion())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlResponseRedirectUrl(is(
	 * "http://www.google.nl/images/srpr/logo3w.png"), is("")));
	 * 
	 * @param requestUrl
	 * @param responseRedirectUrl
	 * @return
	 */
	public static Matcher<Har> requestUrlResponseRedirectUrl(
			final Matcher<String> requestUrl,
			final Matcher<String> responseRedirectUrl) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response redirect url ")
						.appendValue(responseRedirectUrl);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and redirect url ")
						.appendValue(responseRedirectUrl);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (requestUrl.matches(element.getRequest().getUrl())
							&& responseRedirectUrl.matches(element
									.getResponse().getRedirectURL())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlResponseHeadersSize(is(
	 * "http://www.google.nl/images/srpr/logo3w.png"),
	 * is(lessThan(Long.valueOf(45)))));
	 * 
	 * @param requestUrl
	 * @param responseHeadersSize
	 * @return
	 */
	public static Matcher<Har> requestUrlResponseHeadersSize(
			final Matcher<String> requestUrl,
			final Matcher<Long> responseHeadersSize) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response headers size ")
						.appendValue(responseHeadersSize);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response headers size ")
						.appendValue(responseHeadersSize);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (requestUrl.matches(element.getRequest().getUrl())
							&& responseHeadersSize.matches(element
									.getResponse().getHeadersSize())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlResponseBodySize(is(
	 * "http://www.google.nl/images/srpr/logo3w.png"),
	 * is(lessThan(Long.valueOf(45)))));
	 * 
	 * @param requestUrl
	 * @param responseBodySize
	 * @return
	 */
	public static Matcher<Har> requestUrlResponseBodySize(
			final Matcher<String> requestUrl,
			final Matcher<Long> responseBodySize) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response body size ")
						.appendValue(responseBodySize);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response body size ")
						.appendValue(responseBodySize);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (requestUrl.matches(element.getRequest().getUrl())
							&& responseBodySize.matches(element.getResponse()
									.getBodySize())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlResponseCookieName(
			final Matcher<String> requestUrl,
			final Matcher<String> responseCookieName) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and name of response cookie ")
						.appendValue(responseCookieName);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and name of reponse cookie ")
						.appendValue(responseCookieName);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getResponse().getCookies()) {
						if (requestUrl.matches(element.getRequest().getUrl())
								&& responseCookieName.matches(cookie.getName())) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlResponseCookieValue(
			final Matcher<String> requestUrl,
			final Matcher<String> responseCookieValue) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and value of response cookie ")
						.appendValue(responseCookieValue);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and value of response cookie ")
						.appendValue(responseCookieValue);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getResponse().getCookies()) {
						if (requestUrl.matches(element.getRequest().getUrl())
								&& responseCookieValue.matches(cookie
										.getValue())) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlResponseCookiePath(
			final Matcher<String> requestUrl,
			final Matcher<String> responseCookiePath) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description
						.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(
								" and path pertaining to the response cookie ")
						.appendValue(responseCookiePath);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(
								" and path pertaining to the response cookie ")
						.appendValue(responseCookiePath);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getResponse().getCookies()) {
						if (requestUrl.matches(element.getRequest().getUrl())
								&& responseCookiePath.matches(cookie.getPath())) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlResponseCookieDomain(
			final Matcher<String> requestUrl,
			final Matcher<String> responseCookieDomain) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and host of the response cookie ")
						.appendValue(responseCookieDomain);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and host of the response cookie ")
						.appendValue(responseCookieDomain);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getResponse().getCookies()) {
						if (requestUrl.matches(element.getRequest().getUrl())
								&& responseCookieDomain.matches(cookie
										.getDomain())) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlResponseCookieExpires(
			final Matcher<String> requestUrl,
			final Matcher<String> responseCookieExpires) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response cookie expiration time ")
						.appendValue(responseCookieExpires);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response cookie expiration time ")
						.appendValue(responseCookieExpires);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getResponse().getCookies()) {
						if (requestUrl.matches(element.getRequest().getUrl())
								&& responseCookieExpires.matches(cookie
										.getExpires())) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlResponseCookieHttpOnly(
			final Matcher<String> requestUrl,
			final Matcher<Boolean> responseCookieHttpOnly) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response cookie is HTTP only ")
						.appendValue(responseCookieHttpOnly);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response cookie is HTTP only ")
						.appendValue(responseCookieHttpOnly);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getResponse().getCookies()) {
						if (requestUrl.matches(element.getRequest().getUrl())
								&& responseCookieHttpOnly.matches(cookie
										.getHttpOnly())) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlResponseHeaderName(
			final Matcher<String> requestUrl,
			final Matcher<String> responseHeaderName) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response header name ")
						.appendValue(responseHeaderName);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response header name ")
						.appendValue(responseHeaderName);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarNameValuePair nameValuePair : element.getResponse()
							.getHeaders()) {
						if (requestUrl.matches(element.getRequest().getUrl())
								&& responseHeaderName.matches(nameValuePair
										.getName())) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlResponseHeaderValue(
			final Matcher<String> requestUrl,
			final Matcher<String> responseHeaderValue) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response header value ")
						.appendValue(responseHeaderValue);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response header value ")
						.appendValue(responseHeaderValue);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarNameValuePair nameValuePair : element.getResponse()
							.getHeaders()) {
						if (requestUrl.matches(element.getRequest().getUrl())
								&& responseHeaderValue.matches(nameValuePair
										.getValue())) {
							return true;
						}
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlResponseContentSize(
			final Matcher<String> requestUrl,
			final Matcher<String> responseContentSize) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and returned content in bytes ")
						.appendValue(responseContentSize);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and returned content in bytes ")
						.appendValue(responseContentSize);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (requestUrl.matches(element.getRequest().getUrl())
							&& responseContentSize.matches(element
									.getResponse().getContent().getSize())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlResponseContentCompression(
			final Matcher<String> requestUrl,
			final Matcher<Long> contentCompression) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response bytes saved ")
						.appendValue(contentCompression);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response bytes saved ")
						.appendValue(contentCompression);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (requestUrl.matches(element.getRequest().getUrl())
							&& contentCompression.matches(element.getResponse()
									.getContent().getCompression())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlResponseContentMimeType(
			final Matcher<String> requestUrl,
			final Matcher<String> responseContentMimeType) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response content mimeType ")
						.appendValue(responseContentMimeType);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response content mimeType ")
						.appendValue(responseContentMimeType);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (requestUrl.matches(element.getRequest().getUrl())
							&& responseContentMimeType.matches(element
									.getResponse().getContent().getMimeType())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> requestUrlResponseContentText(
			final Matcher<String> requestUrl,
			final Matcher<String> responseContentText) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response content text ")
						.appendValue(responseContentText);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and response content text ")
						.appendValue(responseContentText);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (requestUrl.matches(element.getRequest().getUrl())
							&& responseContentText.matches(element
									.getResponse().getContent().getText())) {
						return true;
					}
				}
				return false;
			}
		};
	}
}
