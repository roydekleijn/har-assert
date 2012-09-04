package harunit;

import org.browsermob.core.har.Har;
import org.browsermob.core.har.HarEntry;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class HarMatchers {
	
	public static Matcher<Har> requestUrlMethod(
			final Matcher<String> url, final Matcher<String> method) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a http response with statusCode ")
						.appendValue(url)
						.appendText(" and ")
						.appendValue(method);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (url.matches(element.getRequest().getUrl()) && method.matches(element.getRequest().getMethod())) {
						return true;
					}
				}
				return false;
			}
		};
	}

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
