package com.jsk.demo.controllers;

import com.jsk.demo.models.EditMobil;
import com.jsk.demo.models.Employee;
import com.jsk.demo.models.Mobil;
import com.jsk.demo.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerMobil {

    @Autowired
    private CarService carService;

    @GetMapping("/show-carform")
    public String formCar  (Model model ){
        model.addAttribute("formcar",new Mobil());
        return "formmobil";}

    @PostMapping("/save-car")
    public String saveMobil (@ModelAttribute("formcar") Mobil mobil){
        carService.saveMobil(mobil);
        return "formmobil";
    }

    @GetMapping("/show-allmobil")
    public String showmobil (Model model){
        model.addAttribute("showmobil", carService.showAllMobil());
        return "viewallmobil";
    }
    @GetMapping("/form-edit")
    public String editForm (Model model){
        model.addAttribute("editMobil", new EditMobil());
        return "editformmobil";
    }
    @PostMapping("/edit-mobil")
    public String editMobil(@ModelAttribute("editMobil") EditMobil newMobil){
        carService.updateCar(newMobil);
        return "editformmobil";
    }

    @RequestMapping("/delete-car/{id}")
            public String deleteMobil(@ModelAttribute("deleteMobil")  DeleteMobil id ){
            carService.deleteCar(id);
            return "editformmobil";
            }
}
