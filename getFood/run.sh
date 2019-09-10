#!/bin/bash
echo " "
echo "-------------------------------------"
echo "  Implantando da aplicação GetFood."
echo "-------------------------------------"
echo " "

if [ "$(id -u)" != "0" ]; then
	echo " "
	echo "--------------------------------"
	echo "  ERRO: Usuário deve ser ROOT."
	echo "--------------------------------"	
	echo " "
	exit
fi

qtd=$#
valido=true
if [ $qtd != 1 ]; then
	valido=false
fi
if $valido ; then
	if [ $1 != "bd" ] && [ $1 != "app" ] && [ $1 != "all" ] ; then
		valido=false			
	fi	 
fi
if $valido ; then
	echo "Aguarde..."
else
	echo "--------------------------------"
	echo "  ERRO: Parametros inválidos."
	echo "--------------------------------"	
	echo " "
	echo "Execute:"
	echo " sudo ./run [parametro] "
	echo " "
	echo "all  -->  Para implantar o banco e aplicação."	
	echo "bd   -->  Para implantar apenas o banco."	
	echo "app  -->  Para implantar apenas a aplicação."
	echo " "
	exit
fi
parametro=$1

#IMPLANTAR TUDO
if [ $parametro == "all" ]; then
	sh ./bd_run.sh
	sh ./app_run.sh	
fi

#IMPLANTAR BANCO DE DADOS
if [ $parametro == "bd" ]; then
	sh ./bd_run.sh	
fi

#IMPLANTAR APLICAÇÃO
if [ $parametro == "app" ]; then	
	sh ./app_run.sh	
fi

echo " "
echo "------------------------------"
echo "  OK: IMPLANTAÇÃO CONCLUÍDA."
echo "------------------------------"	
echo " "


