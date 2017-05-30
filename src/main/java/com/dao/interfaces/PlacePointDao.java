package com.dao.interfaces;

import com.entity.PlacePoint;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public interface PlacePointDao {

    void savePlacePoint(PlacePoint placePoint);
    boolean getPalacePointByAddress(String address);
    boolean getPalacePointById(int id);

}
