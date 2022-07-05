import java.util.Scanner;
import java.util.StringTokenizer;

public class SimulatorOne
{
    public static void main( String [ ] args)
    {
        Graph g = new Graph();
        
        Scanner scan = new Scanner(System.in);
        int numNodes= Integer.parseInt(scan.nextLine());
        String[] input= new String[100]; 
        int i=0; 
            
        while (scan.hasNextLine())
        {   
            input[i]=scan.nextLine();
            i++;
        }
            
        int mark= input.length-5;
            
        while(mark>=0)
        { 
            String line= input[mark];  
            String dest;
            int cost;
            StringTokenizer st = new StringTokenizer(line);
            String source = st.nextToken();
                
            if (st.hasMoreTokens())
            {
                while (st.hasMoreTokens())
                {
                    dest = st.nextToken();
                    cost = Integer.parseInt(st.nextToken());
                    g.addEdge( source, dest, cost );
                }
            }
            else g.addEdge(source, source, 0);  
                 
            mark--;     
        }
        
        int numDrivers= Integer.parseInt(input[input.length -4]);
        
        String driverNode= input[input.length-3];
        String[] homeNodes= driverNode.split(" ");
         
        int numRequests= Integer.parseInt(input[input.length-2]);
        
        String customerRequests= input[input.length-1];
        String[] requests= customerRequests.split(" ");  
        int k=0;
        int cost;
        int tempCost;
        String truck;  
        String path1;
        String path2;
        String path3;  
         
        while (k<requests.length-1)
        {    
            int j=0; 
            g.dijkstra(requests[k]);
            path2= g.printPath(requests[k+1];
            System.out.println("client " + requests[k] + " " + requests[k+1]); 
            
            g.dijkstra(homeNodes[j]);
            path1= g.printpath(requests[k]); 
            cost = Integer.toString(0, path1.indexOf(" ");
            truck= homeNodes[j]; 
            j++; 
            
            while(j<homeNodes.length-1)
            {
                g.dijkstra(homeNodes[j]);
                path1= g.printpath(requests[k]); 
                tempCost= Integer.toString(0, path1.indexOf(" ");
                     
                g.dijkstra(requests[k+1]);
                path3= g.printpath(homeNodes[j]);
                tempCost+= Integer.toString(0, path3.indexOf(" ");  
                
                if (tempCost>=cost)
                {
                    if (tempCost=cost)
                    {    
                        if ((Integer.parseInt(truck)<(Integer.parseInt(homeNodes[j])))    
                            truck= truck; 
                    }        
                    else 
                    {
                        truck= homeNode[j];
                        cost=tempCost;
                    }    
                }
                
                j++; 
            }
            
            System.out.println("pickup " + requests[k]);
            
            System.out.println("dropoff " requests[k+1]);  
            
            k=k+2; 
        }
        
    
    }      
}
