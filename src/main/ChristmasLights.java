package main;

public class ChristmasLights {
    private static int[][] grid = new int[1000][1000];


    public int getValueAtPosition(int firstCoordinate, int secondCoordinate) {
        return grid[firstCoordinate][secondCoordinate];
    }


    public void turnLightOnAt(int firstCoordinate, int secondCoordinate) {
        grid[firstCoordinate][secondCoordinate] += 1;
    }

    public int isTurnedOn(int firstCoordinate, int secondCoordinate) {
        return (grid[firstCoordinate][secondCoordinate] > 0) ? grid[firstCoordinate][secondCoordinate]:0;
    }

    public void turnLightOffAt(int firstCoordinate, int secondCoordinate) {
        if (grid[firstCoordinate][secondCoordinate] > 0) {
            grid[firstCoordinate][secondCoordinate] -= 1;
        }
        else {
            grid[firstCoordinate][secondCoordinate] = 0;
        }
    }

    public int isTurnedOff(int firstCoordinate, int secondCoordinate) {
        return (grid[firstCoordinate][secondCoordinate] == 0) ? 0:grid[firstCoordinate][secondCoordinate];
    }

    public void toggleLightAt(int firstCoordinate, int secondCoordinate) {
        grid[firstCoordinate][secondCoordinate] += 2;
    }
    
    public void turnLightOnForRange(
            int rowStart, int colStart,
            int rowEnd, int colEnd) {

        for (int i=rowStart; i<=rowEnd; i++) {
            for (int j=colStart; j<=colEnd; j++) {
                turnLightOnAt(i,j);
            }
        }
    }

    public void turnLightOffForRange(
            int rowStart, int colStart,
            int rowEnd, int colEnd) {

        for (int i=rowStart; i<=rowEnd; i++) {
            for (int j=colStart; j<=colEnd; j++) {
                turnLightOffAt(i,j);
            }
        }
    }

    public int areTurnedOnForRange(
            int rowStart, int colStart,
            int rowEnd, int colEnd) {

        int response = 0;
        for (int i=rowStart; i<=rowEnd; i++) {
            for (int j=colStart; j<=colEnd; j++) {
                response = (grid[i][j] > 0) ? grid[i][j]:0;
            }
        }
        return response;
    }

    public int areTurnedOffForRange(
            int rowStart, int colStart,
            int rowEnd, int colEnd) {

        int response = 0;
        for (int i=rowStart; i<=rowEnd; i++) {
            for (int j=colStart; j<=colEnd; j++) {
                response = (grid[i][j] == 0) ? 0:grid[i][j];
            }
        }
        return response;
    }

    public void toggleLightForRange(
            int rowStart, int colStart,
            int rowEnd, int colEnd) {

        for (int i=rowStart; i<=rowEnd; i++) {
            for (int j=colStart; j<=colEnd; j++) {
                toggleLightAt(i,j);
            }
        }
    }

    public int totalNumberOfLights() {
        var numberOfLights = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid.length; j++) {
                if (grid[i][j] > 1) {
                    numberOfLights++;
                }
            }
        }
        return numberOfLights;
    }

}
