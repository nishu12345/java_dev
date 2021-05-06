package week6.problem_solving_1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    A city is of rectangular shape with the size A * B meters. On the occasion of the city's anniversary,
    a decision was taken to pave the city with square granite flagstones. Each flagstone is of the size C * C.
    What is the least number of flagstones needed to pave the city?
    NOTE: It's allowed to cover the surface larger than the city, but the city has to be covered. It's not allowed to break the flagstones.
    The sides of flagstones should be parallel to the sides of the city.
    Input->
        A=6, B=6, C=4
    Output->
        4
    Explanation->
        If we use 4 flagstones(2 rows and 2 columns) then it will cover the whole city.
*/
public class SquareGranites {
    private static final Logger LOGGER = LoggerFactory.getLogger(SquareGranites.class);

    public static void main(String[] args) {
        int tilesCount = totalTilesCount(6, 6, 4);
        LOGGER.info("Square tiles of size 4 x 4, required to cover plot size of 6 x 6 is {}", tilesCount);
    }

    public static int totalTilesCount(int a, int b, int c) {
        int tilesForLength = a / c;
        int tilesForBreadth = b / c;
        if (a % c != 0)
            tilesForLength += 1;
        if (b % c != 0)
            tilesForBreadth += 1;
        return tilesForBreadth * tilesForLength;
    }
}
