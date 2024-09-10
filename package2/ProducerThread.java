package package2;

// Thread care citește informațiile din fișierul de intrare
public class ProducerThread extends Thread {
    private final BMPImageProcessor processor;  // Referință către procesorul de imagini

    // Constructor pentru inițializarea procesorului
    public ProducerThread(BMPImageProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        try {
            processor.readImage();  // Citește imaginea din fișierul de intrare
            synchronized (processor) {
                processor.notify();  // Notifică ConsumerThread că imaginea este citită
            }
        } catch (Exception e) {
            e.printStackTrace();  // Tratează eventualele erori
        }
    }
}
