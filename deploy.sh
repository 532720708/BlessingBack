#!/usr/bin/env bash
cd `dirname $0`

# 回滚
roll="0"
if [ "$1" == "1" ];then
    roll="1"
fi

../../axj-cli/mnt/mng/deploy.sh plt plt-admin/target/plt-admin-0.1.jar $roll 22222 139.224.149.225