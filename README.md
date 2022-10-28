- 👋 commons.net-1.4.1.jar ftp连接第三方库  
    常用类：FTPClient、FTPFile
- 👋 commons-codec-1.10 md5生成库  
    文件生成md5方法：DigestUtils.md5Hex();
- 👋 commons-io-2.6.jar 文件操作库  
     文件拷贝：FileUtils.copyFile(file1Path, file2Path);

- 👋 LayaBuild.jar 主要逻辑代码包库，主要功能：  
    1.增量包目录生成  
    2.dcc文件生成  
    3.md5文件对比  
    5.文件拷贝  
    6.ftp上传  

- 📫 环境部署:  
    1.下载apache-ant软件，将bin目录配在环境变量path中  
    2.打开cmd窗口，输入命令 ant -version，如出现版本号则ant配置成功  
    3.将lib目录下所有.jar文件拷贝到ant软件的lib目录  
    4.将build.xml复制到项目根目录下，修改文件中注明需要修改的位置  
    5.打开执行ant命令等待操作成功日志

