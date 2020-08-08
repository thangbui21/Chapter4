/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi;
import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Thắng Bùi
 */
public class RMIServer extends UnicastRemoteObject implements RMIInterface{

    //Khai báo thông tin
    int thisPort = 3232;
    String thisAddress;
    Registry registry;
    
    public RMIServer() throws RemoteException{
        try {
            registry = LocateRegistry.createRegistry(thisPort);// Đăng kí với registry
            registry.rebind("rmiServer", this);
        } catch (RemoteException e) {
            
        }
    }
    
    @Override
    public String square(String str) throws RemoteException {
        int x = Integer.parseInt(str);
        return "square("+ x+ ")"+":"+(x*x);
    }

    @Override
    public void end() throws RemoteException {
        System.out.println("Stopping rmi server!");
        UnicastRemoteObject.unexportObject(registry, true);
        System.exit(0);
    }
    
    public static void main(String[] args) throws RemoteException, Exception {
        new RMIServer();
    }
    
}
