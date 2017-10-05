package com.entity.subsidary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    double sum;
    double percent;
    private Map<String, Double> removeTag;

}
