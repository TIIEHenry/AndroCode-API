package androcode.api.main.menu;

import androidx.annotation.Nullable;

import androcode.api.main.IMainActivity;
import androcode.api.ui.content.editor.IEditor;

public interface MainMenuCallback {
    void onMenuAction(IMainActivity main, @Nullable IEditor editor);
}