package com.uca.capas.actividad_labo3.controller;

import com.uca.capas.actividad_labo3.domain.student;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    private List<student> students = new ArrayList<student>();

    @GetMapping(path = "ejemplo1",produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String ejemplo1(){
        return "Bienvenidos \n"+"Programacion n capas";
    }
    @GetMapping("ejemplo2")
    @ResponseBody
    public List<student> ejemplo2(){
        return Arrays.asList(
                new student("Nombre1","Apellido","10/10/2000","carrera x",true),
                new student("Nombre2","Apellido","10/10/2000","ing en limones", false)
        );
    }

    @GetMapping("/inicio")
    public String inicio(student student){
        return "index";
    }
    @PostMapping("/formData")
    public ModelAndView procesar(student student){
        students.add(student);
        ModelAndView mav= new ModelAndView();
        mav.setViewName("index");
        mav.addObject("student", new student());



        return mav;


    }

    @GetMapping("/listado")
    public ModelAndView listado(){
        ModelAndView mav= new ModelAndView();
        mav.setViewName("listado");
        mav.addObject("studentList", this.students);
        return mav;
    }

}
