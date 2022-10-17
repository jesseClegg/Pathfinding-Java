import java.util.*;

public class aStar {

    public int search(int [][] map){
        int [] startingPoint= {0,0};
        int goalI = map.length-1;
        int goalJ = map[0].length-1;
        int [] goal={goalI, goalJ};
        int result=findPath(map, startingPoint, goal);
        return result;
    }

    public int search(int [][] map, int goalI, int goalJ){
        int [] startingPoint= {0,0};
        int [] goal={goalI, goalJ};
        int result=findPath(map, startingPoint, goal);
        return result;
    }

    public int[][] fillWithZeroes(int y, int x){
        int [][] cleanMaze=new int[y][x];
        for (int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                cleanMaze[i][j]=0;
            }
        }
        return cleanMaze;
    }

    public int findPath(int [][] maze, int [] start, int [] goal){
        System.out.println("MAZE TO SOLVE  ");
        printMaze(maze);
        int totalNodeVisited=0;
        int shortestPathDistance=-1;
        int hasBeenExplored=4;
        int i=start[0];
        int j=start[1];
        int distanceFromStart=0;

        aStarNode startNode = new aStarNode(i,j, goal, distanceFromStart);
        PriorityQueue<aStarNode> pQ = new PriorityQueue<aStarNode>();
        pQ.add(startNode);

        int [][] visited = fillWithZeroes(maze.length, maze[0].length);

        do {
            totalNodeVisited++;
            aStarNode currentNode=pQ.poll();
            i=currentNode.getI();;
            j=currentNode.getJ();;
            visited[i][j]=1;
            maze[i][j]=hasBeenExplored;

            //Goal location has been reached
            if(i==maze.length-1&&j==maze[i].length-1){
                shortestPathDistance= currentNode.getDistanceFromStart()+1;
                currentNode.setDistanceFromStart(shortestPathDistance);
                System.out.println("EXIT FOUND");
                System.out.println("total nodes visited= ["+totalNodeVisited+"]");
                printMaze(maze);
                return totalNodeVisited;
            }

            //go right
            if (j < maze[i].length - 1 && maze[i][j + 1] != 1) {
                StringBuilder tempRi = new StringBuilder();
                StringBuilder tempRj = new StringBuilder();
                tempRi.append(i);
                tempRj.append(j + 1);
                if(visited[i][j+1]==0){
                    aStarNode temp = new aStarNode(i, j+1, goal, currentNode.getDistanceFromStart()+1);
                    pQ.add(temp);
                }
            }

            //go down
            if (i < maze.length - 1 && maze[i + 1][j] != 1) {
                StringBuilder tempDi = new StringBuilder();
                StringBuilder tempDj = new StringBuilder();
                tempDi.append(i + 1);
                tempDj.append(j);
                if(visited[i+1][j]==0){
                    aStarNode temp = new aStarNode(i+1, j, goal, currentNode.getDistanceFromStart()+1);
                    pQ.add(temp);
                }
            }

            //go left
            if (j > 0 && maze[i][j - 1] != 1) {
                StringBuilder tempRi = new StringBuilder();
                StringBuilder tempRj = new StringBuilder();
                tempRi.append(i);
                tempRj.append(j - 1);
                if(visited[i][j-1]==0){
                    aStarNode temp = new aStarNode(i, j-1, goal, currentNode.getDistanceFromStart()+1);
                    pQ.add(temp);
                }
            }

            //go up
            if (i > 0 && maze[i - 1][j] != 1) {
                StringBuilder tempUi = new StringBuilder();
                StringBuilder tempUj = new StringBuilder();
                tempUi.append(i - 1);
                tempUj.append(j);
                if(visited[i-1][j]==0){
                    aStarNode temp = new aStarNode(i-1, j, goal, currentNode.getDistanceFromStart()+1);
                    pQ.add(temp);
                }

            }

        }while(!pQ.isEmpty());

        System.out.println("ERROR: UNABLE TO FIND EXIT");
        return -1;
    }

    public void printMaze (int [][] maze){
        System.out.println("-----------");
        for(int i=0; i< maze.length; i++){
            for(int j=0; j< maze[i].length; j++){
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-----------");
        System.out.println();
        System.out.println();
    }
}
