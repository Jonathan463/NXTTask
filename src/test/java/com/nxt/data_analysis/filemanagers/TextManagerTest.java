package com.nxt.data_analysis.filemanagers;

import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;

import java.nio.file.Path;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TextManagerTest extends TestCase {

    @Test
    public void testConstructor() {
        assertEquals(".txt", (new TextManager()).getFileExtension());
    }


    public void testMoveFile() {
        Path path = Path.of("com.dataAnalysis.fileManagers");
        Path destination = Path.of("test.txt");
        TextManager textManagerMock = Mockito.mock(TextManager.class);
        doNothing().when(textManagerMock).moveFile(path, destination);
        textManagerMock.moveFile(path, destination);
        verify(textManagerMock, times(1)).moveFile(path, destination);
    }

    public void testParseFile() {
        Path path = Path.of("com.dataAnalysis.fileManagers");
        Path destination = Path.of("test.txt");
        StringBuilder fileContent = new StringBuilder("all for one, one for all");
        TextManager textManagerMock = Mockito.mock(TextManager.class);
        when(textManagerMock.parseFile(path)).thenReturn(fileContent.toString());
        assertEquals("all for one, one for all", fileContent.toString());
    }
}