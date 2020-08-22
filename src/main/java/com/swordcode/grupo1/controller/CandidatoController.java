package com.swordcode.grupo1.controller;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.swordcode.grupo1.Candidato;
import com.swordcode.grupo1.CandidatoDistrito;
import com.swordcode.grupo1.CandidatoRepository;
import com.swordcode.grupo1.CandidatoTotales;
import com.swordcode.grupo1.Temperature;
import com.swordcode.grupo1.TemperatureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class CandidatoController {
    @Autowired
    private CandidatoRepository repository;

    @RequestMapping("/eleccionesResultados")
    public String electionResultl(Model model) {
        Map<String, Candidato> sh = new HashMap<>();
        Map<Integer, List<Candidato>> tst = new HashMap<>();
        Map<String, Integer> tots = new HashMap<>();
        BigDecimal h = new BigDecimal("100");

        List<Candidato> list = new ArrayList<>();
        List<CandidatoDistrito> ds = new ArrayList<>();
        List<CandidatoTotales> ct = new ArrayList<>();
        BigDecimal media = new BigDecimal("0.5");

        Iterable<Candidato> it = repository.findAll();
        it.forEach(list::add);
        int total = 0;

        for (Candidato c : list) {
            // headers
            if (sh.get(c.getNombre()) == null) sh.put(c.getNombre(), new Candidato(c.getNombre()));
            int distrito = c.getDistrito();

            List<Candidato> candidatos = tst.get(distrito);
            if (candidatos == null) candidatos = new ArrayList<>();
            candidatos.add(c);
            tst.put(distrito, candidatos);

            Integer totalCandidato = tots.get(c.getNombre());
            if (totalCandidato == null) totalCandidato = 0;
            totalCandidato = totalCandidato + c.getTotal();
            tots.put(c.getNombre(), totalCandidato);

            total = total + c.getTotal();
        }

        for (Integer key : tst.keySet()) {
            CandidatoDistrito cd = new CandidatoDistrito(key, tst.get(key));
            ds.add(cd);
        }
    
        String message = "No hay ganador. Se realizará una segunda ronda de elecciones.";
        for (String key : tots.keySet()) {
            int candidatoTotal = tots.get(key);
            BigDecimal pct = new BigDecimal((double)candidatoTotal/(double)total, MathContext.DECIMAL64);

            if (pct.compareTo(media) > 0)
            message = String.format("El ganador es %s con un %.2f%%", key, pct.multiply(h));

            CandidatoTotales candidatoTotales = new CandidatoTotales(key, candidatoTotal, pct.multiply(h));
            ct.add(candidatoTotales);
        }

        // Footer
        ct.add(new CandidatoTotales(null, total, BigDecimal.ONE.multiply(h)));
        List<Candidato> subheaders =  new ArrayList<Candidato>(sh.values());

        model.addAttribute("subheaders", subheaders);
        model.addAttribute("ctotal", ct);
        model.addAttribute("message", message);
        // model.addAttribute("candidatos", list); --> no va
        model.addAttribute("ds", ds);
        return "eleccionesResultados";
    }
    

    
}