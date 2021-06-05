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
  //    private String kart_id;

  @Autowired
  public KartaController(KartaDAO kartaDAO) {
    this.kartaDAO = kartaDAO;
  }

  // Получает все из KartaDAO для отображения на html

  @GetMapping("/searchAMT")
  public String searchAMT(@ModelAttribute("karta") KartaAMT karta, Model model) {
    return "karta/searchAMT";
  }

  // Получить с html формы поля для обработки   @PostMapping
  @PostMapping()
  public String search(@ModelAttribute("karta") KartaAMT kar, Model model) {
    final List<KartaAMT> kartaAMTList = kartaDAO.serch(kar);
    model.addAttribute("kartaList", kartaAMTList);
    return "karta/viewKarta";
  }

  @GetMapping("/{id}")
  public String AmtHystory(@PathVariable("id") long id, Model model) {
    List<KartaAMT> AMTHys = kartaDAO.AmtHistory(id);
    System.out.println(AMTHys.get(1));
    if (!AMTHys.isEmpty()) {
      KartaAMT kartaAMT = AMTHys.get(0);
      String kart_id = kartaAMT.getKart_id();
      // Serch_Arest(kart_id);
    }

    //        model.addAttribute("AmtArest",AMTArest);
    model.addAttribute("Amthystory", AMTHys);

    //        return "karta/history";
    return "karta/test";
  }
}
