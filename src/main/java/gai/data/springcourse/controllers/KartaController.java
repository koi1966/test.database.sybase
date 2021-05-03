package gai.data.springcourse.controllers;


import gai.data.springcourse.dao.KartaDAO;
import gai.data.springcourse.models.KartaAMT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static gai.data.springcourse.dao.KartaDAO.serch;

@Controller
@RequestMapping("/karta")
public class KartaController {
    private final KartaDAO kartaDAO;

    @Autowired
    public KartaController(KartaDAO kartaDAO) {
        this.kartaDAO = kartaDAO;
    }

    @GetMapping()
    public String index(Model model) {
        // Получает все из KartaDAO для отображения на html
        model.addAttribute("kartaAMT", kartaDAO.index());
        return "karta/index";
    }

    @GetMapping("/searchAMT")
//    public String searchAMT(@ModelAttribute("karta") KartaAMT karta) {
   public String searchAMT(Model model){
        model.addAttribute("karta", new KartaAMT());

        return "karta/searchAMT";
    }
// Получить с html формы поля для обработки   @PostMapping
    @PostMapping()
    public String search(@ModelAttribute("karta") KartaAMT kar, Model model) {
//             KartaDAO.serch(karta);
        model.addAttribute("karta", serch(kar));

        return "karta/viewKarta";
    }

}

