package gai.data.springcourse.controllers;

import gai.data.springcourse.dao.ArestDAO;
import gai.data.springcourse.dao.KartaDAO;
import gai.data.springcourse.dao.KartaDAOSybase;
import gai.data.springcourse.models.ArestSybase;
import gai.data.springcourse.models.KartaSybase;
import gai.data.springcourse.models.KartaAMT;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/karta")
public class KartaController {
  private final KartaDAO kartaDAO;
  private final KartaDAOSybase kartaExport;

  @Autowired
  public KartaController(KartaDAO kartaDAO, KartaDAOSybase kartaExport) {
    this.kartaDAO = kartaDAO;

    this.kartaExport = kartaExport;
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
    System.out.println(AMTHys.get(0));
    //    String kart_id1 = AMTHys.get(0).getKart_id();
    if (!AMTHys.isEmpty()) {
      KartaAMT kartaAMT = AMTHys.get(0);
      String kart_id = kartaAMT.getKart_id();

      List<ArestSybase> ArestA =
          new ArestDAO()
              .Serch_Arest(kart_id); // реализовать поиск по арестам Serch_Arest по kart_id
      model.addAttribute("arest", ArestA); // передать найденый арест на вьюшку
    }

    model.addAttribute("Amthystory", AMTHys);
    //            return "karta/history";
    //    return "karta/test";
    return "karta/historearest";
  }

  @GetMapping("/m")
  public String migrationKarta() throws SQLException {
    final List<KartaSybase> kartaSybase = kartaExport.searchKarta();
//    System.out.println(karta.toString());
    return null;
  }

  @GetMapping("/a")
  public String migrationArest() throws SQLException {
    final List<ArestSybase> arestSybase = kartaExport.searchArest();
//    System.out.println(karta.toString());
    return null;
  }

}
