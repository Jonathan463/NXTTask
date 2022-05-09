package com.nxt.data_analysis;

import com.nxt.data_analysis.filemanagers.TextManager;
import com.nxt.data_analysis.interfaces.FileManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //get directory path
        if (args.length == 0) {
            System.out.println("Application needs a path parameter to observe, " +
                    "please ensure you are sending a path as an arguement in the \"Environment variable\" ");
            return;
        }

        String folder = args[0];
        System.out.println(folder);

        Path path = Path.of(folder);

        FileManager textManager = new TextManager();
        boolean filesExistInTheDirectory = false;


        if (!Files.exists(path)) {
            //throw custom exception to say that directory does not exist
            System.out.println("path does not exist");
            System.out.println("  ");
            System.out.println("Please make sure you send a valid file path ");

            return;

        } else {

            System.out.println("folder exist");

            try {
                Stream<Path> files = Files.list(path);
                if (files.findAny().isPresent()){
                    filesExistInTheDirectory = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            DirectoryObserver directoryWatcher = new DirectoryObserver(path);
            directoryWatcher.startObserving(filesExistInTheDirectory, textManager);
        }






    }
}
