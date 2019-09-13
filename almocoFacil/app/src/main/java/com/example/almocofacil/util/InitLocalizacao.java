package com.example.almocofacil.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

public class InitLocalizacao implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient googleApiClient;
    private Location localizacao;
    private Context context;

    public InitLocalizacao(Context context){
        this.context = context;
        initLocalizacao();
    }

    private synchronized void initLocalizacao(){

        googleApiClient = new GoogleApiClient.Builder(context)
                .addOnConnectionFailedListener(this) //Be aware of failures
                .addConnectionCallbacks(this) //Be aware of state of the connection
                .addApi(LocationServices.API)
                .build();

        //Tentando conexão com o Google API. Se a tentativa for bem sucessidade, o método onConnected()
        // será chamado, senão, o método onConnectionFailed() será chamado.
        googleApiClient.connect();
    }

    private void pararConexaoComGoogleApi() {

        //Verificando se está conectado para então cancelar a conexão!
        if (googleApiClient.isConnected()) {
            googleApiClient.disconnect();
        }
    }

    //metodo chamado quando a conecção funciona
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        System.out.print("Conexão com o serviços do Google Service API foi estabelecida!");
        localizacao = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);

        String latitude = String.valueOf(localizacao.getLatitude());
        String longitude = String.valueOf(localizacao.getLongitude());

        SharedPreferences sp = LocalizacaoSingleton.getInstance(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("latitude", latitude);
        editor.putString("longitude", longitude);

        editor.apply();

    }

    //metodo chamado quando o usuario esta temporariamente desconectado
    @Override
    public void onConnectionSuspended(int i) {
        System.out.println(" Aguardando o GoogleApiClient reestabelecer a conexão.");
    }

    //metodo chamado quando a conexao falhar !
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        pararConexaoComGoogleApi();
        System.out.println("A conexão com o serviço do Goole Service API falhou !");
    }
}
