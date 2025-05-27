import numpy as np
import matplotlib.pyplot as plt

# Dados
t = []
t.append(0)
for i in range(21):
    if i != 0:
        t.append(t[i - 1] + 0.2)

v = []
for i in range(21):
    v.append(1 * (1 - np.exp(-t[i] / 5)))

# Plot dados originais
plt.scatter(t, v, color='b', marker='.', label='Pontos Originais')
plt.title('Capacitor sendo carregado')
plt.ylabel('Tensão (V)')
plt.xlabel('Tempo (segundos)')
plt.grid(True)
plt.legend()
plt.show()

# Converter para numpy arrays
v = np.array(v)
t = np.array(t)

# Linearização correta
y = -np.log(1 - v / 1)  # V0 = 1

# Somatórios para regressão
sig_x = np.sum(t)
sig_y = np.sum(y)
sig_xy = np.sum(t * y)
sig_xx = np.sum(t * t)
n = len(t)

# Cálculo do coeficiente angular (r) e intercepto (b)
r = (n * sig_xy - sig_x * sig_y) / (n * sig_xx - sig_x**2)
b = (sig_y - r * sig_x) / n

# Estimativa de tau
tau = 1 / r

print(f"Coeficiente angular (1/τ): {r:.4f}")
print(f"Intercepto (b): {b:.4f} (deveria ser próximo de 0)")
print(f"Estimativa de τ: {tau:.4f} segundos")

# Reconstrução da curva com parâmetros estimados
V0 = 1  # assumimos conhecido, pois linearizamos com V0 fixo
novo_v = V0 * (1 - np.exp(-r * t))

# Plot comparativo
plt.scatter(t, v, color='b', marker='.', label='Dados originais')
plt.plot(t, novo_v, color='r', label='Ajuste pela regressão')
plt.title('Ajuste da curva de carga do capacitor')
plt.ylabel('Tensão (V)')
plt.xlabel('Tempo (s)')
plt.grid(True)
plt.legend()
plt.show()
print(tau)


