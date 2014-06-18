package fr.upmc.aar.jtomato.net;

import java.util.HashMap;

/**
 * Interface for the JTomato HTTPClient
 * 
 * @author <a href="mailto:tambug@gmail.com">Giordano Tamburrelli</a>
 * 
 * @version 1.0
 **/
public interface NetHttpClientInterface {

	public String buildUrl(String url, HashMap<String, String> params);

	public String get(String url);
}
