package androcode.api.project.loader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import androcode.base.annotation.maintain.LongTerm;
import androcode.base.annotation.todo.NeedSet;

@LongTerm
public class ProjectConfig {
    public static String configFileName = "project.json";
    @NeedSet
    public File projectDir;
    @NeedSet
    public File configFile;
    public String name;
    /**
     * projectBuilder id
     */
    public String builder;
    /**
     * projectPlugin id
     */
    public List<Plugin> plugins = new ArrayList<>();
    public List<Path> projects = new ArrayList<>();
    public Map<String, Object> setting;

    public ProjectConfig() {

    }

    public static ProjectConfig from(String text) {
        return JSON.parseObject(text, ProjectConfig.class);
    }

    public static class Plugin {
        public String id;
        public List<?> parameters;


        @NonNull
        @Override
        public String toString() {
            return "Plugin{id=" + id + ",parameters=" + parameters + "}";
        }
    }


    public static class Path {
        /**
         * 别名
         */
        @Nullable
        public String alias;

        /**
         * 路径 非一般路径
         */
        public String path;

        private File realFile = null;

        public Path() {
        }

        public Path(@Nullable String alias, String path) {
            this.alias = alias;
            this.path = path;
        }

        public File getRealPath(File projectDir) {
            if (realFile == null) {
                if (path.startsWith("/")) {
                    realFile = new File(path);
                } else {
                    String paths = path;
                    while (paths.startsWith("../")) {
                        if (projectDir.getParentFile() != null)
                            projectDir = projectDir.getParentFile();
                        paths = paths.substring(3);
                    }
                    realFile = new File(projectDir, paths);
                }
            }
            return realFile;
        }

        @NonNull
        @Override
        public String toString() {
            return "Path{alias=" + alias + ",path=" + path + "}";
        }
    }
}
