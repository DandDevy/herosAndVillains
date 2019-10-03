package controllers;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class WatcherController {

    public static void watch(String filePathString, int delay){

        try(WatchService service = FileSystems.getDefault().newWatchService()) {

            Map<WatchKey, Path> myWatchKeyPathMap = new HashMap<>();

            Path filePath = Paths.get(filePathString);

//            myWatchKeyPathMap.put(
//                    StandardWatchEventKinds.
//            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
