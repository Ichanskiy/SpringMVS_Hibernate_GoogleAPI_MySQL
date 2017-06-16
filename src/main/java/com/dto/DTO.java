package com.dto;

import com.entity.PlacePoint;
import com.entity.Tag;
import com.entity.UserExpenses;
import com.entity.UserExpensesTag;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Ichanskiy on 2017-06-16.
 */
@Getter
@Setter
@ToString
public class DTO {

    private PlacePoint placePoint;
    private Tag tag;
    private UserExpenses userExpenses;
    private UserExpensesTag userExpensesTag;
}
