# language: pt
Funcionalidade: Calculadora de IRPF

	Esquema do Cenario: 
		Dado Eu recebo R$ <Salario> de salario
		E Eu possuo <Dependentes> dependente		
		E Eu pago R$ <Pensao> de pensao
		Entao Eu devo pagar  R$ <INSS> de INSS
                E Eu devo pagar R$ <IRPF> de IRPF

Exemplos:
	| Salario | Dependentes | Pensao  | INSS   | IRPF   |
	| 1000,00 | 0 		| 0,00    | 80,00  | 0,00   |
        | 2500,00 | 0 		| 0,00    | 275,00 | 24,08  |
        | 3500,00 | 0 		| 0,00    | 385,00 | 112,45 |
        | 4500,00 | 0 		| 0,00    | 495,00 | 265,00 |
        | 5500,00 | 0 		| 0,00    | 513,01 | 502,06 |
