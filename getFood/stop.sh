#!/bin/bash
echo " "
echo "-------------------------------------"
echo "  Removendo da aplicação GetFood."
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
	echo " sudo ./stop [parametro] "
	echo " "
	echo "all  -->  Para remover o banco e aplicação."	
	echo "bd   -->  Para remover apenas o banco."	
	echo "app  -->  Para remover apenas a aplicação."
	echo " "
	exit
fi
parametro=$1

#IMPLANTAR TUDO
if [ $parametro == "all" ]; then
	sh ./bd_stop.sh
	sh ./app_stop.sh	
fi

#IMPLANTAR BANCO DE DADOS
if [ $parametro == "bd" ]; then
	sh ./bd_stop.sh	
fi

#IMPLANTAR APLICAÇÃO
if [ $parametro == "app" ]; then	
	sh ./app_stop.sh	
fi

echo " "
echo "------------------------------"
echo "  OK: REMOÇÃO CONCLUÍDA."
echo "------------------------------"	
echo " "
