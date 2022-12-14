# 热更新出包工具
## 初衷    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;由于游戏上线后，多个渠道分支版本频繁迭代，一周内更新数次，客户端一直为手动操作，效率较低，且偶尔出现操作失误等问题，为了提高工作效率及响应快速迭代需求，让客户端只关注bug修复和新功能开发，因此抽出时间写了版本迭代工具，只需和策划对好版本号，每次更新都会生成一个新版本目录`v1.x.x`和新版本增量包目录`v1.x.x_delta`，线上游戏进行使用增量包进行更新，同时该工具自行将增量目录进行zip格式打包然后上传到ftp服务器交给运维进行测试服和正式服更新，极大缩减了工作流程和提高版本更新效率。  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;此zip包同时也为热更新包，内含此次更新的文件和资源。在游戏用户进入游戏时下载、更新游戏内容。
    
## 介绍    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ant是一个将软件编译、测试、部署等步骤联系在一起加以自动化的一个工具，大多用于Java环境中的软件开发。在实际软件开发中，有很多地方可以用到ant。    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本工具为自定义jar任务类给build.xml调用达到自动化构建，满足热更新打包需求
    
## 优点  
- 1.跨平台：Ant是纯java语音编写的，所以具有很好的跨平台性  
- 2.减少操作失误率、节省工作流程
- 3.操作简单方便快捷：Ant是由一个内置任务和可选任务组成的，用ant任务就像是在dos中写命令行一样。Ant运行时需要一个XML文件(构建文件)。 Ant通过调用target树，就可以执行各种task。每个task实现了特定接口对象
- 4.维护简单、可读性好、集成简单：由于Ant构建文件是XML格式的文件，所以很容易维护和书写，而且结构很清晰。Ant可以集成到开发环境中。
- Ant 是Apache软件基金会JAKARTA目录中的一个子项目，由于Ant的跨平台性和操作简单的特点，它很容易集成到一些开发环境中去
    
### 相关库文件
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

## 开发环境
    system：Windows
    JDK：1.8+
    IDE：Intellij Idea
    ant：1.10.6

## 环境部署  
- 1.下载`apache-ant`软件, 点击下载：https://dlcdn.apache.org//ant/binaries/apache-ant-1.10.12-bin.zip  
- 2.将ant目录下的`bin`目录配在系统环境变量`path`中  
- 3.打开cmd窗口，输入命令 `ant -version`，如出现版本号则ant配置成功  
- 4.将lib目录下所有`.jar`文件拷贝到ant软件的`lib`目录  
- 5.将`build.xml`复制到自己项目根目录下，修改文件中注明需要修改的位置  
- 6.打开执行`ant`命令等待操作成功日志
    
## 相关网址
Apache-Ant官网 https://ant.apache.org/
