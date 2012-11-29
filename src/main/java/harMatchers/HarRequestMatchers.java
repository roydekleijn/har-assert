package harMatchers;

import org.browsermob.core.har.Har;
import org.browsermob.core.har.HarCookie;
import org.browsermob.core.har.HarEntry;
import org.browsermob.core.har.HarNameValuePair;
import org.browsermob.core.har.HarPostDataParam;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public final class HarRequestMatchers {
	
	private HarRequestMatchers() {
		
	}

	/**
	 * Example usage: assertThat(har,
	 * requestUrlMethod(startsWith("http://www.gofeogle"), is("GET")));
	 * 
	 * @param requestUrl
	 * @param requestMethod
	 * @return
	 */
	public static Matcher<Har> requestUrlMethod(
			final Matcher<String> requestUrl,
			final Matcher<String> requestMethod) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and request method ")
						.appendValue(requestMethod);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and request method ")
						.appendValue(requestMethod);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!requestUrl.matches(element.getRequest().getUrl())
							&& !requestMethod.matches(element.getRequest()
									.getMethod())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlHttpVersion(any(String.class),
	 * is("HTTP")));
	 * 
	 * @param requestUrl
	 * @param requestHttpVersion
	 * @return
	 */
	public static Matcher<Har> requestUrlHttpVersion(
			final Matcher<String> requestUrl,
			final Matcher<String> requestHttpVersion) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and request HTTP Version ")
						.appendValue(requestHttpVersion);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and request HTTP Version ")
						.appendValue(requestHttpVersion);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!requestUrl.matches(element.getRequest().getUrl())
							&& !requestHttpVersion.matches(element.getRequest()
									.getHttpVersion())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlCookieName(any(String.class),
	 * is("Some cookieName")));
	 * 
	 * @param requestUrl
	 * @param cookieName
	 * @return
	 */
	public static Matcher<Har> requestUrlCookieName(
			final Matcher<String> requestUrl, final Matcher<String> cookieName) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and name of cookie ")
						.appendValue(cookieName);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and name of cookie ")
						.appendValue(cookieName);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getRequest().getCookies()) {
						if (!requestUrl.matches(element.getRequest().getUrl())
								&& !cookieName.matches(cookie.getName())) {
							return false;
						}
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlCookieValue(any(String.class),
	 * is("Some cookieValue")));
	 * 
	 * @param requestUrl
	 * @param cookieValue
	 * @return
	 */
	public static Matcher<Har> requestUrlCookieValue(
			final Matcher<String> requestUrl, final Matcher<String> cookieValue) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and value of cookie ")
						.appendValue(cookieValue);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and value of cookie ")
						.appendValue(cookieValue);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getRequest().getCookies()) {
						if (!requestUrl.matches(element.getRequest().getUrl())
								&& !cookieValue.matches(cookie.getValue())) {
							return false;
						}
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlCookiePath(any(String.class),
	 * is("cookiePath")));
	 * 
	 * @param requestUrl
	 * @param cookiePath
	 * @return
	 */
	public static Matcher<Har> requestUrlCookiePath(
			final Matcher<String> requestUrl, final Matcher<String> cookiePath) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and path pertaining to the cookie ")
						.appendValue(cookiePath);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and path pertaining to the cookie ")
						.appendValue(cookiePath);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getRequest().getCookies()) {
						if (!requestUrl.matches(element.getRequest().getUrl())
								&& !cookiePath.matches(cookie.getPath())) {
							return false;
						}
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlCookiePath(any(String.class),
	 * is("cookieDomain")));
	 * 
	 * @param requestUrl
	 * @param cookieDomain
	 * @return
	 */
	public static Matcher<Har> requestUrlCookieDomain(
			final Matcher<String> requestUrl, final Matcher<String> cookieDomain) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and host of the cookie ")
						.appendValue(cookieDomain);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and host of the cookie ")
						.appendValue(cookieDomain);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getRequest().getCookies()) {
						if (!requestUrl.matches(element.getRequest().getUrl())
								&& !cookieDomain.matches(cookie.getDomain())) {
							return false;
						}
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlCookiePath(any(String.class),
	 * is("cookieExpires")));
	 * 
	 * @param requestUrl
	 * @param cookieExpires
	 * @return
	 */
	public static Matcher<Har> requestUrlCookieExpires(
			final Matcher<String> requestUrl,
			final Matcher<String> cookieExpires) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and cookie expiration time ")
						.appendValue(cookieExpires);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and cookie expiration time ")
						.appendValue(cookieExpires);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getRequest().getCookies()) {
						if (!requestUrl.matches(element.getRequest().getUrl())
								&& !cookieExpires.matches(cookie.getExpires())) {
							return false;
						}
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlHttpOnly(any(String.class),
	 * is(true)));
	 * 
	 * @param requestUrl
	 * @param cookieHttpOnly
	 * @return
	 */
	public static Matcher<Har> requestUrlCookieHttpOnly(
			final Matcher<String> requestUrl,
			final Matcher<Boolean> cookieHttpOnly) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and cookie is HTTP only ")
						.appendValue(cookieHttpOnly);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and cookie is HTTP only ")
						.appendValue(cookieHttpOnly);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarCookie cookie : element.getRequest().getCookies()) {
						if (!requestUrl.matches(element.getRequest().getUrl())
								&& !cookieHttpOnly
										.matches(cookie.getHttpOnly())) {
							return false;
						}
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlHeaderName(any(String.class),
	 * is("headerName")));
	 * 
	 * @param requestUrl
	 * @param headerName
	 * @return
	 */
	public static Matcher<Har> requestUrlHeaderName(
			final Matcher<String> requestUrl, final Matcher<String> headerName) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and header name ")
						.appendValue(headerName);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and header name ")
						.appendValue(headerName);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarNameValuePair nameValuePair : element.getRequest()
							.getHeaders()) {
						if (!requestUrl.matches(element.getRequest().getUrl())
								&& !headerName.matches(nameValuePair.getName())) {
							return false;
						}
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlHeaderValue(any(String.class),
	 * is("headerValue")));
	 * 
	 * @param requestUrl
	 * @param headerValue
	 * @return
	 */
	public static Matcher<Har> requestUrlHeaderValue(
			final Matcher<String> requestUrl, final Matcher<String> headerValue) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and header value ")
						.appendValue(headerValue);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and header value ")
						.appendValue(headerValue);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarNameValuePair nameValuePair : element.getRequest()
							.getHeaders()) {
						if (!requestUrl.matches(element.getRequest().getUrl())
								&& !headerValue.matches(nameValuePair
										.getValue())) {
							return false;
						}
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har,
	 * requestUrlQuerystringName(any(String.class), is("headerName")));
	 * 
	 * @param requestUrl
	 * @param querystringName
	 * @return
	 */
	public static Matcher<Har> requestUrlQuerystringName(
			final Matcher<String> requestUrl,
			final Matcher<String> querystringName) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and querystring name ")
						.appendValue(querystringName);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and querystring name ")
						.appendValue(querystringName);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarNameValuePair nameValuePair : element.getRequest()
							.getQueryString()) {
						if (!requestUrl.matches(element.getRequest().getUrl())
								&& !querystringName.matches(nameValuePair
										.getName())) {
							return false;
						}
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlHeaderValue(any(String.class),
	 * is("querystringValue")));
	 * 
	 * @param requestUrl
	 * @param querystringValue
	 * @return
	 */
	public static Matcher<Har> requestUrlQuerystringValue(
			final Matcher<String> requestUrl,
			final Matcher<String> querystringValue) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and querystring value ")
						.appendValue(querystringValue);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and querystring value ")
						.appendValue(querystringValue);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarNameValuePair nameValuePair : element.getRequest()
							.getQueryString()) {
						if (!requestUrl.matches(element.getRequest().getUrl())
								&& !querystringValue.matches(nameValuePair
										.getValue())) {
							return false;
						}
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har,
	 * requestUrlPostdataMimetype(any(String.class), is("mimetype")));
	 * 
	 * @param requestUrl
	 * @param postdataMimetype
	 * @return
	 */
	public static Matcher<Har> requestUrlPostdataMimetype(
			final Matcher<String> requestUrl,
			final Matcher<String> postdataMimetype) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and postdata mimetype ")
						.appendValue(postdataMimetype);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and postdata mimetype ")
						.appendValue(postdataMimetype);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!requestUrl.matches(element.getRequest().getUrl())
							&& !postdataMimetype.matches(element.getRequest()
									.getPostData().getMimeType())) {
						return false;
					}

				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlPostdataText(any(String.class),
	 * is("text")));
	 * 
	 * @param requestUrl
	 * @param postdataText
	 * @return
	 */
	public static Matcher<Har> requestUrlPostdataText(
			final Matcher<String> requestUrl, final Matcher<String> postdataText) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and postdata text ")
						.appendValue(postdataText);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and postdata text ")
						.appendValue(postdataText);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!requestUrl.matches(element.getRequest().getUrl())
							&& !postdataText.matches(element.getRequest()
									.getPostData().getText())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har,
	 * requestUrlPostdataParamsName(any(String.class), is("paramName")));
	 * 
	 * @param requestUrl
	 * @param paramsName
	 * @return
	 */
	public static Matcher<Har> requestUrlPostdataParamsName(
			final Matcher<String> requestUrl, final Matcher<String> paramsName) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and postdata parameter name ")
						.appendValue(paramsName);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and postdata parameter name ")
						.appendValue(paramsName);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarPostDataParam postdataParam : element.getRequest()
							.getPostData().getParams()) {
						if (!requestUrl.matches(element.getRequest().getUrl())
								&& !paramsName.matches(postdataParam.getName())) {
							return false;
						}
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har,
	 * requestUrlPostdataParamsValue(any(String.class), is("paramValue")));
	 * 
	 * @param requestUrl
	 * @param paramsValue
	 * @return
	 */
	public static Matcher<Har> requestUrlPostdataParamsValue(
			final Matcher<String> requestUrl, final Matcher<String> paramsValue) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and postdata parameter value ")
						.appendValue(paramsValue);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and postdata parameter value ")
						.appendValue(paramsValue);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarPostDataParam postdataParam : element.getRequest()
							.getPostData().getParams()) {
						if (!requestUrl.matches(element.getRequest().getUrl())
								&& !paramsValue.matches(postdataParam
										.getValue())) {
							return false;
						}
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har,
	 * requestUrlPostdataParamsContentType(any(String.class),
	 * is("paramsContentType")));
	 * 
	 * @param requestUrl
	 * @param paramsContentsType
	 * @return
	 */
	public static Matcher<Har> requestUrlPostdataParamsContentType(
			final Matcher<String> requestUrl,
			final Matcher<String> paramsContentsType) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and postdata parameter contentType ")
						.appendValue(paramsContentsType);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and postdata parameter contentType ")
						.appendValue(paramsContentsType);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarPostDataParam postdataParam : element.getRequest()
							.getPostData().getParams()) {
						if (!requestUrl.matches(element.getRequest().getUrl())
								&& !paramsContentsType.matches(postdataParam
										.getContentType())) {
							return false;
						}
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har,
	 * requestUrlPostdataParamsFilename(any(String.class),
	 * is("paramsFilename")));
	 * 
	 * @param requestUrl
	 * @param paramsFilename
	 * @return
	 */
	public static Matcher<Har> requestUrlPostdataParamsFilename(
			final Matcher<String> requestUrl,
			final Matcher<String> paramsFilename) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and postdata parameter filename ")
						.appendValue(paramsFilename);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl)
						.appendText(" and postdata parameter filename ")
						.appendValue(paramsFilename);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					for (HarPostDataParam postdataParam : element.getRequest()
							.getPostData().getParams()) {
						if (!requestUrl.matches(element.getRequest().getUrl())
								&& !paramsFilename.matches(postdataParam
										.getFileName())) {
							return false;
						}
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlHeaderSize(any(String.class),
	 * is(lessThan(Long.valueOf(25)))));
	 * 
	 * @param requestUrl
	 * @param headerSize
	 * @return
	 */
	public static Matcher<Har> requestUrlHeaderSize(
			final Matcher<String> requestUrl, final Matcher<Long> headerSize) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl).appendText(" and headersize ")
						.appendValue(headerSize);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl).appendText(" and headersize ")
						.appendValue(headerSize);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!requestUrl.matches(element.getRequest().getUrl())
							&& !headerSize.matches(element.getRequest()
									.getHeadersSize())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, requestUrlBodysize(any(String.class),
	 * is(lessThan(Long.valueOf(25)))));
	 * 
	 * @param requestUrl
	 * @param bodysize
	 * @return
	 */
	public static Matcher<Har> requestUrlBodysize(
			final Matcher<String> requestUrl, final Matcher<Long> bodysize) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a absolute URL of the request ")
						.appendValue(requestUrl).appendText(" and bodysize ")
						.appendValue(bodysize);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no absolute URL of the request ")
						.appendValue(requestUrl).appendText(" and bodysize ")
						.appendValue(bodysize);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!requestUrl.matches(element.getRequest().getUrl())
							&& !bodysize.matches(element.getRequest()
									.getBodySize())) {
						return false;
					}
				}
				return true;
			}
		};
	}
}
