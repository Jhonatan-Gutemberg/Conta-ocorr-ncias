import java.util.Scanner;

public class ContaOcorrencia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inicio = 0;
        String entrada;
        entrada = scanner.nextLine();

        String[] valores = entrada.split(";");
        int x;
        x = scanner.nextInt();

        int[] arrayNumeros = montaArrayNumeros(valores);
        int resultado = conta(arrayNumeros, x, inicio);
        System.out.println(resultado);

        scanner.close();
    }

    private static int[] montaArrayNumeros(String[] valores) {
        int[] a = new int[valores.length];
        for (int i = 0; i < a.length; i++) {

            try {
                a[i] = Integer.parseInt(valores[i].trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalido");
                a[i] = 0;

            }
        }

        return a;
    }

    private static int conta(int[] a, int valorPrpcurado, int inicio) {

        if (inicio == a.length)
            return 0;

        int count = (a[inicio] == valorPrpcurado) ? 1 : 0;

        return count + conta(a, valorPrpcurado, inicio + 1);
    }
}