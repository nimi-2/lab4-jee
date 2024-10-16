/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd.pia_lab4.controllers;

import bd.pia_lab4.beans.Pracownik;
import bd.pia_lab4.dao.PracownikDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Emilia
 */
@Controller
public class PracownikController {

    @Autowired
    PracownikDao dao; //wstrzyknięcie dao z pliku XML

    /* Wynikiem działania metody jest przekazanie danych w modelu do
* strony widoku addForm.jsp, która wyświetla formularz
* wprowadzania danych, a „command” jest zastrzeżonym atrybutem
* żądania, umożliwiającym wyświetlenie danych obiektu pracownika
* w formularzu.
     */
    @RequestMapping("/addForm")
    public String showform(Model m) {
        m.addAttribute("command", new Pracownik());
        return "addForm"; //przekiekrowanie do addForm.jsp
    }

    /* Metoda obsługuje zapis pracownika do BD. @ModelAttribute
* umozliwia pobranie danych z żądania do obiektu pracownika.
* Jawnie wskazano RequestMethod.POST (domyślnie jest to GET)
     */
    @RequestMapping(value = "/save", method
            = RequestMethod.POST)
    public String save(@ModelAttribute("pr") Pracownik pr) {
        dao.save(pr);
        return "redirect:/viewAll";
        //przekierowanie do endpointa o URL: /viewAll
    }

    /* Metoda pobiera listę pracowników z BD i umieszcza je w modelu */
    @RequestMapping("/viewAll")
    public String viewAll(Model m) {
        List<Pracownik> list = dao.getAll();
        m.addAttribute("list", list);
        return "viewAll"; //przejście do widoku viewAll.jsp
    }
    
     @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/viewAll"; // Przekierowanie z powrotem do listy pracowników
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable int id, Model model) {
        Pracownik pracownik = dao.getPracownikById(id);
        model.addAttribute("pracownik", pracownik);
        return "editForm"; // Powrót do widoku editForm
    }

    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public String editSave(Pracownik pracownik) {
        dao.update(pracownik);
        return "redirect:/viewAll"; // Przekierowanie do listy pracowników
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error"); // Widok błędu
        return mav;
    }
}
