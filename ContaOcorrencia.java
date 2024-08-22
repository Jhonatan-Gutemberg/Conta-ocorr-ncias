import java.util.Scanner;

public class ContaOcorrencia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        String entrada;
        while (scanner.hasNextLine()) {
            entrada = scanner.nextLine();
            int inicio = 0;
            
            String[] valores = entrada.split(";");
            int valorBuscado;
            valorBuscado = scanner.nextInt();
            scanner.nextLine();

            int[] arrayNumeros = montaArrayNumeros(valores);
            int resultado = conta(arrayNumeros, valorBuscado, inicio);
            System.out.println(resultado);
            if (entrada.equals("FIM")) {
                break;
            }

        }

        scanner.close();
    }

    private static int[] montaArrayNumeros(String[] valores) {
        int[] arrayNumeros = new int[valores.length];
        for (int i = 0; i < arrayNumeros.length; i++) {

            try {
                arrayNumeros[i] = Integer.parseInt(valores[i]);
            } catch (NumberFormatException e) {
                arrayNumeros[i] = 0;

            }
        }

        return arrayNumeros;
    }

    private static int conta(int[] a, int valorPrpcurado, int inicio) {

        if (inicio == a.length)
            return 0;

        int count = (a[inicio] == valorPrpcurado) ? 1 : 0;

        return count + conta(a, valorPrpcurado, inicio + 1);
    }
}