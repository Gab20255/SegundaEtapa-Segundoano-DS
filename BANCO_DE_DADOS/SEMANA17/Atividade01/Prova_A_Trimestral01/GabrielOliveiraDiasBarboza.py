import numpy as np
import matplotlib.pyplot as plt

dados01 = np.loadtxt(r'BANCO_DE_DADOS\SEMANA17\Atividade01\Prova_A_Trimestral01\RT.dat')
dados02 = np.loadtxt(r'BANCO_DE_DADOS\SEMANA17\Atividade01\Prova_A_Trimestral01\capacitor01.dat')
def questao01():
    r= dados01[:,0]
    t= dados01[:,1]
    coef=np.polyfit(r, t, 4)
    funcao= np.poly1d(coef)
    plt.figure(1)
    plt.scatter(r, t, marker='d', color='b', label='Pontos Originais')
    plt.plot(r, funcao(r), color='r', label=f"Polinomio que aproxime a relacao T = f(R), Grau 4:{funcao}")
    plt.title('Termistores NTC')
    plt.ylabel('Temperatura( C °)')
    plt.xlabel('Resistência(K ohm)')
    plt.grid(True)
    plt.show()
    y= 1/(t+273.15)
    x= np.log(r)
    C, i, B, A=np.polyfit(x, y,3)
    novo_t2=(1/(A+B*x+(C*x*x*x)))-273.15
    plt.figure(2)
    plt.scatter(r, t, marker='d', color='b', label='Pontos Originais')
    plt.plot(r, novo_t2, color='r', label='Equação encontrada aproximada com regressão não linear')
    plt.title('Termistores NTC')
    plt.ylabel('Temperatura( C °)')
    plt.xlabel('Resistência(K ohm)')
    plt.grid(True)
    plt.show()
    err=np.abs(t-novo_t2)
    plt.figure(3)
    plt.scatter(r, err, color='r', label='Erro')
    plt.title('Termistores NTC')
    plt.ylabel('Temperatura( C °)')
    plt.xlabel('Resistência(K ohm)')
    plt.grid(True)
    plt.show()
def questao02():
    t= dados02[:,0]
    mv= dados02[:,1]
    print(len(t))
    lny= np.log(mv)
    r, lnV0= np.polyfit(t, lny, 1)
    V0= np.exp(lnV0)
    novo_mv= V0*np.exp(t*r)
    plt.plot(t, novo_mv,color= 'r', label='Função Ajustada')
    plt.scatter(t, mv, color='b', marker='.', label='Pontos Originais')
    plt.title('Capacitor sendo descarregado')
    plt.ylabel('Tensão (mv)')
    plt.xlabel('Tempo (segundos)')
    plt.grid(True)
    plt.show()
    err= np.abs(mv-novo_mv)
    plt.figure(2)
    plt.scatter(t, err,color= 'r', label='Função Ajustada')
    plt.title('Erro')
    plt.ylabel('Tensão (mv)')
    plt.xlabel('Tempo (segundos)')
    plt.grid(True)
    plt.show()
    print(V0)
    r=-1/r
    print(r)
while(True):
    op=int(input("Digte qual questão de python você quer executar? 1 OU 2?\n"))
    if(op==1):
        questao01()
    if(op==2):
        questao02()
    continuar=int(input("Deseja executar mais uma questão? 1 para sim e dois para não\n"))
    if(continuar==2):
        break
