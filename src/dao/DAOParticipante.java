package dao;

import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.*;

public class DAOParticipante extends DAO<Participante> {
    
    public Participante read(Object chave) {
        String nome = (String) chave;
        Query q = manager.query();
        q.constrain(Participante.class);
        q.descend("nome").constrain(nome);
        List<Participante> resultados = q.execute();

        if (resultados.size() > 0) {
            return resultados.get(0);
        }

        return null;
    }

    public List<Participante> consulta(String nomePart, int mes) {
        Query q = manager.query();
        q.constrain(Participante.class);
        q.constrain(new Filtro1(mes, nomePart));
        List<Participante> resultados = q.execute();

        return resultados;
    }
}

class Filtro1 implements Evaluation {
	private int mes;
    private String nome;

	public Filtro1 (int mes, String nome) {
        this.mes = mes;
        this.nome = nome;
    }

	public void evaluate(Candidate candidate) {
		Participante p = (Participante) candidate.getObject();
        boolean teste = false;

        /* Sem retornar o participante pesquisado */

        if (p.getNome().equals(nome)) {
            teste = false;
        }
        else {
            for (Reuniao reuniao : p.getReunioes()) {
                if (reuniao.getDatahora().getMonthValue() == mes) {
                    for (Participante participante : reuniao.getParticipantes()) {
                        if (participante.getNome().equals(nome)) {
                            teste = true;
                            break;
                        }
                    }
                }
            }
        }

        /* Retornando junto com o participante pesquisado */

        // for (Reuniao reuniao : p.getReunioes()) {
        //     if (reuniao.getDatahora().getMonthValue() == mes) {
        //         for (Participante participante : reuniao.getParticipantes()) {
        //             if (participante.getNome().equals(nome)) {
        //                 teste = true;
        //                 break;
        //             }
        //         }
        //     }
        // }

		candidate.include(teste);
	}
}