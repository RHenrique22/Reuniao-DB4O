package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Reuniao {
    private int id;
    private String dataHora;
    private String assunto;
    private ArrayList<Participante> participantes = new ArrayList<Participante>();

    public Reuniao (LocalDateTime dataHora, String assunto) {
        this.dataHora = dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.assunto = assunto;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDatahora() {
        return LocalDateTime.parse(this.dataHora, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public void setDatahora(LocalDateTime datahora) {
        this.dataHora = datahora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public String getAssunto() {
        return this.assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public ArrayList<Participante> getParticipantes() {
        return this.participantes;
    }

    public void adicionar(Participante p) {
        this.participantes.add(p);
    }

    public void remover(Participante p) {
        this.participantes.remove(p);
    }

    public Participante localizarParticipante(String nome) {
        for (Participante participante : participantes) {
            if (participante.getNome().equals(nome)) {
                return participante;
            }
        }
        return null;
    }

    public int TotalDeParticipantes() {
        return this.participantes.size();
    }

    @Override
    public String toString() {
        String output = "";
        output += String.format("%nId: %d%nData e hora: %s%nAssunto: %s%nParticipantes: ",
            this.getId(), this.getDatahora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")), this.getAssunto());

        for (Participante p : participantes) {
            output += String.format("%s ", p.getNome());
        }

        return output;
    }

}
