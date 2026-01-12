package basics;


// SEE THE explanations in the Videos

import oop.Dungeon;

import java.util.HashSet;
import java.util.Set;

public class Flipper {

    public enum Direction {
        North, East, South, West;
    }

    private static int updateX (int oldX, Direction dir) {
        switch (dir) {
            case North:
                return oldX - 1;
            case South:
                return oldX + 1;
            default:
                return oldX;
        }
    }

    private static int updateY (int oldY, Direction dir) {
        switch (dir) {
            case West:
                return oldY - 1;
            case East:
                return oldY + 1;
            default:
                return oldY;
        }
    }

    private static Direction reflect (char mirror, Direction oldDir) {
        switch (oldDir) {
            case North :
                return mirror == '/' ? Direction.East : Direction.West;
            case South:
                return mirror == '/' ? Direction.West : Direction.East;
            case East:
                return mirror == '/' ? Direction.North : Direction.South;
            case West:
                return mirror == '/' ? Direction.South : Direction.North;
            default:
                throw new IllegalArgumentException("Unknown direction " + oldDir);
        }
    }

    public static int run(char [][] map) {
        // TODO

        Set<Integer> visited = new HashSet<>();
        int x = 0;
        int y = 0;
        Direction dir = Direction.East;

        while (x >= 0 && x < map.length && y >= 0 && y < map[0].length) { // as long as the player is on the field
            /// 1 - Gather the id of the cell
            int cellId = x * map[0].length + y;
            visited.add(cellId);

            /// 2 - Update the direction if needed
            if (map[x][y] != '.') {
                dir = reflect(map[x][y], dir);
            }

            /// 3 - Make one step forward according to the direction
            x = updateX(x, dir);
            y = updateY(y, dir);
        }

        return visited.size();
    }

}
