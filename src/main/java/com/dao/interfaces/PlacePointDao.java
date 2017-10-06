package com.dao.interfaces;

import com.entity.PlacePoint;
import com.entity.UserExpenses;

import java.util.List;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public interface PlacePointDao {

    int savePlacePoint(PlacePoint placePoint);
    boolean getPalacePointByAddress(String address);
    boolean getPalacePointById(int id);
    PlacePoint getAddressById(int id);

}
