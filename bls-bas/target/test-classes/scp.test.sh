#!/usr/bin/env bash
cd `dirname $0`

cp -rf doc/img dist/

mkdir dist/rpc
cp -rf gen/* dist/rpc/

scp -P 22222 -r dist/* root@139.224.149.225:/opt/wshop/dist/apidoc/

