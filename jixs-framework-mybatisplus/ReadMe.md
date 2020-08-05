文件生成方式
1、mybaitisplus插件
    
    terminal窗口进入到jixs-framework-mybatisplus工程
    执行mvn mp:code 即可生成
    mvn mp:code -debug 以debug方式启动
    mvn mp:code -e 可以查看异常信息
    
    xml文件没有jdbctype类型
    
2、按照tkmybatis.方式生成

    mapper接口继承类改成com.baomidou.mybatisplus.core.mapper.BaseMapper
    pojo注解修改
   