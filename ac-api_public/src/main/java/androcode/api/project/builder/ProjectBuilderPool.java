package androcode.api.project.builder;

import androcode.base.identifiable.IdentifiablePool;


public class ProjectBuilderPool extends IdentifiablePool<IProjectBuilder, String> {
    private static ProjectBuilderPool instance = new ProjectBuilderPool();

    public static ProjectBuilderPool getInstance() {
        return instance;
    }

    public static ProjectBuilderPool newInstance() {
        instance = new ProjectBuilderPool();
        return instance;
    }
}
