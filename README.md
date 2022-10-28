# 热更新出包工具
## 介绍    
    ant是一个将软件编译、测试、部署等步骤联系在一起加以自动化的一个工具，大多用于Java环境中的软件开发。在实际软件开发中，有很多地方可以用到ant。
    本工具为自定义jar任务类给build.xml调用达到自动化构建，满足热更新打包需求
    
## 优点  
    ant 是Apache软件基金会JAKARTA目录中的一个子项目，它有以下的优点：
    1.跨平台：Ant是纯java语音编写的，所以具有很好的跨平台性  
    2.减少操作失误率、节省工作流程
    3.操作简单方便快捷：Ant是由一个内置任务和可选任务组成的，用ant任务就像是在dos中写命令行一样。Ant运行时需要一个XML文件(构建文件)。 Ant通过调用target树，就可以执行各种task。每个task实现了特定接口对象
    4.维护简单、可读性好、集成简单：由于Ant构建文件是XML格式的文件，所以很容易维护和书写，而且结构很清晰。Ant可以集成到开发环境中。
    由于Ant的跨平台性和操作简单的特点，它很容易集成到一些开发环境中去
    
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
    1.下载`apache-ant`软件, 点击下载：https://dlcdn.apache.org//ant/binaries/apache-ant-1.10.12-bin.zip  
    2.将ant目录下的`bin`目录配在系统环境变量`path`中  
    2.打开cmd窗口，输入命令 `ant -version`，如出现版本号则ant配置成功  
    3.将lib目录下所有`.jar`文件拷贝到ant软件的`lib`目录  
    4.将`build.xml`复制到自己项目根目录下，修改文件中注明需要修改的位置  
    5.打开执行`ant`命令等待操作成功日志

## 补充  
    需要自行补充Apache-Ant 基础配置语法  主要描述一下，Ant中各个属性作用，现在最常用的属性有：delete,target,mkdir,copy,jar,project

        1.<project>
             此属性是构建文件的根属性。它可以有多个内在属性，其各个属性的含义分别如下：
             default表示默认的运行目标，这个属性是必须的。
             basedir表示项目的基准目录。
             name表示项目名。
             description表示项目的描述。
    
        2.<target>
            .name表示目标名称，这个属性是必须的。
            .depends表示依赖的目标。
            if表示仅当属性设置时才执行。
            unless表示当属性没有设置时才执行。
            description表示项目的描述。
            Ant的depends属性指定了target的执行顺序。Ant会依照depends属性中target出现顺序依次执行每个target。在执行之前，首先需要执行它所依赖的target。
    
        3.<mkdir>
            用于创建一个目录，它有一个属性dir用来指定所创建的目录名。
    
        4.<jar>
            该属性用来生成一个JAR文件，其属性如下。
            destfile表示要生成的JAR文件名。
            basedir表示被归档的文件名。
            includes表示需要归档的文件模式。
            exchudes表示被排除的文件模式。

        5.<javac>
            该属性用于编译一个或一组java文件，其属性如下。
            srcdir表示源程序的目录。
            destdir表示class文件的输出目录。
            include表示被编译的文件的模式。
            excludes表示被排除的文件的模式。
            classpath表示所使用的类路径。
            debug表示包含的调试信息。
            optimize表示是否使用优化。
            verbose 表示提供详细的输出信息。
            fileonerror表示当碰到错误就自动停止。

        6.<java>
            该属性用来执行编译生成的.class文件，其属性如下。
            classname 表示将执行的类名。
            jar表示包含该类的JAR文件名。
            classpath所表示用到的类路径。
            fork表示在一个新的虚拟机中运行该类。
            failonerror表示当出现错误时自动停止。
            output 表示输出文件。
            append表示追加或者覆盖默认文件。

        7.<delete>
            该属性用于删除一个文件或一组文件，其属性如下。
            file表示要删除的文件。
            dir表示要删除的目录。
            includeEmptyDirs 表示指定是否要删除空目录，默认值是删除。
            failonerror 表示指定当碰到错误是否停止，默认值是自动停止。

        8.<copy>
            该属性用于文件或文件集的拷贝，其属性如下。
            file 表示源文件。
            tofile 表示目标文件。
            todir 表示目标目录。
            overwrite 表示指定是否覆盖目标文件，默认值是不覆盖。
            includeEmptyDirs 表示制定是否拷贝空目录，默认值为拷贝。
            failonerror 表示指定如目标没有发现是否自动停止，默认值是停止。
    
## 相关网址
    Apache-Ant官网 https://ant.apache.org/
