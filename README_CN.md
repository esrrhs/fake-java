#fakescript 
轻量级嵌入式脚本语言

## 简介
**fakescript**是一款轻量级的嵌入式脚本语言，使用Java语言编写，语法吸取自lua、golang、erlang，基于jflex、cup生成语法树，编译成字节码解释执行。

## 脚本特性
* 语法类似lua
* 全部为函数
* 支持array，map，可以无限嵌套
* 支持fake testfunc(param1)产生routine，实现假多线程效果
* 支持C函数和类成员函数的绑定
* 自带解释器
* 支持多返回值
* 自带profile，可获取脚本各个函数运行时间
* 支持热更新
* 支持Int64
* 支持const定义
* 支持包
* 支持struct

## 产品应用
![d8f9d72a6059252d8aa6c584329b033b5ab5b9f9.jpg](https://bitbucket.org/repo/pAEqqM/images/870497708-d8f9d72a6059252d8aa6c584329b033b5ab5b9f9.jpg)[我是大主宰](http://dzz.youxi.com)
![9f510fb30f2442a71a9ae83ad443ad4bd013029c.jpg](https://bitbucket.org/repo/pAEqqM/images/3631286140-9f510fb30f2442a71a9ae83ad443ad4bd013029c.jpg)[天天炫斗](http://ttxd.qq.com/act/a20160419brandP/)

## 示例

```
#!lua


-- 当前包名
package mypackage.test

-- 引入的文件
include "common.fk"

-- 结构体定义
struct teststruct
	sample_a
	sample_b
	sample_c
end

-- 常量值
const hellostring = "hello"
const helloint = 1234
const hellomap = {1 : "a" 2 : "b" 3 : [1 2 3]}

-- func1 comment
func myfunc1(arg1, arg2)
	
	-- C函数和类成员函数的调用
	arg3 := cfunc1(helloint) + arg2:memfunc1(arg1)
	
	-- 分支
	if arg1 < arg2 then	
		-- 创建一个协程
		fake myfunc2(arg1, arg2)
	elseif arg1 == arg2 then	
		print("elseif")
	else
		print("else")
	end
	
	-- for循环
	for var i = 0, i < arg2, i++ then
		print("i = ", i)
	end
	
	-- 数组
	var a = array()
	a[1] = 3
	
	-- 集合
	var b = map()
	b[a] = 1
	b[1] = a
	
	-- Int64
	var uid = 1241515236123614u
	log("uid = ", uid)

	-- 子函数调用
	var ret1, var ret2 = myfunc2()

	-- 其他包的函数调用
	ret1 = otherpackage.test.myfunc1(arg1, arg2)
	
	-- 结构体
	var tt = teststruct()
	tt->sample_a = 1
	tt->sample_b = teststruct()
	tt->sample_b->sample_a = 10

	-- 分支
	switch arg1
		case 1 then
			print("1")
		case "a" then
			print("a")
		default
			print("default")
	end

	-- 多返回值
	return arg1, arg3
	
end
```

## Java示例

```
#!java
// 创建一个实例
fake f = fk.newfake(null);
// 注册包里全部标记@fakescript的函数
fkreg(f, "com.test");
// 解析fake脚本文件
fkparse(f, "test.fk");
// 执行myfunc1函数，传入两个参数分别为1和2
double ret = (double)fkrun(f, "myfunc1", 1, 2);

```

## 欢迎捐赠
![donation.png](https://bitbucket.org/repo/pAEqqM/images/2041212420-donation.png)

欢迎使用支付宝手扫描上面的二维码，对该项目进行捐赠。捐赠款项将用于改进fakescript性能以及后续持续优化。

