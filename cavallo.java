public class Cavallo extends Thread {
    private String nome;
    private int distanzaPercorsa = 0;
    private int lunghezzaGara;
    
    public Cavallo(String nome, int lunghezzaGara) {
        this.nome = nome;
        this.lunghezzaGara = lunghezzaGara;
    }

    @Override
    public void run() {
        Random random = new Random(); // Use Random instance for better performance
        while (distanzaPercorsa < lunghezzaGara) {
            int passo = random.nextInt(10) + 1; // Generate random step
            distanzaPercorsa = Math.min(distanzaPercorsa + passo, lunghezzaGara);
            // Simuliamo lo step di avanzamento, tra 1 e 10 metri per ogni cavallo
            int passo = (int) (Math.random() * 10 + 1);
            distanzaPercorsa += passo;
            if (distanzaPercorsa > lunghezzaGara) {
                distanzaPercorsa = lunghezzaGara;
            }
            System.out.println(nome + " ha percorso " + distanzaPercorsa + " metri.");
            try {
                // Simuliamo un ritardo per ogni step di avanzamento (500ms)
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupt status
                return;
                e.printStackTrace();
            }
        }
        System.out.println(nome + " ha terminato la gara!");
    }
}
