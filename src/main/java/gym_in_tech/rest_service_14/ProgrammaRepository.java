package gym_in_tech.rest_service_14;

import gym_in_tech.rest_service_14.pojos.Esercizio;
import gym_in_tech.rest_service_14.pojos.Programma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProgrammaRepository{
    private final JdbcTemplate jdbc;

    @Autowired
    public ProgrammaRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    // Endpoint 1: lista nomi programmi predefiniti
    public List<Programma> findAllPrograms() {
        String sql = "SELECT nome FROM PROGRAMMI_REST";

        RowMapper<Programma> programmaRowMapper = (r, i) -> {
            Programma rowObject = new Programma();
            rowObject.setId(r.getInt("ID"));
            rowObject.setNomeProg(r.getString("NOME"));
            rowObject.setEsercizi(getComposizione(rowObject.getNomeProg()));
            rowObject.setTipo("predefinito");
            rowObject.setKcal(r.getInt("KCAL"));

            return rowObject;
        };
        return jdbc.query(sql, programmaRowMapper);
    }

    // Endpoint 2: composizione di un programma (esercizi)
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

    // Endpoint 3: kcal di un esercizio dato il nome
    public float getKcalByEsercizio(String nomeEs) {
        String sql = "SELECT kcal FROM ESERCIZI WHERE nomeEs = ?";
        return jdbc.queryForObject(sql, Float.class, nomeEs);
    }

//    // Inserimento programma personalizzato
//    @Transactional
//    public long inserisciProgrammaPersonalizzato(String nomeEs, int numSerie,
//                                                 int numRep, float kcal) {
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbc.update(connection -> {
//            PreparedStatement ps = connection.prepareStatement(
//                    "INSERT INTO PROGRAMMI_PERSONALIZZATI (nomeEs, numSerie, numRep, kcal, numAllenamenti) " +
//                            "VALUES (?, ?, ?, ?, 0)",
//                    Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, nomeEs);
//            ps.setInt(2, numSerie);
//            ps.setInt(3, numRep);
//            ps.setFloat(4, kcal);
//            return ps;
//        }, keyHolder);
//        return keyHolder.getKey().longValue();
//    }
//
//    public void collegaProgrammaUtente(String username, long idProg) {
//        jdbc.update(
//                "INSERT INTO USER_PRO_PROGRAMMI (username, idProg) VALUES (?, ?)",
//                username, idProg);
//    }


}

