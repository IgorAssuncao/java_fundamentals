import java.util.Scanner;
import java.util.ArrayList;

public class VetorDinamico {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        String nome;

        do {
            System.out.print("Nome: ");
            nome = leLinha();
            if (!(nome.equals("sai"))) {
                nomes.add(nome);
            }
        } while(!(nome.equals("sai")));

        System.out.println(nomes);
    }

    public static String leLinha() {
        Scanner scanner = new Scanner(System.in);

        String linha = scanner.nextLine();
        return linha;
    }
}
