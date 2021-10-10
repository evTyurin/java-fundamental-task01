package by.epam.fundamental.java.task01;

import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;

public class MatrixTest
{
    @Test
    public void createEvenDimension()
    {
        String dimension = "4";
        System.setIn(new ByteArrayInputStream(dimension.getBytes()));

        Assert.assertEquals(Matrix.getDimension(), 4);
    }

    @Test
    public void createUnevenDimension()
    {
        String dimension = "5";
        System.setIn(new ByteArrayInputStream(dimension.getBytes()));

        try {
            Assert.assertEquals(Matrix.getDimension(), 5);
            Assert.fail("Expected exception");
        } catch (RuntimeException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void createNegativeDimension()
    {
        String dimension = "-6";
        System.setIn(new ByteArrayInputStream(dimension.getBytes()));

        try {
            Assert.assertEquals(Matrix.getDimension(), -6);
            Assert.fail("Expected exception");
        } catch (RuntimeException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void createMatrix()
    {
        String dimension = "4";
        System.setIn(new ByteArrayInputStream(dimension.getBytes()));

        Assert.assertTrue(isValidMatrix(Matrix.create()));
    }

    public boolean isValidMatrix(int[][] matrix)
    {
        for (int stringNumber = 0; stringNumber < matrix.length; stringNumber += 2) {
            int x = 0;
            int y = matrix.length;

            for (int columnNumber = 0; columnNumber < matrix[stringNumber].length; columnNumber++) {

                if(matrix[stringNumber][x] != matrix[stringNumber + 1][y - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

}