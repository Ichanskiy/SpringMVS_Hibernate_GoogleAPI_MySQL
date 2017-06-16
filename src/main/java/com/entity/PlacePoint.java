package com.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
@Entity
@Table(name = "placepoint")
@Getter
@Setter
@ToString
public class PlacePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "placepoint_id")
    private int placePointId;

    @Column(name = "placepoint_long")
    private double placePointLong;

    @Column(name = "placepoint_lat")
    private double placePointLat;

    @Column(name = "placepoint_address")
    private String placePointAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PLACEPOINT_ID")
    private UserExpenses userExpenses;

    public PlacePoint() {
    }

    public PlacePoint(int placePointId, double placePointLong, double placePointLat, String placePointAddress) {
        this.placePointId = placePointId;
        this.placePointLong = placePointLong;
        this.placePointLat = placePointLat;
        this.placePointAddress = placePointAddress;
    }
}
