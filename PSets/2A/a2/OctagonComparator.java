package a2;

import java.util.Comparator;

public class OctagonComparator  implements Comparator<Octagon> {
    public int compare(Octagon a, Octagon b) {
        if (a.getSide() > b.getSide()) { return 1; }
        else if (a.getSide() == b.getSide()) { return 0; }
        else { return -1; }
    }
}
