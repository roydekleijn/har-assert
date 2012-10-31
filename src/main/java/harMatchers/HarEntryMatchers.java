package harMatchers;

import org.browsermob.core.har.Har;
import org.browsermob.core.har.HarEntry;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class HarEntryMatchers {

	/**
	 * Example usage: assertThat(har, entryPageref(is("Page reference")));
	 * 
	 * @param entryPageref
	 * @return
	 */
	public static Matcher<Har> entryPageref(final Matcher<String> entryPageref) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("an entry with pageref ").appendValue(
						entryPageref);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no entry with pageref: "
								+ entryPageref);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!entryPageref.matches(element.getPageref())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, entryTime(is(Long.valueOf(25))));
	 * 
	 * @param entryTime
	 * @return
	 */
	public static Matcher<Har> entryTime(final Matcher<Long> entryTime) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("an entry with elapsed time ")
						.appendValue(entryTime);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no entry with elapsed time: "
								+ entryTime);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!entryTime.matches(element.getTime())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har,
	 * entryServerIpAddress(is("123.321.25.36")));
	 * 
	 * @param serverIpAddress
	 * @return
	 */
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
					if (!serverIpAddress.matches(element.getServerIPAddress())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har,
	 * entryAftercacheExpires(is("Some date/timestamp")));
	 * 
	 * @param cacheExpires
	 * @return
	 */
	public static Matcher<Har> entryAftercacheExpires(
			final Matcher<String> cacheExpires) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText(
						"an entry with expiration time of the cache entry ")
						.appendValue(cacheExpires);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no entry with expiration time of the cache entry: "
								+ cacheExpires);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!cacheExpires.matches(element.getCache()
							.getAfterRequest().getExpires())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * example usage: assertThat(har,
	 * entryAftercacheLastAccess(is("Some date/timestamp")));
	 * 
	 * @param cacheLastAccess
	 * @return
	 */
	public static Matcher<Har> entryAftercacheLastAccess(
			final Matcher<String> cacheLastAccess) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText(
						"an entry with last time the cache entry was opened ")
						.appendValue(cacheLastAccess);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no entry with last time the cache entry was opened: "
								+ cacheLastAccess);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!cacheLastAccess.matches(element.getCache()
							.getAfterRequest().getLastAccess())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, entryAftercacheETag(is("Some eTag")));
	 * 
	 * @param cacheETag
	 * @return
	 */
	public static Matcher<Har> entryAftercacheETag(
			final Matcher<String> cacheETag) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("an entry with eTage ").appendValue(
						cacheETag);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription.appendText("there is no entry with eTag: "
						+ cacheETag);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!cacheETag.matches(element.getCache().getAfterRequest()
							.geteTag())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage:
	 * 
	 * @param cacheHitCount
	 * @return
	 */
	public static Matcher<Har> entryAftercacheHitCount(
			final Matcher<Integer> cacheHitCount) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description
						.appendText(
								"an entry with number of times the cache entry has been opened ")
						.appendValue(cacheHitCount);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no entry with number of times the cache entry has been opened: "
								+ cacheHitCount);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!cacheHitCount.matches(element.getCache()
							.getAfterRequest().getHitCount())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har,
	 * entryBeforecacheExpires(is("Some date/timestamp")));
	 * 
	 * @param cacheExpires
	 * @return
	 */
	public static Matcher<Har> entryBeforecacheExpires(
			final Matcher<String> cacheExpires) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText(
						"an entry with expiration time of the cache entry ")
						.appendValue(cacheExpires);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no entry with expiration time of the cache entry: "
								+ cacheExpires);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!cacheExpires.matches(element.getCache()
							.getBeforeRequest().getExpires())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * example usage: assertThat(har,
	 * entryBeforecacheLastAccess(is("Some date/timestamp")));
	 * 
	 * @param cacheLastAccess
	 * @return
	 */
	public static Matcher<Har> entryBeforecacheLastAccess(
			final Matcher<String> cacheLastAccess) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText(
						"an entry with last time the cache entry was opened ")
						.appendValue(cacheLastAccess);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no entry with last time the cache entry was opened: "
								+ cacheLastAccess);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!cacheLastAccess.matches(element.getCache()
							.getBeforeRequest().getLastAccess())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, entryBeforecacheETag(is("Some eTag")));
	 * 
	 * @param cacheETag
	 * @return
	 */
	public static Matcher<Har> entryBeforecacheETag(
			final Matcher<String> cacheETag) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText("an entry with eTage ").appendValue(
						cacheETag);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription.appendText("there is no entry with eTag: "
						+ cacheETag);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!cacheETag.matches(element.getCache()
							.getBeforeRequest().geteTag())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage:
	 * 
	 * @param cacheHitCount
	 * @return
	 */
	public static Matcher<Har> entryBeforecacheHitCount(
			final Matcher<Integer> cacheHitCount) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description
						.appendText(
								"an entry with number of times the cache entry has been opened ")
						.appendValue(cacheHitCount);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no entry with number of times the cache entry has been opened: "
								+ cacheHitCount);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!cacheHitCount.matches(element.getCache()
							.getBeforeRequest().getHitCount())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, entryTimingsBlocked(is(greaterThan(6))));
	 * 
	 * @param timingsBlocked
	 * @return
	 */
	public static Matcher<Har> entryTimingsBlocked(
			final Matcher<Integer> timingsBlocked) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description
						.appendText(
								"an entry with time spent in a queue waiting for a network connection. ")
						.appendValue(timingsBlocked);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no entry with time spent in a queue waiting for a network connection: "
								+ timingsBlocked);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!timingsBlocked.matches(element.getTimings()
							.getBlocked())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, entryTimingsDns(is(lessThan(6))));
	 * 
	 * @param timingsDns
	 * @return
	 */
	public static Matcher<Har> entryTimingsDns(final Matcher<Integer> timingsDns) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description.appendText(
						"an entry with time required to resolve a host name. ")
						.appendValue(timingsDns);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no entry with time required to resolve a host name: "
								+ timingsDns);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!timingsDns.matches(element.getTimings().getDns())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, entryTimingsConnect(is(lessThan(8))));
	 * 
	 * @param timingsConnect
	 * @return
	 */
	public static Matcher<Har> entryTimingsConnect(
			final Matcher<Integer> timingsConnect) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description
						.appendText(
								"an entry with time required to create TCP connection. ")
						.appendValue(timingsConnect);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no entry with time required to create TCP connection: "
								+ timingsConnect);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!timingsConnect.matches(element.getTimings()
							.getConnect())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, entryTimingsSend(is(lessThan(15))));
	 * 
	 * @param timingsSend
	 * @return
	 */
	public static Matcher<Har> entryTimingsSend(
			final Matcher<Integer> timingsSend) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description
						.appendText(
								"an entry with time required to send HTTP request to the server. ")
						.appendValue(timingsSend);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no entry with time required to send HTTP request to the server: "
								+ timingsSend);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!timingsSend.matches(element.getTimings().getSend())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage: assertThat(har, entryTimingsWait(is(lessThan(15))));
	 * 
	 * @param timingsWait
	 * @return
	 */
	public static Matcher<Har> entryTimingsWait(
			final Matcher<Integer> timingsWait) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description
						.appendText(
								"an entry with time waiting for a response from the server. ")
						.appendValue(timingsWait);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no entry with time waiting for a response from the server.: "
								+ timingsWait);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!timingsWait.matches(element.getTimings().getWait())) {
						return false;
					}
				}
				return true;
			}
		};
	}

	/**
	 * Example usage:
	 * 
	 * @param timingsReceive
	 * @return
	 */
	public static Matcher<Har> entryTimingsReceive(
			final Matcher<Integer> timingsReceive) {
		return new TypeSafeMatcher<Har>() {

			@Override
			public void describeTo(final Description description) {
				description
						.appendText(
								"an entry with time required to read entire response from the server. ")
						.appendValue(timingsReceive);
			}

			@Override
			public void describeMismatchSafely(Har har,
					Description mismatchDescription) {
				mismatchDescription
						.appendText("there is no entry with time required to read entire response from the server.: "
								+ timingsReceive);
			}

			@Override
			protected boolean matchesSafely(Har har) {
				for (HarEntry element : har.getLog().getEntries()) {
					if (!timingsReceive.matches(element.getTimings()
							.getReceive())) {
						return false;
					}
				}
				return true;
			}
		};
	}

}
