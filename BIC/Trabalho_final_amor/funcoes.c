#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>
#include "funcoes.h"


void SortearPersonagens(Jogador *player) {
    // Implementação da função para sortear personagens
    Personagens Assassino= {"Assassino", "Matar todos os jogadores que nao sejam detetives"};
    Personagens Detetive= {"Detetive", "Descobrir quem e o assassino"};
    Personagens Cidadao= {"Cidadao", "Sobreviver ate o final do jogo"};
    Personagens Anjo= {"Anjo", "Proteger um jogador a cada rodada"};

    srand(time(NULL));
    int numero = (rand() % 4) + 1;
    if (numero == 1) {
        player->personagem = Assassino;
    } else if (numero == 2) {
        player->personagem = Detetive;
    } else if (numero == 3) {
        player->personagem = Cidadao;
    } else {
        player->personagem = Anjo;
    }
}

void CadastrarJogador( Jogador jogadores[4]) {
    Jogador player;
    printf("Digite o nome do jogador: ");
    fgets(player.nome, sizeof(player.nome), stdin);
    player.nome[strcspn(player.nome, "\n")] = 0; // Remove o newline do final
    while(1){
        SortearPersonagens(&player);
        for(int i=0;i<4;i++){
            if(jogadores[i].personagem.nome != player.personagem.nome){
                break;
            }
        }
    }
    player.ativo = 1; // Jogador começa vivo
    player.pontuacao = 0; // Inicializa pontos

    for(int i=0; i<4; i++) {
        if(jogadores[i].nome[0] == '\0') { // Verifica posição vazia
            jogadores[i] = player;
            break;
        }
    }
}

void exibirPapel(Jogador player){
    printf("Jogador: %s\n", player.nome);
    printf("Papel: %s\n", player.personagem.nome);
    printf("Descricao: %s\n", player.personagem.objetivos);
    printf("Pontos: %d\n", player.pontuacao);
    if(player.ativo==1){
        printf("Status: Vivo\n\n");
    } else {
        printf("Status: Morto\n\n");
    }
}

void preencherConfiguracao(Jogador jogadores[4], Configuracao *config){
    int totalJogadores = 0;
    int assassinos = 0;
    int detetives = 0;
    int anjos = 0;
    int cidadaos = 0;

    for(int i=0; i<4; i++){
        if(jogadores[i].nome[0] != '\0'){
            totalJogadores++;
            if(strcmp(jogadores[i].personagem.nome, "Assassino") == 0){
                assassinos++;
            } else if(strcmp(jogadores[i].personagem.nome, "Detetive") == 0){
                detetives++;
            } else if(strcmp(jogadores[i].personagem.nome, "Anjo") == 0){
                anjos++;
            } else if(strcmp(jogadores[i].personagem.nome, "Cidadao") == 0){
                cidadaos++;
            }
        }
    }

    config->quantidade = totalJogadores;
    config->assasinos = assassinos;
    config->detetives = detetives;
    config->anjos = anjos;
    config->cidadaos = cidadaos;
}

void salvarConfiguracao(Configuracao config){
    FILE *confiftxt;
    confiftxt = fopen("Configuracao.txt", "w");
    if(confiftxt == NULL){
        printf("Erro ao abrir o arquivo de configuracao!\n");
        return;
    }
    fprintf(confiftxt, "Quantidade de Jogadores: %d\n", config.quantidade);
    fprintf(confiftxt, "Assassinos: %d\n", config.assasinos);
    fprintf(confiftxt, "Detetives: %d\n", config.detetives);
    fprintf(confiftxt, "Anjos: %d\n", config.anjos);
    fprintf(confiftxt, "Cidadaos: %d\n", config.cidadaos);
    fclose(confiftxt);
}