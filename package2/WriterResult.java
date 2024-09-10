package package2;

import java.io.*;

// Clasă pentru transmiterea informației procesate prin intermediul Pipes
public class WriterResult {
    public static void main(String[] args) {
        try {
            PipedOutputStream out = new PipedOutputStream();  // Flux de ieșire
            PipedInputStream in = new PipedInputStream(out);  // Flux de intrare legat la fluxul de ieșire

            // Partitionarea în 4 segmente
            byte[][] segments = new byte[4][];

            // Exemplu de partitionare a informației în segmente
            for (int i = 0; i < 4; i++) {
                segments[i] = new byte[256];  // Simulare segment
                out.write(segments[i]);  // Transmite segmentul prin pipe
                System.out.println("Sent segment " + (i + 1));
                in.read(segments[i]);  // Citește segmentul prin pipe
                System.out.println("Received segment " + (i + 1));
            }

            out.close();  // Închide fluxul de ieșire
            in.close();  // Închide fluxul de intrare
        } catch (Exception e) {
            e.printStackTrace();  // Tratează eventualele erori
        }
    }
}
