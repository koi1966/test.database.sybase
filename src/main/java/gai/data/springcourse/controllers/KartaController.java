package gai.data.springcourse.controllers;
import gai.data.springcourse.dao.KartaDAO;
import gai.data.springcourse.models.KartaAMT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/karta")
public class KartaController {
  private final KartaDAO kartaDAO;
    private String kart_id;

    @Autowired
  public KartaController(KartaDAO kartaDAO) {
    this.kartaDAO = kartaDAO;
  }

// Получает все из KartaDAO для отображения на html
//  @GetMapping()
//  public String index(Model model) {
//
//    model.addAttribute("kartaAMT", kartaDAO.index());
//    return "karta/index";
//  }

  @GetMapping("/searchAMT")
  public String searchAMT(@ModelAttribute("karta") KartaAMT karta, Model model) {
    final List<KartaAMT> kartaAMTList = kartaDAO.serch(karta);
    model.addAttribute("kartaList", kartaAMTList);
    return "karta/searchAMT";
  }


  // Получить с html формы поля для обработки   @PostMapping
 @PostMapping()
  public String search(@ModelAttribute("karta") KartaAMT kar, Model model) {
   final List<KartaAMT> kartaAMTList = kartaDAO.serch(kar);
   model.addAttribute("kartaList", kartaAMTList);
   return "karta/viewKarta";
  }

//    @GetMapping("/{kart_id}/history")
    @GetMapping("/{kart_id}")
    public String AmtHystory( @PathVariable("kart_id") String Kart_id, Model model) {
        final List<KartaAMT> AMTHys = kartaDAO.AmtHistory(Kart_id);
        model.addAttribute("Amthystory",AMTHys);

        return "karta/history";

    }
}
