package com.swordcode.grupo1.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.swordcode.grupo1.Temperature;
import com.swordcode.grupo1.TemperatureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class WeatherController {
    @Autowired
    private TemperatureRepository temperatureRepo;

    @RequestMapping("/temperaturas")
    public String weather(Model model) {
		Temperature temperature = new Temperature();
		model.addAttribute("temperature", temperature);
        return "temperaturas";
    }

    @PostMapping("/salvarTemperatura")
    public String saveTemperature(@ModelAttribute("temperature") Temperature temperature, BindingResult result, SessionStatus status) {
        temperatureRepo.save(temperature);
        return "salvarTemperatura";
    }

    @RequestMapping("/reporte")
    public String weeklyReport(Model model) {
        Iterable<Temperature> it = temperatureRepo.findAll();
        List<Temperature> list = new ArrayList<>();
        it.forEach(list::add);
        model.addAttribute("temperatures", list);
        return "reporte";
    }

    @RequestMapping("/calcularTemperatura")
    public String prepareTemperature(Model model) {
        Temperature temperature = new Temperature();
		model.addAttribute("temperature", temperature);
        return "calcularTemperatura";
    }

    @PostMapping("/resultadoTemperatura")
    public String displayTemperature(@ModelAttribute("temperature") Temperature temperature, Model model) {
        Date date = temperature.getDateMeasured();
        LocalDate ld = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date startDate = java.sql.Date.valueOf(ld.with(DayOfWeek.MONDAY));
        Date endDate = java.sql.Date.valueOf(ld.with(DayOfWeek.SUNDAY));

        BigDecimal max = temperatureRepo.getMaxCelsisuInADateRange(startDate, endDate);
        BigDecimal min = temperatureRepo.getMinCelsisuInADateRange(startDate, endDate);


        String message = null;
        if (max == null) message = "Información no disponible para esa semana";
        else {
            message = String.format(
                "La temperatura mayor esa semana fue de %.1f grados celsius, y la menor fue de %.1f grados celsius",
                max, min
            );
        }

        model.addAttribute("message", message);
        return "resultadoTemperatura";
    }

}