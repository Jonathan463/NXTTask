package com.nxt.data_analysis;

import com.nxt.data_analysis.interfaces.DirectoryObserverInterface;
import com.nxt.data_analysis.interfaces.FileManager;
import com.nxt.data_analysis.interfaces.Statistics;
import com.nxt.data_analysis.models.StatisticsModel;
import com.nxt.data_analysis.statistics.MostUsedWordStatistics;
import com.nxt.data_analysis.statistics.NumberOfDotsStatistics;
import com.nxt.data_analysis.statistics.NumberOfWordsStatistics;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DirectoryObserver implements DirectoryObserverInterface {
    private Path processedFolder;
    private Path unSupportedFilesFolder;
    private WatchService watcher;
    private Path path;
    private WatchKey key;

    public DirectoryObserver(Path mydirectoryToWatch) {
        this.path = mydirectoryToWatch;
        checkForAndCreateProcessedFolder();
        initializeWatcher();
    }


    private void initializeWatcher() {
        try {
            watcher = FileSystems.getDefault().newWatchService();
            path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkForAndCreateProcessedFolder(){
        processedFolder = path.resolve("processedFolder");
        unSupportedFilesFolder = path.resolve("unSupportedFilesFolder");
        try {
            if (!Files.exists(processedFolder)) {
                processedFolder = Files.createDirectories(path.resolve("processedFolder"));
            }
            if (!Files.exists(unSupportedFilesFolder)) {
                unSupportedFilesFolder = Files.createDirectories(path.resolve("unSupportedFilesFolder"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startObserving(boolean fileInDirectory, FileManager textManager) {

        while (true) {
            //check if there are any files in the folder
            if (fileInDirectory == true) {
                // get the files, process each of them and send them to the processed directory
                try {
                    var files = Files.newDirectoryStream(path, "*.txt");
                    files.forEach(path -> {
                        // read the content of the files initially in the directory and move them if supported
                        processFiles(path, textManager);
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path filename = ev.context();

                Path changedFile = path.resolve(filename);
                processFiles(changedFile, textManager);
            }
            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }

    }

    void processFiles(Path path, FileManager textManager){
        if (path.getFileName().toString().toLowerCase(Locale.ROOT).endsWith(textManager.getFileExtension())){
            // read the content of the file and move the file
            String fileContent = textManager.parseFile(path);
            textManager.moveFile(path, processedFolder);

            //get the statistics of the file
            printStats(path.getFileName(), fileContent);
        }else{
            System.out.println("Unsupported file format, please ensure you put only \".txt\" files in the folder");
            textManager.moveFile(path, unSupportedFilesFolder);

        }
    }

    void printStats(Path filename, String fileContent){
        List<Statistics> statsArray = new ArrayList<>();
        statsArray.add(new NumberOfWordsStatistics());
        statsArray.add(new NumberOfDotsStatistics());
        statsArray.add(new MostUsedWordStatistics());
        for(Statistics s: statsArray) {
            StatisticsModel stat = s.getStatistics(fileContent);
            stat.setNameOfFile(filename.toString());
            stat.logStatNameAndValue();
        }
    }


    @Override
    public void StopObserving() {
        try {
            key.cancel();
            watcher.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
