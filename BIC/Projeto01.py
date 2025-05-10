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

#abrir o arquivo nas específicas pastas do pc do gabriel, selecionar o modo de leitura, O encoding='utf-8' garante que caracteres especiais (ç, ã, é)
#acessando isso com o nome de arquivo entrada para organizar.
caminho_absoluto = input("Digite o caminho absoluto do arquivo de textos: ")

# Corrigir barras invertidas em sistemas Windows com uma string bruta
with open(caminho_absoluto, 'r', encoding='utf-8') as arquivo_entrada:

#colocar tudo na variável dados e ler
        dados = arquivo_entrada.read()

#pegar a variável dados e deixar todas minúsculas;
#                                              |
#substituir os caracteres removidos por nada   |
#                                 |            |
#remover todos os sinais de pontuação,         |
# mas manter as letras e os espaços(\s)        |        
#                        |        |            |        
#colocar tudo dentro dados limpo  |            |   
#    |                   |        |            |
#    v                   v        v            v
dados_limpo = re.sub(r'[^a-z\s0-9]', ' ', dados.lower())

#pega a variável palavras que é o resultado de todas as palavras de todos os textos separando em variáveis diferentes
palavras = dados_limpo.split()

#A função set Seleciona para colocar na lista oficial apenas palavras que não se repetem
palavras_unicas = list(set(palavras))
quantidade_de_palavras = len(palavras_unicas)

#abrir o arquivo nas mesma pasta que guarda o código, selecionar o modo de escrever, O encoding='utf-8' garante que caracteres especiais (ç, ã, é)
#sejam escritos corretamente, eacessando isso com o nome de arquivo saída para organizar.
with open(r'C:\Users\gabri\OneDrive\Área de Trabalho\DesenvolvimentodeSoftware2\BIC\ARQUIVOS\Textos_bictratados.txt', 'w', encoding='utf-8') as arquivo_saida:

#descarregar tudo do arquivo saída dentro do arquivo txt
    arquivo_saida.write(dados_limpo)

#fazer uma lista com o textos todos do arquivo, que são separados por 3 espaços e colocar cada texto inteiro em um lugar da matriz
lista_dos_textos = dados_limpo.split('\n\n\n')

#Remove os espaços em branco e quebras de linha extras que estão na string (tipo 4 espaços ou quebra de linha seguidos) e coloca em lista dos textos
lista_dos_textos = [t.strip() for t in lista_dos_textos]

# Dicionário para contar em quantos textos cada palavra aparece
contador_palavras = defaultdict(int)

#fazer um for que conta o nomero de palavras de todos os textos
for palavra in palavras_unicas:
    contador_palavras[palavra] += 1

#criar a veriável palavras filtradas 
palavras_filtradas = {}

#criar a variável q sabe o total de  textos
total_textos = len(lista_dos_textos)

#a função .itens retorna a chave e o valor do dicionário que atribuido pela variável contagem
for palavra, contagem in contador_palavras.items():

    # Mantém apenas palavras que NÃO aparecem em todos os textos
    #Se a palavra aparece em menos textos do que o total, então ela não está presente em todos
    if contagem < total_textos:  
        
        #Se a condição for verdadeira, a palavra é adicionada ao dicionário palavras_filtradas com sua respectiva contagem
        palavras_filtradas[palavra] = contagem

# Exibir algumas palavras com suas contagens
for palavra, ocorrencias in list(contador_palavras.items())[:20]:
    print(f"{palavra}: {ocorrencias}")

# Número total de palavras distintas contadas
#apenas exibir coisas
print(f"\nTotal de palavras únicas identificadas: {len(contador_palavras)}")   
print(total_textos)

#criar uma versão dos textos que contém apenas as palavras que não aparecem em todos os textos
textos_processados = []

for texto in lista_dos_textos:
    
    # Conjunto de palavras únicas, criadas pela função split(separou o texto em listas de palavras) e a função set eliminou as palavras repetidas
    palavras_no_texto = set(texto.split()) 

    #é um texto inteiro, então textos processados tem todos os textos
    palavras_filtradas_no_texto = palavras_no_texto.intersection(palavras_filtradas.keys())  # Remove palavras comuns

    #adicionar na variável o texto processado final
    textos_processados.append(palavras_filtradas_no_texto)

# Comparar todos os pares de textos e calcular Índice de Jaccard 
pares = itertools.combinations(range(len(textos_processados)), 2)  # Todos os pares possíveis
# Criar matriz quadrada de Jaccard com os nomes dos textos
nomes_textos = [f"Texto{i+1}" for i in range(total_textos)]

# Inicializar matriz com zeros
matriz_jaccard = [[0.0 for _ in range(total_textos)] for _ in range(total_textos)]

# Preencher a matriz com os valores de Jaccard já calculados
pares = itertools.combinations(range(total_textos), 2)


        

for i, j in pares:
    intersecao = len(textos_processados[i] & textos_processados[j])
    uniao = len(textos_processados[i] | textos_processados[j])
    jaccard = intersecao / uniao if uniao != 0 else 0
    matriz_jaccard[i][j] = jaccard
    matriz_jaccard[j][i] = jaccard

# Colocar 1.0 na diagonal principal (comparação de um texto com ele mesmo)
for i in range(total_textos):
    matriz_jaccard[i][i] = 1.0

# Escrever a matriz em CSV com os nomes dos textos como cabeçalho e índice
with open(r'C:\Users\gabri\OneDrive\Área de Trabalho\DesenvolvimentodeSoftware2\BIC\ARQUIVOS\matriz_jaccard.csv', 'w', newline='', encoding='utf-8') as arquivo_csv:
    escritor = csv.writer(arquivo_csv)

    # Escrever o cabeçalho
    escritor.writerow([''] + nomes_textos)

    # Escrever cada linha da matriz com o nome do texto no início
    for nome, linha in zip(nomes_textos, matriz_jaccard):
        escritor.writerow([nome] + [round(valor, 4) for valor in linha])



# Criação da lista de palavras filtradas
lista_palavras_filtradas = list(palavras_filtradas.keys())

# Inicializando a matriz com zeros
matriz_julio = [[0 for _ in range(total_textos)] for _ in range(len(palavras_filtradas))]


# Iterar sobre os textos
for j in range(total_textos):
    texto = lista_dos_textos[j]  # Pega o texto atual
    texto = texto.split()  # Divide o texto em palavras

    # Iterar sobre as palavras filtradas
    for i in range(len(lista_palavras_filtradas)):
        
        # Verifica se a palavra filtrada está na lista de palavras do texto
        if lista_palavras_filtradas[i] in texto:
            matriz_julio[i][j] = 1  # Marca a presença da palavra filtrada

# Escrever a matriz no arquivo CSV
with open(r'C:\Users\gabri\OneDrive\Área de Trabalho\DesenvolvimentodeSoftware2\BIC\ARQUIVOS\matriz_julio.csv', 'w', newline='', encoding='utf-8') as arquivo_csv:
    es = csv.writer(arquivo_csv)

    # Escrever o cabeçalho (primeira linha com palavras filtradas)
    es.writerow([''] + lista_palavras_filtradas)

    # Escrever as linhas da matriz
    for i in range(len(lista_palavras_filtradas)):
        # Escrever a palavra e a linha correspondente da matriz
        es.writerow([lista_palavras_filtradas[i]] + matriz_julio[i])
print()
with open(r'C:\Users\gabri\OneDrive\Área de Trabalho\DesenvolvimentodeSoftware2\BIC\ARQUIVOS\indices_jaccard_Textos.csv', 'w', newline='', encoding='utf-8') as arquivo_csv:
    escritor = csv.writer(arquivo_csv)
    escritor.writerow(["source,target,weight"])  # Cabeçalho do CSV

    for i, j in pares:
        intersecao = len(textos_processados[i] & textos_processados[j])  # Palavras em comum (A ∩ B)
        uniao = len(textos_processados[i] | textos_processados[j])  # Todas as palavras únicas (A ∪ B)
        
        jaccard = intersecao / uniao if uniao != 0 else 0  # Evita divisão por zero
        escritor.writerow([i+1, j+1, round(jaccard, 4)])  # Salva os resultados no CSV
        

print("Comparações concluídas! O arquivo 'indices_jaccard_190.csv' foi gerado.")
with open(r'C:\Users\gabri\OneDrive\Área de Trabalho\DesenvolvimentodeSoftware2\BIC\ARQUIVOS\palavras_filtradas.csv', 'w', newline='', encoding='utf-8') as arquivo_csv:
    escritor = csv.writer(arquivo_csv)
    
    # Escreve o cabeçalho da tabela
    escritor.writerow(['Palavra', 'Número de Textos'])
    
    # Escreve cada palavra e quantas vezes ela aparece
    for palavra, contagem in palavras_filtradas.items():
        escritor.writerow([palavra, contagem])

print("Arquivo 'palavras_filtradas.csv' criado com sucesso!")
                
                



