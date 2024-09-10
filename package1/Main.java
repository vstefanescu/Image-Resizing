package package1;

import package2.BMPImageProcessor;

public class Main {
    public static void main(String[] args) {
        // Verifică dacă au fost furnizați parametrii necesari
        if (args.length < 3) {
            System.out.println("Utilizare: java Main <input_file> <output_file> <zoom_factor>");
            return;
        }

        // Extrage fișierele de intrare, ieșire și factorul de zoom din linia de comandă
        String inputFile = args[0];
        String outputFile = args[1];
        double zoomFactor = Double.parseDouble(args[2]);

        // Creează un procesor de imagine BMP
        BMPImageProcessor processor = new BMPImageProcessor(inputFile, outputFile, zoomFactor);

        try {
            // Aplica zoom-ul pe imagine
            processor.zoomKTimes(zoomFactor);
        } catch (Exception e) {
            e.printStackTrace(); // Tratăm eventualele erori care apar în procesul de zoom
        }
    }
}
