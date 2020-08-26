package taokdao.api.project.load;

import androidx.annotation.NonNull;

import java.io.File;

import taokdao.api.project.bean.Project;
import taokdao.api.project.bean.ProjectConfig;
import taokdao.api.project.bean.ProjectConfigJson;

public interface IProjectLoader {
    default File getProjectConfigFile(File projectDir) {
        return new File(projectDir, ProjectConfigJson.configFileName);
    }

    @NonNull
    default ProjectConfig loadProjectConfigFromDir(@NonNull File projectDir) throws Exception {
        return loadProjectConfigFromFile(getProjectConfigFile(projectDir));
    }

    @NonNull
    ProjectConfig loadProjectConfigFromFile(@NonNull File configFile) throws Exception;

    @NonNull
    Project loadProject(@NonNull ProjectConfig config) throws ProjectLoadException;
}
