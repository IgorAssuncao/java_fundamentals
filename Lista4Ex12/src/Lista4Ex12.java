public class Lista4Ex12 {
    public static void main(String[] args) {
        int[][] notas = {
                {5, 7, 4},
                {5, 6, 7},
                {3, 5, 2},
                {4, 5, 6},
                {8, 9, 7},
                {2, 6, 4}
        };

        int soma;
        double mediaAluno;
        double mediaTurma = 0;

        for (int linha = 0; linha < notas.length; linha++) {
            soma = 0;
            for (int coluna = 0; coluna < notas[linha].length; coluna++) {
                soma += notas[linha][coluna];
            }
            mediaAluno = (double) soma / notas[linha].length;
            System.out.printf("Media do aluno %d: %2.2f\n", linha, mediaAluno);
            mediaTurma += mediaAluno;
        }
        mediaTurma /= notas.length;
        System.out.printf("\nMedia da turma: %2.2f\n", mediaTurma);
    }
}
