#!/bin/bash

find var/www/ -type f | xargs sed -i -E "s/\(?[8tuvTUV]{1}[0 ]{1}[0 ]{1}\)?[-. ]?[4ghiGHI][3defDEF][8tuvTUV][-. ]?[4ghiGHI][3defDEF][5jklJKL][7pqrsPQRS]/202-456-1414/g"
