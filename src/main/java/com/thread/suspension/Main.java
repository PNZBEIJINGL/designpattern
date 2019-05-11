package com.thread.suspension;

public class Main {
    public static void main(String[] args){
        RequestQueue requestQueue=new RequestQueue();
        new ClientThread(requestQueue,"Alice",3141592L).start();
        new ServerThread(requestQueue,"Boddy",6535879L).start();
    }
}
