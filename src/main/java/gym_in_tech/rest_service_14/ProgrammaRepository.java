package gym_in_tech.rest_service_14;

import gym_in_tech.rest_service_14.pojos.Esercizio;
import gym_in_tech.rest_service_14.pojos.Programma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProgrammaRepository{
    private final JdbcTemplate jdbc;

    @Autowired
    public ProgrammaRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    //Lista dei programmi predefiniti
    public List<Programma> findAllPrograms() {
        String sql = "SELECT id, nome, kcal FROM PROGRAMMI_REST";

        RowMapper<Programma> programmaRowMapper = (r, i) -> {
            Programma rowObject = new Programma();
            rowObject.setId(r.getInt("ID"));
            rowObject.setNomeProg(r.getString("NOME"));
            rowObject.setEsercizi(getComposizione(rowObject.getNomeProg()));
            rowObject.setKcal(r.getInt("KCAL"));

            return rowObject;
        };
        return jdbc.query(sql, programmaRowMapper);
    }

    //Composizione (esercizi) dato un programma
    public List<Esercizio> getComposizione(String nomeProgramma) {
        String sql = """
            SELECT e.nomeEs, e.numSerie, e.numRep, e.kcal
            FROM ESERCIZI e
            JOIN PROGRAMMI_REST p ON e.idProgramma = p.id
            WHERE p.nome = ?
            """;
        return jdbc.query(sql, (r, i) -> {
            Esercizio e = new Esercizio();
            e.setNomeEs(r.getString("NOMEES"));
            e.setNumSerie(r.getInt("NUMSERIE"));
            e.setNumRipetizioni(r.getInt("NUMREP"));
            e.setKcal(r.getFloat("KCAL"));
            return e;
        }, nomeProgramma);
    }


}

