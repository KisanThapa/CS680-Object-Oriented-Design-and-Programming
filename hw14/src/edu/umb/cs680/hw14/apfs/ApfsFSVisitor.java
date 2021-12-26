package edu.umb.cs680.hw14.apfs;

public interface ApfsFSVisitor {
    void visit(ApfsDirectory directory);
    void visit(ApfsFile file);
    void visit(ApfsLink link);
}
