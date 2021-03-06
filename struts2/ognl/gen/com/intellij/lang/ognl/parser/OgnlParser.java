/*
 * Copyright 2013 The authors
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


// Generated from ognl.bnf, do not modify
package com.intellij.lang.ognl.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.openapi.diagnostic.Logger;
import static com.intellij.lang.ognl.OgnlTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.lang.LighterASTNode;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class OgnlParser implements PsiParser {

  public static final Logger LOG_ = Logger.getInstance("com.intellij.lang.ognl.parser.OgnlParser");

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, EXTENDS_SETS_);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    if (root_ == BINARY_EXPRESSION) {
      result_ = expression(builder_, 0, 3);
    }
    else if (root_ == CONDITIONAL_EXPRESSION) {
      result_ = expression(builder_, 0, 2);
    }
    else if (root_ == EXPRESSION) {
      result_ = expression(builder_, 0, -1);
    }
    else if (root_ == INDEXED_EXPRESSION) {
      result_ = indexedExpression(builder_, 0);
    }
    else if (root_ == LITERAL_EXPRESSION) {
      result_ = literalExpression(builder_, 0);
    }
    else if (root_ == METHOD_CALL_EXPRESSION) {
      result_ = methodCallExpression(builder_, 0);
    }
    else if (root_ == NEW_EXPRESSION) {
      result_ = newExpression(builder_, 0);
    }
    else if (root_ == PARENTHESIZED_EXPRESSION) {
      result_ = parenthesizedExpression(builder_, 0);
    }
    else if (root_ == REFERENCE_EXPRESSION) {
      result_ = referenceExpression(builder_, 0);
    }
    else if (root_ == SEQUENCE_EXPRESSION) {
      result_ = sequenceExpression(builder_, 0);
    }
    else if (root_ == UNARY_EXPRESSION) {
      result_ = unaryExpression(builder_, 0);
    }
    else if (root_ == VARIABLE_ASSIGNMENT_EXPRESSION) {
      result_ = variableAssignmentExpression(builder_, 0);
    }
    else if (root_ == VARIABLE_EXPRESSION) {
      result_ = variableExpression(builder_, 0);
    }
    else {
      result_ = parse_root_(root_, builder_, 0);
    }
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return root(builder_, level_ + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(BINARY_EXPRESSION, CONDITIONAL_EXPRESSION, EXPRESSION, INDEXED_EXPRESSION,
      LITERAL_EXPRESSION, METHOD_CALL_EXPRESSION, NEW_EXPRESSION, PARENTHESIZED_EXPRESSION,
      REFERENCE_EXPRESSION, SEQUENCE_EXPRESSION, UNARY_EXPRESSION, VARIABLE_ASSIGNMENT_EXPRESSION,
      VARIABLE_EXPRESSION),
  };

  /* ********************************************************** */
  // '[' expression? ']' sequenceExpression?
  static boolean arrayConstructorExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayConstructorExpression")) return false;
    if (!nextTokenIs(builder_, LBRACKET)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, LBRACKET);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, arrayConstructorExpression_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, RBRACKET)) && result_;
    result_ = pinned_ && arrayConstructorExpression_3(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, null, result_, pinned_, null);
    return result_ || pinned_;
  }

  // expression?
  private static boolean arrayConstructorExpression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayConstructorExpression_1")) return false;
    expression(builder_, level_ + 1, -1);
    return true;
  }

  // sequenceExpression?
  private static boolean arrayConstructorExpression_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayConstructorExpression_3")) return false;
    sequenceExpression(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // plusMinusOperations |
  //                            divideMultiplyOperations |
  //                            bitwiseBooleanOperations |
  //                            instanceOfOperation |
  //                            shiftOperations |
  //                            booleanOperations |
  //                            equalityOperations |
  //                            relationalOperations |
  //                            setOperations
  static boolean binaryOperations(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "binaryOperations")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<operator>");
    result_ = plusMinusOperations(builder_, level_ + 1);
    if (!result_) result_ = divideMultiplyOperations(builder_, level_ + 1);
    if (!result_) result_ = bitwiseBooleanOperations(builder_, level_ + 1);
    if (!result_) result_ = instanceOfOperation(builder_, level_ + 1);
    if (!result_) result_ = shiftOperations(builder_, level_ + 1);
    if (!result_) result_ = booleanOperations(builder_, level_ + 1);
    if (!result_) result_ = equalityOperations(builder_, level_ + 1);
    if (!result_) result_ = relationalOperations(builder_, level_ + 1);
    if (!result_) result_ = setOperations(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // OR | XOR | AND | BAND_KEYWORD | BOR_KEYWORD | XOR_KEYWORD
  static boolean bitwiseBooleanOperations(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "bitwiseBooleanOperations")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OR);
    if (!result_) result_ = consumeToken(builder_, XOR);
    if (!result_) result_ = consumeToken(builder_, AND);
    if (!result_) result_ = consumeToken(builder_, BAND_KEYWORD);
    if (!result_) result_ = consumeToken(builder_, BOR_KEYWORD);
    if (!result_) result_ = consumeToken(builder_, XOR_KEYWORD);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // NEGATE | NOT
  static boolean bitwiseOperations(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "bitwiseOperations")) return false;
    if (!nextTokenIs(builder_, "", NEGATE, NOT)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEGATE);
    if (!result_) result_ = consumeToken(builder_, NOT);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // TRUE_KEYWORD | FALSE_KEYWORD
  static boolean booleanLiteralExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "booleanLiteralExpression")) return false;
    if (!nextTokenIs(builder_, "", FALSE_KEYWORD, TRUE_KEYWORD)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, TRUE_KEYWORD);
    if (!result_) result_ = consumeToken(builder_, FALSE_KEYWORD);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // "&&" | "||" |
  //                               "and" | "or" |
  //                               "not"
  static boolean booleanOperations(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "booleanOperations")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, AND_AND);
    if (!result_) result_ = consumeToken(builder_, OR_OR);
    if (!result_) result_ = consumeToken(builder_, AND_KEYWORD);
    if (!result_) result_ = consumeToken(builder_, OR_KEYWORD);
    if (!result_) result_ = consumeToken(builder_, NOT_KEYWORD);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // COLON expression
  static boolean conditinoalExpressionTail(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "conditinoalExpressionTail")) return false;
    if (!nextTokenIs(builder_, COLON)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, COLON);
    pinned_ = result_; // pin = 1
    result_ = result_ && expression(builder_, level_ + 1, -1);
    exit_section_(builder_, level_, marker_, null, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '(' methodCallParameters ')'
  static boolean constructorExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "constructorExpression")) return false;
    if (!nextTokenIs(builder_, LPARENTH)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, LPARENTH);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, methodCallParameters(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RPARENTH) && result_;
    exit_section_(builder_, level_, marker_, null, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '*' | '/' | '%'
  static boolean divideMultiplyOperations(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "divideMultiplyOperations")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, MULTIPLY);
    if (!result_) result_ = consumeToken(builder_, DIVISION);
    if (!result_) result_ = consumeToken(builder_, MODULO);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // "==" | "!=" |
  //                                "eq" | "neq"
  static boolean equalityOperations(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "equalityOperations")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EQUAL);
    if (!result_) result_ = consumeToken(builder_, NOT_EQUAL);
    if (!result_) result_ = consumeToken(builder_, EQ_KEYWORD);
    if (!result_) result_ = consumeToken(builder_, NEQ_KEYWORD);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // expression (',' expression)+
  static boolean expressionSequenceRequired(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expressionSequenceRequired")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = expression(builder_, level_ + 1, -1);
    pinned_ = result_; // pin = 1
    result_ = result_ && expressionSequenceRequired_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, pinned_, null);
    return result_ || pinned_;
  }

  // (',' expression)+
  private static boolean expressionSequenceRequired_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expressionSequenceRequired_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = expressionSequenceRequired_1_0(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!expressionSequenceRequired_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "expressionSequenceRequired_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ',' expression
  private static boolean expressionSequenceRequired_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expressionSequenceRequired_1_0")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, COMMA);
    pinned_ = result_; // pin = 1
    result_ = result_ && expression(builder_, level_ + 1, -1);
    exit_section_(builder_, level_, marker_, null, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // INSTANCEOF_KEYWORD
  static boolean instanceOfOperation(PsiBuilder builder_, int level_) {
    return consumeToken(builder_, INSTANCEOF_KEYWORD);
  }

  /* ********************************************************** */
  // expression? (',' expression)*
  static boolean methodCallParameters(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "methodCallParameters")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = methodCallParameters_0(builder_, level_ + 1);
    result_ = result_ && methodCallParameters_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // expression?
  private static boolean methodCallParameters_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "methodCallParameters_0")) return false;
    expression(builder_, level_ + 1, -1);
    return true;
  }

  // (',' expression)*
  private static boolean methodCallParameters_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "methodCallParameters_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!methodCallParameters_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "methodCallParameters_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ',' expression
  private static boolean methodCallParameters_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "methodCallParameters_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && expression(builder_, level_ + 1, -1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // INTEGER_LITERAL | BIG_INTEGER_LITERAL | DOUBLE_LITERAL | BIG_DECIMAL_LITERAL
  static boolean numberLiteralExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "numberLiteralExpression")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, INTEGER_LITERAL);
    if (!result_) result_ = consumeToken(builder_, BIG_INTEGER_LITERAL);
    if (!result_) result_ = consumeToken(builder_, DOUBLE_LITERAL);
    if (!result_) result_ = consumeToken(builder_, BIG_DECIMAL_LITERAL);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '+' | '-'
  static boolean plusMinusOperations(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "plusMinusOperations")) return false;
    if (!nextTokenIs(builder_, "", PLUS, MINUS)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, PLUS);
    if (!result_) result_ = consumeToken(builder_, MINUS);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '<'  | "<="  | '>'  | ">=" |
  //                                  "lt" | "lte" | "gt" | "gte"
  static boolean relationalOperations(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "relationalOperations")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LESS);
    if (!result_) result_ = consumeToken(builder_, LESS_EQUAL);
    if (!result_) result_ = consumeToken(builder_, GREATER);
    if (!result_) result_ = consumeToken(builder_, GREATER_EQUAL);
    if (!result_) result_ = consumeToken(builder_, LT_KEYWORD);
    if (!result_) result_ = consumeToken(builder_, LT_EQ_KEYWORD);
    if (!result_) result_ = consumeToken(builder_, GT_KEYWORD);
    if (!result_) result_ = consumeToken(builder_, GT_EQ_KEYWORD);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // EXPRESSION_START rootElement EXPRESSION_END
  static boolean root(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "root")) return false;
    if (!nextTokenIs(builder_, EXPRESSION_START)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, EXPRESSION_START);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, rootElement(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, EXPRESSION_END) && result_;
    exit_section_(builder_, level_, marker_, null, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // expression
  static boolean rootElement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rootElement")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = expression(builder_, level_ + 1, -1);
    exit_section_(builder_, level_, marker_, null, result_, false, rootRecover_parser_);
    return result_;
  }

  /* ********************************************************** */
  // !(EXPRESSION_END)
  static boolean rootRecover(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rootRecover")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !consumeToken(builder_, EXPRESSION_END);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // NOT_IN_KEYWORD | IN_KEYWORD
  static boolean setOperations(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "setOperations")) return false;
    if (!nextTokenIs(builder_, "", IN_KEYWORD, NOT_IN_KEYWORD)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NOT_IN_KEYWORD);
    if (!result_) result_ = consumeToken(builder_, IN_KEYWORD);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // SHIFT_LEFT | SHIFT_RIGHT | SHIFT_RIGHT_LOGICAL |
  //                             SHIFT_LEFT_KEYWORD | SHIFT_RIGHT_KEYWORD | SHIFT_RIGHT_LOGICAL_KEYWORD
  static boolean shiftOperations(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "shiftOperations")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, SHIFT_LEFT);
    if (!result_) result_ = consumeToken(builder_, SHIFT_RIGHT);
    if (!result_) result_ = consumeToken(builder_, SHIFT_RIGHT_LOGICAL);
    if (!result_) result_ = consumeToken(builder_, SHIFT_LEFT_KEYWORD);
    if (!result_) result_ = consumeToken(builder_, SHIFT_RIGHT_KEYWORD);
    if (!result_) result_ = consumeToken(builder_, SHIFT_RIGHT_LOGICAL_KEYWORD);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // STRING_LITERAL | CHARACTER_LITERAL
  static boolean textLiteralExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "textLiteralExpression")) return false;
    if (!nextTokenIs(builder_, "", CHARACTER_LITERAL, STRING_LITERAL)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, STRING_LITERAL);
    if (!result_) result_ = consumeToken(builder_, CHARACTER_LITERAL);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // bitwiseOperations |
  //                           '+' | '-' |
  //                           '!' | "not" | '~'
  static boolean unaryOperator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "unaryOperator")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = bitwiseOperations(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, PLUS);
    if (!result_) result_ = consumeToken(builder_, MINUS);
    if (!result_) result_ = consumeToken(builder_, NEGATE);
    if (!result_) result_ = consumeToken(builder_, NOT_KEYWORD);
    if (!result_) result_ = consumeToken(builder_, NOT);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // Expression root: expression
  // Operator priority table:
  // 0: ATOM(sequenceExpression)
  // 1: ATOM(parenthesizedExpression)
  // 2: ATOM(variableAssignmentExpression)
  // 3: BINARY(conditionalExpression)
  // 4: BINARY(binaryExpression)
  // 5: ATOM(newExpression)
  // 6: ATOM(methodCallExpression)
  // 7: ATOM(indexedExpression)
  // 8: ATOM(variableExpression)
  // 9: ATOM(referenceExpression)
  // 10: ATOM(unaryExpression)
  // 11: ATOM(literalExpression)
  public static boolean expression(PsiBuilder builder_, int level_, int priority_) {
    if (!recursion_guard_(builder_, level_, "expression")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<expression>");
    result_ = sequenceExpression(builder_, level_ + 1);
    if (!result_) result_ = parenthesizedExpression(builder_, level_ + 1);
    if (!result_) result_ = variableAssignmentExpression(builder_, level_ + 1);
    if (!result_) result_ = newExpression(builder_, level_ + 1);
    if (!result_) result_ = methodCallExpression(builder_, level_ + 1);
    if (!result_) result_ = indexedExpression(builder_, level_ + 1);
    if (!result_) result_ = variableExpression(builder_, level_ + 1);
    if (!result_) result_ = referenceExpression(builder_, level_ + 1);
    if (!result_) result_ = unaryExpression(builder_, level_ + 1);
    if (!result_) result_ = literalExpression(builder_, level_ + 1);
    pinned_ = result_;
    result_ = result_ && expression_0(builder_, level_ + 1, priority_);
    exit_section_(builder_, level_, marker_, null, result_, pinned_, null);
    return result_ || pinned_;
  }

  public static boolean expression_0(PsiBuilder builder_, int level_, int priority_) {
    if (!recursion_guard_(builder_, level_, "expression_0")) return false;
    boolean result_ = true;
    while (true) {
      Marker left_marker_ = (Marker) builder_.getLatestDoneMarker();
      if (!invalid_left_marker_guard_(builder_, left_marker_, "expression_0")) return false;
      Marker marker_ = builder_.mark();
      if (priority_ < 3 && consumeToken(builder_, QUESTION)) {
        result_ = report_error_(builder_, expression(builder_, level_, 3));
        result_ = conditinoalExpressionTail(builder_, level_ + 1) && result_;
        marker_.drop();
        left_marker_.precede().done(CONDITIONAL_EXPRESSION);
      }
      else if (priority_ < 4 && binaryOperations(builder_, level_ + 1)) {
        result_ = report_error_(builder_, expression(builder_, level_, 4));
        marker_.drop();
        left_marker_.precede().done(BINARY_EXPRESSION);
      }
      else {
        exit_section_(builder_, marker_, null, false);
        break;
      }
    }
    return result_;
  }

  // '{' expressionSequenceRequired '}'
  public static boolean sequenceExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "sequenceExpression")) return false;
    if (!nextTokenIs(builder_, LBRACE)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, LBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, expressionSequenceRequired(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RBRACE) && result_;
    exit_section_(builder_, level_, marker_, SEQUENCE_EXPRESSION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '(' expression ')'
  public static boolean parenthesizedExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parenthesizedExpression")) return false;
    if (!nextTokenIs(builder_, LPARENTH)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, LPARENTH);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, expression(builder_, level_ + 1, -1));
    result_ = pinned_ && consumeToken(builder_, RPARENTH) && result_;
    exit_section_(builder_, level_, marker_, PARENTHESIZED_EXPRESSION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '#' IDENTIFIER '=' expression
  public static boolean variableAssignmentExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableAssignmentExpression")) return false;
    if (!nextTokenIs(builder_, HASH)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, HASH);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    result_ = result_ && consumeToken(builder_, EQ);
    pinned_ = result_; // pin = 3
    result_ = result_ && expression(builder_, level_ + 1, -1);
    exit_section_(builder_, level_, marker_, VARIABLE_ASSIGNMENT_EXPRESSION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // NEW_KEYWORD referenceExpression (arrayConstructorExpression | constructorExpression)
  public static boolean newExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "newExpression")) return false;
    if (!nextTokenIs(builder_, NEW_KEYWORD)) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, NEW_KEYWORD);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, referenceExpression(builder_, level_ + 1));
    result_ = pinned_ && newExpression_2(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, NEW_EXPRESSION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // arrayConstructorExpression | constructorExpression
  private static boolean newExpression_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "newExpression_2")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = arrayConstructorExpression(builder_, level_ + 1);
    if (!result_) result_ = constructorExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // referenceExpression '(' methodCallParameters ')'
  public static boolean methodCallExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "methodCallExpression")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<method call expression>");
    result_ = referenceExpression(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, LPARENTH);
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, methodCallParameters(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RPARENTH) && result_;
    exit_section_(builder_, level_, marker_, METHOD_CALL_EXPRESSION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // (referenceExpression | variableExpression) '[' expression ']'
  public static boolean indexedExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "indexedExpression")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<indexed expression>");
    result_ = indexedExpression_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, LBRACKET);
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, expression(builder_, level_ + 1, -1));
    result_ = pinned_ && consumeToken(builder_, RBRACKET) && result_;
    exit_section_(builder_, level_, marker_, INDEXED_EXPRESSION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // referenceExpression | variableExpression
  private static boolean indexedExpression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "indexedExpression_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = referenceExpression(builder_, level_ + 1);
    if (!result_) result_ = variableExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '#' IDENTIFIER
  public static boolean variableExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableExpression")) return false;
    if (!nextTokenIs(builder_, HASH)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, HASH);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, VARIABLE_EXPRESSION, result_);
    return result_;
  }

  // (variableExpression | ('@')? IDENTIFIER) ('.' IDENTIFIER)* ('@' IDENTIFIER)?
  public static boolean referenceExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "referenceExpression")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _COLLAPSE_, "<reference expression>");
    result_ = referenceExpression_0(builder_, level_ + 1);
    result_ = result_ && referenceExpression_1(builder_, level_ + 1);
    result_ = result_ && referenceExpression_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, REFERENCE_EXPRESSION, result_, false, null);
    return result_;
  }

  // variableExpression | ('@')? IDENTIFIER
  private static boolean referenceExpression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "referenceExpression_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = variableExpression(builder_, level_ + 1);
    if (!result_) result_ = referenceExpression_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ('@')? IDENTIFIER
  private static boolean referenceExpression_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "referenceExpression_0_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = referenceExpression_0_1_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ('@')?
  private static boolean referenceExpression_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "referenceExpression_0_1_0")) return false;
    referenceExpression_0_1_0_0(builder_, level_ + 1);
    return true;
  }

  // ('@')
  private static boolean referenceExpression_0_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "referenceExpression_0_1_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, AT);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ('.' IDENTIFIER)*
  private static boolean referenceExpression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "referenceExpression_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!referenceExpression_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "referenceExpression_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // '.' IDENTIFIER
  private static boolean referenceExpression_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "referenceExpression_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DOT);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ('@' IDENTIFIER)?
  private static boolean referenceExpression_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "referenceExpression_2")) return false;
    referenceExpression_2_0(builder_, level_ + 1);
    return true;
  }

  // '@' IDENTIFIER
  private static boolean referenceExpression_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "referenceExpression_2_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, AT);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // unaryOperator expression
  public static boolean unaryExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "unaryExpression")) return false;
    boolean result_ = false;
    boolean pinned_ = false;
    Marker marker_ = enter_section_(builder_, level_, _COLLAPSE_, "<unary expression>");
    result_ = unaryOperator(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && expression(builder_, level_ + 1, -1);
    exit_section_(builder_, level_, marker_, UNARY_EXPRESSION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // numberLiteralExpression |
  //                       textLiteralExpression |
  //                       booleanLiteralExpression |
  //                       NULL_KEYWORD
  public static boolean literalExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "literalExpression")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _COLLAPSE_, "<literal expression>");
    result_ = numberLiteralExpression(builder_, level_ + 1);
    if (!result_) result_ = textLiteralExpression(builder_, level_ + 1);
    if (!result_) result_ = booleanLiteralExpression(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, NULL_KEYWORD);
    exit_section_(builder_, level_, marker_, LITERAL_EXPRESSION, result_, false, null);
    return result_;
  }

  final static Parser rootRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder builder_, int level_) {
      return rootRecover(builder_, level_ + 1);
    }
  };
}
