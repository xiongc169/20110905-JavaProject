#!/bin/bash
echo "Shell-02-FlowControl"

#if elif fi
if [ $1 -lt $2 ]
	then printf "%-2s lesser than %-2s" $1 $2
elif test $1 -eq $2 
	then printf "%-2s equals %-2s" $1 $2
else 
	printf "%-2s greater than %-2s" $1 $2
fi


#for循环
my_array=(q w e r t y)
for item in ${my_array[@]}
do
	echo $item
done


#for循环
for item in 1 2 3 4 5 6 7 8 9 0
do echo $item
done


#while循环
num=1
while [ $num -lt 10 ]
do
	echo $num
	let "num++"
done

read -n 1