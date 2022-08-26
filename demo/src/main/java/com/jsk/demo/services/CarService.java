package com.jsk.demo.services;

import com.jsk.demo.models.EditMobil;
import com.jsk.demo.models.Mobil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarService {
    private List<Mobil> listMobil = new ArrayList<>();

    public void saveMobil(Mobil mobil){
        listMobil.add(mobil);
    }

    public List<Mobil> showAllMobil(){
        return listMobil;
    }

    public void updateCar(EditMobil mobil){
        Mobil car = listMobil.get(mobil.getId());
        car.setMerk(mobil.getMerk());
        car.setTahun(mobil.getTahun());
        car.setType(mobil.getType());
        car.setNama(mobil.getNama());
    }
}
