import numpy as np
import matplotlib.pyplot as plt

t= []
v=[]

for i in range(21):
    t[i]= i*5
    v[i]= 1*(1-np.exp(-t[i]/5))

with open