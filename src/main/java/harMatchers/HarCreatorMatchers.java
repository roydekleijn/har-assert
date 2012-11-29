package harMatchers;

import org.browsermob.core.har.Har;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public final class HarCreatorMatchers {
	
	private HarCreatorMatchers() {
		
	}

	/**
	 * Example usage: assertThat(har,
	 * creatorName(is("The name of the creator of this HAR file")));
	 * 
	 * @param creatorName
	 * @return
	 */
	public static Matcher<Har> creatorName(final Matcher<String> creatorName) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a creator with version number ")
						.appendValue(creatorName);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription.appendText("got "
						+ har.getLog().getCreator().getName());
			}

			@Override
			protected boolean matchesSafely(Har har) {
				if (creatorName.matches(har.getLog().getVersion())) {
					return true;
				}
				return false;
			}
		};
	}

	/**
	 * Example usage: assertThat( har,
	 * creatorVersion(is("The version of the creator of this HAR file")));
	 * 
	 * @param creatorVersion
	 * @return
	 */
	public static Matcher<Har> creatorVersion(
			final Matcher<String> creatorVersion) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("a creator with version number ")
						.appendValue(creatorVersion);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription.appendText("got "
						+ har.getLog().getCreator().getVersion());
			}

			@Override
			protected boolean matchesSafely(Har har) {
				if (creatorVersion.matches(har.getLog().getVersion())) {
					return true;
				}
				return false;
			}
		};
	}
}