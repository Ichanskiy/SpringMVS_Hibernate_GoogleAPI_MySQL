package com.service.interfaces;

import com.dto.DTO;
import com.entity.*;

import java.sql.Date;

/**
 * Created by Ichanskiy on 2017-05-30.
 */
public interface AllEntityService {
    void saveAllUserExpansesData(DTO dto, String idUser);
    void getExpansesForDate (Date first, Date second);
}
