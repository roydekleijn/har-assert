package harunit;

import org.browsermob.core.har.Har;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ContainsStatusCode extends TypeSafeMatcher<Har> {
	private final int statuscode;

	public ContainsStatusCode(int statuscode) {
		this.statuscode = statuscode;
	}

	@Override
	public boolean matchesSafely(Har har) {
		return har.getLog().getEntries().iterator().next().getResponse()
				.getStatus() == 404;
	}

	public void describeMismatchSafely(Har item, Description mismatchDescription) {
		mismatchDescription.appendText(" differed by ").appendText(
				" more than delta ");
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("a numeric value within ").appendText(" of ");
	}

	@Factory
	public static ContainsStatusCode containsStatusCode(int status) {
		return new ContainsStatusCode(status);
	}
}

/**
 * extends TypeSafeMatcher<Har> { private final int status;
 * 
 * public ContainsStatusCode(int status) { this.status = status; }
 * 
 * @Override public void describeMismatchSafely(Double item, Description
 *           mismatchDescription) {
 *           mismatchDescription.appendValue(item).appendText(" differed by ")
 *           .appendText(" more than delta "); }
 * @Override public boolean matchesSafely(Har har) { return
 *           har.getLog().getEntries().iterator().next().getResponse()
 *           .getStatus() == 404; }
 * 
 *           public void describeTo(Description description) {
 *           description.appendText("not a number"); }
 * @Factory public static <T> Matcher<Har> containsStatusCode(int status) {
 *          return new ContainsStatusCode(status); }
 * 
 *          }
 **/
