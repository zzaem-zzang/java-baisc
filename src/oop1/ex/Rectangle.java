package oop1.ex;

public class Rectangle {
    int width;
    int height;

    int calculateArea(){
        return width*height;
    }

    int calulatePerimeter(){
        return 2*(width+height);
    }

    Boolean isSquare(){
        return width == height;
    }
}
