package taokdao.api.event.send.wrapped;

import androidx.annotation.NonNull;

import taokdao.api.event.send.IEventSender;
import taokdao.api.event.tag.IEventTag;
import taokdao.api.main.IMainContext;

public class EventSender implements IEventSender {
    private final IEventTag eventTag;
    private final String message;

    public EventSender(@NonNull IEventTag eventTag, @NonNull String message) {
        this.eventTag = eventTag;
        this.message = message;
    }

    @Override
    public void log(@NonNull IMainContext main) {
        main.log(eventTag, message);
    }

    @Override
    public void notify(@NonNull IMainContext main) {
        main.notify(eventTag, message);
    }

    @Override
    public void send(@NonNull IMainContext main) {
        main.send(eventTag, message);
    }

}
