import java.util.Scanner;

public class Lista4Ex5 {
    public static void main(String[] args) {
        final int TAMANHO = 20;
        final int FIM = 0;
        int[] numeros = new int[TAMANHO];
        int numero = leNumero(TAMANHO);

        while (numero != FIM) {
            numeros[numero - 1]++;
            numero = leNumero(TAMANHO);
        }

        for (int index = 0; index < numeros.length; index++) {
            System.out.printf("Quantidade de repeticoes de %d : %d\n", index + 1, numeros[index]);
        }
    }

    public static int leNumero(int tamanho) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        System.out.print("Entre com um numero: ");
        do {
            numero = scanner.nextInt();
            if ((numero < 0) || (numero > tamanho)) {
                System.out.println("Erro: Numero deve ser entre 0 e 20.");
            }
        } while ((numero < 0) || (numero > tamanho));

        return numero;
    }
}
