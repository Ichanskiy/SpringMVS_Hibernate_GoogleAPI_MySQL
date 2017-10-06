package com.service.interfaces;

import com.dto.DTO;
import com.entity.PlacePoint;
import com.entity.subsidary.Information;
import com.entity.subsidary.Result;

//import java.sql.Date;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public interface AllEntityService {
    void saveAllUserExpansesData(DTO dto, String idUser);
    Result Mamdani(Date first, Date second, String phone, double avocation, double clothes, double food);
    List<String> getAddressListById (List ids);
    List<String> route (Date firstDate, Date secondDate, String phone);
}
