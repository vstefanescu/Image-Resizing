package package2;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// Clasa care procesează imagini BMP și implementează funcționalitățile de zoom
public class BMPImageProcessor extends ImageProcessor implements Zoomable {
    private BufferedImage image; // Obiect pentru stocarea imaginii în memorie

    // Bloc static de inițializare, se execută o singură dată la încărcarea clasei
    static {
        System.out.println("BMPImageProcessor class loaded");
    }

    // Constructor pentru inițializarea fișierelor de intrare și ieșire și a factorului de zoom
    public BMPImageProcessor(String inputFile, String outputFile, double zoomFactor) {
        super(inputFile, outputFile, zoomFactor);
    }

    // Metodă pentru citirea imaginii BMP din fișier
    @Override
    protected void readImage() throws IOException {
        System.out.println("Reading BMP image from " + inputFile);
        image = ImageIO.read(new File(inputFile)); // Citim imaginea din fișier
        if (image == null) {
            throw new IOException("Image could not be read. Check if the file is a valid BMP image.");
        }
    }

    // Metodă pentru procesarea imaginii (aplicarea zoom-ului)
    @Override
    protected void processImage() throws IOException {
        System.out.println("Processing BMP image");
        zoomImage(); // Aplicăm zoom-ul folosind factorul specificat
    }

    // Metodă pentru scrierea imaginii BMP în fișierul de ieșire
    @Override
    protected void writeImage() throws IOException {
        System.out.println("Writing BMP image to " + outputFile);
        ImageIO.write(image, "bmp", new File(outputFile)); // Salvăm imaginea în fișier
    }

    // Metodă pentru aplicarea zoom-ului folosind factorul de zoom dat
    @Override
    public void zoomImage() {
        zoomImageByFactor(zoomFactor); // Apelăm metoda auxiliară care face zoom
    }

    // Metodă pentru aplicarea zoom-ului de k ori pe imaginea citită
    public void zoomKTimes(double k) throws IOException {
        readImage();  // Citește imaginea de intrare
        zoomImageByFactor(k);  // Aplică zoom-ul de k ori
        writeImage();  // Salvează imaginea în fișierul de ieșire
    }

    // Metodă auxiliară pentru redimensionarea imaginii în funcție de un factor de zoom
    private void zoomImageByFactor(double factor) {
        System.out.println("Zooming image by a factor of " + factor);

        int originalWidth = image.getWidth();  // Obține lățimea originală
        int originalHeight = image.getHeight();  // Obține înălțimea originală
        int newWidth = (int) (originalWidth * factor);  // Calculează noua lățime
        int newHeight = (int) (originalHeight * factor);  // Calculează noua înălțime

        // Creează o imagine nouă redimensionată
        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = scaledImage.createGraphics();

        // Redimensionează imaginea folosind interpolare bilineară pentru o calitate mai bună
        Image scaledImg = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        g2d.drawImage(scaledImg, 0, 0, null);
        g2d.dispose();

        image = scaledImage;  // Actualizează imaginea originală cu cea redimensionată

        System.out.println("Image zoomed to width: " + newWidth + " and height: " + newHeight);
    }
}
