package designpatterns.visitor.runoob;

public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}