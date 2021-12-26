package edu.umb.cs680.hw12.apfs.comparator;

import edu.umb.cs680.hw12.apfs.ApfsElement;
import java.util.Comparator;

public class TimeStampComparator implements Comparator<ApfsElement> {

    @Override
    public int compare(ApfsElement apfsEle1, ApfsElement apfsEle2) {
        return apfsEle1.getCreationTime().toString().compareTo(apfsEle2.getCreationTime().toString());
    }
}
