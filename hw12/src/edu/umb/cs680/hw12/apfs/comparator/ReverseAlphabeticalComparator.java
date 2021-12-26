package edu.umb.cs680.hw12.apfs.comparator;

import edu.umb.cs680.hw12.apfs.ApfsElement;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<ApfsElement> {
    @Override
    public int compare(ApfsElement apfsEle1, ApfsElement apfsEle2) {
        return -apfsEle1.getName().compareToIgnoreCase(apfsEle2.getName());
    }
}
