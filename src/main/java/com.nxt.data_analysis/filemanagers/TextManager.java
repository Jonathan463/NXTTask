package com.nxt.data_analysis.filemanagers;

import com.nxt.data_analysis.interfaces.FileManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextManager implements FileManager {

    private final String  fileExtension = ".txt";

    @Override
    public String getFileExtension() {
        return fileExtension;
    }

    @Override
    public void moveFile(Path path, Path destination) {
        try {
            Files.move(path, destination.resolve(path.getFileName().toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String parseFile(Path path) {
        StringBuilder fileContent = new StringBuilder();
        try {
            BufferedReader reader = Files.newBufferedReader(path);
            String line;
            while ((line = reader.readLine()) != null){
                fileContent.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent.toString();
    }
}
