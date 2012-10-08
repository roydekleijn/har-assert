package harMatchers;

import org.browsermob.core.har.Har;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class HarBrowserMatchers {
	/**
	 * Example usage: assertThat(har, logBrowserName(is("Firefox")));
	 * 
	 * @param browserName
	 * @return
	 */
	public static Matcher<Har> logBrowserName(final Matcher<String> browserName) {
		return new TypeSafeMatcher<Har>() {
			@Override
			public void describeTo(final Description description) {
				description.appendText("a har with browser name ").appendValue(
						browserName);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription.appendText("got "
						+ har.getLog().getBrowser().getName());
			}

			@Override
			protected boolean matchesSafely(Har har) {
				if (browserName.matches(har.getLog().getBrowser().getName())) {
					return true;
				}
				return false;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, logBrowserVersion(is("15.0")));
	 * 
	 * @param version
	 * @return
	 */
	public static Matcher<Har> logBrowserVersion(
			final Matcher<String> browserVersion) {
		return new TypeSafeMatcher<Har>() {
			@Override
			public void describeTo(final Description description) {
				description.appendText("a har with browser version number ")
						.appendValue(browserVersion);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription.appendText("got "
						+ har.getLog().getBrowser().getName());
			}

			@Override
			protected boolean matchesSafely(Har har) {
				if (browserVersion.matches(har.getLog().getBrowser()
						.getVersion())) {
					return true;
				}
				return false;
			}
		};
	}
}
