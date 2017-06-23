package com.Math.test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ichanskiy on 2017-05-08.
 */
public class Main {
    public static void main(String[] args) {
        List<String> pointList = new ArrayList<String>();
        List<String> sort = new ArrayList<String>();
        pointList.add(0,"0");
        pointList.add(1,"вулиця Героїв Севастополя, 65, Київ, Украина");
        pointList.add(2,"вулиця Сергія Колоса, 2А, Київ, Украина");
        pointList.add(3,"вулиця Верховинна, 68, Київ, Украина");
        pointList.add(4,"вулиця Михайла Ломоносова, 40-42, Київ, Украина");
        pointList.add(5,"Брянська вулиця, 15, Київ, Украина");

        //sort = getCommisVoyageur(pointList);

        System.out.println(sort);
    }
}
