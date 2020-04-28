package taokdao.api.event.tags;

import androidx.annotation.NonNull;

import taokdao.api.event.tag.IEventTag;
import taokdao.api.main.IMainActivity;
import taokdao.api.ui.progressbar.ProgressBarSet;
import tiiehenry.taokdao.api.main.R;

public class ProgressBarTag implements IEventTag {
    private final ProgressBarSet progressBar;

    public ProgressBarTag(@NonNull ProgressBarSet progressBar) {
        this.progressBar = progressBar;
    }

    @NonNull
    @Override
    public String getTag(@NonNull IMainActivity main) {
        return main.getString(R.string.event_progressbar_prefix) + "(" + progressBar.label + ")";
    }
}
