package gym_in_tech.rest_service_14;


import com.sun.tools.javac.Main;
import gym_in_tech.rest_service_14.pojos.Esercizio;
import gym_in_tech.rest_service_14.pojos.Programma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private ProgrammaRepository programmaRepository;
    private KCalCalculatorService calculatorService;

    @Autowired
    MainController(ProgrammaRepository programmaRepository, KCalCalculatorService calculatorService){
        this.programmaRepository=programmaRepository;
        this.calculatorService=calculatorService;
    }

    @GetMapping("/getProgrammi")
    public List<Programma> getProgrammi(){
        return programmaRepository.findAllPrograms();
    }

    @PostMapping("/getEsercizi")
    public List<Esercizio> getEsercizi(@RequestParam String nomeProg){
        return programmaRepository.getComposizione(nomeProg);
    }

    @PostMapping("/countKcal")
    public float countKCal(@RequestParam Programma programma){
        return calculatorService.countKCal(programma);
    }

}
