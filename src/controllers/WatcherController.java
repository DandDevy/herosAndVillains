package controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * <h1>WatcherController</h1>
 * <p>This controller watches the common folder for changes</p>
 */
public class WatcherController {
    private static ArrayList<Path> pathArrayList;
    private static final boolean USE_WATCH_SERVICE = false;

    /**
     * <p>watches the file path with a dedicated delay</p>
     * @param filePathString
     * @param delay
     */
    public static void watch(String filePathString, int delay){
        if (USE_WATCH_SERVICE)
            watchWithWatchService(filePathString, delay);

        else
            watchWithFolder(filePathString, delay);

    }

    /**
     * <p>Uses an ArrayList and the (File) .listFiles() to get the files in the common folder</p>
     * @param filePathString
     * @param delay
     */
    private static void watchWithFolder(String filePathString, int delay) {
        pathArrayList = new ArrayList<Path>();
        while (true) {
            setListFilesForFolder(new File(filePathString));
            System.out.println("WatcherController: villainSS here ->>" + pathArrayList + "\n\n");
            for (Path eventpath : pathArrayList) {
                try {
                    Controller.dealWithVillain(eventpath);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                TimeUnit.SECONDS.sleep(delay);
                pathArrayList.clear();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * <p>Uses watchService to watch for changes.</p>
     * @param filePathString
     * @param delay
     */
    private static void watchWithWatchService(String filePathString, int delay){


        try(WatchService service = FileSystems.getDefault().newWatchService()) {

            Map<WatchKey, Path> myWatchKeyPathMap = new HashMap<>();

            Path filePath = Paths.get(filePathString);

            //populate the key map
            myWatchKeyPathMap.put(
                    filePath.register(service,

                            StandardWatchEventKinds.ENTRY_CREATE,
                            StandardWatchEventKinds.ENTRY_DELETE,
                            StandardWatchEventKinds.ENTRY_MODIFY),
                    filePath

            );

            WatchKey watchKey;

            //clears the watch key every time.
            do {
                System.out.println("WatcherController: Waiting every " + delay + " seconds after I see something");
                watchKey = service.take();
                Path myEventDir = myWatchKeyPathMap.get(watchKey);

                for (WatchEvent<?> event: watchKey.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    Path eventpath = (Path) event.context();

                    System.out.println("WatcherController: WATCHER ANNOUNCEMENT: " + myEventDir + "   " + kind + "   " +  eventpath);


//                    DefeatVillainController.dealWithVillain(eventpath);
                    try{
                        if(kind == StandardWatchEventKinds.ENTRY_CREATE || kind == StandardWatchEventKinds.ENTRY_MODIFY) {

                            TimeUnit.MILLISECONDS.sleep(200);

                            System.out.println("WatcherController: villain here ->>" + eventpath);
                            Controller.dealWithVillain(eventpath);
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }

                }

                watchKey.reset();
                TimeUnit.SECONDS.sleep(delay);
            } while (true);// watchKey.reset() inside


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>lists all the files in a folder</p>
     * @param folder
     */
    private static void setListFilesForFolder(final File folder) {
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                setListFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
                pathArrayList.add(Paths.get(fileEntry.getName()));
            }
        }
    }
}
