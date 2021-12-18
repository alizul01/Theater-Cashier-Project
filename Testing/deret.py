import matplotlib.pyplot as plt
import numpy as np
import seaborn as sns

sns.set()

def a(n):
    hasil = 6 - 3 * n
    return hasil
def b(n):
    hasil = 3 + 5 * n
    return hasil
def c(n):
    hasil = 7 * n - 2
    return hasil
def d(n):
    hasil = 4 * n + 5
    return hasil
def e(n):
    hasil = 22 - 9 * n
    return hasil

def main():
    for i in range (1, 4, 1):
        print(i)
        print("1. ", a(i))
        print("2. ", b(i))
        print("3. ", c(i))
        print("4. ", d(i))
        print("5. ", e(i))
main()