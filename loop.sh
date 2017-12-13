#!/bin/bash

counter=1
while [ $counter -le 10000 ]
do
	echo $counter
        ((counter++))
	curl http://localhost:8080
        sleep 1
done

echo All done
