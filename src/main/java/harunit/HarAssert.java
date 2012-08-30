package harunit;

import static ch.lambdaj.Lambda.filter;
import static ch.lambdaj.collection.LambdaCollections.with;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;

import ch.lambdaj.function.matcher.Predicate;
import edu.umass.cs.benchlab.har.HarEntry;
import edu.umass.cs.benchlab.har.HarLog;
import edu.umass.cs.benchlab.har.HarQueryParam;
import edu.umass.cs.benchlab.har.tools.HarFileReader;
import junit.framework.Assert;

public class HarAssert extends Assert {

	protected HarAssert() {
		super();
	}

	public static void assertQueryParam(String harJson, final String key,
			final String value) {
		try {
			InputStream is;

			is = new ByteArrayInputStream(harJson.getBytes("UTF-8"));

			HarFileReader logTemp = new HarFileReader();
			HarLog har = logTemp.readHarFile(is);
			List<HarEntry> entries = with(har.getEntries().getEntries())
					.retain(new Predicate<HarEntry>() {

						@Override
						public boolean apply(HarEntry entry) {
							List<HarQueryParam> pairs = entry.getRequest()
									.getQueryString().getQueryParams();
							return 0 < filter(new Predicate<HarQueryParam>() {
								@Override
								public boolean apply(HarQueryParam pair) {
									return pair.getName().contains(key)
											&& pair.getValue().contains(value);
								}

							}, pairs).size();
						}
					});
			assertEquals("", 1, entries.size());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
