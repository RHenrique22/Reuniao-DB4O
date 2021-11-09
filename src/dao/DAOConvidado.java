package dao;

import java.util.List;
import com.db4o.query.Query;

import modelo.Convidado;

public class DAOConvidado extends DAO<Convidado> {
    
    public Convidado read(Object chave) {
        String nomeConvidado = (String) chave;
        Query q = manager.query();
        q.constrain(Convidado.class);
        q.descend("nome").constrain(nomeConvidado);
        List<Convidado> resultados = q.execute();

        if (resultados.size() > 0) {
            return resultados.get(0);
        }

        return null;
    }
}
