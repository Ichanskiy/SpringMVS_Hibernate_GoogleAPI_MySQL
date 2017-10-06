package com.entity.subsidary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private double sum;
    private double percent;
    private Map<String, Double> removeTag;
    private List<String> pointList = new ArrayList<String>();

}
