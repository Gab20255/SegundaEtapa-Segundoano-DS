import numpy as np
import matplotlib.pyplot as plt
def questao01():
    t=[ 5, 7, 12, 16, 20]
    m=[40, 120, 180, 210, 240]
    som_t=0
    som_m=0
    for i in range(len(t)):
        som_t=t[i]+som_t
        som_m=m[i]+som_m
    som_minv= som_m/len(m)
    som_tinv= som_t/len(t)
    r1=np.zeros((5))
    r2=np.zeros((5))
    for i in range(len(t)):
        r1[i]=t[i]-som_tinv
        r2[i]=m[i]-som_minv  
    r3=r1*r2
    r4=r1*r1
    som_r3=0
    som_r4=0
    for i in range(len(t)):
        som_r3=r3[i]+som_r3
        som_r4=r4[i]+som_r4
    a=som_r3/som_r4
    b=som_minv- a*som_tinv
    t= np.array(t)
    novo_m= a*t+b
    plt.scatter(t,m, color='b', marker='.', label='Pontos Originais')
    plt.plot(t,novo_m, color='r', label='Regressão Polinomial de ordem 2')
    plt.xlabel('X')
    plt.ylabel('Y')
    plt.title('Regressão Polinomial de ordem 2')
    plt.grid(True)
    plt.show()
def questao11():
    x=[1,2,3,4,5]
    y=[2,4,9,16,25]
    x=np.array(x)
    matriz_x=np.zeros((len(x), 3))
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
    matriz_x=np.array(matriz_x)
    x_t=np.array(x_t)
    y=np.array(y)
    parte_1=np.matmul(x_t,matriz_x)
    parte_1_inv=np.linalg.inv(parte_1)
    parte_2= np.matmul(x_t,y)
    teta=np.matmul(parte_1_inv, parte_2)
    print(f"{teta[0]}x²+ {teta[1]}x +{teta[0]}")
    novo_y= (teta[0]*(x*x)) + (teta[1]*x) + teta[2]
    print(novo_y)
    plt.scatter(x,y, color='b', marker='.', label='Pontos Originais')
    plt.plot(x,novo_y, color='r', label='Regressão Polinomial de ordem 2')
    plt.xlabel('X')
    plt.ylabel('Y')
    plt.title('Regressão Polinomial de ordem 2')
    plt.grid(True)
    plt.show()
    erro_e= y-novo_y
    erro_m= np.sum(erro_e)/len(erro_e)
    print(erro_m)
    plt.scatter(x,erro_e, color='b', marker='.', label='erro')
    plt.xlabel('X')
    plt.ylabel('Y')
    plt.title('Regressão Polinomial de ordem 2')
    plt.grid(True)
    plt.show()

    
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
questao01()