# Requirements
- Python 3.7.4
# Usage
```
./subnet.py -f <input filename> -o <output filename>
```
- If `-f` is not specified then `input` will be used as the default input file
- If `-o` is not specified then `output` will be used as the default output file
- Input file format: for each lines, first argument will be **the IP address as a string representation of a 32-bit unsigned int**, second argument will be **the string representation of a CIDR subnet**. Example:
```
0x62D2ED4B 98.210.237.192/26
0x62D2EDC5 98.210.237.192/26
```
- Output format example:
```
98.210.237.75 	 98.210.237.192/26 	 False
98.210.237.197 	 98.210.237.192/26 	 True
```
