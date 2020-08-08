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
import java.util.Scanner;
/**
 *
 * @author Thắng Bùi
 */
public class RMIClient {
    RMIInterface rmiServer;
    Registry registry;
    
    // Phương thức khởi tạo của RMIClient truyền vào 2 tham số: Địa chỉ + cổng
    public RMIClient(String address, int port) {
        try {
            registry = LocateRegistry.getRegistry(address, port);
            rmiServer = (RMIInterface) (registry.lookup("rmiServer"));
            // lookup(): Tìm một đối tượng từ xa cụ thể với URL cho trước gắn với nó.
        } catch (RemoteException e) {
            System.out.println(e);
        } catch (NotBoundException e) {
            System.out.println(e);
        }
    }
    
    public String square(String str) {
        try {
            return rmiServer.square(str);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public void theEnd() {
        try {
            rmiServer.end();
        } catch (RemoteException e) {
            //System.out.println(e);
        }
    }
    
    
    public static void main(String[] args) {
        RMIClient client = new RMIClient("localhost", 3232);
        Scanner scan = new Scanner(System.in);
        
        try {
            System.out.println("Nhập một số nguyên dương: ");
            int x = scan.nextInt();
            System.out.println("Kết quả: "+client.square(String.valueOf(x)));
        } catch (Exception e) {
            //System.out.println(e);
        }
        
        client.theEnd();
    }
}
