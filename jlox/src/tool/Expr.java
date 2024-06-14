package tool;

public abstract class Expr {
  public interface Visitor<R> {
    public R visitBinaryExpr(Binary expr);
    public R visitGroupingExpr(Grouping expr);
    public R visitLiteralExpr(Literal expr);
    public R visitUnaryExpr(Unary expr);
    public R visitConditionalExpr(Conditional expr);
  }
 public static class Binary extends Expr {
    public Binary(Expr left, lox.Token operator, Expr right) {
    this.left = left;
    this.operator = operator;
    this.right = right;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
      return visitor.visitBinaryExpr(this);
    }

    public final Expr left;
    public final lox.Token operator;
    public final Expr right;
  }
 public static class Grouping extends Expr {
    public Grouping(Expr expression) {
    this.expression = expression;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
      return visitor.visitGroupingExpr(this);
    }

    public final Expr expression;
  }
 public static class Literal extends Expr {
    public Literal(Object value) {
    this.value = value;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
      return visitor.visitLiteralExpr(this);
    }

    public final Object value;
  }
 public static class Unary extends Expr {
    public Unary(lox.Token operator, Expr right) {
    this.operator = operator;
    this.right = right;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
      return visitor.visitUnaryExpr(this);
    }

    public final lox.Token operator;
    public final Expr right;
  }
 public static class Conditional extends Expr {
    public Conditional(Expr expr, Expr thenBranch, Expr elseBranch) {
    this.expr = expr;
    this.thenBranch = thenBranch;
    this.elseBranch = elseBranch;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
      return visitor.visitConditionalExpr(this);
    }

    public final Expr expr;
    public final Expr thenBranch;
    public final Expr elseBranch;
  }

  public abstract <R> R accept(Visitor<R> visitor);
}
