import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaraDiCavalli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input della lunghezza della gara
        System.out.println("Inserisci la lunghezza della gara (in metri): ");
        int lunghezzaGara = scanner.nextInt();
        
        // Input del numero di cavalli
        System.out.println("Inserisci il numero di cavalli partecipanti: ");
        int numCavalli = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline
        
        // Lista dei cavalli 
        List<Cavallo> cavalli = new ArrayList<>();
        
        // Input dei nomi dei cavalli
        for (int i = 0; i < numCavalli; i++) {
            System.out.println("Inserisci il nome del cavallo " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            cavalli.add(new Cavallo(nome, lunghezzaGara));
        }
        
        System.out.println("La gara inizia!");

        // Avvia tutti i cavalli
        for (Cavallo cavallo : cavalli) {
            cavallo.start();
        }

        // Aspetta che tutti i cavalli terminino la gara
        for (Cavallo cavallo : cavalli) {
            try {
                cavallo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("La gara è finita!");
        scanner.close();
    }
}
