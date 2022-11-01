import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.JSONArray;


public class Test{

	private String apiurl = "https://api.nal.usda.gov/fdc";
	private String apikey = "UkaojsuvAJCo3lryhbiiUg0eodTWSnmQyCIYr76d";


	/* this code is based on Unirest, which has different dependencies than imported in this program
	public void search(String term)
	{
		String urlMod = "?query=" + term;
		try { 
			HttpResponse<JsonNode> response = Unirest.post( apiurl + "/foods/search/" + urlMod )
                .header( "apikey", apikey )
                .asJson() ;
            JSONObject json = response.getBody().getObject() ;
            System.out.println(json.toString());
		} catch (Exception e) {
			System.out.println( e.toString() ) ;
		}

	}
	*/


	public static void main(String[] args){

		// Create a URL object
		URL urlObj = new URL(apiurl);
		URLConnection urlCon = urlObj.openConnection();
		 
		urlCon.setRequestProperty("X-Api-Key", apikey);

		Map<String, List<String>> map = urlCon.getHeaderFields();
 
		for (String key : map.keySet()) {
		    System.out.println(key + ":");
		 
		    List<String> values = map.get(key);
		 
		    for (String aValue : values) {
		        System.out.println("\t" + Value);
		    }
		}

		//search("chicken breast");
	}

}

