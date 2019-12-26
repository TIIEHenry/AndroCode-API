package androcode.api.builder.base;

import androcode.api.activity.IMainActivity;

public interface ITask<I>  {
        boolean runTask(IMainActivity activity, I config) throws Exception;

        boolean buildTask(IMainActivity activity, I config) throws Exception;
}
