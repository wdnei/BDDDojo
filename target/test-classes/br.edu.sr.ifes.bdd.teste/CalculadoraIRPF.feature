# language: pt
Funcionalidade: Calculadora de IRPF

	Cenario: Base calculo de ate R$ 1903,98
		Dado Eu recebo R$ 1000,00 de salario
		Entao Eu devo pagar R$ 0,00 de imposto
		
	Cenario: Base calculo entre R$ 1903,99 e R$ 2826,65
		Dado Eu recebo R$ 2500,00 de salario
		Entao Eu devo pagar R$ 24,08 de imposto
		
	Cenario: Base calculo entre R$ 2826,66 e R$ 3751,05
		Dado Eu recebo R$ 3500,00 de salario
		Entao Eu devo pagar R$ 112,45 de imposto
		
	Cenario: Base calculo entre R$ 3751,05 e R$ 4664,68
		Dado Eu recebo R$ 4500,00 de salario
		Entao Eu devo pagar R$ 265,00 de imposto
		
	Cenario: Base calculo a partir de R$ 4664,69
		Dado Eu recebo R$ 5500,00 de salario
		Entao Eu devo pagar R$ 502,06 de imposto