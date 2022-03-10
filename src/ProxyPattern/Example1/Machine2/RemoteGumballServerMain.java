package ProxyPattern.Example1.Machine2;

import java.rmi.Naming;

public class RemoteGumballServerMain {
    public static void main(String[] args){
        GumballMachineRemote gumballMachine = null;
        int count;

        if(args.length < 2){
            System.out.println("RemoteGumballServerMain <name> <inventory>");
            System.exit(1);
        }

        try{
            count = Integer.parseInt(args[1]);
            gumballMachine = new GumballMachine(count, args[0]);
            System.out.println(gumballMachine);
            Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
