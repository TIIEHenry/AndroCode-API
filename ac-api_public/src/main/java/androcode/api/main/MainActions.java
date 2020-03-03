package androcode.api.main;

import java.util.ArrayList;

import androcode.api.main.IMainActivity;

public enum MainActions  {
    onCreate("onCreate"), onDestroy("onDestroy"),
    onPause("onPause"), onResume("onResume"),
    onStart("onStart"), onStop("onStop"),
    onAny("onAny"),
    onProjectOpened("onProjectOpened"),
    onProjectClosed("onProjectClosed"),
    onFileRenamed("onFileRenamed"),
    onFileCreated("onFileCreated"),
    onFileDeleted("onFileDeleted"),
    //screen onOrientationChanged
    onOrientationChanged("onOrientationChanged"),
    onLandscape("onLandscape"),
    onPortrait("onPortrait"),

    AllFilesSaved("AllFilesSaved"), AllFilesSavedInThread("AllFilesSavedInThread");

    public String name;

    MainActions(String name) {
        this.name = name;
    }

    public ArrayList<Observer> list = new ArrayList<>();

    public void addObserver(Observer o) {
        list.add(o);
    }

    public void removeObserver(Observer o) {
        list.remove(o);
    }

    public void runObservers(IMainActivity main) {
        for (Observer o : list) {
            o.onAction(main);
        }
    }

    public interface Observer {
        void onAction(IMainActivity main);
    }

    public void clear() {
        list.clear();
    }

    public static void clearAll() {
        for (MainActions value : values()) {
            value.clear();
        }
    }
}