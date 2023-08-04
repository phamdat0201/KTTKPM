package decoratorPatternDemo;

public class ColorDecorator implements Shape {
	private Shape shape;
    private String color;

    public ColorDecorator(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String draw() {
        return shape.draw() + " và tô màu " + color;
    }
}
