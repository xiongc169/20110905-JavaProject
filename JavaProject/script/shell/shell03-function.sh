#!/bin/bash

export -f printA

echo "Shell-03-Function"


#函数 1
function print(){
	printf "%s %s %f\n" print yoong 25
}
print

#函数 2
printA(){
	printf "%s %s %f\n" printA yoong2 26
}
printA

#函数 3
printB(){
	printf "%s %s %f\n" printA yoong2 26
	return 28
}
printB
echo $?

read -n 1