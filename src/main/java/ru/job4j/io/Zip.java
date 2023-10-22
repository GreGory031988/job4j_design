package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (var path : sources) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(path.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void validate(ArgsName value) {
        if (!Files.isDirectory(Path.of(value.get("d")))) {
            throw new IllegalArgumentException("The archived directory does not exist");
        }
        if (!value.get("e").startsWith("*.")) {
            throw new IllegalArgumentException("The extension was sent in the wrong format");
        }
        if (!value.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException("The extension was sent in the wrong format");
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName argsName = ArgsName.of(args);
        validate(argsName);
        Zip zip = new Zip();
        List<Path> filter = Search.search(Path.of(argsName.get("d")),
                path -> !path.toString().endsWith(argsName.get("e")));
        zip.packFiles(filter, new File(argsName.get("o")));
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
    }
}
