# 个人整理工具类合集

> [Java分析器](https://www.ej-technologies.com/products/jprofiler/overview.html), ![](https://www.ej-technologies.com/images/product_banners/jprofiler_medium.png)

包含工具类如下：其中加粗为常用工具

- **BeanUtil**
对象映射工具，提供对象转换功能，如将UserPO转换为UserBO，减少开发者Setter/Getter的工作量
- CoordinateUtil
经纬度工具，计算两个经纬度之间的距离
- **DateUtil**
LocalDateTime工具类，对日期进行相关操作，包含与Date的转换，日期格式化，计算两个日期差，计算N天后的日期
- EmailUtil
邮件工具，配置信息后可进行邮件发送
- ExcelUtil
根据集合对象生产成Excel文件，或根据Excel读取对应的集合对象
- **ExceptionManager**
创建自定义异常,项目中会自动解析该异常Code，并获取对应异常message
- FileUtil
文件相关操作
- HexUtil
字节转换
- ImageUtil
图片操作，目前提供放大缩小功能
- **JsonUtil.java**
Json字符串与对象的相互转换，基于Gson封装
- **LogUtil**
日志打印工具，项目中统一使用该工具进行日志打印，方便日后进行统一调整更改
- BigDecimalUtil
提供各种类型和BigDecimal的转换，以及加减乘除运算（可指定精度）
- NumberUtil
大小端字节转换，int、short与byte数组的相互转换
- **MPPageUtil**
分页辅助工具，将PageParam与PageResult与MybatisPlus中的分页进行转换
- ChinesUtil
汉字拼音相关操作
- PropertiesUtil
Property文件读取操作
- RandomUtil
生成随机的数字或字符串
- ClassUtil
反射相关操作
- RegexUtil
正则判断工具，包含常用正则判断及正则匹配
- AESUtil
AES加解密
- Base64Util
Base64编码与解码
- **MD5Util**
MD5摘要算法，包含对字符串、文件的MD5计算和校验
- RSAUtil
RSA非对称加密
- SHAUtil
SHA1和SHA256摘要算法加密
- **SpringContextUtil**
Spring容器操作，可获取容器中的对象
- **SpringPropertyUtil**
获取Spring管理的属性
- **StringUtil**
字符串操作，包含判空、去除空格、截取、替换、首字母大小写等操作
- SystemUtil
获取系统相关信息
- ZipUtil
文件压缩与解压缩
