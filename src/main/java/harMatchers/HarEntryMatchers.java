package harMatchers;

import org.browsermob.core.har.Har;
import org.browsermob.core.har.HarEntry;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/*
 * TODO: startedDateTime is not in this file yet
 */
public class HarEntryMatchers {
	public static Matcher<Har> entryPageref(final Matcher<String> pageref) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("an entry with pageref ").appendValue(
						pageref);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no entry with pageref: "
								+ pageref);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (pageref.matches(element.getPageref())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> entryTime(final Matcher<Long> time) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("an entry with elapsed time ")
						.appendValue(time);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no entry with elapsed time: "
								+ time);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (time.matches(element.getTime())) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static Matcher<Har> entryServerIpAddress(
			final Matcher<String> serverIpAddress) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("an entry with serverIpAddress ")
						.appendValue(serverIpAddress);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no entry with serverIpaddress: "
								+ serverIpAddress);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (serverIpAddress.matches(element.getServerIPAddress())) {
						return true;
					}
				}
				return false;
			}
		};
	}

}
