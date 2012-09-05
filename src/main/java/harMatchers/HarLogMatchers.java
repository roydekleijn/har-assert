package harMatchers;

import org.browsermob.core.har.Har;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class HarLogMatchers {
	public static Matcher<Har> logVersion(final Matcher<String> version) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a har with version number ")
						.appendValue(version);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				if (version.matches(har.getLog().getVersion())) {
					return true;
				}
				return false;
			}
		};
	}

	public static Matcher<Har> logBrowserName(final Matcher<String> name) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a har with browser name ").appendValue(
						name);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				if (name.matches(har.getLog().getBrowser().getName())) {
					return true;
				}
				return false;
			}
		};
	}

	public static Matcher<Har> logBrowserVersion(final Matcher<String> version) {
		return new TypeSafeDiagnosingMatcher<Har>() {

			public void describeTo(final Description description) {
				description.appendText("a har with browser version number ")
						.appendValue(version);
			}

			@Override
			protected boolean matchesSafely(Har har,
					final Description mismatchDescription) {
				if (version.matches(har.getLog().getBrowser().getVersion())) {
					return true;
				}
				return false;
			}
		};
	}
}
