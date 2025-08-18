package com.orange.carshow.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.orange.carshow.services.CarService;
import com.orange.carshow.services.dto.CarRequest;
import com.orange.carshow.services.dto.CardDto;


@RestController
@RequestMapping("/cars")
public class CarController {
    
    private final CarService carService;
    
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping
    public List<CardDto> getCars() {
        return carService.getCars();

    }
    @GetMapping("/most-expensive")
    CardDto get_most_expensivecar(){

        return carService.get_most_expensivecar();
    }
    @GetMapping("/{modelID}")
    public CardDto get_car_by_id(@PathVariable long modelID) {
        return carService.get_car_by_id(modelID);
        }
    @PostMapping("/add_car")
    public CardDto addcar(@RequestBody  CardDto cardDto){
        return carService.addcar(  cardDto);
    }
    @DeleteMapping("/{modelID}")
    public CardDto delete_byid(@PathVariable long modelID) {
        return carService.delete_byid(modelID);
    }
    @GetMapping("/search")
    List<CardDto> search_car( @RequestParam String model ){
return carService.search_car(model );
    }

}
