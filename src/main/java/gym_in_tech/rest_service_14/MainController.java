package gym_in_tech.rest_service_14;

import gym_in_tech.rest_service_14.pojos.Esercizio;
import gym_in_tech.rest_service_14.pojos.Programma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private final ProgrammaRepository programmaRepository;
    private final KCalCalculatorService calculatorService;

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
    public float countKCal(@RequestBody Programma programma){
        return calculatorService.countKCal(programma);
    }

}
