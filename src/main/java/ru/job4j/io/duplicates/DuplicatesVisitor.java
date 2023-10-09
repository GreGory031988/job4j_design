package ru.job4j.io.duplicates;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, List<Path>> result = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        File f = file.toFile();
        FileProperty fp = new FileProperty(f.length(), f.getName());
        result.computeIfAbsent(fp, a -> new ArrayList<>()).add(file);
        return super.visitFile(file, attrs);
    }

    public void printDuplicates() {
        for (var fp : result.keySet()) {
            var list = result.get(fp);
            if (list.size() > 1) {
                System.out.printf("%s - %d%n", fp.getName(), fp.getSize());
                for (var path : list) {
                    System.out.println(path);
                }
            }
        }
    }
}
