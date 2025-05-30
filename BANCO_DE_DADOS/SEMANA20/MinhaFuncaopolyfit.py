import numpy as np
import matplotlib.pyplot as plt
t=[ 5, 7, 12, 16, 20]
m=[40, 120, 180, 210, 240]
def Ajustepolinomialgeral(x, y, grau):
    x=np.array(x)
    y=np.array(y)
    matriz_x= np.zeros((len(x),grau+1))
    matriz_x_t=np.zeros((grau+1,len(x)))
    xt_x=np.zeros((grau+1,grau+1))
    for i in range(len(x)):
        for j in range(grau+1):
            if(j==grau+1):
                matriz_x[i][j]=1
                matriz_x_t[j][i]=matriz_x[i][j]
            matriz_x[i][j]= pow(x[i],j)
            matriz_x_t[j][i]=matriz_x[i][j]
    for i in range(grau + 1):  
        for j in range(grau + 1):  
            for k in range(len(x)):  # ou len(matriz_x)
                xt_x[i][j] += matriz_x[k][i] * matriz_x[k][j]
    teta=np.linalg.inv(xt_x)@ matriz_x_t @ y
    return teta #b a