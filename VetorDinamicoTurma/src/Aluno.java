public class Aluno {
    private String nome;
    private int[] notas;

    public Aluno(String nome, int[] notas) {
        this.nome = nome;
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int[] getNotas() {
        return notas;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return nome + " " + notas[0] + " " + notas[1];
    }
}

