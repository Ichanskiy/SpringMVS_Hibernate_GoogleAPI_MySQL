package com.Math.CommisVoyageur;

import com.Math.sample.AbstractSample;
import com.Math.sample.JsonReader;
import com.google.common.collect.Maps;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by Ichanskiy on 2017-05-05.
 */
public class Voyageur extends AbstractSample {
    public List<String> getsCommisVoyageur(List<String> inputList )  {

        List<String> pointList =  new ArrayList<String>(inputList);
        List<String> sortList = new ArrayList<String>(inputList);
        int sizeList = pointList.size();
        System.out.println(sizeList);

        double C[][] = new double[sizeList][sizeList];

        for (int i = 1; i < sizeList; i++) {
            for (int j = 1; j < sizeList ; j++) {
                if (i==j){
                    C[i][j] = 0;
                }
                if(i<j){
                    String a = String.valueOf(pointList.get(i));
                    String b = String.valueOf(pointList.get(j));
                    double d = 0;
                    try {
                        d = getsDistanse(a,b);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    C[i][j] = d;
                }

                if(j<i){
                    double d = C[j][i];
                    C[i][j] = d;
                }

/*                if(i<j){
                    String a = String.valueOf(pointList.get(i));
                    String b = String.valueOf(pointList.get(j));
                    double d = 0;
                    try {
                        d = getsDistanse(a,b);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    C[i][j] = d;
                }

                if (j<i){
                    String b = String.valueOf(pointList.get(i));
                    String a = String.valueOf(pointList.get(j));
                    double d = 0;
                    try {
                        d = getsDistanse(a,b);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    C[i][j] = d;
                }*/
            }
        }

        for (int i = 1; i < sizeList; i++) {
            for (int j = 1; j < sizeList; j++) {
                System.out.print(C[i][j] + "         ");
            }
            System.out.println();
        }

        Route tspNearestNeighbour = new Route();
        List<Integer> rout = tspNearestNeighbour.tsp(C);
        // System.out.println(rout);
        pointList.remove(0);
        sortList.remove(0);


        System.out.println("rout");
        for (int i = 0; i < pointList.size()-1; i++) {
            System.out.println("i = " + i + "-->" + rout.get(i));
        }

        System.out.println("point");
        for (int i = 0; i < rout.size(); i++) {
            System.out.println("i = " + i + "-->" + pointList.get(i));
        }

       /* System.out.println(pointList.size());
        System.out.println(rout.size());
        System.out.println(sortList.size());*/



        for (int i = 0;  i < pointList.size(); i++) {
            int key = rout.get(i) - 1;
            System.out.println("k " + key);
            if (key == pointList.size()){
                continue;
            }
            String value = pointList.get(i);
            System.out.println("v " + value);
            sortList.set(key,value);
            //System.out.println(sortList);
        }

        System.out.println("sort");
        for (int i = 0; i < sortList.size(); i++) {
            System.out.println("i = " + i + " --> " + sortList.get(i));
        }
        return sortList;
    }
    public static double getsDistanse(String fistAddress, String secondAddress) throws IOException, JSONException {
        final String proxy = "http://anonymouse.org/cgi-bin/anon-www.cgi/";
        final String baseUrl = proxy + "http://maps.googleapis.com/maps/api/directions/json";// путь к Geocoding API по
        // HTTP
        final Map<String, String> params = Maps.newHashMap();
        params.put("sensor", "false");// указывает, исходит ли запрос на геокодирование от устройства с датчиком
        params.put("language", "ru");// язык данные на котором мы хочем получить
        params.put("mode", "walking");// способ перемещения, может быть driving, walking, bicycling
        params.put("origin", fistAddress);// адрес или текстовое значение широты и
        // отправного пункта маршрута
        params.put("destination", secondAddress);// адрес или текстовое значение широты и долготы
        // долготы конечного пункта маршрута
        final String url = baseUrl + '?' + encodeParams(params);// генерируем путь с параметрами
        // System.out.println(url); // Можем проверить что вернет этот путь в браузере
        final JSONObject response = JsonReader.read(url);// делаем запрос к вебсервису и получаем от него ответ
        // как правило наиболее подходящий ответ первый и данные о кординатах можно получить по пути
        // //results[0]/geometry/location/lng и //results[0]/geometry/location/lat
        JSONObject location = response.getJSONArray("routes").getJSONObject(0);
        location = location.getJSONArray("legs").getJSONObject(0);


        final String distancetest = String.valueOf(location.getJSONObject("distance").get("value"));
        //final String distancetest = String.valueOf(location.getJSONObject("distance").get;
        System.out.println(distancetest);

       // final String distance = location.getJSONObject("distance").getString("value");
       // final String duration = location.getJSONObject("duration").getString("text");
        //System.out.println("D = " + distance);
        // System.out.println(distance + "\n" + duration);
        double result = Double.parseDouble(distancetest);
        return result;
    }
    public static void main(String[] args) {
        List<String> pointList = new ArrayList<String>();
        pointList.add(0,"0");
        pointList.add(1,"вулиця Героїв Севастополя, 65, Київ, Украина");
        pointList.add(2,"вулиця Сергія Колоса, 2А, Київ, Украина");
        pointList.add(3,"вулиця Верховинна, 68, Київ, Украина");
        pointList.add(4,"вулиця Михайла Ломоносова, 40-42, Київ, Украина");
        pointList.add(5,"Брянська вулиця, 15, Київ, Украина");

        Voyageur voyageur = new Voyageur();
        voyageur.getsCommisVoyageur(pointList);
    }

}

