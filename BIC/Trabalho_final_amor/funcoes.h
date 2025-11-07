#ifndef FUNCOES_H
#define FUNCOES_H

#include "struct.h"

void SortearPersonagens(Jogador *player);
void CadastrarJogador(Jogador jogadores[4]);
void exibirPapel(Jogador player);
void preencherConfiguracao(Jogador jogadores[4], Configuracao *config);
void salvarConfiguracao( Configuracao config);


#endif