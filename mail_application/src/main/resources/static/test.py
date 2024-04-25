import math
import json
import sys
import cryptography

def calculatr(x):
    result=math.sqrt(x)
    return json.dumps({"result":result})

arg1=int(sys.argv[1])
x=calculatr(arg1)
print(x)