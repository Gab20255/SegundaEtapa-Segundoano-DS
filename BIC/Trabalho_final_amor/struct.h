#ifndef STRUCTS_H
#define STRUCTS_H

typedef struct Personagens{
    char nome[100];
    char objetivos[100];
}Personagens;

typedef struct Jogador{
    char nome[100];
    Personagens personagem;
    int ativo;
    int pontuacao;
}Jogador;

typedef struct Configuracao{
    int quantidade;
    int assasinos;
    int detetives;
    int anjos;
    int cidadaos;
}Configuracao;

#endif