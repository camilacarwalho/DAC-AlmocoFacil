/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author alann
 */


//classe responssavel pelas notificações
public class Notificacao {

    private static int init;

    //este metodo notifica uma aplicacao android apartir de um token
    public static void notificacao(String token) throws IOException, FirebaseMessagingException {

        if (init == 0) {
            
            //caminho do arquivo onde esta o json do firebase , esta na raiz da aplicacao
            //no meu computador ele tem esse caminho , talvez precise alterar no de vcs
            File arquivo = new File("almoco-facil-firebase-adminsdk-52gm1-99965426c7.json");
            String path = arquivo.getAbsolutePath();

            FileInputStream serviceAccount
                    = new FileInputStream(path);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://almoco-facil.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
            init = 1;
        }

        Message message = Message.builder()
                .setNotification(new Notification("Notificação", "Reifeição encerrada"))
                .putData("score", "850")
                .putData("time", "2:45")
                .setToken(token)
                .build();

        String response = FirebaseMessaging.getInstance().send(message);
        System.out.println("Successfully sent message: " + response);

    }
}
