# directedGraphs_cheapestRoute
Minimum cost path for a "driver" to drive to a location to fetch a parcel, drive to drop off location, and drive home.

A "driver" whose home is at node number D and is doing a trip to take goods from node number Cp to node number Cd will take the cheapest route from D to Cp, from Cp to Cd, and finally, from Cd to D.
If there are two or more "drivers" who could service any request at the same minimum cost, then the one whose home has the lowest node number is selected.
