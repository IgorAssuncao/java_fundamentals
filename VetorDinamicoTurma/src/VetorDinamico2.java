import java.util.ArrayList;

public class VetorDinamico2 {
    public static void main(String[] args) {
        ArrayList<Aluno> turma = new ArrayList<>();

        int[] notas = {0, 1};
        turma.add(new Aluno("Candango", notas));
        System.out.println(turma);

        int[] notas2 = {2, 3};
        turma.add(new Aluno("Fulano", notas2));
        System.out.println(turma);

        int[] notas3 = {4, 5};
        turma.add(new Aluno("Ciclano", notas3));
        System.out.println(turma);
    }
}
