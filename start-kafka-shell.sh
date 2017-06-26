#!/bin/bash
CURR_FOLDER=${PWD##*/}
NETWORK_NAME=${CURR_FOLDER//-}_default
HOST_NETWORK=${1:-$NETWORK_NAME} 
BRIDGE_IP=$(docker network inspect -f '{{range .IPAM.Config}}{{.Gateway}}{{end}}' $HOST_NETWORK)
echo "Network name: $HOST_NETWORK"
echo "IP: $BRIDGE_IP"
docker run --rm -v /var/run/docker.sock:/var/run/docker.sock -e HOST_IP=$BRIDGE_IP -e ZK=$BRIDGE_IP:2181 -i -t wurstmeister/kafka /bin/bash
