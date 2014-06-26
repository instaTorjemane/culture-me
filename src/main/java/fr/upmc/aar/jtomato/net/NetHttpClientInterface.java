package fr.upmc.aar.jtomato.net;

import java.util.HashMap;


public interface NetHttpClientInterface {

	public String buildUrl(String url, HashMap<String, String> params);

	public String get(String url);
}
