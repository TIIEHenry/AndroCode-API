package androcode.api.project.template;

import androcode.base.identifiable.IdentifiablePool;

public class ProjectTemplatePool extends IdentifiablePool<IProjectTemplate, String> {
    private static ProjectTemplatePool instance = new ProjectTemplatePool();

    public static ProjectTemplatePool getInstance() {
        return instance;
    }

    public static ProjectTemplatePool newInstance() {
        instance = new ProjectTemplatePool();
        return instance;
    }
}
