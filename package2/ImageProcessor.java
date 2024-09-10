package package2;

import java.io.*;

// Clasă abstractă pentru procesarea imaginilor
public abstract class ImageProcessor {
    protected String inputFile;  // Numele fișierului de intrare
    protected String outputFile;  // Numele fișierului de ieșire
    protected double zoomFactor;  // Factorul de zoom

    // Constructor pentru inițializarea fișierelor și a factorului de zoom
    public ImageProcessor(String inputFile, String outputFile, double zoomFactor) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.zoomFactor = zoomFactor;
    }

    // Metodă abstractă pentru citirea imaginii
    protected abstract void readImage() throws IOException;

    // Metodă abstractă pentru procesarea imaginii
    protected abstract void processImage() throws IOException;

    // Metodă abstractă pentru scrierea imaginii
    protected abstract void writeImage() throws IOException;

    // Metodă pentru aplicarea zoom-ului, trebuie implementată de subclase
    public void zoomImage() {
        System.out.println("Zooming image by a factor of " + zoomFactor);
        // Cod pentru zoom
    }
}
