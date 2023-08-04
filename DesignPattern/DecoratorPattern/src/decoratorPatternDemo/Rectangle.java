package decoratorPatternDemo;

public class Rectangle implements Shape{
	@Override
    public String draw() {
        return "Vẽ hình chữ nhật";
    }
}
