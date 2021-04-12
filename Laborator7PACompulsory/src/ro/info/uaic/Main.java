package ro.info.uaic;

public class Main {

    public static void main(String[] args) throws Exception{
        Board masa = new Board(100);
        masa.afisareBoard();

        Thread p1 = new Thread(new Player("Dragos", masa));
        Thread p2 = new Thread(new Player("Andrei", masa));
        Thread p3 = new Thread(new Player("Ionut", masa));
        Thread deamon = new Thread(new Player("deamon", masa));

        deamon.setDaemon(true);

        deamon.start();
        p1.start();
        p2.start();
        p3.start();

        deamon.join();
        p1.join();
        p2.join();
        p3.join();

        masa.afisarePlayeri();


    }
}
