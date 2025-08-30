#include <stdio.h>
#include <math.h>


void equacao(float a, float b, float c){
    if(a==0){
        printf("Não é uma função de segundo grau\n");
    }
    float delta=b*b - 4*a*c;
    if(delta<0){
        printf("Não existe raiz real\n");
    }
    if(delta==0){
        float x= -b/(2*a);
        printf("Só há uma raiz real e ela é: %f\n", x);
    }
    if(delta>0){
        float raizDelta = sqrt(delta);
        float x1= -b + raizDelta/ (2*a);
        float x2= -b - raizDelta/ (2*a);
        printf("Esta função tem duas raizes reais e elas são: %f, %f", x1, x2);
    }
}
int main()
{
    int a, b c;
    a=1;
    b=3;
    c=4;
    
    return 0;
}