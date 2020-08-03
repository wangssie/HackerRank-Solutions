#https://www.hackerrank.com/challenges/luck-balance/problem?h_r=profile
#level: easy

import math
import os
import random
import re
import sys

# Complete the luckBalance function below.
def luckBalance(k, contests):
    luckBalance = 0 
    for luck,importance in sorted(contests, reverse = True):
        if k>0 or importance == 0:
            luckBalance += luck
            k-=importance
        else:
            luckBalance -= luck
    return luckBalance
