package gym_in_tech.rest_service_14;


import gym_in_tech.rest_service_14.pojos.Esercizio;
import gym_in_tech.rest_service_14.pojos.Programma;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KCalCalculatorService {

    public float countKCal(Programma programma){
        List<Esercizio> esercizi = programma.getEsercizi();
        float kcalProg=0;
        for (Esercizio e : esercizi){
            float kcal= e.getNumSerie()*e.getNumRipetizioni()*2;
            kcalProg+=kcal;
        }

        return kcalProg;
    }

}
