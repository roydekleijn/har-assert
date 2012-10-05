package harMatchers;

import org.browsermob.core.har.Har;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class HarCreatorMatchers {
	public static Matcher<Har> creatorName(final Matcher<String> name) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a creator with version number ")
						.appendValue(name);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription.appendText("got "
						+ har.getLog().getCreator().getName());
			}

			@Override
			protected boolean matchesSafely(Har har) {
				if (name.matches(har.getLog().getVersion())) {
					return true;
				}
				return false;
			}
		};
	}

	public static Matcher<Har> creatorVersion(final Matcher<String> version) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a creator with version number ")
						.appendValue(version);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription.appendText("got "
						+ har.getLog().getCreator().getVersion());
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