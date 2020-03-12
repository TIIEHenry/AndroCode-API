package androcode.api.setting.preference.wrapped;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import androcode.api.setting.preference.ICategoryPreference;
import androcode.api.setting.preference.base.IGroupPreference;
import androcode.api.setting.preference.base.IPreference;
import androcode.base.annotation.relation.MainConstructor;

public class CategoryPreference implements ICategoryPreference {
    private final String id;
    private final Drawable icon;
    private final String title;
    private final String description;
    private List<IPreference<?>> children = new ArrayList<>();
    private boolean enable = true;

    @MainConstructor
    public CategoryPreference(@NonNull String id, Drawable icon, String title, String description) {
        this.id = id;
        this.icon = icon;
        this.title = title;
        this.description = description;

    }

    public CategoryPreference(@NonNull String id, String title, String description) {
        this(id, null, title, description);
    }

    public CategoryPreference(@NonNull String id, String title) {
        this(id, null, title, null);
    }

    @NonNull
    @Override
    public Object loadValue() {
        return new Object();
    }

    @Override
    public void saveValue(Object value) {

    }

    @NonNull
    @Override
    public List<IPreference<?>> getNumberList() {
        return children;
    }

    @Override
    public void setNumberList(@NonNull List<IPreference<?>> list) {
        children = list;
        for (IPreference child : list) {
            child.setGroup(this);
        }
    }

    @NonNull
    @Override
    public String getTitle() {
        return title;
    }

    @Nullable
    @Override
    public Drawable getIcon() {
        return icon;
    }

    @Nullable
    @Override
    public String getDescription() {
        return description;
    }

    @Nullable
    @Override
    public IGroupPreference getGroup() {
        return null;
    }

    @Override
    public void setGroup(@NonNull IGroupPreference group) {

    }

    @Override
    public void enable() {
        enable = true;
    }

    @Override
    public void disable() {
        enable = false;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }

    @NonNull
    @Override
    public String id() {
        return id;
    }
}
