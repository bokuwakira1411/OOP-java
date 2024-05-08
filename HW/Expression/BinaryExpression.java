package Expression;

interface BinaryExpression extends Expression {
    abstract public Expression left();
    abstract public Expression right();
}
