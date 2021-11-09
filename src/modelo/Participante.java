package modelo;

import java.util.ArrayList;

public class Participante {
    private String nome;
    private String email;
    private ArrayList<Reuniao> reunioes = new ArrayList<Reuniao>();

    public Participante (String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Reuniao> getReunioes() {
        return this.reunioes;
    }

    public void adicionar(Reuniao r) {
        this.reunioes.add(r);
    }

    public void remover(Reuniao r) {
        this.reunioes.remove(r);
    }

    public int TotalDeReunioes() {
        return this.reunioes.size();
    }

    @Override
    public String toString() {
        String output;
        output = String.format("%nNome: %s%nE-mail: %s%nReuniões: ", this.getNome(), this.getEmail());

        if (reunioes.isEmpty()) {
            output += "Sem reuniões";
        }
        else {
            for (Reuniao r : reunioes) {
                output += String.format("%s ", r.getId());
            }
        }

        return output;
    }

}
