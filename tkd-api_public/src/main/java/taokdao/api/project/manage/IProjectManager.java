package taokdao.api.project.manage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.File;

import taokdao.api.project.bean.Project;
import taokdao.api.project.load.IProjectLoader;

public interface IProjectManager {

    @NonNull
    IProjectLoader getProjectLoader();

    void setProjectLoader(@NonNull IProjectLoader projectLoader);

    /**
     * 打开工程
     *
     * @param file 工程配置文件
     * @return 是否打开成功
     */
    boolean openProject(@NonNull File file);

    /**
     * 关闭工程
     */
    void closeProject();


    /**
     * 重新打开当前工程
     *
     * @return 是否打开成功
     */
    boolean reopenProject();

    /**
     * @return 是否已打开工程
     */
    boolean isOpenedProject();

    /**
     * @return 打开的工程
     */
    @Nullable
    Project getProject();

    /**
     * 关闭工程请使用closeProject
     *
     * @param project 设置已打开的工程
     */
    void setProject(@Nullable Project project);


}
