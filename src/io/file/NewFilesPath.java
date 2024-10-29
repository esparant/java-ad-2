package io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class NewFilesPath {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("temp/..");
        System.out.println("path = " + path);

        System.out.println("path.toAbsolutePath() = " + path.toAbsolutePath());

        System.out.println("path.toRealPath() = " + path.toRealPath());

        Stream<Path> list = Files.list(path);
        List<Path> list1 = list.toList();

        for (Path p : list1) {
            System.out.println((Files.isRegularFile(p) ? "Directory" : "File") + "|" + p.getFileName());
        }


    }
}
