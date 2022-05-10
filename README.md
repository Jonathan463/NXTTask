# NXTTask
___

## File Observer Tax

Instructions The application can be run on your IDE terminal, simply:

- Clone the project from [Here](https://github.com/Jonathan463/NXTTask)
- open the application on your IDE _(preferably Intellij)_
- edit configuration by putting a valid folder path (path can be a string) into your environment variable, the path will be the folder that the application will be observing as it runs.
- run the application from your IDE



## Packages
___

The **Simple file parser** application has a package called **interfaces** that houses all interfaces. The interfaces provide the application, the ability to scale up it's implementations for statistics and fileManagers or fileParsers The application has a fileManagers package that houses all the implementations of the different possible types of file parsers that will cater for different file extensions. The application has a Statistics package that houses all the implementations of the classes or potential classes responsible for calculating the different types of statistics.

DirectoryObserver The directory observer class is responsible for watching a directory and ensuring that whenever a create event is triggered on the directory, the application knows and carries out certain tasks on the file that was added. the directory observer has a method that starts observing the directory provided in the environment variable when invoked and another that stops observing the directory when invoked.

fileManagers This package houses implementations of the FileManager interface, it houses only the TextManager class at the moment, but can house other implementations that will cater for parsing the contents of other file types into string values which will then be processed to show statistics of the file content. The fileManagers also implement methods for moving files from a folder to another folder.

Statistics This package houses classes that provide method implementations that perform statistic checks on the files that are added to the folder being watched by the file observer. There are implementations for number of dots (numDotsStatistics class), number of words(numWordsStatistics class), most used word statistics (mostUsedWordStatistics class) these implementations are used in the directory observer startObserving method to provide statistics for every file that is added to the folder.

Model--> StatisticsModel The Model package basically houses any model that the application may need, for now it has just the Statistics Model. The Statistics Model basically serves as the return type for all statistic implementations, it gives the application the feature of displaying statistics based on the statistic type, it collects the stat to be displayed and the value of the stat for that file as part of its constructor.