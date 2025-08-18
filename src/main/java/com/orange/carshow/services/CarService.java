package com.orange.carshow.services;

import java.util.List;

import com.orange.carshow.services.dto.CardDto;

public interface CarService {

    List<CardDto> getCars();

    CardDto get_most_expensivecar();

    CardDto get_car_by_id(long modelID);

    CardDto addcar(CardDto cardDto);
    CardDto delete_byid(long modelID );
    List<CardDto> search_car(String model );

}


