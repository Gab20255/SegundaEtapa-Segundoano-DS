#biblioteca que remove caractereaabss estranhos do teXto
import re 
import pandas as pd
#Fazer contagem de valores, palavras e agrupa-las
from collections import defaultdict

#fazer a comparação entre os pares de texto
import itertools

# bibliotec pra poder escrever nos arquivos
import csv

#biblioteca de contagem de palavras
from collections import Counter

#biblioteca de funções de cauculos matemáticos
import numpy as np
#Faz o texto ficar em minúsculo
with open(r'C:\Users\gabri\OneDrive\Área de Trabalho\DesenvolvimentodeSoftware2\BIC\ARQUIVOS\Textos_bic.txt', 'r',  encoding='utf-8') as d:
    texto_bruto= d.read()
texto_bruto= texto_bruto.lower()

#Limpa o texto de caractéres especiais e deixa apenas números, letras e espaços, percorrendo em um for o texto e o filtrando com o join(junta as palavras filtradas com ' ')
texto_tratado=''.join(i for i in texto_bruto if i.isalnum() or i.isspace())
#escreve um arquivo com os textos tratados
with open(r'C:\Users\gabri\OneDrive\Área de Trabalho\DesenvolvimentodeSoftware2\BIC\ARQUIVOS\Textos_bictratados2.txt', 'w',  encoding='utf-8') as d1:
    d1.write(texto_tratado)
palavras= texto_tratado.split()
palavras_unicas= list(set(palavras))
quantidade_de_palavras_unicas= len(palavras_unicas)
#Faz com que se crie uma lista dos textos
lista_dos_textos = texto_tratado.strip().split('\n\n\n')
contagempalavras= np.zeros(quantidade_de_palavras_unicas)
for i in range(quantidade_de_palavras_unicas):
    for j in (lista_dos_textos):
        if palavras_unicas[i] in j:
            contagempalavras[i]= contagempalavras[i]+1

matriz_contagem_de_palavras_por_texto = []
palavras_unicas_filtradas = []

for i in range(quantidade_de_palavras_unicas):
    if contagempalavras[i] > 100:
        continue
    if contagempalavras[i] == 1:
        continue
    if len(palavras_unicas[i]) < 3:
        continue
    if palavras_unicas[i].isnumeric():
        continue
    matriz_contagem_de_palavras_por_texto.append([palavras_unicas[i], contagempalavras[i]])
    palavras_unicas_filtradas.append(palavras_unicas[i])


nome_textos= []
lista_textos_filtrados = []
for texto in lista_dos_textos:
    palavras1 = texto.split()
    if palavras1:  # Evita erro se o texto estiver vazio
        nome_textos.append(palavras1[0])
        filtradas = [p for p in palavras1 if p in palavras_unicas_filtradas]
        texto_limpo = set(filtradas)  # Conjunto para usar com Jaccard
        lista_textos_filtrados.append(texto_limpo)

# Cálculo da matriz de similaridade de Jaccard
total_textos = len(lista_textos_filtrados)
matriz_jaccard = np.zeros((total_textos, total_textos))

for i, j in itertools.combinations(range(total_textos), 2):
    intersecao = len(lista_textos_filtrados[i] & lista_textos_filtrados[j])
    uniao = len(lista_textos_filtrados[i] | lista_textos_filtrados[j])
    jaccard = intersecao / uniao if uniao != 0 else 0
    matriz_jaccard[i][j] = jaccard
    matriz_jaccard[j][i] = jaccard

# Diagonal principal = 1
for i in range(total_textos):
    matriz_jaccard[i][i] = 1.0
with open(r'C:\Users\gabri\OneDrive\Área de Trabalho\DesenvolvimentodeSoftware2\BIC\ARQUIVOS\matriz_jaccard.csv', 'w', newline='', encoding='utf-8') as arquivo_csv:
    escritor = csv.writer(arquivo_csv)

    # Escrever o cabeçalho
    escritor.writerow([''] + nome_textos)

    # Escrever cada linha da matriz com o nome do texto no início
    for nome, linha in zip(nome_textos, matriz_jaccard):
        escritor.writerow([nome] + [round(valor, 4) for valor in linha])

matriz_julio = np.zeros((total_textos, len(palavras_unicas_filtradas)), dtype=int)
for j in range(len(lista_textos_filtrados)):
    texto = lista_textos_filtrados[j]  # Pega o texto atual
    for i in range(len(palavras_unicas_filtradas)):
        if( palavras_unicas_filtradas[i] in texto ):
            matriz_julio[j][i]=1
import csv

with open(r'C:\Users\gabri\OneDrive\Área de Trabalho\DesenvolvimentodeSoftware2\BIC\ARQUIVOS\matriz_julio.csv', 'w', newline='', encoding='utf-8') as arquivo_csv:
    escritor = csv.writer(arquivo_csv)

    # Escreve o cabeçalho com as palavras únicas
    escritor.writerow(['Texto'] + palavras_unicas_filtradas)

    # Escreve cada linha: índice ou nome do texto + presença das palavras
    for i in range(total_textos):
        escritor.writerow([nome_textos[i]] + list(matriz_julio[i]))

with open(r'C:\Users\gabri\OneDrive\Área de Trabalho\DesenvolvimentodeSoftware2\BIC\ARQUIVOS\palavras_filtradas.csv', 'w', newline='', encoding='utf-8') as arquivo_csv:
    escritor = csv.writer(arquivo_csv)

    # Escreve o cabeçalho
    escritor.writerow(['Palavra', 'Contagem'])

    # Escreve cada palavra e sua contagem
    for linha in matriz_contagem_de_palavras_por_texto:
        escritor.writerow(linha)
