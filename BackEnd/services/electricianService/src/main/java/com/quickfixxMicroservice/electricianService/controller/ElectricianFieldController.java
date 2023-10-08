package com.quickfixxMicroservice.electricianService.controller;


import com.quickfixxMicroservice.electricianService.dto.ElectricianDto;
import com.quickfixxMicroservice.electricianService.model.Electrician;
import com.quickfixxMicroservice.electricianService.service.ElectricianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/electrician")
@RequiredArgsConstructor
public class ElectricianFieldController {

    private final ElectricianService electricianService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createElectrician(@RequestBody ElectricianDto electricianDto){
        electricianService.createElectrician(electricianDto);
        return "Electrician registered";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getALl(){
        List<Object> electricianList = electricianService.getAllElectrician().stream().map(electrician -> {
            System.out.println(electrician.getId() + " "+ electrician.getName());
            return null;
        }).toList();

        if(electricianList.isEmpty()) return "no data present";
        else return "Found all data";
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Electrician> getByID(@PathVariable("id") String idString){
        Long id= Long.parseLong(idString);
        Optional<Electrician> optionalElectrician = electricianService.getByID(id);

        if(optionalElectrician.isPresent()){
            return electricianService.getByID((id));
        }else {
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteID(@PathVariable("id") Long id){
        electricianService.removeElectrician(id);
        return "Electrician data removed successfully";
    }




}
