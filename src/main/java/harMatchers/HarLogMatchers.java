package harMatchers;

import org.browsermob.core.har.Har;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class HarLogMatchers {
	public static Matcher<Har> logVersion(final Matcher<String> version) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a har with version number ")
						.appendValue(version);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription.appendText("got "
						+ har.getLog().getVersion());
			}

			@Override
			protected boolean matchesSafely(Har har) {
				if (version.matches(har.getLog().getVersion())) {
					return true;
				}
				return false;
			}
		};
	}
}
