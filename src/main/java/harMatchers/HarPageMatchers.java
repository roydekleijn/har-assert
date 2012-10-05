package harMatchers;

import org.browsermob.core.har.Har;
import org.browsermob.core.har.HarEntry;
import org.browsermob.core.har.HarPage;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class HarPageMatchers {

	/**
	 * 
	 * Hello World
	 * 
	 */
	public static Matcher<Har> pageId(final Matcher<String> id) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText(
						"a page within an entry with the unique identifier ")
						.appendValue(id);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no page within an entry with the unique identifier: "
								+ id);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarPage element : har.getLog().getPages()) {
					if (id.matches(element.getId())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> pageTitle(final Matcher<String> title) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description
						.appendText("a page within an entry with the title ")
						.appendValue(title);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no page within an entry with the title: "
								+ title);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarPage element : har.getLog().getPages()) {
					if (title.matches(element.getTitle())) {
						return true;
					}
				}
				return false;
			}
		};
	}
}
