package train.ex5;

import java.awt.*;
import java.util.*;
import java.util.List;

enum Direct{
    LEFT, RIGHT, UP, DOWN;
}

public class MazeSolver {
    int[][] maze;
    int sizeh, sizew;
    Point startPoint;
    Point endPoint;
    Map<Point, Point> prePoint = new HashMap<>();
    int[][] markPoint;
    public MazeSolver(int[][] maze, Point startPoint){
            this.maze = maze;
            this.startPoint = startPoint;
            this.endPoint = endPoint;
            sizeh = this.maze.length;
            sizew = this.maze[0].length;
            markPoint = new int[sizeh][sizew];
            for (int i = 0; i < sizeh; i++) {
                for (int j = 0; j < sizew; j++) {
                    markPoint[i][j] = 0;
                }
            }
            endPoint = findEndPoint();
    }



    public Point findEndPoint(){
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if(maze[i][j] == 2)
                    return new Point(i, j);
            }
        }
        return null;
    }

    public List<Point> canGo(Point point){
        int posY = point.y, posX = point.x;
        List<Point> points = new ArrayList<>();
        // left
        if(posY>0 && maze[posX][posY-1] != 1){
            points.add(new Point(posX, posY-1));
        }
        // up
        if(posX>0 && maze[posX-1][posY] != 1){
            points.add(new Point(posX-1, posY));
        }
        // right
        if(posY<(sizew-1) && maze[posX][posY+1] != 1){
            points.add(new Point(posX, posY+1));
        }
        // down
        if(posX<sizeh-1 && maze[posX+1][posY] != 1){
            points.add(new Point(posX+1, posY));
        }
        List<Point> _points = new ArrayList<>();
        for(Point point1: points){
            if(!point1.equals(prePoint.get(point)) && markPoint[point1.x][point1.y] == 0){
                _points.add(point1);
                markPoint[point1.x][point1.y] = 1;
            }
        }
        return _points;
    }


    public void dfs(){

    }

    public List<Point> bfs(){
        Queue<Point> queue = new LinkedList<>();
        queue.add(startPoint);
        while(!queue.isEmpty()){
            final Point tempPoint = queue.remove();
//            System.out.println("Cur point"+tempPoint);
            // point that can go
            List<Point> list = canGo(tempPoint);
            queue.addAll(list);
            list.forEach(point -> prePoint.put(point, tempPoint));
            if (tempPoint.equals(endPoint)) {
                System.out.println("ewrwer");
                break;
            }
        }
        System.out.println("end point "+endPoint);
        Point tempPoint = endPoint;
        List<Point> result = new ArrayList<>();
//        result.add(endPoint);
        do {
            tempPoint = prePoint.get(tempPoint);
            result.add(tempPoint);
        }while (!tempPoint.equals(startPoint));
        Collections.reverse(result);
        return result;
    }

    public void solve(){
        List<Point> points = bfs();
        for(Point point: points){
            maze[point.x][point.y] = 3;
        }
    }

    public static void main(String[] args) {

    }


}
