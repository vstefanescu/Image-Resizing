package package1;

import package2.*;

public class TestApplication {
    public static void runTest(String inputFile, String outputFile, double zoomFactor) {
        // Creează un procesor de imagine BMP
        BMPImageProcessor processor = new BMPImageProcessor(inputFile, outputFile, zoomFactor);

        // Inițializarea thread-urilor Producer și Consumer
        ProducerThread producer = new ProducerThread(processor);
        ConsumerThread consumer = new ConsumerThread(processor);

        // Pornim thread-urile
        producer.start();
        consumer.start();

        try {
            // Așteptăm finalizarea ambelor thread-uri
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace(); // Tratăm eventualele erori de întrerupere
        }
    }
}
