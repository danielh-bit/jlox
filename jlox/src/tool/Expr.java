package tool;

import lox.*;

import java.util.*;

public abstract class Expr {
  public interface Visitor<R> {
    public R visitAssignExpr(Assign expr);
    public R visitBinaryExpr(Binary expr);
    public R visitCallExpr(Call expr);
    public R visitGroupingExpr(Grouping expr);
    public R visitLiteralExpr(Literal expr);
    public R visitLogicalExpr(Logical expr);
    public R visitUnaryExpr(Unary expr);
    public R visitConditionalExpr(Conditional expr);
    public R visitVariableExpr(Variable expr);
  }
 public static class Assign extends Expr {
    public Assign(Token name, Expr value) {
    this.name = name;
    this.value = value;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
      return visitor.visitAssignExpr(this);
    }

    public final Token name;
    public final Expr value;
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
 public static class Call extends Expr {
    public Call(Expr callee, Token paren, List<Expr> arguments) {
    this.callee = callee;
    this.paren = paren;
    this.arguments = arguments;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
      return visitor.visitCallExpr(this);
    }

    public final Expr callee;
    public final Token paren;
    public final List<Expr> arguments;
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
 public static class Logical extends Expr {
    public Logical(Expr left, Token operator, Expr right) {
    this.left = left;
    this.operator = operator;
    this.right = right;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
      return visitor.visitLogicalExpr(this);
    }

    public final Expr left;
    public final Token operator;
    public final Expr right;
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
 public static class Variable extends Expr {
    public Variable(Token name) {
    this.name = name;
    }

    @Override
    public <R> R accept(Visitor<R> visitor) {
      return visitor.visitVariableExpr(this);
    }

    public final Token name;
  }

  public abstract <R> R accept(Visitor<R> visitor);
}
