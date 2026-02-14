package S.Models;

public class Ninja {
    private String nome;
    private String aldeia;
    private String cla;
    private int idade;

    public Ninja(String nome, String aldeia, String cla, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.cla = cla;
    }

    public String getNome() {
        return nome;
    }

    public String getAldeia() {
        return aldeia;
    }

    public String getCla() {
        return cla;
    }

    public int getIdade() {
        return idade;
    }
}
