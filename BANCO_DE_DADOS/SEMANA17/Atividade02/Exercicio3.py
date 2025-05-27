import numpy as np
import matplotlib.pyplot as plt

t = []
t.append(0)
for i in range(21):
    if i != 0:
        t.append(t[i - 1] + 0.2)

v = []
for i in range(21):
    v.append(1 * (1 - np.exp(-t[i] / 5)))
with open(r'C:\Users\gabri\OneDrive\Área de Trabalho\DesenvolvimentodeSoftware2\BANCO_DE_DADOS\SEMANA17\Atividade02\capacitor2.txt', 'w', newline='', encoding='utf-8') as data:
    for i in range(len(t)):
        data.write(f"{t[i]:.2f}")
        data.write(' ')
        data.write(f"{v[i]:.2f}")
        data.write('\n')
plt.scatter(t, v, color='b', marker='.', label='Pontos Originais')
plt.title('Capacitor sendo carregado')
plt.ylabel('Tensão (V)')
plt.xlabel('Tempo (segundos)')
plt.grid(True)
plt.legend()
plt.show()
dados=np.loadtxt(r'C:\Users\gabri\OneDrive\Área de Trabalho\DesenvolvimentodeSoftware2\BANCO_DE_DADOS\SEMANA17\Atividade02\capacitor2.txt')
t=dados[:,0]
v=dados[:,1]



