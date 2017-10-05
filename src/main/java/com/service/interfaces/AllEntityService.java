package com.service.interfaces;

import com.dto.DTO;
import com.entity.subsidary.Information;
import com.entity.subsidary.Result;

//import java.sql.Date;
import java.util.Date;
import java.util.Map;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public interface AllEntityService {
    void saveAllUserExpansesData(DTO dto, String idUser);
    Result Mamdani(Date first, Date second, String phone, double avocation, double clothes, double food);
    void getExpansesForDate (Date first, Date second);
}
