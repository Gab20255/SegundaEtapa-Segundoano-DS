import numpy as np
import matplotlib.pyplot as plt
dados01= np.loadtxt(r'C:\Users\gabri\OneDrive\Área de Trabalho\DesenvolvimentodeSoftware2\BANCO_DE_DADOS\ARQUIVOS\temperaturaPTC.dat')
dados02= np.loadtxt(r'C:\Users\gabri\OneDrive\Área de Trabalho\DesenvolvimentodeSoftware2\BANCO_DE_DADOS\ARQUIVOS\capacitor01.dat')
def questao01():
    t= dados01[0]
    r= dados01[1]
    print(len(r))
    print(len(t))
    ln_r=np.log(r)
    y, ln_A=np.polyfit(t, ln_r,1)
    A0= np.exp(ln_A)
    novo_r= A0*np.exp(t*y)
    plt.figure(1)
    plt.plot(t, novo_r, color='r', label='Regressão não linear')
    plt.scatter(t, r, marker='.', color='b', label='Pontos Originais')
    plt.title('Termistores PTC')
    plt.ylabel('Temperatura (celsius)')
    plt.xlabel('Resistência (Kohms)')
    plt.grid(True)
    plt.show()
    y= y/2
    print(y,A0)
def questao02():
    t = [22.769,35.195,42.716,53.052,69.672] 
    v = [0.8877,0.9646,1.5427,3.3842,5.0193]
    coef2=np.polyfit(t, v, 2)
    funcao2=np.poly1d(coef2)
    err2= v-funcao2(t)
    plt.figure(1)
    plt.plot(t, funcao2(t), color='Red', label=f"Ajuste de grau 2: {funcao2}")
    plt.scatter(t, v, marker='.', color='b', label='Pontos Originais')
    plt.title('Termistores PTC')
    plt.ylabel('Temperatura (celsius)')
    plt.xlabel('Resistência (Kohms)')
    plt.grid(True)
    plt.show()
    coef1=np.polyfit(t, v, 1)
    funcao1=np.poly1d(coef1)
    err1= v-funcao1(t)
    plt.figure(2)
    plt.plot(t, funcao1(t), color='Red', label=f"Ajuste de grau 1: {funcao1}")
    plt.scatter(t, v, marker='.', color='b', label='Pontos Originais')
    plt.title('Termistores PTC')
    plt.ylabel('Temperatura (celsius)')
    plt.xlabel('Resistência (Kohms)')
    plt.grid(True)
    plt.show()
    plt.figure(3)
    plt.subplot(1,2,1)
    plt.scatter(t, err2, marker='.', color='b', label='Erro da segunda equação')
    plt.title('Termistores PTC')
    plt.ylabel('Temperatura (celsius)')
    plt.xlabel('Resistência (Kohms)')
    plt.grid(True)
    plt.subplot(1,2,2)
    plt.scatter(t, err1, marker='.', color='b', label='Erro da primeira equação')
    plt.title('Termistores PTC')
    plt.ylabel('Temperatura (celsius)')
    plt.xlabel('Resistência (Kohms)')
    plt.grid(True)
    plt.show()
while(True):
    op=input("Digte qual questão de python você quer executar? 1 OU 2?")
    if(op==1):
        questao01()
    if(op==2):
        questao02()
    op=input("Deseja executar mais uma questão? 1 para sim e dois para não")
    if(op==2):
        break