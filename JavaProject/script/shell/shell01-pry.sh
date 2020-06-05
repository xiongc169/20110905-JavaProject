#!/bin/bash
# #!是一个约定的标记，它告诉系统这个脚本需要什么解释器来执行，即使用哪一种 Shell。
echo "Hello World !"

#变量
var1=GoodMorning
var2="GoodAfternoon"
name=yoong

echo ${var1}
echo $var2

readonly ${var1}
unset ${var1}

#字符串
echo '1 Hello ${name}'
echo '2 Hello '${name}
echo "3 Hello ${name}"
echo ${#name}
echo ${name:2:2}
echo `expr index ${name} n`

#数组
my_array=(q w e r t y)
echo ${my_array[2]}
echo ${my_array[@]}
echo ${my_array[*]}
echo ${#my_array[@]}
echo ${#my_array[*]}


#传递参数
echo $0	#执行的文件名
echo $1


#运算符
sum=`expr 10 + 4`
sub=`expr 10 - 4`
mul=`expr 10 \* 4`
div=`expr 10 / 4`
mode=`expr 10 % 3`
echo ${sum}
echo ${sub}
echo ${mul}
echo ${div}
echo ${mode}

echo [ ${sum} == ${sum} ]
if [ ${sum} == ${sum} ]
then echo 'equals'
else echo 'not equals'
fi

if [ 100 -gt 99 ]
then echo 'gt'
else echo 'not gt'
fi

#文件测试运算符
if [ -x "D:\Github\test" ]
then echo "Executable"
else choe "Not Executable"
fi

if [ -e "D:\Github\test" ]
then echo "Exist"
else echo "Not Exist"
fi

if [ -d "D:\Github\test" ]
then echo "Directory"
else echo "Not Directory"
fi


#printf命令
# %s %c %d %f
printf '%-10s %-10s %-4s\n' 姓名 性别 体重
printf '%-10s %-10s %-4.2f\n' Name1 Sex1 11.1111
printf '%-10s %-10s %-4.2f\n' Name2 Sex2 22.2222


java -version
echo 继续运行


read -n 1
















