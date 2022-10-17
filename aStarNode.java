public class aStarNode implements Comparable<aStarNode>{
    int distanceFromGoal;
    int distanceFromStart;
    int hueristic;
    int i;
    int j;
    int [] start;
    int [] goal;



    aStarNode(int i, int j, int[] goal, int distanceFromStart){
        this.i=i;
        this.j=j;
        this.distanceFromGoal=(goal[0]-i)+(goal[1]-j);
        this.distanceFromStart=distanceFromStart;
        this.hueristic=this.calculateHueristic(distanceFromGoal, distanceFromStart);
    }
    aStarNode(int i, int j, int distanceFromGoal, int distanceFromStart){
        this.i=i;
        this.j=j;
        this.distanceFromGoal=distanceFromGoal;
        this.distanceFromStart=distanceFromStart;
        this.hueristic=this.calculateHueristic(distanceFromGoal, distanceFromStart);
    }
    aStarNode(int i, int j){
        this.i=i;
        this.j=j;
    }

    public int calculateHueristic(int fromGoal, int fromStart){
        int result=fromGoal+fromStart;
        return result;
    }

    public int getDistanceFromStart() {
        return distanceFromStart;
    }

    public void setDistanceFromStart(int distanceFromStart) {
        this.distanceFromStart = distanceFromStart;
    }

    @Override
    public String toString(){
        StringBuilder name = new StringBuilder();
        name.append(this.i);
        name.append(", ");
        name.append(this.j);
        name.append(" ["+this.distanceFromGoal+"]");
        return name.toString();
    }

    @Override
    public int compareTo(aStarNode o) {
        if(this.hueristic> o.hueristic){
            return 1;
        }else if(this.hueristic< o.hueristic){
            return -1;
        }else{
            return 0;
        }
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
