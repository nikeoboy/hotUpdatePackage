- commons.net-1.4.1.jar ftp连接第三方库  
    常用类：`FTPClient` `FTPFile`
- commons-codec-1.10 md5生成库  
    文件生成md5方法：`DigestUtils.md5Hex()`;
- commons-io-2.6.jar 文件操作库  
     文件拷贝：`FileUtils.copyFile(file1Path, file2Path)`;

- LayaBuild.jar 主要逻辑代码包库，主要功能：  
    > 增量包目录生成  
    > dcc文件生成  
    > 文件md5差异对比  
    > 文件拷贝  
    > ftp上传  

- 📫 环境部署  
    1.下载`apache-ant`软件, 点击下载：https://dlcdn.apache.org//ant/binaries/apache-ant-1.10.12-bin.zip  
    2.将ant目录下的`bin`目录配在系统环境变量`path`中  
    2.打开cmd窗口，输入命令 `ant -version`，如出现版本号则ant配置成功  
    3.将lib目录下所有`.jar`文件拷贝到ant软件的`lib`目录  
    4.将`build.xml`复制到自己项目根目录下，修改文件中注明需要修改的位置  
    5.打开执行`ant`命令等待操作成功日志

- 介绍    
    采用ant软件 自定义jar任务类给build.xml调用达到自动化构建，
   
- 优点  
    1.跨平台，支持windows、mac、linux等所有平台  
    2.减少操作失误率、节省工作流程
    3.自动化方便快捷

- 补充
    需要自行补充apache-ant 基础配置语法
    
- 相关网址
    apache-ant官网：https://ant.apache.org/
