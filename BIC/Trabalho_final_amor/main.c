#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include "funcoes.h"

Jogador jogadores[4] = {0}; // Array para armazenar até 4 jogadores
Configuracao config = {0};
int main() {
    int opcao;

    while(1) {
        printf("1. Cadastrar Jogador\n");
        printf("2. Exibir Jogadores\n");
        printf("3. Sair\n");
        printf("Escolha uma opcao: ");
        scanf("%d", &opcao);
        while(getchar() != '\n'); // Limpar o buffer do teclado

        if(opcao == 1) {
            CadastrarJogador( jogadores);
        } else if(opcao == 2) {
            for(int i=0; i<4; i++) {
                if(jogadores[i].nome[0] != '\0') {
                    exibirPapel(jogadores[i]);
                }
            }
        } else if(opcao == 3) {
            break;
        } else {
            printf("Opcao invalida!\n");
        }
        preencherConfiguracao(jogadores, &config);

    }
    salvarConfiguracao(config);

    return 0;
}

