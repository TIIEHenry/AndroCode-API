package androcode.api.dynamic.language;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.fastjson.JSON;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import androcode.api.main.IMainActivity;

public class JsonLanguageLoader implements ILanguageLoader<String> {
    private String defaultLan;
    private String currentLan;

    public JsonLanguageLoader(IMainActivity main) {
        currentLan = main.getLanguageManager().getLanguageCountry();
    }

    private HashMap<String, HashMap<String, String>> map = new HashMap<>();

    @Nullable
    @Override

    public ILanguageLoader<String> input(@NonNull String source) {
        map = JSON.parseObject(source, HashMap.class) ;
        return null;
    }

    @Nullable
    @Override
    public String output() {
        return JSON.toJSONString(map);
    }

    @NonNull
    @Override
    public String get(@NonNull String id, @NonNull String language) {
        HashMap<String, String> idMap = map.get(id);
        if (idMap != null) {
            String s = idMap.get(currentLan);
            if (s != null)
                return s;
            int index = currentLan.indexOf("-");
            if (index > 1) {
                String lan = currentLan.substring(0, index - 1);
                s = idMap.get(lan);
                if (s != null)
                    return s;
            }
            s = idMap.get(language);
            if (s != null)
                return s;
        }
        return "None";
    }

    @Override
    public void set(@NonNull String id, @NonNull String language, @NonNull String str) {
        HashMap<String, String> idMap = map.get(id);
        if (idMap == null) {
            idMap = new HashMap<>();
            map.put(id, idMap);
        }
        idMap.put(language, str);
    }

    @NonNull
    @Override
    public String getDefaultLanguage() {
        return defaultLan;
    }

    @Override
    public void setDefaultLanguage(@NonNull String language) {
        this.defaultLan = language;
    }

    @NonNull
    @Override
    public String getCurrentLanguage() {
        return currentLan;
    }

    @Override
    public void setCurrentLanguage(@NotNull String language) {
        this.currentLan = language;
    }
}
