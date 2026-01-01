package algorithms;

import java.util.Iterator;

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
        // TODO
    }


    /**
     * Inserts satellite "b" just after satellite "a".
     * @param a the satellite before which "b" should be inserted, "a" must be in the chain and must be different from n-1 (last satellite)
     * @param b the satellite to insert, it must not be in the chain
     * @throws IllegalArgumentException if "b" is already in the chain or if "a" is the last satellite
     */
    public void insertAfter(int a, int b) {
        // TODO
    }


    /**
     * Inserts satellite "b" just before satellite "a".
     * @param a the satellite after which "b" should be inserted, "a" must be in the chain and must be different from 0 (first satellite)
     * @param b the satellite to insert, it must not be in the chain
     * @throws IllegalArgumentException if "b" is already in the chain or if "a" is the first satellite
     */
    public void insertBefore(int a, int b) {
        // TODO
    }



    /**
     * Iterator over the satellites in the chain
     * @return an iterator over the satellites in the chain, in the order they are connected,
     *         starting from the first satellite 0 and ending with the last satellite n-1
     */
    @Override
    public Iterator<Integer> iterator() {
        // TODO
         return null;
    }

}
