package controllers;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <h1>WatcherController</h1>
 * <p>This controller watches the common folder for changes</p>
 */
public class WatcherController {
    private static boolean isFirstTime = true;

    /**
     * <p>watches the file path with a dedicated delay</p>
     * @param filePathString
     * @param delay
     */
    public static void watch(String filePathString, int delay){


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
                        if(kind == StandardWatchEventKinds.ENTRY_CREATE) {
                            if (isFirstTime)
                                TimeUnit.MILLISECONDS.sleep(200);

                            isFirstTime = false;
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
}
