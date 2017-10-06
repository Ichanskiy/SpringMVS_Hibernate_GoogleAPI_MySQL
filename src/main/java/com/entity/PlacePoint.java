package com.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
@Entity
@Table(name = "placepoint")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlacePoint {

    public static final String PLACEPOINT_ID = "placepoint_id";
    public static final String PLACEPOINT_LONGITUDE = "placepoint_long";
    public static final String PLACEPOINT_LATITUDE = "placepoint_lat";
    public static final String PLACEPOINT_ADDRESS = "placepoint_address";
    private static final String JOIN_PLACEPOINT_ID = "PLACEPOINT_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = PLACEPOINT_ID)
    private int placepoint_id;

    @Column(name = PLACEPOINT_LONGITUDE)
    private double placePointLong;

    @Column(name = PLACEPOINT_LATITUDE)
    private double placePointLat;

    @Column(name = PLACEPOINT_ADDRESS)
    private String placePointAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = JOIN_PLACEPOINT_ID)
    private UserExpenses userExpenses;

}
