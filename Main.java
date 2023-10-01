import java.awt.Color;


public class Main {

        /**
     * Various tests for the segmentation functionality.
     *
     * @param args command line arguments - name of file to process.
     */
    public static void main(String[] args) {

        Maze maze = new Maze(args[0], Color.white);

        System.out.println(maze.mazeHasSolution());

        System.out.println("Number of components: " + maze.getNumComponents());

        DisplayImage compImg = maze.getComponentImage();
        compImg.show();
    }


    
}
