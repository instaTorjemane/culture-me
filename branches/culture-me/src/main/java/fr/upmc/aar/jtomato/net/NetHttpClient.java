package fr.upmc.aar.jtomato.net;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import com.google.appengine.api.urlfetch.FetchOptions;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;


public class NetHttpClient implements NetHttpClientInterface {

	private final String ENCODING = "utf-8";
	private final String SCHEMA = "http://";
	private final String agent = "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2";

	public String get(String uri) {
		String response = "";
		try {
			URLFetchService urlFetchService = URLFetchServiceFactory.getURLFetchService();
			URL url = new URL(uri);

			FetchOptions fetchOptions = FetchOptions.Builder.withDefaults();
			fetchOptions.doNotValidateCertificate();
			fetchOptions.setDeadline(60D);

			HTTPRequest request = new HTTPRequest(url, HTTPMethod.GET, fetchOptions);

			HTTPResponse httpResponse = urlFetchService.fetch(request);
			if (httpResponse.getResponseCode() == HttpURLConnection.HTTP_OK) {
				response = new String(httpResponse.getContent());
			} 

		} catch (Exception e) {
		}
		return response;
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
