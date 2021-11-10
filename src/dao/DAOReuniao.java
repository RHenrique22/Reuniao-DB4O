package dao;

import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.*;

public class DAOReuniao extends DAO<Reuniao> {

    public Reuniao read(Object chave) {
        int id = (Integer) chave;
        Query q = manager.query();
        q.constrain(Reuniao.class);
        q.descend("id").constrain(id);
        List<Reuniao> resultados = q.execute();
        
        if (resultados.size() > 0) {
            return resultados.get(0);
        }

        return null;
    }

    public void create(Reuniao object) {
        Reuniao r = object;
        int id = super.getMaxId();
        id++;
        r.setId(id);
        manager.store(r);
    }

    public List<Reuniao> consulta() {
        Query q = manager.query();
        q.constrain(Reuniao.class);
        q.descend("participantes").constrain(new Filtro2());
        List<Reuniao> resultados = q.execute();

        return resultados;
    }
}

class Filtro2 implements Evaluation {
    public void evaluate(Candidate candidate) {
        Participante p = (Participante) candidate.getObject();
        boolean teste = false;

        if (p instanceof Convidado) {
            teste = true;
        }

        candidate.include(teste);
    }
}
