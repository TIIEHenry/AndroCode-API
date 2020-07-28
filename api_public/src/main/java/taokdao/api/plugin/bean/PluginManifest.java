package taokdao.api.plugin.bean;


import androidx.annotation.NonNull;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.util.Arrays;

import taokdao.base.annotation.Identifier;
import taokdao.base.annotation.todo.NeedSet;


public class PluginManifest {
    public static String manifestFileName = "manifest.json";
    @NeedSet
    public File pluginDir;
    @NeedSet
    public File manifestFile;
    @NeedSet
    public PluginType pluginType;
    /**
     * 插件唯一标识,推荐包名
     */
    @Identifier
    public String id;
    /**
     * 插件类型决定了加载次序 engine
     */
    public String type;
    public String api;
    public PluginVersion version;
    public Information information;
    /**
     * 插件支持的语言，如zh-CN
     */
    public String[] languages = new String[]{};
    public Engine engine;


    public PluginVisibility visibility;

    public PluginManifest() {
    }

    public static PluginManifest from(String text) {
        return JSON.parseObject(text, PluginManifest.class);
    }

    public void check() throws Exception {
        if (version == null)
            throw new Exception("Plugin don't have version");
        version.check();
        if (information == null)
            throw new Exception("Plugin don't have information");
        information.check();
        if (engine == null)
            throw new Exception("Plugin don't have engine");
        engine.check();
        if (pluginType == null)
            throw new Exception("Plugin type is incorrect");
    }

    @Override
    public String toString() {
        return "PluginManifest{" +
                "pluginDir=" + pluginDir +
                ", manifestFile=" + manifestFile +
                ", pluginType=" + pluginType +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", api='" + api + '\'' +
                ", version=" + version +
                ", information=" + information +
                ", languages=" + Arrays.toString(languages) +
                ", engine=" + engine +
                ", visibility=" + visibility +
                '}';
    }

    public int hashCode() {
        return manifestFile != null ? manifestFile.hashCode() : 0;
    }

    public static class Information {
        public String author;
        public String label;
        public String icon;
        public String description;
        /**
         * readme文件名,比如README.MD，根据language优先匹配如README-zhCN.MD文件，若找不到则加载README.MD
         */
        public String readme;
        public String[] tags = new String[]{};

        public void check() throws Exception {
            if (label == null)
                throw new Exception("Information don't have label");
        }

        @Override
        public String toString() {
            return "Information{" +
                    "author='" + author + '\'' +
                    ", label='" + label + '\'' +
                    ", icon='" + icon + '\'' +
                    ", description='" + description + '\'' +
                    ", readme='" + readme + '\'' +
                    ", tags=" + Arrays.toString(tags) +
                    '}';
        }
    }

    public static class Engine {
        /**
         * 插件引擎 rhino,luaj,class,replusgin
         */
        public String id;
        public String entrance;
        public String[] parameters = new String[]{};

        public Engine() {
        }

        public void check() throws Exception {
            if (id == null)
                throw new Exception("Engine don't have id");
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "id='" + id + '\'' +
                    ", entrance='" + entrance + '\'' +
                    ", parameters=" + Arrays.toString(parameters) +
                    '}';
        }
    }
}
