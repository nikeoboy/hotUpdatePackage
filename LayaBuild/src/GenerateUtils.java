import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class GenerateUtils extends Task {
    private String rootPath;        // 项目根目录
    private String lastPath;        // 项目上次版本发布目录
    private String outPath;         // 项目最新版本发布目录
    private String deltaPath;       // 项目最新版本增量目录

    public void setMessage(String message)
    {
        System.out.println("msg ="+message);
    }

    public void setRoot(String path)
    {
        this.rootPath = path;
    }

    public void setTempVersion(String path)
    {
        this.lastPath = path;
    }

    public void setVersion(String path)
    {
        this.outPath = path;
    }

    public void setExport(String path)
    {
        this.deltaPath = path;
    }

    @Override
    public void execute() throws BuildException {
        clearDeltaPath(deltaPath);
        try {
            generateDeltaPackge(outPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 清空增量包目录,再生成
     * @param dir
     */
    private void clearDeltaPath(String dir)
    {
        File tempDir = new File(dir);
        if(Objects.isNull(tempDir) || !tempDir.exists())
        {
            return;
        }

        for(File file:tempDir.listFiles()) {
            if(file.isDirectory())
            {
                clearDeltaPath(file.getAbsolutePath());
            }
            file.delete();
        }
    }

    /**
     * 生成增量包文件
     * 从最新发布的目录中寻求差异文件
     */
    public void generateDeltaPackge(String dir) throws IOException {
        File file = new File(dir);
        if(!file.exists() || Objects.isNull(file) )
        {
            return;
        }

        File[] childFiles = file.listFiles();

        if(Objects.isNull(childFiles) || childFiles.length==0)
        {
            return;
        }

        for (File childFile : childFiles)
        {
            if(childFile.isFile())
            {
                boolean isChanged = compareWithOldVersionFile(childFile);
                //如果为首次发布则将所有资源复制一份到增量目录
                if(outPath.equals(lastPath) || isChanged)
                {
                    //将差异文件进行拷贝到增量目录
                    String path = childFile.getAbsolutePath();
                    String destDir = path.replace(outPath, deltaPath);
                    FileUtils.copyFile(new File(path), new File(destDir));
                    System.out.println(childFile.getName());
                    System.out.println(childFile.getParent());
                }
            }
            else
            {
                generateDeltaPackge(childFile.getAbsolutePath());
            }
        }
    }

    /**
     * 和旧版本文件进行对比
     * 获取文件的相对路径，
     * 和旧版本文件进行对比
     * @param file
     * @return
     */
    public boolean compareWithOldVersionFile(File file) throws IOException
    {
        if(Objects.isNull(file) || !file.exists())
        {
            return false;
        }

        String path = file.getAbsolutePath();//当前遍历文件相对路径
        String oldFileDir = path.replace(outPath, lastPath); //路径替换为上次发布目录路径，寻找是否存在
        File oldFile = new File(oldFileDir);

        //文件不存在
        if(Objects.isNull(oldFile) || !oldFile.exists())
        {
            return true;
        }

        //文件MD5发生变化
        String md5_1 = getFileMD5(file);
        String md5_2 = getFileMD5(oldFile);
        System.out.println(path+ "  md5: "+md5_1 + "\n"+oldFileDir+ "  md5: "+md5_2);
        return !md5_1.equals(md5_2);
    }

    public String getFileMD5(File file) throws IOException
    {
        return getMd5(file.getAbsolutePath());
    }

    /**
     * 获取md5码
     * @param filepath
     * @return
     * @throws IOException
     */
    public String getMd5(String filepath) throws IOException {
        return DigestUtils.md5Hex(new FileInputStream(filepath));
    }
}
