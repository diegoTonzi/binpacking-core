package br.com.diegotonzi.binpacking.model;

/**
 * This class represents an entry point for a new item in a bin. <br/><br/>
 * An entry point is composed by three lines: width, length and height
 */
public class Point implements Comparable<Point> {
    
    private Line width;
    private Line length;
    private Line height;
    
    public Point(Line width, Line length, Line height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public Line getWidth() {
        return width;
    }

    public Line getLength() {
        return length;
    }

    public Line getHeight() {
        return height;
    }
    
    /**
     * A point can be considered less than another, when the sum of the initial values ​​of their lines have a lower value than the sum of the initial values ​​of the lines of the point compared <br/> 
     * One point is equal to another point when the sum of the initial values ​​of their lines have the same value as the sum of the initial values ​​of the lines of the point compared <br/>
     */
    @Override
    public int compareTo(Point point) {
        double thisBegin = width.getBegin() + length.getBegin() + height.getBegin();
        double otherBegin = point.getWidth().getBegin() + point.getLength().getBegin() + point.getHeight().getBegin();
        if(thisBegin > otherBegin){
            return 1;
        } else if (thisBegin < otherBegin) {
            return -1;
        } else {
            return 0;
        }
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Point(new Line(this.width.getBegin(), this.width.getEnd()), new Line(this.length.getBegin(), this.length.getEnd()), new Line(this.height.getBegin(), this.height.getEnd()));
    }
    
    @Override
    public String toString() {
        return "Point Lines {width: " + this.width + ", length: " + this.length + ", height: " + this.height + "}";
    }

}