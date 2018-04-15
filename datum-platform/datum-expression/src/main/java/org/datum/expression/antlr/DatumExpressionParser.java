// Generated from DatumExpression.g4 by ANTLR 4.4
package org.datum.expression.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DatumExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__68=1, T__67=2, T__66=3, T__65=4, T__64=5, T__63=6, T__62=7, T__61=8, 
		T__60=9, T__59=10, T__58=11, T__57=12, T__56=13, T__55=14, T__54=15, T__53=16, 
		T__52=17, T__51=18, T__50=19, T__49=20, T__48=21, T__47=22, T__46=23, 
		T__45=24, T__44=25, T__43=26, T__42=27, T__41=28, T__40=29, T__39=30, 
		T__38=31, T__37=32, T__36=33, T__35=34, T__34=35, T__33=36, T__32=37, 
		T__31=38, T__30=39, T__29=40, T__28=41, T__27=42, T__26=43, T__25=44, 
		T__24=45, T__23=46, T__22=47, T__21=48, T__20=49, T__19=50, T__18=51, 
		T__17=52, T__16=53, T__15=54, T__14=55, T__13=56, T__12=57, T__11=58, 
		T__10=59, T__9=60, T__8=61, T__7=62, T__6=63, T__5=64, T__4=65, T__3=66, 
		T__2=67, T__1=68, T__0=69, NUMBER=70, FIELD=71, PARAMETER=72, STRING=73, 
		DATE=74, COMPARISON_OPERATOR=75, LOGICAL_OPERATOR=76, COMMENT=77, LINE_COMMENT=78, 
		WS=79;
	public static final String[] tokenNames = {
		"<INVALID>", "'DATE_DIFF'", "'FLOOR'", "'ABS'", "'QUARTER'", "'^'", "'MID'", 
		"'TODAY'", "'LTRIM'", "'CONTAINS'", "'UPPER'", "'DATE_PART'", "'('", "'LEFT'", 
		"'LOG'", "','", "'ROUND'", "'DATE_ADD'", "'RTRIM'", "'SIN'", "'ACOS'", 
		"'MONTH'", "'REPLACE'", "'PI'", "'HOUR'", "'SPACE'", "'ASCII'", "']'", 
		"'POWER'", "'YEAR'", "'FIND'", "'LN'", "'#'", "'NATIVE'", "'+'", "'/'", 
		"'DIV'", "'EXP'", "'RIGHT'", "'AND'", "';'", "'DEGREES'", "'LEN'", "'ASIN'", 
		"'TRIM'", "'SECOND'", "'*'", "'COT'", "'TAN'", "'MINUTE'", "'CEILING'", 
		"'WEEK'", "'DAY'", "'ENDSWITH'", "'CHAR'", "'['", "'RADIANS'", "'NOW'", 
		"'OR'", "'%'", "'LOWER'", "'ATAN'", "')'", "'DATE_SUB'", "'SQRT'", "'SIGN'", 
		"'COS'", "'-'", "'STARTSWITH'", "'ATAN2'", "NUMBER", "FIELD", "PARAMETER", 
		"STRING", "DATE", "COMPARISON_OPERATOR", "LOGICAL_OPERATOR", "COMMENT", 
		"LINE_COMMENT", "WS"
	};
	public static final int
		RULE_calculations = 0, RULE_arithmetic_expression = 1, RULE_functions_returning_numerics = 2, 
		RULE_numeric_literal = 3, RULE_string_expression = 4, RULE_functions_returning_strings = 5, 
		RULE_string_literal = 6, RULE_date_expression = 7, RULE_functions_returning_dates = 8, 
		RULE_date_literal = 9, RULE_bool_expression = 10, RULE_functions_returning_bools = 11, 
		RULE_native_expression = 12, RULE_comment_expression = 13, RULE_field = 14;
	public static final String[] ruleNames = {
		"calculations", "arithmetic_expression", "functions_returning_numerics", 
		"numeric_literal", "string_expression", "functions_returning_strings", 
		"string_literal", "date_expression", "functions_returning_dates", "date_literal", 
		"bool_expression", "functions_returning_bools", "native_expression", "comment_expression", 
		"field"
	};

	@Override
	public String getGrammarFileName() { return "DatumExpression.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DatumExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CalculationsContext extends ParserRuleContext {
		public Arithmetic_expressionContext arithmetic_expression() {
			return getRuleContext(Arithmetic_expressionContext.class,0);
		}
		public Native_expressionContext native_expression() {
			return getRuleContext(Native_expressionContext.class,0);
		}
		public String_expressionContext string_expression() {
			return getRuleContext(String_expressionContext.class,0);
		}
		public Date_expressionContext date_expression() {
			return getRuleContext(Date_expressionContext.class,0);
		}
		public Comment_expressionContext comment_expression() {
			return getRuleContext(Comment_expressionContext.class,0);
		}
		public Bool_expressionContext bool_expression() {
			return getRuleContext(Bool_expressionContext.class,0);
		}
		public CalculationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calculations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).enterCalculations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).exitCalculations(this);
		}
	}

	public final CalculationsContext calculations() throws RecognitionException {
		CalculationsContext _localctx = new CalculationsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_calculations);
		try {
			setState(40);
			switch (_input.LA(1)) {
			case T__68:
			case T__67:
			case T__66:
			case T__63:
			case T__62:
			case T__61:
			case T__60:
			case T__59:
			case T__58:
			case T__57:
			case T__56:
			case T__55:
			case T__53:
			case T__52:
			case T__51:
			case T__50:
			case T__49:
			case T__48:
			case T__47:
			case T__46:
			case T__44:
			case T__43:
			case T__41:
			case T__40:
			case T__39:
			case T__38:
			case T__37:
			case T__36:
			case T__33:
			case T__32:
			case T__31:
			case T__28:
			case T__27:
			case T__26:
			case T__25:
			case T__22:
			case T__21:
			case T__19:
			case T__17:
			case T__16:
			case T__15:
			case T__14:
			case T__13:
			case T__12:
			case T__9:
			case T__8:
			case T__6:
			case T__5:
			case T__4:
			case T__3:
			case T__2:
			case T__1:
			case T__0:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(30); native_expression();
					}
					break;
				case 2:
					{
					setState(31); arithmetic_expression(0);
					}
					break;
				case 3:
					{
					setState(32); string_expression(0);
					}
					break;
				case 4:
					{
					setState(33); date_expression();
					}
					break;
				case 5:
					{
					setState(34); bool_expression(0);
					}
					break;
				}
				setState(37); match(T__29);
				}
				break;
			case COMMENT:
			case LINE_COMMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(39); comment_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arithmetic_expressionContext extends ParserRuleContext {
		public List<Arithmetic_expressionContext> arithmetic_expression() {
			return getRuleContexts(Arithmetic_expressionContext.class);
		}
		public Native_expressionContext native_expression() {
			return getRuleContext(Native_expressionContext.class,0);
		}
		public Arithmetic_expressionContext arithmetic_expression(int i) {
			return getRuleContext(Arithmetic_expressionContext.class,i);
		}
		public Numeric_literalContext numeric_literal() {
			return getRuleContext(Numeric_literalContext.class,0);
		}
		public Functions_returning_numericsContext functions_returning_numerics() {
			return getRuleContext(Functions_returning_numericsContext.class,0);
		}
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public Arithmetic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).enterArithmetic_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).exitArithmetic_expression(this);
		}
	}

	public final Arithmetic_expressionContext arithmetic_expression() throws RecognitionException {
		return arithmetic_expression(0);
	}

	private Arithmetic_expressionContext arithmetic_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Arithmetic_expressionContext _localctx = new Arithmetic_expressionContext(_ctx, _parentState);
		Arithmetic_expressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_arithmetic_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(44);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(43); match(T__2);
				}
			}

			setState(54);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(46); numeric_literal();
				}
				break;
			case T__14:
				{
				setState(47); field();
				}
				break;
			case T__68:
			case T__67:
			case T__66:
			case T__58:
			case T__55:
			case T__53:
			case T__50:
			case T__49:
			case T__48:
			case T__46:
			case T__43:
			case T__41:
			case T__40:
			case T__39:
			case T__38:
			case T__33:
			case T__32:
			case T__28:
			case T__27:
			case T__26:
			case T__22:
			case T__21:
			case T__19:
			case T__17:
			case T__13:
			case T__8:
			case T__5:
			case T__4:
			case T__3:
			case T__0:
				{
				setState(48); functions_returning_numerics();
				}
				break;
			case T__36:
				{
				setState(49); native_expression();
				}
				break;
			case T__57:
				{
				setState(50); match(T__57);
				setState(51); arithmetic_expression(0);
				setState(52); match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(65);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new Arithmetic_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expression);
						setState(56);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(57); match(T__64);
						setState(58); arithmetic_expression(4);
						}
						break;
					case 2:
						{
						_localctx = new Arithmetic_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expression);
						setState(59);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(60);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__23) | (1L << T__10))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(61); arithmetic_expression(4);
						}
						break;
					case 3:
						{
						_localctx = new Arithmetic_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expression);
						setState(62);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(63);
						_la = _input.LA(1);
						if ( !(_la==T__35 || _la==T__2) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(64); arithmetic_expression(3);
						}
						break;
					}
					} 
				}
				setState(69);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Functions_returning_numericsContext extends ParserRuleContext {
		public List<Arithmetic_expressionContext> arithmetic_expression() {
			return getRuleContexts(Arithmetic_expressionContext.class);
		}
		public Arithmetic_expressionContext arithmetic_expression(int i) {
			return getRuleContext(Arithmetic_expressionContext.class,i);
		}
		public List<String_expressionContext> string_expression() {
			return getRuleContexts(String_expressionContext.class);
		}
		public String_expressionContext string_expression(int i) {
			return getRuleContext(String_expressionContext.class,i);
		}
		public List<Date_expressionContext> date_expression() {
			return getRuleContexts(Date_expressionContext.class);
		}
		public Date_expressionContext date_expression(int i) {
			return getRuleContext(Date_expressionContext.class,i);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public Functions_returning_numericsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions_returning_numerics; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).enterFunctions_returning_numerics(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).exitFunctions_returning_numerics(this);
		}
	}

	public final Functions_returning_numericsContext functions_returning_numerics() throws RecognitionException {
		Functions_returning_numericsContext _localctx = new Functions_returning_numericsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functions_returning_numerics);
		int _la;
		try {
			setState(143);
			switch (_input.LA(1)) {
			case T__46:
				enterOuterAlt(_localctx, 1);
				{
				setState(70); match(T__46);
				setState(71); match(T__57);
				setState(72); match(T__7);
				}
				break;
			case T__67:
			case T__66:
			case T__50:
			case T__49:
			case T__38:
			case T__32:
			case T__28:
			case T__26:
			case T__22:
			case T__21:
			case T__19:
			case T__13:
			case T__8:
			case T__5:
			case T__4:
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__67) | (1L << T__66) | (1L << T__50) | (1L << T__49) | (1L << T__38) | (1L << T__32) | (1L << T__28) | (1L << T__26) | (1L << T__22) | (1L << T__21) | (1L << T__19) | (1L << T__13) | (1L << T__8))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__5 - 64)) | (1L << (T__4 - 64)) | (1L << (T__3 - 64)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(74); match(T__57);
				setState(75); arithmetic_expression(0);
				setState(76); match(T__7);
				}
				break;
			case T__41:
			case T__33:
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				_la = _input.LA(1);
				if ( !(((((_la - 28)) & ~0x3f) == 0 && ((1L << (_la - 28)) & ((1L << (T__41 - 28)) | (1L << (T__33 - 28)) | (1L << (T__0 - 28)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(79); match(T__57);
				setState(80); arithmetic_expression(0);
				setState(81); match(T__54);
				setState(82); arithmetic_expression(0);
				setState(83); match(T__7);
				}
				break;
			case T__55:
			case T__53:
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				_la = _input.LA(1);
				if ( !(_la==T__55 || _la==T__53) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(86); match(T__57);
				setState(87); arithmetic_expression(0);
				setState(90);
				_la = _input.LA(1);
				if (_la==T__54) {
					{
					setState(88); match(T__54);
					setState(89); arithmetic_expression(0);
					}
				}

				setState(92); match(T__7);
				}
				break;
			case T__43:
			case T__27:
				enterOuterAlt(_localctx, 5);
				{
				setState(94);
				_la = _input.LA(1);
				if ( !(_la==T__43 || _la==T__27) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(95); match(T__57);
				setState(96); string_expression(0);
				setState(97); match(T__7);
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 6);
				{
				setState(99); match(T__39);
				setState(100); match(T__57);
				setState(101); string_expression(0);
				setState(102); match(T__54);
				setState(103); string_expression(0);
				setState(106);
				_la = _input.LA(1);
				if (_la==T__54) {
					{
					setState(104); match(T__54);
					setState(105); arithmetic_expression(0);
					}
				}

				setState(108); match(T__7);
				}
				break;
			case T__58:
				enterOuterAlt(_localctx, 7);
				{
				setState(110); match(T__58);
				setState(111); match(T__57);
				setState(114);
				switch (_input.LA(1)) {
				case T__62:
				case T__52:
				case T__37:
				case T__12:
				case T__6:
					{
					setState(112); date_expression();
					}
					break;
				case T__14:
					{
					setState(113); field();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(116); match(T__54);
				setState(117);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__65) | (1L << T__48) | (1L << T__45) | (1L << T__40) | (1L << T__24) | (1L << T__20) | (1L << T__18) | (1L << T__17))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(118); match(T__7);
				}
				break;
			case T__48:
			case T__40:
			case T__17:
				enterOuterAlt(_localctx, 8);
				{
				setState(120);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__48) | (1L << T__40) | (1L << T__17))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(121); match(T__57);
				setState(124);
				switch (_input.LA(1)) {
				case T__62:
				case T__52:
				case T__37:
				case T__12:
				case T__6:
					{
					setState(122); date_expression();
					}
					break;
				case T__14:
					{
					setState(123); field();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(126); match(T__7);
				}
				break;
			case T__68:
				enterOuterAlt(_localctx, 9);
				{
				setState(128); match(T__68);
				setState(129); match(T__57);
				setState(132);
				switch (_input.LA(1)) {
				case T__62:
				case T__52:
				case T__37:
				case T__12:
				case T__6:
					{
					setState(130); date_expression();
					}
					break;
				case T__14:
					{
					setState(131); field();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(134); match(T__54);
				setState(137);
				switch (_input.LA(1)) {
				case T__62:
				case T__52:
				case T__37:
				case T__12:
				case T__6:
					{
					setState(135); date_expression();
					}
					break;
				case T__14:
					{
					setState(136); field();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(139); match(T__54);
				setState(140);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__65) | (1L << T__48) | (1L << T__45) | (1L << T__40) | (1L << T__24) | (1L << T__20) | (1L << T__18) | (1L << T__17))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(141); match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Numeric_literalContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(DatumExpressionParser.NUMBER, 0); }
		public Numeric_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).enterNumeric_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).exitNumeric_literal(this);
		}
	}

	public final Numeric_literalContext numeric_literal() throws RecognitionException {
		Numeric_literalContext _localctx = new Numeric_literalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_numeric_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145); match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class String_expressionContext extends ParserRuleContext {
		public Native_expressionContext native_expression() {
			return getRuleContext(Native_expressionContext.class,0);
		}
		public Functions_returning_stringsContext functions_returning_strings() {
			return getRuleContext(Functions_returning_stringsContext.class,0);
		}
		public List<String_expressionContext> string_expression() {
			return getRuleContexts(String_expressionContext.class);
		}
		public String_expressionContext string_expression(int i) {
			return getRuleContext(String_expressionContext.class,i);
		}
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public String_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).enterString_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).exitString_expression(this);
		}
	}

	public final String_expressionContext string_expression() throws RecognitionException {
		return string_expression(0);
	}

	private String_expressionContext string_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		String_expressionContext _localctx = new String_expressionContext(_ctx, _parentState);
		String_expressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_string_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(148); string_literal();
				}
				break;
			case T__63:
			case T__61:
			case T__59:
			case T__56:
			case T__51:
			case T__47:
			case T__44:
			case T__31:
			case T__25:
			case T__15:
			case T__9:
				{
				setState(149); functions_returning_strings();
				}
				break;
			case T__14:
				{
				setState(150); field();
				}
				break;
			case T__36:
				{
				setState(151); native_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(159);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new String_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_string_expression);
					setState(154);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(155); match(T__35);
					setState(156); string_expression(4);
					}
					} 
				}
				setState(161);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Functions_returning_stringsContext extends ParserRuleContext {
		public List<Arithmetic_expressionContext> arithmetic_expression() {
			return getRuleContexts(Arithmetic_expressionContext.class);
		}
		public Arithmetic_expressionContext arithmetic_expression(int i) {
			return getRuleContext(Arithmetic_expressionContext.class,i);
		}
		public List<String_expressionContext> string_expression() {
			return getRuleContexts(String_expressionContext.class);
		}
		public String_expressionContext string_expression(int i) {
			return getRuleContext(String_expressionContext.class,i);
		}
		public Functions_returning_stringsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions_returning_strings; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).enterFunctions_returning_strings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).exitFunctions_returning_strings(this);
		}
	}

	public final Functions_returning_stringsContext functions_returning_strings() throws RecognitionException {
		Functions_returning_stringsContext _localctx = new Functions_returning_stringsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functions_returning_strings);
		int _la;
		try {
			setState(199);
			switch (_input.LA(1)) {
			case T__44:
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				_la = _input.LA(1);
				if ( !(_la==T__44 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(163); match(T__57);
				setState(164); arithmetic_expression(0);
				setState(165); match(T__7);
				}
				break;
			case T__61:
			case T__59:
			case T__51:
			case T__25:
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__61) | (1L << T__59) | (1L << T__51) | (1L << T__25) | (1L << T__9))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(168); match(T__57);
				setState(169); string_expression(0);
				setState(170); match(T__7);
				}
				break;
			case T__63:
				enterOuterAlt(_localctx, 3);
				{
				setState(172); match(T__63);
				setState(173); match(T__57);
				setState(174); string_expression(0);
				setState(175); match(T__54);
				setState(176); arithmetic_expression(0);
				setState(179);
				_la = _input.LA(1);
				if (_la==T__54) {
					{
					setState(177); match(T__54);
					setState(178); arithmetic_expression(0);
					}
				}

				setState(181); match(T__7);
				}
				break;
			case T__56:
			case T__31:
				enterOuterAlt(_localctx, 4);
				{
				setState(183);
				_la = _input.LA(1);
				if ( !(_la==T__56 || _la==T__31) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(184); match(T__57);
				setState(185); string_expression(0);
				setState(186); match(T__54);
				setState(187); arithmetic_expression(0);
				setState(188); match(T__7);
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 5);
				{
				setState(190); match(T__47);
				setState(191); match(T__57);
				setState(192); string_expression(0);
				setState(193); match(T__54);
				setState(194); string_expression(0);
				setState(195); match(T__54);
				setState(196); string_expression(0);
				setState(197); match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class String_literalContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(DatumExpressionParser.STRING, 0); }
		public String_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).enterString_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).exitString_literal(this);
		}
	}

	public final String_literalContext string_literal() throws RecognitionException {
		String_literalContext _localctx = new String_literalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_string_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201); match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Date_expressionContext extends ParserRuleContext {
		public Date_literalContext date_literal() {
			return getRuleContext(Date_literalContext.class,0);
		}
		public Functions_returning_datesContext functions_returning_dates() {
			return getRuleContext(Functions_returning_datesContext.class,0);
		}
		public Date_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).enterDate_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).exitDate_expression(this);
		}
	}

	public final Date_expressionContext date_expression() throws RecognitionException {
		Date_expressionContext _localctx = new Date_expressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_date_expression);
		try {
			setState(205);
			switch (_input.LA(1)) {
			case T__37:
				enterOuterAlt(_localctx, 1);
				{
				setState(203); date_literal();
				}
				break;
			case T__62:
			case T__52:
			case T__12:
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(204); functions_returning_dates();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Functions_returning_datesContext extends ParserRuleContext {
		public Arithmetic_expressionContext arithmetic_expression() {
			return getRuleContext(Arithmetic_expressionContext.class,0);
		}
		public Date_expressionContext date_expression() {
			return getRuleContext(Date_expressionContext.class,0);
		}
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public Functions_returning_datesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions_returning_dates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).enterFunctions_returning_dates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).exitFunctions_returning_dates(this);
		}
	}

	public final Functions_returning_datesContext functions_returning_dates() throws RecognitionException {
		Functions_returning_datesContext _localctx = new Functions_returning_datesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functions_returning_dates);
		int _la;
		try {
			setState(225);
			switch (_input.LA(1)) {
			case T__52:
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				_la = _input.LA(1);
				if ( !(_la==T__52 || _la==T__6) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(208); match(T__57);
				setState(211);
				switch (_input.LA(1)) {
				case T__62:
				case T__52:
				case T__37:
				case T__12:
				case T__6:
					{
					setState(209); date_expression();
					}
					break;
				case T__14:
					{
					setState(210); field();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(213); match(T__54);
				setState(214);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__65) | (1L << T__48) | (1L << T__45) | (1L << T__40) | (1L << T__24) | (1L << T__20) | (1L << T__18) | (1L << T__17))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(215); match(T__54);
				setState(216); arithmetic_expression(0);
				setState(217); match(T__7);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(219); match(T__12);
				setState(220); match(T__57);
				setState(221); match(T__7);
				}
				break;
			case T__62:
				enterOuterAlt(_localctx, 3);
				{
				setState(222); match(T__62);
				setState(223); match(T__57);
				setState(224); match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Date_literalContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(DatumExpressionParser.DATE, 0); }
		public Date_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).enterDate_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).exitDate_literal(this);
		}
	}

	public final Date_literalContext date_literal() throws RecognitionException {
		Date_literalContext _localctx = new Date_literalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227); match(T__37);
			setState(228); match(DATE);
			setState(229); match(T__37);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_expressionContext extends ParserRuleContext {
		public List<Arithmetic_expressionContext> arithmetic_expression() {
			return getRuleContexts(Arithmetic_expressionContext.class);
		}
		public Native_expressionContext native_expression() {
			return getRuleContext(Native_expressionContext.class,0);
		}
		public Arithmetic_expressionContext arithmetic_expression(int i) {
			return getRuleContext(Arithmetic_expressionContext.class,i);
		}
		public List<String_expressionContext> string_expression() {
			return getRuleContexts(String_expressionContext.class);
		}
		public String_expressionContext string_expression(int i) {
			return getRuleContext(String_expressionContext.class,i);
		}
		public List<Date_expressionContext> date_expression() {
			return getRuleContexts(Date_expressionContext.class);
		}
		public Date_expressionContext date_expression(int i) {
			return getRuleContext(Date_expressionContext.class,i);
		}
		public Functions_returning_boolsContext functions_returning_bools() {
			return getRuleContext(Functions_returning_boolsContext.class,0);
		}
		public List<Bool_expressionContext> bool_expression() {
			return getRuleContexts(Bool_expressionContext.class);
		}
		public Bool_expressionContext bool_expression(int i) {
			return getRuleContext(Bool_expressionContext.class,i);
		}
		public TerminalNode COMPARISON_OPERATOR() { return getToken(DatumExpressionParser.COMPARISON_OPERATOR, 0); }
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public Bool_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).enterBool_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).exitBool_expression(this);
		}
	}

	public final Bool_expressionContext bool_expression() throws RecognitionException {
		return bool_expression(0);
	}

	private Bool_expressionContext bool_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bool_expressionContext _localctx = new Bool_expressionContext(_ctx, _parentState);
		Bool_expressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_bool_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(232); arithmetic_expression(0);
				{
				setState(233); match(COMPARISON_OPERATOR);
				}
				setState(237);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(234); arithmetic_expression(0);
					}
					break;
				case 2:
					{
					setState(235); field();
					}
					break;
				case 3:
					{
					setState(236); native_expression();
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(239); string_expression(0);
				{
				setState(240); match(COMPARISON_OPERATOR);
				}
				setState(244);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(241); string_expression(0);
					}
					break;
				case 2:
					{
					setState(242); field();
					}
					break;
				case 3:
					{
					setState(243); native_expression();
					}
					break;
				}
				}
				break;
			case 3:
				{
				setState(246); date_expression();
				{
				setState(247); match(COMPARISON_OPERATOR);
				}
				setState(251);
				switch (_input.LA(1)) {
				case T__62:
				case T__52:
				case T__37:
				case T__12:
				case T__6:
					{
					setState(248); date_expression();
					}
					break;
				case T__14:
					{
					setState(249); field();
					}
					break;
				case T__36:
					{
					setState(250); native_expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				{
				setState(253); field();
				{
				setState(254); match(COMPARISON_OPERATOR);
				}
				setState(259);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(255); arithmetic_expression(0);
					}
					break;
				case 2:
					{
					setState(256); string_expression(0);
					}
					break;
				case 3:
					{
					setState(257); date_expression();
					}
					break;
				case 4:
					{
					setState(258); native_expression();
					}
					break;
				}
				}
				break;
			case 5:
				{
				setState(261); match(T__57);
				setState(262); bool_expression(0);
				setState(263); match(T__7);
				}
				break;
			case 6:
				{
				setState(265); functions_returning_bools();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(273);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bool_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bool_expression);
					setState(268);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(269);
					_la = _input.LA(1);
					if ( !(_la==T__30 || _la==T__11) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(270); bool_expression(4);
					}
					} 
				}
				setState(275);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Functions_returning_boolsContext extends ParserRuleContext {
		public List<String_expressionContext> string_expression() {
			return getRuleContexts(String_expressionContext.class);
		}
		public String_expressionContext string_expression(int i) {
			return getRuleContext(String_expressionContext.class,i);
		}
		public Functions_returning_boolsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions_returning_bools; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).enterFunctions_returning_bools(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).exitFunctions_returning_bools(this);
		}
	}

	public final Functions_returning_boolsContext functions_returning_bools() throws RecognitionException {
		Functions_returning_boolsContext _localctx = new Functions_returning_boolsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functions_returning_bools);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			_la = _input.LA(1);
			if ( !(((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & ((1L << (T__60 - 9)) | (1L << (T__16 - 9)) | (1L << (T__1 - 9)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(277); match(T__57);
			setState(278); string_expression(0);
			setState(279); match(T__54);
			setState(280); string_expression(0);
			setState(281); match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Native_expressionContext extends ParserRuleContext {
		public List<Arithmetic_expressionContext> arithmetic_expression() {
			return getRuleContexts(Arithmetic_expressionContext.class);
		}
		public Arithmetic_expressionContext arithmetic_expression(int i) {
			return getRuleContext(Arithmetic_expressionContext.class,i);
		}
		public List<String_expressionContext> string_expression() {
			return getRuleContexts(String_expressionContext.class);
		}
		public String_expressionContext string_expression(int i) {
			return getRuleContext(String_expressionContext.class,i);
		}
		public List<Date_expressionContext> date_expression() {
			return getRuleContexts(Date_expressionContext.class);
		}
		public Date_expressionContext date_expression(int i) {
			return getRuleContext(Date_expressionContext.class,i);
		}
		public Native_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_native_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).enterNative_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).exitNative_expression(this);
		}
	}

	public final Native_expressionContext native_expression() throws RecognitionException {
		Native_expressionContext _localctx = new Native_expressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_native_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283); match(T__36);
			setState(284); match(T__57);
			setState(285); string_expression(0);
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__54) {
				{
				{
				setState(286); match(T__54);
				setState(290);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(287); arithmetic_expression(0);
					}
					break;
				case 2:
					{
					setState(288); string_expression(0);
					}
					break;
				case 3:
					{
					setState(289); date_expression();
					}
					break;
				}
				}
				}
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(297); match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comment_expressionContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(DatumExpressionParser.COMMENT, 0); }
		public TerminalNode LINE_COMMENT() { return getToken(DatumExpressionParser.LINE_COMMENT, 0); }
		public Comment_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).enterComment_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).exitComment_expression(this);
		}
	}

	public final Comment_expressionContext comment_expression() throws RecognitionException {
		Comment_expressionContext _localctx = new Comment_expressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comment_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			_la = _input.LA(1);
			if ( !(_la==COMMENT || _la==LINE_COMMENT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode FIELD() { return getToken(DatumExpressionParser.FIELD, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DatumExpressionListener ) ((DatumExpressionListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301); match(T__14);
			setState(302); match(FIELD);
			setState(303); match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return arithmetic_expression_sempred((Arithmetic_expressionContext)_localctx, predIndex);
		case 4: return string_expression_sempred((String_expressionContext)_localctx, predIndex);
		case 10: return bool_expression_sempred((Bool_expressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean string_expression_sempred(String_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean arithmetic_expression_sempred(Arithmetic_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 4);
		case 1: return precpred(_ctx, 3);
		case 2: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean bool_expression_sempred(Bool_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3Q\u0134\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\5\2&\n\2\3\2\3\2\3\2\5\2+\n\2\3\3\3\3\5\3/\n\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\5\39\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3D\n\3\f\3\16"+
		"\3G\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4]\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4m\n\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4u\n\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4\177\n\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0087\n\4\3"+
		"\4\3\4\3\4\5\4\u008c\n\4\3\4\3\4\3\4\3\4\5\4\u0092\n\4\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\5\6\u009b\n\6\3\6\3\6\3\6\7\6\u00a0\n\6\f\6\16\6\u00a3\13"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\5\7\u00b6\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\5\7\u00ca\n\7\3\b\3\b\3\t\3\t\5\t\u00d0\n\t\3\n\3\n\3"+
		"\n\3\n\5\n\u00d6\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5"+
		"\n\u00e4\n\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00f0\n\f"+
		"\3\f\3\f\3\f\3\f\3\f\5\f\u00f7\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u00fe\n\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\f\u0106\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u010d\n\f"+
		"\3\f\3\f\3\f\7\f\u0112\n\f\f\f\16\f\u0115\13\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0125\n\16\7\16\u0127\n\16"+
		"\f\16\16\16\u012a\13\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\2"+
		"\5\4\n\26\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\21\5\2%%\60\60="+
		"=\4\2$$EE\r\2\4\5\25\26!!\'\'++--\61\62\64\64::??BD\5\2\36\36&&GG\4\2"+
		"\20\20\22\22\4\2\34\34,,\t\2\6\6\27\27\32\32\37\37//\63\63\65\66\5\2\27"+
		"\27\37\37\66\66\4\2\33\3388\7\2\n\n\f\f\24\24..>>\4\2\17\17((\4\2\23\23"+
		"AA\4\2))<<\5\2\13\13\67\67FF\3\2OP\u015e\2*\3\2\2\2\4,\3\2\2\2\6\u0091"+
		"\3\2\2\2\b\u0093\3\2\2\2\n\u009a\3\2\2\2\f\u00c9\3\2\2\2\16\u00cb\3\2"+
		"\2\2\20\u00cf\3\2\2\2\22\u00e3\3\2\2\2\24\u00e5\3\2\2\2\26\u010c\3\2\2"+
		"\2\30\u0116\3\2\2\2\32\u011d\3\2\2\2\34\u012d\3\2\2\2\36\u012f\3\2\2\2"+
		" &\5\32\16\2!&\5\4\3\2\"&\5\n\6\2#&\5\20\t\2$&\5\26\f\2% \3\2\2\2%!\3"+
		"\2\2\2%\"\3\2\2\2%#\3\2\2\2%$\3\2\2\2&\'\3\2\2\2\'(\7*\2\2(+\3\2\2\2)"+
		"+\5\34\17\2*%\3\2\2\2*)\3\2\2\2+\3\3\2\2\2,.\b\3\1\2-/\7E\2\2.-\3\2\2"+
		"\2./\3\2\2\2/8\3\2\2\2\609\5\b\5\2\619\5\36\20\2\629\5\6\4\2\639\5\32"+
		"\16\2\64\65\7\16\2\2\65\66\5\4\3\2\66\67\7@\2\2\679\3\2\2\28\60\3\2\2"+
		"\28\61\3\2\2\28\62\3\2\2\28\63\3\2\2\28\64\3\2\2\29E\3\2\2\2:;\f\6\2\2"+
		";<\7\7\2\2<D\5\4\3\6=>\f\5\2\2>?\t\2\2\2?D\5\4\3\6@A\f\4\2\2AB\t\3\2\2"+
		"BD\5\4\3\5C:\3\2\2\2C=\3\2\2\2C@\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2"+
		"F\5\3\2\2\2GE\3\2\2\2HI\7\31\2\2IJ\7\16\2\2J\u0092\7@\2\2KL\t\4\2\2LM"+
		"\7\16\2\2MN\5\4\3\2NO\7@\2\2O\u0092\3\2\2\2PQ\t\5\2\2QR\7\16\2\2RS\5\4"+
		"\3\2ST\7\21\2\2TU\5\4\3\2UV\7@\2\2V\u0092\3\2\2\2WX\t\6\2\2XY\7\16\2\2"+
		"Y\\\5\4\3\2Z[\7\21\2\2[]\5\4\3\2\\Z\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\7@"+
		"\2\2_\u0092\3\2\2\2`a\t\7\2\2ab\7\16\2\2bc\5\n\6\2cd\7@\2\2d\u0092\3\2"+
		"\2\2ef\7 \2\2fg\7\16\2\2gh\5\n\6\2hi\7\21\2\2il\5\n\6\2jk\7\21\2\2km\5"+
		"\4\3\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\7@\2\2o\u0092\3\2\2\2pq\7\r\2\2"+
		"qt\7\16\2\2ru\5\20\t\2su\5\36\20\2tr\3\2\2\2ts\3\2\2\2uv\3\2\2\2vw\7\21"+
		"\2\2wx\t\b\2\2xy\7@\2\2y\u0092\3\2\2\2z{\t\t\2\2{~\7\16\2\2|\177\5\20"+
		"\t\2}\177\5\36\20\2~|\3\2\2\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081"+
		"\7@\2\2\u0081\u0092\3\2\2\2\u0082\u0083\7\3\2\2\u0083\u0086\7\16\2\2\u0084"+
		"\u0087\5\20\t\2\u0085\u0087\5\36\20\2\u0086\u0084\3\2\2\2\u0086\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008b\7\21\2\2\u0089\u008c\5\20\t\2"+
		"\u008a\u008c\5\36\20\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\u008d"+
		"\3\2\2\2\u008d\u008e\7\21\2\2\u008e\u008f\t\b\2\2\u008f\u0090\7@\2\2\u0090"+
		"\u0092\3\2\2\2\u0091H\3\2\2\2\u0091K\3\2\2\2\u0091P\3\2\2\2\u0091W\3\2"+
		"\2\2\u0091`\3\2\2\2\u0091e\3\2\2\2\u0091p\3\2\2\2\u0091z\3\2\2\2\u0091"+
		"\u0082\3\2\2\2\u0092\7\3\2\2\2\u0093\u0094\7H\2\2\u0094\t\3\2\2\2\u0095"+
		"\u0096\b\6\1\2\u0096\u009b\5\16\b\2\u0097\u009b\5\f\7\2\u0098\u009b\5"+
		"\36\20\2\u0099\u009b\5\32\16\2\u009a\u0095\3\2\2\2\u009a\u0097\3\2\2\2"+
		"\u009a\u0098\3\2\2\2\u009a\u0099\3\2\2\2\u009b\u00a1\3\2\2\2\u009c\u009d"+
		"\f\5\2\2\u009d\u009e\7$\2\2\u009e\u00a0\5\n\6\6\u009f\u009c\3\2\2\2\u00a0"+
		"\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\13\3\2\2"+
		"\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\t\n\2\2\u00a5\u00a6\7\16\2\2\u00a6"+
		"\u00a7\5\4\3\2\u00a7\u00a8\7@\2\2\u00a8\u00ca\3\2\2\2\u00a9\u00aa\t\13"+
		"\2\2\u00aa\u00ab\7\16\2\2\u00ab\u00ac\5\n\6\2\u00ac\u00ad\7@\2\2\u00ad"+
		"\u00ca\3\2\2\2\u00ae\u00af\7\b\2\2\u00af\u00b0\7\16\2\2\u00b0\u00b1\5"+
		"\n\6\2\u00b1\u00b2\7\21\2\2\u00b2\u00b5\5\4\3\2\u00b3\u00b4\7\21\2\2\u00b4"+
		"\u00b6\5\4\3\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\u00b8\7@\2\2\u00b8\u00ca\3\2\2\2\u00b9\u00ba\t\f\2\2\u00ba"+
		"\u00bb\7\16\2\2\u00bb\u00bc\5\n\6\2\u00bc\u00bd\7\21\2\2\u00bd\u00be\5"+
		"\4\3\2\u00be\u00bf\7@\2\2\u00bf\u00ca\3\2\2\2\u00c0\u00c1\7\30\2\2\u00c1"+
		"\u00c2\7\16\2\2\u00c2\u00c3\5\n\6\2\u00c3\u00c4\7\21\2\2\u00c4\u00c5\5"+
		"\n\6\2\u00c5\u00c6\7\21\2\2\u00c6\u00c7\5\n\6\2\u00c7\u00c8\7@\2\2\u00c8"+
		"\u00ca\3\2\2\2\u00c9\u00a4\3\2\2\2\u00c9\u00a9\3\2\2\2\u00c9\u00ae\3\2"+
		"\2\2\u00c9\u00b9\3\2\2\2\u00c9\u00c0\3\2\2\2\u00ca\r\3\2\2\2\u00cb\u00cc"+
		"\7K\2\2\u00cc\17\3\2\2\2\u00cd\u00d0\5\24\13\2\u00ce\u00d0\5\22\n\2\u00cf"+
		"\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\21\3\2\2\2\u00d1\u00d2\t\r\2"+
		"\2\u00d2\u00d5\7\16\2\2\u00d3\u00d6\5\20\t\2\u00d4\u00d6\5\36\20\2\u00d5"+
		"\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\7\21"+
		"\2\2\u00d8\u00d9\t\b\2\2\u00d9\u00da\7\21\2\2\u00da\u00db\5\4\3\2\u00db"+
		"\u00dc\7@\2\2\u00dc\u00e4\3\2\2\2\u00dd\u00de\7;\2\2\u00de\u00df\7\16"+
		"\2\2\u00df\u00e4\7@\2\2\u00e0\u00e1\7\t\2\2\u00e1\u00e2\7\16\2\2\u00e2"+
		"\u00e4\7@\2\2\u00e3\u00d1\3\2\2\2\u00e3\u00dd\3\2\2\2\u00e3\u00e0\3\2"+
		"\2\2\u00e4\23\3\2\2\2\u00e5\u00e6\7\"\2\2\u00e6\u00e7\7L\2\2\u00e7\u00e8"+
		"\7\"\2\2\u00e8\25\3\2\2\2\u00e9\u00ea\b\f\1\2\u00ea\u00eb\5\4\3\2\u00eb"+
		"\u00ef\7M\2\2\u00ec\u00f0\5\4\3\2\u00ed\u00f0\5\36\20\2\u00ee\u00f0\5"+
		"\32\16\2\u00ef\u00ec\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0"+
		"\u010d\3\2\2\2\u00f1\u00f2\5\n\6\2\u00f2\u00f6\7M\2\2\u00f3\u00f7\5\n"+
		"\6\2\u00f4\u00f7\5\36\20\2\u00f5\u00f7\5\32\16\2\u00f6\u00f3\3\2\2\2\u00f6"+
		"\u00f4\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7\u010d\3\2\2\2\u00f8\u00f9\5\20"+
		"\t\2\u00f9\u00fd\7M\2\2\u00fa\u00fe\5\20\t\2\u00fb\u00fe\5\36\20\2\u00fc"+
		"\u00fe\5\32\16\2\u00fd\u00fa\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3"+
		"\2\2\2\u00fe\u010d\3\2\2\2\u00ff\u0100\5\36\20\2\u0100\u0105\7M\2\2\u0101"+
		"\u0106\5\4\3\2\u0102\u0106\5\n\6\2\u0103\u0106\5\20\t\2\u0104\u0106\5"+
		"\32\16\2\u0105\u0101\3\2\2\2\u0105\u0102\3\2\2\2\u0105\u0103\3\2\2\2\u0105"+
		"\u0104\3\2\2\2\u0106\u010d\3\2\2\2\u0107\u0108\7\16\2\2\u0108\u0109\5"+
		"\26\f\2\u0109\u010a\7@\2\2\u010a\u010d\3\2\2\2\u010b\u010d\5\30\r\2\u010c"+
		"\u00e9\3\2\2\2\u010c\u00f1\3\2\2\2\u010c\u00f8\3\2\2\2\u010c\u00ff\3\2"+
		"\2\2\u010c\u0107\3\2\2\2\u010c\u010b\3\2\2\2\u010d\u0113\3\2\2\2\u010e"+
		"\u010f\f\5\2\2\u010f\u0110\t\16\2\2\u0110\u0112\5\26\f\6\u0111\u010e\3"+
		"\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\27\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0117\t\17\2\2\u0117\u0118\7\16"+
		"\2\2\u0118\u0119\5\n\6\2\u0119\u011a\7\21\2\2\u011a\u011b\5\n\6\2\u011b"+
		"\u011c\7@\2\2\u011c\31\3\2\2\2\u011d\u011e\7#\2\2\u011e\u011f\7\16\2\2"+
		"\u011f\u0128\5\n\6\2\u0120\u0124\7\21\2\2\u0121\u0125\5\4\3\2\u0122\u0125"+
		"\5\n\6\2\u0123\u0125\5\20\t\2\u0124\u0121\3\2\2\2\u0124\u0122\3\2\2\2"+
		"\u0124\u0123\3\2\2\2\u0125\u0127\3\2\2\2\u0126\u0120\3\2\2\2\u0127\u012a"+
		"\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012b\3\2\2\2\u012a"+
		"\u0128\3\2\2\2\u012b\u012c\7@\2\2\u012c\33\3\2\2\2\u012d\u012e\t\20\2"+
		"\2\u012e\35\3\2\2\2\u012f\u0130\79\2\2\u0130\u0131\7I\2\2\u0131\u0132"+
		"\7\35\2\2\u0132\37\3\2\2\2\36%*.8CE\\lt~\u0086\u008b\u0091\u009a\u00a1"+
		"\u00b5\u00c9\u00cf\u00d5\u00e3\u00ef\u00f6\u00fd\u0105\u010c\u0113\u0124"+
		"\u0128";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}