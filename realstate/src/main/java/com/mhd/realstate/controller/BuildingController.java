package com.mhd.realstate.controller;

import com.mhd.realstate.entity.Buildings;
import com.mhd.realstate.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
@RequestMapping(value = "/building/")
public class BuildingController {
    private static String UPLOADED_FOLDER = "src/main/resources/static/img/";
    @Autowired
    private BuilldingRepo builldingRepo;
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private AreaRepo areaRepo;
    @Autowired
    private HousingRepo housingRepo;
    @Autowired
    private CatagoryRepo catagoryRepo;
    @Autowired
    private AvailRepo availRepo;
    @Autowired
    private ConstructionRepo constructionRepo;





    @Autowired
    private ImageOptimizer imageOptimizer;

    @GetMapping(value = "building-list")
    public String list(Model model){
        model.addAttribute("list",this.builldingRepo.findAll());
        return "buildings/building-list";
    }
    @GetMapping(value = "building-grid-list")
    public String listgrid(Model model){
        model.addAttribute("list",this.builldingRepo.findAll());
        return "buildings/building-grid-list";
    }

    @GetMapping(value = "add-building")
    public String viewAdd(Model model){
        model.addAttribute("building",new Buildings());
        model.addAttribute("cities", this.cityRepo.findAll());
        model.addAttribute("areas", this.areaRepo.findAll());
        model.addAttribute("housings",this.housingRepo.findAll());
        model.addAttribute("catagories",this.catagoryRepo.findAll());
        model.addAttribute("availability",this.availRepo.findAll());
        model.addAttribute("constructiontypes",this.constructionRepo.findAll());
        return "buildings/add-building";
    }

    @PostMapping(value = "add-building")
    public String add(@Valid Buildings buildings, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file){
        if(bindingResult.hasErrors()){
            model.addAttribute("cities", this.cityRepo.findAll());
            model.addAttribute("areas", this.areaRepo.findAll());
            model.addAttribute("housings",this.housingRepo.findAll());
            model.addAttribute("catagories",this.catagoryRepo.findAll());
            model.addAttribute("availability",this.availRepo.findAll());
            model.addAttribute("constructiontypes",this.constructionRepo.findAll());
            return "buildings/add-building";
        }

        try {
            //////////////////////For Image Upload start /////////////////////
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            buildings.setFileName("new-" + file.getOriginalFilename());
            buildings.setFileSize(file.getSize());
            // user.setFile(file.getBytes());
            buildings.setFilePath("img/" + "new-" + file.getOriginalFilename());
            buildings.setFileExtension(file.getContentType());
            //////////////////////For Image Upload end/////////////////////
            buildings.setRegistrationDate(new Date());
            this.builldingRepo.save(buildings);
            model.addAttribute("building", new Buildings());
            model.addAttribute("cities", this.cityRepo.findAll());
            model.addAttribute("areas", this.areaRepo.findAll());
            model.addAttribute("housings",this.housingRepo.findAll());
            model.addAttribute("catagories",this.catagoryRepo.findAll());
            model.addAttribute("availability",this.availRepo.findAll());
            model.addAttribute("constructiontypes",this.constructionRepo.findAll());
            model.addAttribute("successMsg", "Congratulations! Successfully added data.");
            imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 0.3f, 100, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("cities", this.cityRepo.findAll());
        model.addAttribute("areas", this.areaRepo.findAll());
        model.addAttribute("housings",this.housingRepo.findAll());
        model.addAttribute("catagories",this.catagoryRepo.findAll());
        model.addAttribute("availability",this.availRepo.findAll());
        model.addAttribute("constructiontypes",this.constructionRepo.findAll());
        return "buildings/add-building";
    }




    @GetMapping(value = "edit-building/{id}")
    public String editShow(Model model, @PathVariable("id") Long id){
        model.addAttribute("building", this.builldingRepo.getOne(id));
        model.addAttribute("cities", this.cityRepo.findAll());
        model.addAttribute("areas", this.areaRepo.findAll());
        model.addAttribute("housings",this.housingRepo.findAll());
        model.addAttribute("catagories",this.catagoryRepo.findAll());
        model.addAttribute("availability",this.availRepo.findAll());
        model.addAttribute("constructiontypes",this.constructionRepo.findAll());
        return "buildings/edit-building";
    }
    @PostMapping(value = "edit-building/{id}")
    public String userEdit(@Valid Buildings buildings
            , BindingResult bindingResult, @PathVariable("id") Long id, Model model, @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cities", this.cityRepo.findAll());
            model.addAttribute("areas", this.areaRepo.findAll());
            model.addAttribute("housings",this.housingRepo.findAll());
            model.addAttribute("catagories",this.catagoryRepo.findAll());
            model.addAttribute("availability",this.availRepo.findAll());
            model.addAttribute("constructiontypes",this.constructionRepo.findAll());
            return "buildings/edit-building";
        }
        try {
            //////////////////////For Image Upload start /////////////////////
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            buildings.setFileName("new-" + file.getOriginalFilename());
            buildings.setFileSize(file.getSize());
            // user.setFile(file.getBytes());
            buildings.setFilePath("img/" + "new-" + file.getOriginalFilename());
            buildings.setFileExtension(file.getContentType());
            //////////////////////For Image Upload end/////////////////////
            buildings.setRegistrationDate(new Date());
            this.builldingRepo.save(buildings);
            model.addAttribute("buildings", new Buildings());
            model.addAttribute("cities", this.cityRepo.findAll());
            model.addAttribute("areas", this.areaRepo.findAll());
            model.addAttribute("housings",this.housingRepo.findAll());
            model.addAttribute("catagories",this.catagoryRepo.findAll());
            model.addAttribute("availability",this.availRepo.findAll());
            model.addAttribute("constructiontypes",this.constructionRepo.findAll());
            model.addAttribute("success", "Congratulations! Data save sucessfully");
            imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 0.3f, 100, 100);
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("cities", this.cityRepo.findAll());
        model.addAttribute("areas", this.areaRepo.findAll());
        model.addAttribute("housings",this.housingRepo.findAll());
        model.addAttribute("catagories",this.catagoryRepo.findAll());
        model.addAttribute("availability",this.availRepo.findAll());
        model.addAttribute("constructiontypes",this.constructionRepo.findAll());
        return "buildings/edit-building";
    }


    @GetMapping(value = "delete/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.builldingRepo.deleteById(id);
        }
        return "redirect:/building/building-list";
    }
}
