#!/bin/bash
#
#tester for intro. 
#

FILES=*.in
MAX_NO=0

if [ $# -ne 1 ]
then
   echo "use: %thisfile.sh [filename with no extension] "
   exit 1
fi
echo "tester for intro, compring output vs school solution"
echo "press enter to contiune"
read
echo "compling all *.java in folder"
javac *.java
#clear
echo "press enter to contiune"
read
echo "testing $1."
echo "all files in the form of *.in will be used as input."
echo "note: if a diffrence has been found. the loop will break. and not all the input files will be checked"
echo "press enter to contiune"
i=1
WORKPATH="~/tests"
	for f in $FILES
		do
   			echo "test number $i"

			# note: its possible to show the user input of every check . but there is no realy need for that
			# echo "input:"
			# cat $f 

			java $WORKPATH  $f > myout1
			~oop/for_students/school_solutions/ex1/ex1SchoolSolution
$WORKPATH  $f sout1
			echo "*****diff starts"
			#diff myout1 sout1
			if [ -n "$(diff myout1 sout1)" ]
				then
			   		 # files differ break loop
					diff myout1 sout1
					echo "breaking the loop.....diffrence has been found "
					echo "input file: " $f
					echo "myout: myout1"
					echo "school out: sout1"
					meld mysou1 sout1
			          	break 
 			fi
    
			echo "*****diff ends"
			echo "end checking input of $i times"
			i=`expr $i + 1`

		done

######################FINISH CHECKING#########################
echo "test finished"
###########################EOF################################
