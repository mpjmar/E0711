public class App {
    public static void main(String[] args) throws Exception {

        int numeros[] = pedirNumeros(10);
        System.out.println("Array original: ");
        imprimeTabla(numeros);
        System.out.println();
        System.out.println("Array con los primos al principio: ");
        numeros = desplazaPrimos(numeros);
        imprimeTabla(numeros);
    }

    public static void imprimeTabla(int array[]) {
        System.out.print("┌────────");
        for (int i = 0; i < array.length; i++)
            System.out.print("┬─────");
        System.out.println("┐");

        System.out.print("│ Indice ");
        for (int i = 0; i < array.length; i++)
            System.out.printf("│%4s ", i);
        System.out.println("│");

        System.out.print("├────────");
        for (int i = 0; i < array.length; i++)
            System.out.print("┼─────");
        System.out.println("┤");

        System.out.print("│ Valor  ");
        for (int i = 0; i < array.length; i++)
            System.out.printf("│%4s ", array[i]);
        System.out.println("│");

        System.out.print("└────────");
        for (int i = 0; i < array.length; i++)
            System.out.print("┴─────");
        System.out.println("┘");
    }

    public static int[] desplazaPrimos(int numeros[]) {
        int desplazados[] = new int[numeros.length];
        int j = 0;
        for (int i = 0; i < numeros.length; i++)
            if (esPrimo(numeros[i]))
                desplazados[j++] = numeros[i];
        for(int i = 0; i < numeros.length; i++)
            if (!esPrimo(numeros[i]))
                desplazados[j++] = numeros[i];
        return desplazados;
    }

    public static boolean esPrimo(int num) {
        if (num < 2)
            return false;
        for (int i = num / 2; i >= 2; i--)
            if (num % i == 0)
                return false;
        return true;
    }

    public static int[] pedirNumeros(int cantidad) {
        int numeros[] = new int[cantidad];

        System.out.println("Introduzca 10 números separados por INTRO:");
        try {
            for (int i = 0; i < numeros.length; i++)
                numeros[i] = Integer.parseInt(System.console().readLine());
        }
        catch(NumberFormatException e) {
            System.out.println("El número debe ser un entero.");
        }
        catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado.");
        }
        return numeros;
    }
}
