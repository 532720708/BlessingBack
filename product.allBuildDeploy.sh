#!/usr/bin/env bash
cd `dirname $0`

args=$*

if [[ -z "$args" ]] || [[ $args =~ "1" ]];then
../../build.sh
fi

if [[ -z "$args" ]] || [[ $args =~ "2" ]];then
./build.sh
./product.deploy.sh
fi

if [[ $args =~ "4" ]];then
./shop-bas/target/test-classes/scp.test.sh
fi
