package com.service.interfaces;

import com.dto.DTO;

import java.sql.Date;
import java.util.Map;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public interface AllEntityService {
    void saveAllUserExpansesData(DTO dto, String idUser);
    Map Mamdani(Date first, Date second, String phone);
    void getExpansesForDate (Date first, Date second);
}
