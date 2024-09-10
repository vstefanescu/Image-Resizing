package package2;

// Thread care consumă informațiile furnizate de ProducerThread și procesează imaginea
public class ConsumerThread extends Thread {
    private final BMPImageProcessor processor;  // Referință către procesorul de imagini

    // Constructor pentru inițializarea procesorului
    public ConsumerThread(BMPImageProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        synchronized (processor) {
            try {
                processor.wait();  // Așteaptă până când ProducerThread notifică
                processor.processImage();  // Procesează imaginea după notificare
                processor.writeImage();  // Scrie imaginea procesată în fișierul de ieșire
            } catch (Exception e) {
                e.printStackTrace();  // Tratează eventualele erori
            }
        }
    }
}
