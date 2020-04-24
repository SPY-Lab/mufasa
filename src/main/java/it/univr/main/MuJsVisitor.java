// Generated from ../eclipse-workspace/mu-js/src/main/java/it/univr/main/MuJs.g4 by ANTLR 4.7.2

    package it.univr.main;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MuJsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MuJsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code ProgramExecution}
	 * labeled alternative in {@link MuJsParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramExecution(MuJsParser.ProgramExecutionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(MuJsParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(MuJsParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(MuJsParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NaN}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaN(MuJsParser.NaNContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyObject}
	 * labeled alternative in {@link MuJsParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyObject(MuJsParser.EmptyObjectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Obj}
	 * labeled alternative in {@link MuJsParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObj(MuJsParser.ObjContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(MuJsParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Diff}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiff(MuJsParser.DiffContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Repeat}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat(MuJsParser.RepeatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StartsWith}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartsWith(MuJsParser.StartsWithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToUpperCase}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToUpperCase(MuJsParser.ToUpperCaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Includes}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludes(MuJsParser.IncludesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(MuJsParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RandomInt}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRandomInt(MuJsParser.RandomIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MuJsParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrimLeft}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrimLeft(MuJsParser.TrimLeftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PropLookup}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropLookup(MuJsParser.PropLookupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(MuJsParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Less}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLess(MuJsParser.LessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Substring}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstring(MuJsParser.SubstringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Replace}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplace(MuJsParser.ReplaceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(MuJsParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexOf}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOf(MuJsParser.IndexOfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Trim}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrim(MuJsParser.TrimContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrimRight}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrimRight(MuJsParser.TrimRightContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(MuJsParser.SumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToLowerCase}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToLowerCase(MuJsParser.ToLowerCaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimitiveValue}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveValue(MuJsParser.PrimitiveValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(MuJsParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(MuJsParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquals(MuJsParser.EqualsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CharAt}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharAt(MuJsParser.CharAtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Length}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLength(MuJsParser.LengthContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(MuJsParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Slice}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlice(MuJsParser.SliceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Greater}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreater(MuJsParser.GreaterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectExpression}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectExpression(MuJsParser.ObjectExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EndsWith}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndsWith(MuJsParser.EndsWithContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(MuJsParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PropUpdate}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropUpdate(MuJsParser.PropUpdateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Composition}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposition(MuJsParser.CompositionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(MuJsParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(MuJsParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(MuJsParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStmt(MuJsParser.AssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(MuJsParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectAsg}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectAsg(MuJsParser.ObjectAsgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForEach}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForEach(MuJsParser.ForEachContext ctx);
	/**
	 * Visit a parse tree produced by {@link MuJsParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MuJsParser.BlockContext ctx);
}