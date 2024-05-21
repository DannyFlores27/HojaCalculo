import java.io.IOException;

public class Main {
        public static void main(String[] args) {
            MatrizOrtogonal matriz = new MatrizOrtogonal();
            matriz.insertarCelda(1, 1, 10);
            matriz.insertarCelda(1, 2, 20.5);
            matriz.insertarCelda(2, 1, "Texto no numérico");

            // Guardar la matriz en un archivo
            try {
                matriz.guardarEnArchivo("matriz.dat");
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Cargar la matriz desde el archivo
            MatrizOrtogonal matrizCargada = null;
            try {
                matrizCargada = MatrizOrtogonal.cargarDesdeArchivo("matriz.dat");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            // Realizar operaciones con la matriz cargada
            if (matrizCargada != null) {
                System.out.println(matrizCargada.realizarOperacion(1, 1, 1, 2, "sumar")); // 30.5
                System.out.println(matrizCargada.realizarOperacion(1, 1, 2, 1, "sumar")); // Error: Ambos valores deben ser numéricos
                System.out.println(matrizCargada.realizarOperacion(1, 1, 1, 2, "dividir")); // 0.4878048780487805
            }
        }
}
