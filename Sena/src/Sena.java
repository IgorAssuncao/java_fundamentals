import java.util.Scanner;

public class Sena {
    public static void main(String[] args) {
        final int TAMANHO = 60;
        int[] aposta = new int[6];
        int[] resultado = new int[6];
        int acertos;

        leSena(aposta, "Entre com a aposta");
        leSena(resultado, "Entre com o resultado da aposta");

        acertos = verificaAposta(aposta, resultado);

        mostraResultado(acertos);
    }

    public static int leNumero() {
        Scanner scanner = new Scanner(System.in);
        int numero;

        do {
            System.out.print("Entre com um numero valido: ");
            numero = scanner.nextInt();
            if (numero < 0 || numero > 60) {
                System.out.println("Erro: numero invalido!");
            }
        } while (numero < 0 || numero > 60);

        return numero;
    }

    public static void leSena(int[] sena, String mensagem) {
        int numero, contador = 0;

        System.out.println(mensagem);

        while (contador < 6) {
            numero = leNumero();
            if (!numeroRepetido(numero, sena, contador)) {
                sena[contador] = numero;
                contador++;
            } else {
                System.out.println("Erro: numero ja existe!");
            }
        }
        System.out.println();
    }

    public static boolean numeroRepetido(int numero, int[] sena, int contador) {
        boolean repetido = false;

        for (int index = 0; index < contador; index++) {
            if (numero == sena[index]) {
                repetido = true;
                break;
            }
        }

        return repetido;
    }

    public static void mostraResultado(int acertos) {
        System.out.println(acertos);
        switch(acertos) {
            case 4:
                System.out.println("Quadra.");
                break;
            case 5:
                System.out.println("Quina.");
                break;
            case 6:
                System.out.println("Sena.");
                break;
            default:
                System.out.println("Tente novamente.");
                break;
        }
    }

    public static int verificaAposta(int[] aposta, int[] resultado) {
        int cont = 0;

        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < aposta.length; j++) {
                if (aposta[j] == resultado[i]) cont++;
            }
        }
        return cont;
    }
}
