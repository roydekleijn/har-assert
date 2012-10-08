package harMatchers;

import org.browsermob.core.har.Har;
import org.browsermob.core.har.HarPage;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class HarPageMatchers {

	/**
	 * Example usage: assertThat(har, pageId(is("some page id")));
	 * 
	 * @param pageId
	 * @return
	 */
	public static Matcher<Har> pageId(final Matcher<String> pageId) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText(
						"a page within an entry with the unique identifier ")
						.appendValue(pageId);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no page within an entry with the unique identifier: "
								+ pageId);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarPage element : har.getLog().getPages()) {
					if (pageId.matches(element.getId())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, pageTitle(is("some page title")));
	 * 
	 * @param pageTitle
	 * @return
	 */
	public static Matcher<Har> pageTitle(final Matcher<String> pageTitle) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description
						.appendText("a page within an entry with the title ")
						.appendValue(pageTitle);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no page within an entry with the title: "
								+ pageTitle);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarPage element : har.getLog().getPages()) {
					if (pageTitle.matches(element.getTitle())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	/**
	 * Example usage: assertThat(har,
	 * pageTimingOnload(greaterThan(Long.valueOf(14))));
	 * 
	 * @param pageOnloadTiming
	 * @return
	 */
	public static Matcher<Har> pageTimingOnload(
			final Matcher<Long> pageOnloadTiming) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description
						.appendText(
								"a page within an entry with number of milliseconds since page load started ")
						.appendValue(pageOnloadTiming);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no page within an entry with number of milliseconds since page load started: "
								+ pageOnloadTiming);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarPage element : har.getLog().getPages()) {
					if (pageOnloadTiming.matches(element.getPageTimings()
							.getOnLoad())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	/**
	 * Example usage: assertThat(har,
	 * pageTimingOnload(greaterThan(Long.valueOf(14))));
	 * 
	 * @param pageOnContentloadTiming
	 * @return
	 */
	public static Matcher<Har> pageTimingOnContentLoad(
			final Matcher<Long> pageOnContentloadTiming) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description
						.appendText(
								"a page within an entry with number of milliseconds since page load started ")
						.appendValue(pageOnContentloadTiming);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no page within an entry with number of milliseconds since page load started: "
								+ pageOnContentloadTiming);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarPage element : har.getLog().getPages()) {
					if (pageOnContentloadTiming.matches(element
							.getPageTimings().getOnContentLoad())) {
						return true;
					}
				}
				return false;
			}
		};
	}
}
