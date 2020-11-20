package Network_Programming;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class RMIServer {
    public static void main(String[] args) throws RemoteException {
        System.out.println("create World clock remote service...");
        // 实例化一个WorldClock:
        WorldClock wc = new WorldClockService();
        // 将此服务转换为远程服务接口:
        WorldClock skeleton = (WorldClock) UnicastRemoteObject.exportObject(wc, 0);
        // 将RMI服务注册到1099端口:
        Registry registry = LocateRegistry.createRegistry(1099);
        // 注册此服务，服务名为"WorldClock":
        registry.rebind("WorldClock", skeleton);
    }
}

interface WorldClock extends Remote {
    LocalDateTime getLocalDateTime(String zoneID) throws RemoteException;
}

class WorldClockService implements WorldClock {
    @Override
    public LocalDateTime getLocalDateTime(String zoneID) throws RemoteException {
        return LocalDateTime.now(ZoneId.of(zoneID)).withNano(0);

    }
}


