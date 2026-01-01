package algorithms;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The AstroLink project consists of thousands of satellites orbiting Earth in an ordered chain.
 * Occasionally, additional satellites need to be inserted into the chain to enhance connectivity.
 * Efficiency is critical!
 * To meet these demands, Alan Tusk has tasked you, with designing a specialized linked list.
 * This linked list must allow constant-time O(1) insertion of satellites into the chain,
 * ensuring that even with thousands of satellites, the network remains responsive.
 *
 * The constellation has n satellites numbered 0 to n-1.
 * Internally, the linked list is represented by two arrays:
 * successor[i] and predecessor[i] are the direct successor and predecessor for each satellite i.
 * If the satellite i is not yet part of the chain, we have successor[i] = predecessor[i] = i.
 * By convention, predecessor[0] always equals 0, and successor[n - 1] always equals n - 1.
 *
 * When an AstroLink object is initialized for n satellites,
 * it contains a simple chain of two satellites: 0 <-> n-1.
 *
 * Example:
 * Initialize AstroLink with 5 satellites:
 * successor = [4, 1, 2, 3, 4]
 * predecessor = [0, 1, 2, 3, 0]
 * // The chain is initially 0 <-> 4
 *
 * insertAfter(0, 2); // Insert satellite 2 just after satellite 0 (and thus, before 4)
 * successor = [2, 1, 4, 3, 4]
 * predecessor = [0, 1, 0, 3, 2]
 * // The chain is now 0 <-> 2 <-> 4
 *
 * insertAfter(0, 1); // Insert satellite 1 just after satellite 0 (and thus, before 2)
 * successor = [1, 2, 4, 3, 4]
 * predecessor = [0, 0, 1, 3, 2]
 * // The chain is now 0 <-> 1 <-> 2 <-> 4
 *
 * The insertBefore() operation is defined similarly to insertAfter().
 *
 * You need to complete the implementation of the AstroLink class containing the
 * insertAfter(), insertBefore() and iterator() methods.
 */
public class AstroLink implements Iterable<Integer> {

    protected int[] successor;
    protected int[] predecessor;

    /**
     * Creates a new StarLink with n satellites.
     * The satellites are numbered from 0 to n-1.
     * The first satellite is 0, and is connected to the last satellite n-1.
     * @param n > 1 the number of satellites
     */
    public AstroLink(int n) {
        successor = new int[n];
        predecessor = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n-1) {
                successor[i] = n-1;
                predecessor[i] = 0;
                continue;
            }
            predecessor[i] = i;
            successor[i] = i;
        }
    }


    /**
     * Inserts satellite "b" just after satellite "a".
     * @param a the satellite before which "b" should be inserted, "a" must be in the chain and must be different from n-1 (last satellite)
     * @param b the satellite to insert, it must not be in the chain
     * @throws IllegalArgumentException if "b" is already in the chain or if "a" is the last satellite
     */
    public void insertAfter(int a, int b) {
        // TODO
        if (predecessor[b] != b && successor[b] != b) {
            throw new IllegalArgumentException( b + " is already in the chain");
        }
        if (predecessor[a] == a && successor[a] == a) {
            throw new IllegalArgumentException("the satellite " + a + " is not in the chain");
        }
        if (successor[a] == a) {
            throw new IllegalArgumentException("You can't insert after the last satellite of the chain");
        }
        // 1 - Retrieve the previous successor of the satellite a
        int prev = successor[a];
        // 2 - Update the successor of the satellite a
        successor[a] = b;
        // 3 - Update the predecessor of the previous successor of the satellite a
        predecessor[prev] = b;
        // 4 - Update the predecessor and the successor of the inserted satellite
        predecessor[b] = a;
        successor[b] = prev;

    }


    /**
     * Inserts satellite "b" just before satellite "a".
     * @param a the satellite after which "b" should be inserted, "a" must be in the chain and must be different from 0 (first satellite)
     * @param b the satellite to insert, it must not be in the chain
     * @throws IllegalArgumentException if "b" is already in the chain or if "a" is the first satellite
     */
    public void insertBefore(int a, int b) {
        // TODO
        if (predecessor[b] != b && successor[b] != b) {
            throw new IllegalArgumentException( b + " is already in the chain");
        }
        if (predecessor[a] == a && successor[a] == a) {
            throw new IllegalArgumentException("the satellite " + a + " is not in the chain");
        }
        if (predecessor[a] == a) {
            throw new IllegalArgumentException("You can't insert before the first satellite of the chain");
        }
        // 1 - Retrieve the previous predecessor of the satellite a
        int prev = predecessor[a];
        // 2 - Update the predecessor of the satellite a
        predecessor[a] = b;
        // 3 - Update the successor of the previous predecessor of the satellite a
        successor[prev] = b;
        // 4 - Update both successor and predecessor of the inserted satellite
        predecessor[b] = prev;
        successor[b] = a;
    }



    /**
     * Iterator over the satellites in the chain
     * @return an iterator over the satellites in the chain, in the order they are connected,
     *         starting from the first satellite 0 and ending with the last satellite n-1
     */
    @Override
    public Iterator<Integer> iterator() {
        // TODO
         return new Iterator<Integer>() {
             int i = 0;
             int prev = -1;
             @Override
             public boolean hasNext() {
                 return i != prev;
             }

             @Override
             public Integer next() {
                 if (i == prev) {
                     throw new NoSuchElementException();
                 }
                 int res = i;
                 prev = i;
                 i = successor[i];
                 return res;
             }
         };
    }
}
