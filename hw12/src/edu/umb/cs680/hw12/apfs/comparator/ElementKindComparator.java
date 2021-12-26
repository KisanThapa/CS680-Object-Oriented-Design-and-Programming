package edu.umb.cs680.hw12.apfs.comparator;

import edu.umb.cs680.hw12.apfs.ApfsElement;
import java.util.Comparator;

public class ElementKindComparator implements Comparator<ApfsElement> {

    @Override
    public int compare(ApfsElement apfsEle1, ApfsElement apfsEle2) {
        return -String.valueOf(apfsEle1.getSize()).compareTo(String.valueOf(apfsEle2.getSize()));
    }
}
