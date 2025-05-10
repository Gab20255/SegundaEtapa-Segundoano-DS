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
lista_dos_textos=texto_tratado.split('\n\n\n')
contagempalavras= np.zeros(quantidade_de_palavras_unicas)
for i in range(quantidade_de_palavras_unicas):
    for j in (lista_dos_textos):
        if palavras_unicas[i] in j:
            contagempalavras[i]= contagempalavras[i]+1
matriz_contagem_de_palavras_por_texto= []#matriz que armazenara as palavras filtradas
palavras_unicas_filtradas= []
nome_textos= []
nova_quantidade_de_palavras_unicas=0
for i in range(quantidade_de_palavras_unicas):
    if contagempalavras[i]>100 or contagempalavras[i]==1 or len(palavras_unicas[i])<3 or  palavras_unicas[i].isnumeric():
        contagempalavras[i]=0
    if contagempalavras[i]!=0:
        matriz_contagem_de_palavras_por_texto.append([palavras_unicas[i], contagempalavras[i]])
        nova_quantidade_de_palavras_unicas= nova_quantidade_de_palavras_unicas+1
        palavras_unicas_filtradas.append(palavras_unicas[i])
nome_textos= []
lista_textos_filtrados = []

for texto in lista_dos_textos:
    palavras = texto.split()  # quebra em palavras
    filtradas = [p for p in palavras if p in palavras_unicas_filtradas]
    texto_limpo = ' '.join(filtradas)
    lista_textos_filtrados.append(texto_limpo)
pares = itertools.combinations(range(len(lista_textos_filtrados)), 2)  # Todos os pares possíveis
total_textos= len(lista_textos_filtrados)
matriz_jaccard= np.zeros((total_textos, total_textos))
pares = itertools.combinations(range(total_textos), 2)
for i, j in pares:
    intersecao = len(lista_textos_filtrados[i] & lista_textos_filtrados[j])
    uniao = len(lista_textos_filtrados[i] | lista_textos_filtrados[j])
    jaccard = intersecao / uniao if uniao != 0 else 0
    matriz_jaccard[i][j] = jaccard
    matriz_jaccard[j][i] = jaccard

# Colocar 1.0 na diagonal principal (comparação de um texto com ele mesmo)
for i in range(total_textos):
    matriz_jaccard[i][i] = 1.0