package ru.job4j.paintimg.start;

/**
 * @author alekseev
 * @since mm-dd-yyyy
 */
public class Paint {
    /**
     * Method draw img.
     * @param shape - method shape accept object Triangle or Square.
     */
    public String draw(Shape shape) {
        //System.out.print(shape.pic());
        return shape.pic();
    }
}
