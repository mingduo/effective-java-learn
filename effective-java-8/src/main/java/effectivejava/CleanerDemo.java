package effectivejava;

import java.lang.ref.Cleaner;

// An autocloseable class using a cleaner as a safety net
public class CleanerDemo implements AutoCloseable {


    public static void main(String[] args) {
        closeWithTryResource();

        closeWithOutTryResource();
    }

    private static void closeWithOutTryResource() {
        new CleanerDemo(99);
        System.out.println("Peace out");
    }

    private static void closeWithTryResource() {
        try (CleanerDemo myRoom = new CleanerDemo(7)) {
            System.out.println("Goodbye");
        }
    }


    private static final Cleaner cleaner = Cleaner.create();

    // Resource that requires cleaning. Must not refer to Room!
    private static class State implements Runnable {
        int numJunkPiles; // Number of junk piles in this room

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        // Invoked by close method or cleaner
        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

    // The state of this room, shared with our cleanable
    private final State state;
    // Our cleanable. Cleans the room when it’s eligible for gc
    private final Cleaner.Cleanable cleanable;

    public CleanerDemo(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() {
        cleanable.clean();
    }
}