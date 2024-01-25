package ma.fath.ExamSpring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ma.fath.ExamSpring.Entities.CentreVaccination;
import ma.fath.ExamSpring.Entities.Citoyen;
import ma.fath.ExamSpring.Repositories.CentreVaccinationRepository;
import ma.fath.ExamSpring.Repositories.CitoyenRepository;

// VaccinationController.java
@Controller
public class VaccinationController {

    @Autowired
    private CitoyenRepository citoyenRepository;

    @Autowired
    private CentreVaccinationRepository centreVaccinationRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<CentreVaccination> centres = centreVaccinationRepository.findAll();
        model.addAttribute("centres", centres);
        return "home";
    }

    @GetMapping("/nouveauCitoyen")
    public String nouveauCitoyen(Model model) {
        model.addAttribute("citoyen", new Citoyen());
        model.addAttribute("centres", centreVaccinationRepository.findAll());
        return "nouveauCitoyen";
    }

    @PostMapping("/enregistrerCitoyen")
    public String enregistrerCitoyen(@ModelAttribute Citoyen citoyen) {
        citoyenRepository.save(citoyen);
        return "redirect:/";
    }

    @GetMapping("/nouveauCentre")
    public String nouveauCentre(Model model) {
        model.addAttribute("centre", new CentreVaccination());
        return "nouveauCentre";
    }

    @PostMapping("/enregistrerCentre")
    public String enregistrerCentre(@ModelAttribute CentreVaccination centre) {
        centreVaccinationRepository.save(centre);
        return "redirect:/";
    }

    @GetMapping("/centre/{id}")
    public String voirCentre(@PathVariable Long id, Model model) {
        CentreVaccination centre = centreVaccinationRepository.findById(id).orElse(null);
        model.addAttribute("centre", centre);
        return "voirCentre";
    }
}
