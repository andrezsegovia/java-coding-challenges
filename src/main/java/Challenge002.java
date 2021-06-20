import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;
import java.util.stream.Collectors;

import org.json.simple.*;
import org.json.simple.parser.*;

public class Challenge002 {
    /*
     * Complete the function below.
     * https://jsonmock.hackerrank.com/api/countries/search?name=
     */

    static JSONObject get(URL url) throws Exception {
        System.out.println(url.toString());
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept","application/json; utf-8");
        int statusCode = con.getResponseCode();
        System.out.println("Status Code: " + statusCode);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String respLine = null;
            while((respLine = br.readLine()) != null) {
                response.append(respLine.trim());
            }
            JSONObject jsonObj = (JSONObject) new JSONParser().parse(response.toString());
            return jsonObj;
        }
    }

    static int getCountries(String s, int p) throws Exception {
        System.out.println(s);
        System.out.println(p);
        URL url = new URL("https://jsonmock.hackerrank.com/api/countries/search?name="+s);
        JSONObject jsonObject = get(url);
        long pages = (long) jsonObject.get("total_pages");
        List<JSONArray> cities = new ArrayList<>();
        cities.add((JSONArray)jsonObject.get("data"));
        while (pages > 1) {
            cities.add((JSONArray) get(new URL("https://jsonmock.hackerrank.com/api/countries/search?name="+s+"&page="+pages)).get("data"));
            pages--;
        }
        List<JSONObject> citiesFilter = new ArrayList<>();
        int result = 0;
        for(JSONArray jsonArray: cities) {
            jsonArray.stream().filter(obj -> (long)((JSONObject) obj).get("population") >= (long) p).forEach(city -> {
                System.out.println(((JSONObject) city).get("name") +" - "+ ((JSONObject) city).get("population"));
            });
            result += (Long)jsonArray.stream().filter(obj -> (long)((JSONObject) obj).get("population") > (long) p).count();
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        getCountries("uni", 300);
    }
}