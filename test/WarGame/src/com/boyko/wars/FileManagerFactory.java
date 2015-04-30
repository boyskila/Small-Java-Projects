package com.boyko.wars;

public class FileManagerFactory {
    public static FileManagerInetrface getInstance(){
        return new FileManager();
    }
}
