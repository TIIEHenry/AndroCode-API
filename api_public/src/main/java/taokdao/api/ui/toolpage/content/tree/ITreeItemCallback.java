package taokdao.api.ui.toolpage.content.tree;

import androidx.annotation.NonNull;

import taokdao.api.ui.toolpage.content.tree.TreeItem;

public interface ITreeItemCallback {
    void onAction(@NonNull TreeItem item);
}
