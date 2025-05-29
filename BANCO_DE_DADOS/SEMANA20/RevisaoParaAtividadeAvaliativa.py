import numpy as np
import matplotlib.pyplot as plt
def questao23():
    x= [1, 2, 3, 4, 5] 
    y = [2, 6, 12, 20, 30]
    matriz_x= np.zeros((len(x), 3))
    x_t=np.zeros((3,len(x)))
    for i in range(len(x)):
        for j in range(3):
            if (j==0):
                matriz_x[i][j]= x[i]*x[i]
                x_t[j][i]=matriz_x[i][j]
            if (j==1):
                matriz_x[i][j]= x[i]
                x_t[j][i]=matriz_x[i][j]
            if (j==2):
                matriz_x[i][j]=1
                x_t[j][i]=matriz_x[i][j]
    matriz_x= np.array(matriz_x)
    x_t=np.array(x_t)
    parte1_inv = np.linalg.inv(np.matmul(x_t,matriz_x))
    parte_2=np.matmul(x_t,y)
    teta=np.matmul(parte1_inv,parte_2)
    x=np.array(x)
    novo_y= ((x*x)*teta[0]) +(x*teta[1])+ (teta[2])
    print(teta)
    plt.scatter(x,y, color='b', marker='.', label='Pontos Originais')
    plt.plot(x,novo_y, color='r', label='Regressão Polinomial de ordem 2')
    plt.xlabel('X')
    plt.ylabel('Y')
    plt.title('Regressão Polinomial de ordem 2')
    plt.grid(True)
    plt.show()
def questao33():
    x = [1, 2, 3, 4, 5]
    y = [2, 6, 12, 20, 30] 
    matriz_x= np.zeros((len(x), 4))
    x_t=np.zeros((4,len(x)))
    for i in range(len(x)):
        for j in range(3):
            if (j==0):
                matriz_x[i][j]= x[i]*x[i]*x[i]
                x_t[j][i]=matriz_x[i][j]
            if (j==1):
                matriz_x[i][j]= x[i]*x[i]
                x_t[j][i]=matriz_x[i][j]
            if (j==2):
                matriz_x[i][j]=x[i]
                x_t[j][i]=matriz_x[i][j]
            if (j==3):
                matriz_x[i][j]=1
                x_t[j][i]=matriz_x[i][j]
    print(matriz_x)
    matriz_x= np.array(matriz_x)
    x_t=np.array(x_t)
    parte_1=np.matmul(x_t,matriz_x)
    print(parte_1)
    parte1_inv = np.linalg.pinv(parte_1)
    parte_2=np.matmul(x_t,y)
    teta=np.matmul(parte1_inv,parte_2)
    x=np.array(x)
    novo_y= ((x*x*x)*teta[0]) +(x*x*teta[1])+ (x*teta[2]) +teta[3]
    print(teta)
    plt.scatter(x,y, color='b', marker='.', label='Pontos Originais')
    plt.plot(x,novo_y, color='r', label='Regressão Polinomial de ordem 2')
    plt.xlabel('X')
    plt.ylabel('Y')
    plt.title('Regressão Polinomial de ordem 2')
    plt.grid(True)
    plt.show()
questao33()