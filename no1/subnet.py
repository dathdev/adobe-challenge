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

try:
    input
except NameError:
    input = open("input", "r")

try:
    output
except NameError:
    output = open("output", "w")

for line in input:
    ip_hex = line.split()[0]
    ip_str = ".".join([str(int(ip_hex[octet:octet+2],16)) for octet in range(2, len(ip_hex), 2)])
    cidr = line.split()[1]
    sn_ip = cidr.split('/')[0]
    mask = cidr.split('/')[1]

    ip_num = int(ip_hex[2:], 16)
    sn_ip_num = struct.unpack("!I",socket.inet_aton(sn_ip))[0]
    mask_num = (0xffffffff >> (32 - int(mask))) << (32 - int(mask))
    print(ip_str, '\t', cidr, '\t', (sn_ip_num&mask_num == ip_num&mask_num))
    output.write(ip_str + '\t' + cidr + '\t' + str(sn_ip_num&mask_num == ip_num&mask_num) + '\n')
