package edu.umb.cs680.hw14.apfs.util;

import edu.umb.cs680.hw14.apfs.ApfsDirectory;
import edu.umb.cs680.hw14.apfs.ApfsFSVisitor;
import edu.umb.cs680.hw14.apfs.ApfsFile;
import edu.umb.cs680.hw14.apfs.ApfsLink;

public class ApfsCountingVisitor implements ApfsFSVisitor {

    private int dirNum = 0;
    private int fileNum = 0;
    private int linkNum = 0;

    @Override
    public void visit(ApfsDirectory directory) {
        dirNum++;
    }

    @Override
    public void visit(ApfsFile file) {
        fileNum++;
    }

    @Override
    public void visit(ApfsLink link) {
        linkNum++;
    }

    public int getDirNum() {
        return dirNum;
    }

    public int getFileNum() {
        return fileNum;
    }

    public int getLinkNum() {
        return linkNum;
    }
}
