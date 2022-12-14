package br.infnet.edu.at_java;

import br.infnet.edu.at_java.FileOperations.FileHandler;

public class FileTests {
    public boolean CreateFile(){
    
        FileHandler fileHandler = new FileHandler();
        var res = fileHandler.CreateFile();
        return res;
    }

    public boolean CreateFile(String path){
    
        FileHandler fileHandler = new FileHandler();
        var res = fileHandler.CreateFile(path);
        return res;
    }

    public boolean WriteInFile(String content){
        FileHandler fileHandler = new FileHandler();
        var res = fileHandler.WriteInFile(content);
        return res;
    }

    public String ReadFile(){
        FileHandler fileHandler = new FileHandler();
        var res = fileHandler.ReadFile();
        return res;
    }

}
    