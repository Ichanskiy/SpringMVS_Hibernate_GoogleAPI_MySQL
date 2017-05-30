package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
@Entity
@Table(name = "placepoint")
public class PlacePoint {

    @Id
    @Column(name = "placepoint_id")
    private int placePointId;

    @Column(name = "placepoint_long")
    private double placePointLong;

    @Column(name = "placepoint_lat")
    private double placePointLat;

    @Column(name = "placepoint_address")
    private String placePointAddress;


    public PlacePoint() {
    }

    public PlacePoint(int placePointId, double placePointLong, double placePointLat, String placePointAddress) {
        this.placePointId = placePointId;
        this.placePointLong = placePointLong;
        this.placePointLat = placePointLat;
        this.placePointAddress = placePointAddress;
    }

    public int getPlacePointId() {
        return placePointId;
    }

    public void setPlacePointId(int placePointId) {
        this.placePointId = placePointId;
    }

    public double getPlacePointLong() {
        return placePointLong;
    }

    public void setPlacePointLong(double placePointLong) {
        this.placePointLong = placePointLong;
    }

    public double getPlacePointLat() {
        return placePointLat;
    }

    public void setPlacePointLat(double placePointLat) {
        this.placePointLat = placePointLat;
    }

    public String getPlacePointAddress() {
        return placePointAddress;
    }

    public void setPlacePointAddress(String placePointAddress) {
        this.placePointAddress = placePointAddress;
    }

    @Override
    public String toString() {
        return "PlacePoint{" +
                "placePointId=" + placePointId +
                ", placePointLong=" + placePointLong +
                ", placePointLat=" + placePointLat +
                ", placePointAddress='" + placePointAddress + '\'' +
                '}';
    }
}
