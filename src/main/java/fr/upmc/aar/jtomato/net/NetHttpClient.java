package fr.upmc.aar.jtomato.net;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DecompressingHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

/**
 * HTTP Client used by default
 * 
 * @author <a href="mailto:tambug@gmail.com">Giordano Tamburrelli</a>
 * 
 * @version 1.0
 **/
public class NetHttpClient implements NetHttpClientInterface {

	private final String ENCODING = "utf-8";
	private final String SCHEMA = "http://";
	private final String agent = "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2";

	public String get(String uri) {
		HttpClient httpclient = new DecompressingHttpClient(new DefaultHttpClient());
		HttpProtocolParams.setUserAgent(httpclient.getParams(), agent);

		HttpGet httpget = new HttpGet(uri);
		HttpResponse response;
		try {
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				String responseContent = EntityUtils.toString(entity);
				return responseContent;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String buildUrl(String url, HashMap<String, String> params) {
		if (params != null) {
			List<NameValuePair> httpParams = new LinkedList<NameValuePair>();
			for (String p : params.keySet()) {
				httpParams.add(new BasicNameValuePair(p, String.valueOf(params.get(p))));
			}
			String paramString = URLEncodedUtils.format(httpParams, this.ENCODING);
			url += "?" + paramString;
		}
		return this.SCHEMA + url;
	}
}
