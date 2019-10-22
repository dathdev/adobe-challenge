#!/usr/bin/python

import sys
import getopt
import struct
import socket

optlist, args = getopt.getopt(sys.argv[1:], 'f:o:')

for opt, val in optlist:
    if opt == "-f":
        input = open(val, "r")
    elif opt == "-o":
        output = open(val, "w")

for line in input:
    ip_hex = line.split()[0]
    ip = [int(ip_hex[octet:octet+2],16) for octet in range(2, len(ip_hex), 2)]
    octets = [ip_hex[octet:octet+2] for octet in range(2, len(ip_hex), 2)]
    ip = [int(i,16) for i in octets]

    cidr = line.split()[1]
    sn_ip = cidr.split('/')[0].split('.')
    mask = cidr.split('/')[1]
    print(sn_ip)
    print(mask)

