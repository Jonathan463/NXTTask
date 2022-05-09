package com.nxt.data_analysis.interfaces;

import java.nio.file.Path;

public interface FileManager {
    String getFileExtension();
    void moveFile(Path path, Path Destination);
    String parseFile(Path path);
}
