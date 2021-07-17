# WindowsUtility
Simple utility application for operations on folders and files.
When executed, it does a specific operation on the folder/file provided as path, and does the same on every subfolder recursively.


# How to use
1. Download and install java 8 on your computer from https://www.oracle.com/java/technologies/javase-jre8-downloads.html
2. Download WindowsUtility.jar
3. Execute the following command from terminal: 'java -jar WindowsUtility.jar {operation} {path}


# Application arguments
{operation} can have the following values:
- DEACCENT - Removes accents from characters (eg. nézet -> nezet, Árnyék -> Arnyek, etc.)
- LOWERCASE - Makes all characters lowercase (eg. TestFolder -> testfolder)
- UPPERCASE - Makes all characters uppercase (eg. TestFolder -> TESTFOLDER)

{path} must be a valid absolute path to a file or folder on the file system (eg. C:/folder1/folder2, D:/folder1/file1, etc.)
