import numpy as np
import matplotlib.pyplot as plt
t =[]
t.append(0)
for i in range(21):
    if (i !=0):
        t.append(t[i-1]+0.2)
v=[]
v.append(1)
for i in range(21):
    if (i !=0):
        v.append(v[0]*(1-np.exp(-t[i]/5)))
with open(r'C:\Users\gabri\OneDrive\Área de Trabalho\DesenvolvimentodeSoftware2\BANCO_DE_DADOS\SEMANA17\Atividade02\capacitor2.txt', 'w', newline='', encoding='utf-8') as data:
    for i in range(len(t)):
        
