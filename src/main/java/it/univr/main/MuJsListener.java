// Generated from ../eclipse-workspace/mu-js/src/main/java/it/univr/main/MuJs.g4 by ANTLR 4.7.2

    package it.univr.main;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MuJsParser}.
 */
public interface MuJsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ProgramExecution}
	 * labeled alternative in {@link MuJsParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgramExecution(MuJsParser.ProgramExecutionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProgramExecution}
	 * labeled alternative in {@link MuJsParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgramExecution(MuJsParser.ProgramExecutionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 */
	void enterInteger(MuJsParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 */
	void exitInteger(MuJsParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(MuJsParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(MuJsParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 */
	void enterString(MuJsParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 */
	void exitString(MuJsParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NaN}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 */
	void enterNaN(MuJsParser.NaNContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NaN}
	 * labeled alternative in {@link MuJsParser#val}.
	 * @param ctx the parse tree
	 */
	void exitNaN(MuJsParser.NaNContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyObject}
	 * labeled alternative in {@link MuJsParser#object}.
	 * @param ctx the parse tree
	 */
	void enterEmptyObject(MuJsParser.EmptyObjectContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyObject}
	 * labeled alternative in {@link MuJsParser#object}.
	 * @param ctx the parse tree
	 */
	void exitEmptyObject(MuJsParser.EmptyObjectContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Obj}
	 * labeled alternative in {@link MuJsParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObj(MuJsParser.ObjContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Obj}
	 * labeled alternative in {@link MuJsParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObj(MuJsParser.ObjContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOr(MuJsParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOr(MuJsParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Diff}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDiff(MuJsParser.DiffContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Diff}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDiff(MuJsParser.DiffContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Repeat}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRepeat(MuJsParser.RepeatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Repeat}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRepeat(MuJsParser.RepeatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StartsWith}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStartsWith(MuJsParser.StartsWithContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StartsWith}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStartsWith(MuJsParser.StartsWithContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToUpperCase}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterToUpperCase(MuJsParser.ToUpperCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToUpperCase}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitToUpperCase(MuJsParser.ToUpperCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Includes}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIncludes(MuJsParser.IncludesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Includes}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIncludes(MuJsParser.IncludesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(MuJsParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(MuJsParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RandomInt}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRandomInt(MuJsParser.RandomIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RandomInt}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRandomInt(MuJsParser.RandomIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(MuJsParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(MuJsParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrimLeft}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTrimLeft(MuJsParser.TrimLeftContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrimLeft}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTrimLeft(MuJsParser.TrimLeftContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PropLookup}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPropLookup(MuJsParser.PropLookupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PropLookup}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPropLookup(MuJsParser.PropLookupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(MuJsParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCall}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(MuJsParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Less}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLess(MuJsParser.LessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Less}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLess(MuJsParser.LessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Substring}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubstring(MuJsParser.SubstringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Substring}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubstring(MuJsParser.SubstringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Replace}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterReplace(MuJsParser.ReplaceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Replace}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitReplace(MuJsParser.ReplaceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMul(MuJsParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMul(MuJsParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexOf}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexOf(MuJsParser.IndexOfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexOf}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexOf(MuJsParser.IndexOfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Trim}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTrim(MuJsParser.TrimContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Trim}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTrim(MuJsParser.TrimContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrimRight}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTrimRight(MuJsParser.TrimRightContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrimRight}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTrimRight(MuJsParser.TrimRightContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSum(MuJsParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSum(MuJsParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToLowerCase}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterToLowerCase(MuJsParser.ToLowerCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToLowerCase}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitToLowerCase(MuJsParser.ToLowerCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimitiveValue}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveValue(MuJsParser.PrimitiveValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimitiveValue}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveValue(MuJsParser.PrimitiveValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Div}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDiv(MuJsParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDiv(MuJsParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNot(MuJsParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNot(MuJsParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEquals(MuJsParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEquals(MuJsParser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CharAt}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCharAt(MuJsParser.CharAtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharAt}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCharAt(MuJsParser.CharAtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Length}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLength(MuJsParser.LengthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Length}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLength(MuJsParser.LengthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd(MuJsParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd(MuJsParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Slice}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSlice(MuJsParser.SliceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Slice}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSlice(MuJsParser.SliceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Greater}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGreater(MuJsParser.GreaterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Greater}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGreater(MuJsParser.GreaterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectExpression}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterObjectExpression(MuJsParser.ObjectExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectExpression}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitObjectExpression(MuJsParser.ObjectExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EndsWith}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEndsWith(MuJsParser.EndsWithContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EndsWith}
	 * labeled alternative in {@link MuJsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEndsWith(MuJsParser.EndsWithContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(MuJsParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(MuJsParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PropUpdate}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterPropUpdate(MuJsParser.PropUpdateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PropUpdate}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitPropUpdate(MuJsParser.PropUpdateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Composition}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterComposition(MuJsParser.CompositionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Composition}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitComposition(MuJsParser.CompositionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(MuJsParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(MuJsParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(MuJsParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(MuJsParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(MuJsParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(MuJsParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStmt(MuJsParser.AssignmentStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStmt(MuJsParser.AssignmentStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(MuJsParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(MuJsParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectAsg}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterObjectAsg(MuJsParser.ObjectAsgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectAsg}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitObjectAsg(MuJsParser.ObjectAsgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForEach}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterForEach(MuJsParser.ForEachContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForEach}
	 * labeled alternative in {@link MuJsParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitForEach(MuJsParser.ForEachContext ctx);
	/**
	 * Enter a parse tree produced by {@link MuJsParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MuJsParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MuJsParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MuJsParser.BlockContext ctx);
}