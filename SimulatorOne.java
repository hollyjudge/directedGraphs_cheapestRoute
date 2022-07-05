import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*; 

public class SimulatorOne
{
    public static void main( String [ ] args)
    {
        Graph g = new Graph();
        
        File file= new File("data.txt");
        String[] input= new String[100]; 
        int lines=0;
        
        try
        {
            Scanner scan = new Scanner(file);

            int numNodes= Integer.parseInt(scan.nextLine()); 
            int i=0; 
            
            while (scan.hasNextLine())
            {   
                input[lines]=scan.nextLine();
                lines++;
            }
        }
        catch (Exception e)
        {
        }
         
        lines=lines-1; 
        System.out.println(lines);
        int mark= lines-5;
        
        while(mark>=0)
        { 
            String line= input[mark];  
            System.out.println(line);
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
        
        
        String driverNode= input[lines-2];
        String[] homeNodes= driverNode.split(" ");
         
        //int numRequests= Integer.parseInt(input[lines-2]);
        
        String customerRequests= input[lines];
        String[] requests= customerRequests.split(" ");  
        int k=0;
        double cost; 
        double tempCost;
        String truck;  
         
        while (k<(requests.length-1))
        {    
            int j=0;
            g.dijkstra(requests[k]);
            System.out.println("client " + requests[k] + " " + requests[k+1]); 
            
    //        if (g.printPath(requests[k+1]) == "no")
    //        {
    //            System.out.println("cannot be helped");
    //            break;
    //        }
            
            g.dijkstra(homeNodes[j]); 
            cost= g.printCost(requests[k]); 
            
            g.dijkstra(requests[k+1]);
            cost+= g.printCost(requests[k]);               
            truck= homeNodes[j]; 
            j++; 
            
            while(j<homeNodes.length-1)
            {
                g.dijkstra(homeNodes[j]); 
                tempCost= g.printCost(requests[k]); 
                     
                g.dijkstra(requests[k+1]);
                tempCost+= g.printCost(requests[k]);   
                
                if (tempCost<=cost)
                {
                    if (tempCost==cost)
                    {    
                        if ((Integer.parseInt(truck))<(Integer.parseInt(homeNodes[j])))    
                            truck= truck; 
                    }        
                    else 
                    {
                        truck= homeNodes[j];
                        cost=tempCost;
                    }    
                }
                
                j++; 
            }
            
            System.out.println("truck " + truck); 
            g.dijkstra(truck);
            String firstPath= g.compare(requests[k]);
            
            g.dijkstra2(truck);
            String secondPath= g.compare(requests[k]);
            
            if (firstPath.equals(secondPath))
                g.printPath(requests[k]); 
            else
                System.out.println("multiple solutions cost " + (int)g.printCost(requests[k]));
            
            System.out.println("pickup " + requests[k]);
            g.dijkstra(requests[k]);
            firstPath= g.compare(requests[k+1]);
          
            g.dijkstra2(requests[k]);
            secondPath= g.compare(requests[k+1]);
            
            if (firstPath.equals(secondPath))
                  g.printPath(requests[k+1]); 
            else
                 System.out.println("multiple solutions cost " + (int)g.printCost(requests[k+1]));

            System.out.println("dropoff "+ requests[k+1]);  
            g.dijkstra(requests[k+1]);
            firstPath= g.compare(truck); 
            
            g.dijkstra2(requests[k+1]);
            secondPath= g.compare(truck); 
    
            if (firstPath.equals(secondPath))
               g.printPath(truck);
            else
                System.out.println("multiple solutions cost " + (int)g.printCost(requests[k+1]));
    
            k=k+2; 
        }
        
    
    }      
}
