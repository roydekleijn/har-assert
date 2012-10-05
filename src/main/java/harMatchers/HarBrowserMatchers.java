package harMatchers;

import org.browsermob.core.har.Har;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class HarBrowserMatchers {
	public static Matcher<Har> logBrowserName(final Matcher<String> name) {
		return new TypeSafeMatcher<Har>() {
			@Override
			public void describeTo(final Description description) {
				description.appendText("a har with browser name ").appendValue(
						name);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription.appendText("got "
						+ har.getLog().getBrowser().getName());
			}

			@Override
			protected boolean matchesSafely(Har har) {
				if (name.matches(har.getLog().getBrowser().getName())) {
					return true;
				}
				return false;
			}
		};
	}

	public static Matcher<Har> logBrowserVersion(final Matcher<String> version) {
		return new TypeSafeMatcher<Har>() {
			@Override
			public void describeTo(final Description description) {
				description.appendText("a har with browser version number ")
						.appendValue(version);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription.appendText("got "
						+ har.getLog().getBrowser().getName());
			}

			@Override
			protected boolean matchesSafely(Har har) {
				if (version.matches(har.getLog().getBrowser().getVersion())) {
					return true;
				}
				return false;
			}
		};
	}
}
