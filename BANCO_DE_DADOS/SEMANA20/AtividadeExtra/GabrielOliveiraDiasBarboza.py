import numpy as np
import matplotlib.pyplot as plt
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
            for k in range(len(x)): 
                xt_x[i][j] += matriz_x[k][i] * matriz_x[k][j]
    teta=np.linalg.inv(xt_x)@ matriz_x_t @ y
    return teta

dados01 = np.loadtxt(r'C:\Users\gabri\OneDrive\Área de Trabalho\DesenvolvimentodeSoftware2\BANCO_DE_DADOS\SEMANA20\AtividadeExtra\CrescimentoExponencialJuros.dat')
dados02= np.loadtxt(r'C:\Users\gabri\OneDrive\Área de Trabalho\DesenvolvimentodeSoftware2\BANCO_DE_DADOS\SEMANA20\AtividadeExtra\ComESemRuido.dat')
def questao11():
    x=dados02[:,0]
    y_semruido=dados02[:,1]
    y_comruido=dados02[:,2]
    coeficientes_sem=np.polyfit(x, y_semruido,5)
    coeficientes_com=np.polyfit(x, y_comruido,5)
    funcao_sem= np.poly1d(coeficientes_sem)
    funcao_com= np.poly1d(coeficientes_com)
    print(funcao_sem)
    print(funcao_com)
    teta_com=Ajustepolinomialgeral(x, y_comruido, 3)
    teta_com_reta= Ajustepolinomialgeral(x, y_comruido,1 )
    novo_y_com= teta_com_reta[0] + x*teta_com_reta[1]
    print(teta_com_reta)
    plt.plot(x, novo_y_com, color='r')
    plt.scatter(x, y_comruido,marker='d', color='b', label="Pontos Originais")
    plt.title('Crescimento do Ativo')
    plt.xlabel('Tempo em anos')
    plt.ylabel('Valor Obtido dos Juros')
    plt.grid(True)
    plt.legend()
    plt.show()
def questao12():
    tempo= dados01[0,:]
    valor= dados01[1,:]
    plt.scatter(tempo, valor, marker='d', color='b', label='Pontos Originais')
    plt.title('Crescimento do Ativo')
    plt.xlabel('Tempo em anos')
    plt.ylabel('Valor Obtido dos Juros')
    plt.grid(True)
    plt.legend()
    plt.show()
    ln_v= np.log(valor)
    constantes=Ajustepolinomialgeral(tempo, ln_v, 1)
    ln_a0=constantes[0]
    print(ln_a0)
    r=constantes[1]
    a0= np.exp(ln_a0)
    novo_valor_ajustado= a0 *np.exp(r*tempo)
    
    plt.plot(tempo, novo_valor_ajustado, color='r', label=f"A0={a0} r={r}")
    plt.scatter(tempo, valor,marker='d', color='b', label="Pontos Originais")
    plt.title('Crescimento do Ativo')
    plt.xlabel('Tempo em anos')
    plt.ylabel('Valor Obtido dos Juros')
    plt.grid(True)
    plt.legend()
    plt.show()
while(True):
    op=int(input("Digte qual questão de python você quer executar? 1 OU 2?\n"))
    if(op==1):
        questao11()
    if(op==2):
        questao12()
    continuar=int(input("Deseja executar mais uma questão? 1 para sim e dois para não\n"))
    if(continuar==2):
        break
