import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import java.io.IOException;
import java.io.InputStream;

/**
 * layadcc文件生成
 * @author songxiangjun
 */
public class GenerateDcc extends Task {

    private String outPath;

    @Override
    public void execute() throws BuildException {
        try {
            //执行cmd命令
            Runtime mt = Runtime.getRuntime();
            String cmd = "layadcc "+outPath;
            Process pro = mt.exec("cmd.exe /c " + cmd);
            pro.waitFor();
            System.out.println("成功生成dcc 路径:" + outPath);
            pro.destroy();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setOutPath(String path)
    {
        this.outPath = path;
    }
}
