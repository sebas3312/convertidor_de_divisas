import com.google.gson.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static java.lang.System.in;

public class ConvertidorDeDivisas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Convertir de dólares a euros");
            System.out.println("2. Convertir de euros a dólares");
            System.out.println("3. Convertir de dólares a pesos mexicanos");
            System.out.println("4. Convertir de pesos mexicanos a dólares");
            System.out.println("5. Convertir de euros a pesos mexicanos");
            System.out.println("6. Convertir de pesos mexicanos a euros");
            System.out.println("7. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad en dólares: ");
                    double dolares = scanner.nextDouble();
                    double tasaCambio = obtenerTasaCambio("USD", "EUR");
                    double euros = dolares * tasaCambio;
                    System.out.println(dolares + " dólares equivalen a " + euros + " euros.");
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad en euros: ");
                    double euritos = scanner.nextDouble();
                    tasaCambio = obtenerTasaCambio("EUR", "USD");
                    double dolarcitos = euritos / tasaCambio;
                    System.out.println(euritos + " euros equivalen a " + dolarcitos + " dólares.");
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad en dólares: ");
                    dolares = scanner.nextDouble();
                    tasaCambio = obtenerTasaCambio("USD", "MXN");
                    double pesosMexicanos = dolares * tasaCambio;
                    System.out.println(dolares + " dólares equivalen a " + pesosMexicanos + " pesos mexicanos.");
                    break;
                case 4:
                    System.out.print("Ingrese la cantidad en pesos mexicanos: ");
                    double pesosMex = scanner.nextDouble();
                    tasaCambio = obtenerTasaCambio("MXN", "USD");
                    dolarcitos = pesosMex / tasaCambio;
                    System.out.println(pesosMex + " pesos mexicanos equivalen a " + dolarcitos + " dólares.");
                    break;
                case 5:
                    System.out.print("Ingrese la cantidad en euros: ");
                    euritos = scanner.nextDouble();
                    tasaCambio = obtenerTasaCambio("EUR", "MXN");
                    pesosMexicanos = euritos * tasaCambio;
                    System.out.println(euritos + " euros equivalen a " + pesosMexicanos + " pesos mexicanos.");
                    break;
                case 6:
                    System.out.print("Ingrese la cantidad en pesos mexicanos: ");
                    pesosMex = scanner.nextDouble();
                    tasaCambio = obtenerTasaCambio("MXN", "EUR");
                    euritos = pesosMex / tasaCambio;
                    System.out.println(pesosMex + " pesos mexicanos equivalen a " + euritos + " euros.");
                    break;
                case 7:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static double obtenerTasaCambio(String monedaOrigen, String monedaDestino) {
        try {
            String url_str = "https://v6.exchangerate-api.com/v6/c50a5fd388b6e2d3572fe7fe/latest/" + monedaOrigen;
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Leer la respuesta JSON de la API
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader(request.getInputStream()));
            JsonObject jsonobj = root.getAsJsonObject();

            // Formatear el JSON para que sea "pretty"
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String prettyJsonString = gson.toJson(jsonobj);

            // Guardar la respuesta JSON en un archivo
            try (FileWriter fileWriter = new FileWriter("response.json")) {
                fileWriter.write(prettyJsonString);

            }

            // Obtener la tasa de cambio específica para la moneda de destino
            JsonObject ratesObj = jsonobj.getAsJsonObject("conversion_rates");
            double tasaCambio = ratesObj.get(monedaDestino).getAsDouble();

            return tasaCambio;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }
}