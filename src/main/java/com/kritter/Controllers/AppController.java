package com.kritter.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    //Automatically Inject the EstateService object
    @Autowired
    private EstateService service;

    //Specify / to map the url to homePage
    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Estate> listEstates = service.listAll();
        model.addAttribute("listEstates",listEstates);
        return "index";
    }
    @RequestMapping("/new")
    public String showNewEstateForm(Model model){
        Estate estate = new Estate();
        model.addAttribute("estate",estate);

        return "new_estate";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEstate(@ModelAttribute("estate") Estate estate){
        //@ModelAttribute is used to map the estate object request from the form
        service.save(estate);
        String s = "redirect:/";
        return s;

    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditEstateForm(@PathVariable(name = "id") Long id){
        ModelAndView mav=new ModelAndView("edit_estate");

        Estate estate = service.get(id);
        mav.addObject("estate",estate);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteEstate(@PathVariable(name = "id") Long id) {
        service.delete(id);
        String s = "redirect:/";
        return s;
    }

}
