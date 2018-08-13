package com.baidu.openrasp.tool.cmdtokenizer;
// Generated from BashJava.g4 by ANTLR 4.5
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BashJava extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, HERE_DOC=2, SPACIAL_CAHR=3, DOUBLE_CURLY=4, VAR=5, ARGS=6, 
		MATH_EXEC=7, EXEC=8, DOLLAR=9, FUNCTION_DEFINE=10, WS=11, SINGLE_QUOTED_STR=12, 
		SINGLE_QUOTED_ERR=13, DOUBLE_QUOTE=14, TICK=15, UNQUOTED_STRING=16, IN_DOUBLE_DOLLAR_TOKEN=17, 
		IN_DOUBLE_QUOTE_MATH_EXEC=18, IN_DOUBLE_EXEC=19, TICK_START=20, IN_DOUBLE_ERROR=21, 
		END_DOUBLE_QUOTE=22, DOUBLE_QUOTED_STRING=23, IN_TICK_DOLLAR_TOKEN=24, 
		IN_TICK_COMMENT=25, IN_TICK_COMMENT2=26, IN_TICK_MATH_EXEC=27, IN_TICK_EXEC=28, 
		IN_TICK_DOUBLE_QUOTE=29, END_TICK_TOKEN=30, IN_TICK_SINGLE_QUOTED_ERR=31, 
		IN_TICK_HERE_DOC=32, IN_TICK_TOKEN=33, IN_TICK_WS=34, IN_EXEC_DOLLAR_TOKEN=35, 
		IN_EXEC_COMMENT=36, IN_EXEC_MATH_EXEC=37, IN_EXEC_EXEC=38, END_EXEC_TOKEN=39, 
		IN_EXEC_TICK_START=40, IN_EXEC_ERROR=41, IN_EXEC_DOUBLE_QUOTE=42, IN_EXEC_SINGLE_QUOTED_ERR=43, 
		IN_EXEC_HERE_DOC=44, IN_EXEC_TOKEN=45, IN_EXEC_WS=46, IN_TICK_IN_DOUBLE_DOLLAR_TOKEN=47, 
		IN_TICK_IN_DOUBLE_QUOTE_MATH_EXEC=48, IN_TICK_IN_DOUBLE_EXEC=49, IN_TICK_IN_DOUBLE_ERROR=50, 
		IN_TICK_END_DOUBLE_QUOTE=51, IN_TICK_DOUBLE_QUOTED_STRING=52, IN_TICK_IN_EXEC_DOLLAR_TOKEN=53, 
		IN_TICK_IN_EXEC_COMMENT=54, IN_TICK_IN_EXEC_MATH_EXEC=55, IN_TICK_IN_EXEC_EXEC=56, 
		IN_TICK_END_EXEC_TOKEN=57, IN_TICK_IN_EXEC_ERROR=58, IN_TICK_IN_EXEC_DOUBLE_QUOTE=59, 
		IN_TICK_IN_EXEC_SINGLE_QUOTED_ERR=60, IN_TICK_IN_EXEC_HERE_DOC=61, IN_TICK_IN_EXEC_TOKEN=62, 
		IN_TICK_IN_EXEC_WS=63;
	public static final int IN_DOUBLE_QUOTE = 1;
	public static final int IN_TICK = 2;
	public static final int IN_EXEC = 3;
	public static final int IN_TICK_IN_DOUBLE_QUOTE = 4;
	public static final int IN_TICK_IN_EXEC = 5;
	public static String[] modeNames = {
		"DEFAULT_MODE", "IN_DOUBLE_QUOTE", "IN_TICK", "IN_EXEC", "IN_TICK_IN_DOUBLE_QUOTE", 
		"IN_TICK_IN_EXEC"
	};

	public static final String[] ruleNames = {
		"SPCAE_CHAR", "ESC_CHAR", "BASE_CHAR", "VAR_NAME", "UNICODE_CHAR", "BASE_DOUBLE_QUOTED_STR", 
		"COMMENT", "HERE_DOC", "SPACIAL_CAHR", "DOUBLE_CURLY", "VAR", "ARGS", 
		"MATH_EXEC", "EXEC", "DOLLAR", "FUNCTION_DEFINE", "WS", "SINGLE_QUOTED_STR", 
		"SINGLE_QUOTED_ERR", "DOUBLE_QUOTE", "TICK", "UNQUOTED_STRING", "NORMAL_TOKEN", 
		"DOLLAR_TOKEN", "IN_DOUBLE_DOLLAR_TOKEN", "IN_DOUBLE_QUOTE_MATH_EXEC", 
		"IN_DOUBLE_EXEC", "TICK_START", "IN_DOUBLE_ERROR", "END_DOUBLE_QUOTE", 
		"DOUBLE_QUOTED_STRING", "IN_TICK_DOLLAR_TOKEN", "IN_TICK_COMMENT", "IN_TICK_COMMENT2", 
		"IN_TICK_MATH_EXEC", "IN_TICK_EXEC", "IN_TICK_DOUBLE_QUOTE", "END_TICK_TOKEN", 
		"IN_TICK_SINGLE_QUOTED_ERR", "IN_TICK_HERE_DOC", "IN_TICK_TOKEN", "IN_TICK_WS", 
		"IN_EXEC_DOLLAR_TOKEN", "IN_EXEC_COMMENT", "IN_EXEC_MATH_EXEC", "IN_EXEC_EXEC", 
		"END_EXEC_TOKEN", "IN_EXEC_TICK_START", "IN_EXEC_ERROR", "IN_EXEC_DOUBLE_QUOTE", 
		"IN_EXEC_SINGLE_QUOTED_ERR", "IN_EXEC_HERE_DOC", "IN_EXEC_TOKEN", "IN_EXEC_WS", 
		"IN_TICK_IN_DOUBLE_DOLLAR_TOKEN", "IN_TICK_IN_DOUBLE_QUOTE_MATH_EXEC", 
		"IN_TICK_IN_DOUBLE_EXEC", "IN_TICK_IN_DOUBLE_ERROR", "IN_TICK_END_DOUBLE_QUOTE", 
		"IN_TICK_DOUBLE_QUOTED_STRING", "IN_TICK_IN_EXEC_DOLLAR_TOKEN", "IN_TICK_IN_EXEC_COMMENT", 
		"IN_TICK_IN_EXEC_MATH_EXEC", "IN_TICK_IN_EXEC_EXEC", "IN_TICK_END_EXEC_TOKEN", 
		"IN_TICK_IN_EXEC_ERROR", "IN_TICK_IN_EXEC_DOUBLE_QUOTE", "IN_TICK_IN_EXEC_SINGLE_QUOTED_ERR", 
		"IN_TICK_IN_EXEC_HERE_DOC", "IN_TICK_IN_EXEC_TOKEN", "IN_TICK_IN_EXEC_WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'${{'", null, null, null, null, "'$'", "'()'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMENT", "HERE_DOC", "SPACIAL_CAHR", "DOUBLE_CURLY", "VAR", "ARGS", 
		"MATH_EXEC", "EXEC", "DOLLAR", "FUNCTION_DEFINE", "WS", "SINGLE_QUOTED_STR", 
		"SINGLE_QUOTED_ERR", "DOUBLE_QUOTE", "TICK", "UNQUOTED_STRING", "IN_DOUBLE_DOLLAR_TOKEN", 
		"IN_DOUBLE_QUOTE_MATH_EXEC", "IN_DOUBLE_EXEC", "TICK_START", "IN_DOUBLE_ERROR", 
		"END_DOUBLE_QUOTE", "DOUBLE_QUOTED_STRING", "IN_TICK_DOLLAR_TOKEN", "IN_TICK_COMMENT", 
		"IN_TICK_COMMENT2", "IN_TICK_MATH_EXEC", "IN_TICK_EXEC", "IN_TICK_DOUBLE_QUOTE", 
		"END_TICK_TOKEN", "IN_TICK_SINGLE_QUOTED_ERR", "IN_TICK_HERE_DOC", "IN_TICK_TOKEN", 
		"IN_TICK_WS", "IN_EXEC_DOLLAR_TOKEN", "IN_EXEC_COMMENT", "IN_EXEC_MATH_EXEC", 
		"IN_EXEC_EXEC", "END_EXEC_TOKEN", "IN_EXEC_TICK_START", "IN_EXEC_ERROR", 
		"IN_EXEC_DOUBLE_QUOTE", "IN_EXEC_SINGLE_QUOTED_ERR", "IN_EXEC_HERE_DOC", 
		"IN_EXEC_TOKEN", "IN_EXEC_WS", "IN_TICK_IN_DOUBLE_DOLLAR_TOKEN", "IN_TICK_IN_DOUBLE_QUOTE_MATH_EXEC", 
		"IN_TICK_IN_DOUBLE_EXEC", "IN_TICK_IN_DOUBLE_ERROR", "IN_TICK_END_DOUBLE_QUOTE", 
		"IN_TICK_DOUBLE_QUOTED_STRING", "IN_TICK_IN_EXEC_DOLLAR_TOKEN", "IN_TICK_IN_EXEC_COMMENT", 
		"IN_TICK_IN_EXEC_MATH_EXEC", "IN_TICK_IN_EXEC_EXEC", "IN_TICK_END_EXEC_TOKEN", 
		"IN_TICK_IN_EXEC_ERROR", "IN_TICK_IN_EXEC_DOUBLE_QUOTE", "IN_TICK_IN_EXEC_SINGLE_QUOTED_ERR", 
		"IN_TICK_IN_EXEC_HERE_DOC", "IN_TICK_IN_EXEC_TOKEN", "IN_TICK_IN_EXEC_WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public int token_error = 0;


	public BashJava(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BashJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 6:
			COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 7:
			HERE_DOC_action((RuleContext)_localctx, actionIndex);
			break;
		case 13:
			EXEC_action((RuleContext)_localctx, actionIndex);
			break;
		case 18:
			SINGLE_QUOTED_ERR_action((RuleContext)_localctx, actionIndex);
			break;
		case 19:
			DOUBLE_QUOTE_action((RuleContext)_localctx, actionIndex);
			break;
		case 20:
			TICK_action((RuleContext)_localctx, actionIndex);
			break;
		case 25:
			IN_DOUBLE_QUOTE_MATH_EXEC_action((RuleContext)_localctx, actionIndex);
			break;
		case 26:
			IN_DOUBLE_EXEC_action((RuleContext)_localctx, actionIndex);
			break;
		case 27:
			TICK_START_action((RuleContext)_localctx, actionIndex);
			break;
		case 28:
			IN_DOUBLE_ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		case 29:
			END_DOUBLE_QUOTE_action((RuleContext)_localctx, actionIndex);
			break;
		case 32:
			IN_TICK_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 33:
			IN_TICK_COMMENT2_action((RuleContext)_localctx, actionIndex);
			break;
		case 35:
			IN_TICK_EXEC_action((RuleContext)_localctx, actionIndex);
			break;
		case 36:
			IN_TICK_DOUBLE_QUOTE_action((RuleContext)_localctx, actionIndex);
			break;
		case 37:
			END_TICK_TOKEN_action((RuleContext)_localctx, actionIndex);
			break;
		case 38:
			IN_TICK_SINGLE_QUOTED_ERR_action((RuleContext)_localctx, actionIndex);
			break;
		case 39:
			IN_TICK_HERE_DOC_action((RuleContext)_localctx, actionIndex);
			break;
		case 43:
			IN_EXEC_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 45:
			IN_EXEC_EXEC_action((RuleContext)_localctx, actionIndex);
			break;
		case 46:
			END_EXEC_TOKEN_action((RuleContext)_localctx, actionIndex);
			break;
		case 47:
			IN_EXEC_TICK_START_action((RuleContext)_localctx, actionIndex);
			break;
		case 48:
			IN_EXEC_ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		case 49:
			IN_EXEC_DOUBLE_QUOTE_action((RuleContext)_localctx, actionIndex);
			break;
		case 50:
			IN_EXEC_SINGLE_QUOTED_ERR_action((RuleContext)_localctx, actionIndex);
			break;
		case 51:
			IN_EXEC_HERE_DOC_action((RuleContext)_localctx, actionIndex);
			break;
		case 55:
			IN_TICK_IN_DOUBLE_QUOTE_MATH_EXEC_action((RuleContext)_localctx, actionIndex);
			break;
		case 56:
			IN_TICK_IN_DOUBLE_EXEC_action((RuleContext)_localctx, actionIndex);
			break;
		case 57:
			IN_TICK_IN_DOUBLE_ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		case 58:
			IN_TICK_END_DOUBLE_QUOTE_action((RuleContext)_localctx, actionIndex);
			break;
		case 61:
			IN_TICK_IN_EXEC_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 63:
			IN_TICK_IN_EXEC_EXEC_action((RuleContext)_localctx, actionIndex);
			break;
		case 64:
			IN_TICK_END_EXEC_TOKEN_action((RuleContext)_localctx, actionIndex);
			break;
		case 65:
			IN_TICK_IN_EXEC_ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		case 66:
			IN_TICK_IN_EXEC_DOUBLE_QUOTE_action((RuleContext)_localctx, actionIndex);
			break;
		case 67:
			IN_TICK_IN_EXEC_SINGLE_QUOTED_ERR_action((RuleContext)_localctx, actionIndex);
			break;
		case 68:
			IN_TICK_IN_EXEC_HERE_DOC_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			this.token_error |= 1;
			break;
		}
	}
	private void HERE_DOC_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			this.token_error |= 1;
			break;
		}
	}
	private void EXEC_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			this.token_error += 2;
			break;
		}
	}
	private void SINGLE_QUOTED_ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			this.token_error |= 1;
			break;
		}
	}
	private void DOUBLE_QUOTE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			this.token_error += 2;
			break;
		}
	}
	private void TICK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			this.token_error += 2;
			break;
		}
	}
	private void IN_DOUBLE_QUOTE_MATH_EXEC_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			this.token_error |= 1;
			break;
		}
	}
	private void IN_DOUBLE_EXEC_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			this.token_error += 2;
			break;
		}
	}
	private void TICK_START_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:
			this.token_error += 2; 
			break;
		}
	}
	private void IN_DOUBLE_ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:
			this.token_error |= 1;
			break;
		}
	}
	private void END_DOUBLE_QUOTE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10:
			this.token_error -= 2;
			break;
		}
	}
	private void IN_TICK_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11:
			this.token_error |= 1;
			break;
		}
	}
	private void IN_TICK_COMMENT2_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12:
			this.token_error |= 1;
			break;
		}
	}
	private void IN_TICK_EXEC_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13:
			this.token_error += 2;
			break;
		}
	}
	private void IN_TICK_DOUBLE_QUOTE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14:
			this.token_error += 2;
			break;
		}
	}
	private void END_TICK_TOKEN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15:
			this.token_error -= 2;
			break;
		}
	}
	private void IN_TICK_SINGLE_QUOTED_ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 16:
			this.token_error |= 1;
			break;
		}
	}
	private void IN_TICK_HERE_DOC_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 17:
			this.token_error |= 1;
			break;
		}
	}
	private void IN_EXEC_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 18:
			this.token_error |= 1;
			break;
		}
	}
	private void IN_EXEC_EXEC_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 19:
			this.token_error += 2;
			break;
		}
	}
	private void END_EXEC_TOKEN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 20:
			this.token_error -= 2;
			break;
		}
	}
	private void IN_EXEC_TICK_START_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 21:
			this.token_error += 2;
			break;
		}
	}
	private void IN_EXEC_ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 22:
			this.token_error |= 1;
			break;
		}
	}
	private void IN_EXEC_DOUBLE_QUOTE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 23:
			this.token_error += 2;
			break;
		}
	}
	private void IN_EXEC_SINGLE_QUOTED_ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 24:
			this.token_error |= 1;
			break;
		}
	}
	private void IN_EXEC_HERE_DOC_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 25:
			this.token_error |= 1;
			break;
		}
	}
	private void IN_TICK_IN_DOUBLE_QUOTE_MATH_EXEC_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 26:
			this.token_error |= 1;
			break;
		}
	}
	private void IN_TICK_IN_DOUBLE_EXEC_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 27:
			this.token_error += 2;
			break;
		}
	}
	private void IN_TICK_IN_DOUBLE_ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 28:
			this.token_error |= 1;
			break;
		}
	}
	private void IN_TICK_END_DOUBLE_QUOTE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 29:
			this.token_error -= 2;
			break;
		}
	}
	private void IN_TICK_IN_EXEC_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 30:
			this.token_error |= 1;
			break;
		}
	}
	private void IN_TICK_IN_EXEC_EXEC_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 31:
			this.token_error += 2;
			break;
		}
	}
	private void IN_TICK_END_EXEC_TOKEN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 32:
			this.token_error -= 2;
			break;
		}
	}
	private void IN_TICK_IN_EXEC_ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 33:
			this.token_error |= 1;
			break;
		}
	}
	private void IN_TICK_IN_EXEC_DOUBLE_QUOTE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 34:
			this.token_error += 2;
			break;
		}
	}
	private void IN_TICK_IN_EXEC_SINGLE_QUOTED_ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 35:
			this.token_error |= 1;
			break;
		}
	}
	private void IN_TICK_IN_EXEC_HERE_DOC_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 36:
			this.token_error |= 1;
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2A\u0207\b\1\b\1\b"+
		"\1\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t"+
		"\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t"+
		"\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t"+
		"(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t"+
		"\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t"+
		":\4;\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4"+
		"F\tF\4G\tG\4H\tH\3\2\3\2\3\3\3\3\3\3\3\4\3\4\5\4\u009e\n\4\3\5\3\5\7\5"+
		"\u00a2\n\5\f\5\16\5\u00a5\13\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\6\7\u00ae\n"+
		"\7\r\7\16\7\u00af\3\7\3\7\3\b\3\b\7\b\u00b6\n\b\f\b\16\b\u00b9\13\b\3"+
		"\b\5\b\u00bc\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u00d2\n\f\r\f\16\f\u00d3\3\f\3\f\3"+
		"\f\5\f\u00d9\n\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\6\22\u00ef\n\22\r\22\16\22"+
		"\u00f0\3\22\3\22\3\23\3\23\3\23\7\23\u00f8\n\23\f\23\16\23\u00fb\13\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\6\27\u010e\n\27\r\27\16\27\u010f\3\30\3\30\3\30\3\30\3"+
		"\30\5\30\u0117\n\30\3\31\3\31\3\31\5\31\u011c\n\31\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \6 \u013d\n \r"+
		" \16 \u013e\3!\3!\3\"\3\"\7\"\u0145\n\"\f\"\16\"\u0148\13\"\3\"\3\"\3"+
		"\"\3\"\3#\3#\7#\u0150\n#\f#\16#\u0153\13#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3"+
		"$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)"+
		"\3)\3)\3*\3*\3+\6+\u0179\n+\r+\16+\u017a\3+\3+\3,\3,\3-\3-\7-\u0183\n"+
		"-\f-\16-\u0186\13-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60"+
		"\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\63"+
		"\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\67\6\67\u01b1"+
		"\n\67\r\67\16\67\u01b2\3\67\3\67\38\38\39\39\39\39\39\39\3:\3:\3:\3:\3"+
		":\3;\3;\3;\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\6=\u01d1\n=\r=\16=\u01d2\3>\3"+
		">\3?\3?\7?\u01d9\n?\f?\16?\u01dc\13?\3?\3?\3?\3@\3@\3@\3@\3A\3A\3A\3A"+
		"\3A\3B\3B\3B\3B\3B\3C\3C\3C\3D\3D\3D\3D\3D\3E\3E\3E\3F\3F\3F\3F\3F\3G"+
		"\3G\3H\6H\u0202\nH\rH\16H\u0203\3H\3H\3\u00d3\2I\b\2\n\2\f\2\16\2\20\2"+
		"\22\2\24\3\26\4\30\5\32\6\34\7\36\b \t\"\n$\13&\f(\r*\16,\17.\20\60\21"+
		"\62\22\64\2\66\28\23:\24<\25>\26@\27B\30D\31F\32H\33J\34L\35N\36P\37R"+
		" T!V\"X#Z$\\%^&`\'b(d)f*h+j,l-n.p/r\60t\61v\62x\63z\64|\65~\66\u0080\67"+
		"\u00828\u00849\u0086:\u0088;\u008a<\u008c=\u008e>\u0090?\u0092@\u0094"+
		"A\b\2\3\4\5\6\7\20\5\2\13\f\16\17\"\"\t\2##\'\',<??Aac}\177\177\5\2C\\"+
		"aac|\6\2\62;C\\aac|\3\2\2\u0081\4\2\f\f\17\17\4\3\f\f\17\17\b\2((*+=>"+
		"@@~~\u0080\u0080\t\2##%&,,//\62;ABaa\4\2))^^\4\2%%))\5\2\f\f\17\17bb\4"+
		"\2&&bb\4\2**bb\u0222\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2"+
		"\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2"+
		"\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2"+
		"\2\2\38\3\2\2\2\3:\3\2\2\2\3<\3\2\2\2\3>\3\2\2\2\3@\3\2\2\2\3B\3\2\2\2"+
		"\3D\3\2\2\2\4F\3\2\2\2\4H\3\2\2\2\4J\3\2\2\2\4L\3\2\2\2\4N\3\2\2\2\4P"+
		"\3\2\2\2\4R\3\2\2\2\4T\3\2\2\2\4V\3\2\2\2\4X\3\2\2\2\4Z\3\2\2\2\5\\\3"+
		"\2\2\2\5^\3\2\2\2\5`\3\2\2\2\5b\3\2\2\2\5d\3\2\2\2\5f\3\2\2\2\5h\3\2\2"+
		"\2\5j\3\2\2\2\5l\3\2\2\2\5n\3\2\2\2\5p\3\2\2\2\5r\3\2\2\2\6t\3\2\2\2\6"+
		"v\3\2\2\2\6x\3\2\2\2\6z\3\2\2\2\6|\3\2\2\2\6~\3\2\2\2\7\u0080\3\2\2\2"+
		"\7\u0082\3\2\2\2\7\u0084\3\2\2\2\7\u0086\3\2\2\2\7\u0088\3\2\2\2\7\u008a"+
		"\3\2\2\2\7\u008c\3\2\2\2\7\u008e\3\2\2\2\7\u0090\3\2\2\2\7\u0092\3\2\2"+
		"\2\7\u0094\3\2\2\2\b\u0096\3\2\2\2\n\u0098\3\2\2\2\f\u009d\3\2\2\2\16"+
		"\u009f\3\2\2\2\20\u00a6\3\2\2\2\22\u00a8\3\2\2\2\24\u00b3\3\2\2\2\26\u00bf"+
		"\3\2\2\2\30\u00c4\3\2\2\2\32\u00c6\3\2\2\2\34\u00ca\3\2\2\2\36\u00da\3"+
		"\2\2\2 \u00dd\3\2\2\2\"\u00e1\3\2\2\2$\u00e8\3\2\2\2&\u00ea\3\2\2\2(\u00ee"+
		"\3\2\2\2*\u00f4\3\2\2\2,\u00fe\3\2\2\2.\u0101\3\2\2\2\60\u0106\3\2\2\2"+
		"\62\u010d\3\2\2\2\64\u0116\3\2\2\2\66\u011b\3\2\2\28\u011d\3\2\2\2:\u011f"+
		"\3\2\2\2<\u0125\3\2\2\2>\u012a\3\2\2\2@\u012f\3\2\2\2B\u0132\3\2\2\2D"+
		"\u013c\3\2\2\2F\u0140\3\2\2\2H\u0142\3\2\2\2J\u014d\3\2\2\2L\u015a\3\2"+
		"\2\2N\u015e\3\2\2\2P\u0163\3\2\2\2R\u0168\3\2\2\2T\u016d\3\2\2\2V\u0170"+
		"\3\2\2\2X\u0175\3\2\2\2Z\u0178\3\2\2\2\\\u017e\3\2\2\2^\u0180\3\2\2\2"+
		"`\u018a\3\2\2\2b\u018e\3\2\2\2d\u0193\3\2\2\2f\u0198\3\2\2\2h\u019d\3"+
		"\2\2\2j\u01a0\3\2\2\2l\u01a5\3\2\2\2n\u01a8\3\2\2\2p\u01ad\3\2\2\2r\u01b0"+
		"\3\2\2\2t\u01b6\3\2\2\2v\u01b8\3\2\2\2x\u01be\3\2\2\2z\u01c3\3\2\2\2|"+
		"\u01c6\3\2\2\2~\u01d0\3\2\2\2\u0080\u01d4\3\2\2\2\u0082\u01d6\3\2\2\2"+
		"\u0084\u01e0\3\2\2\2\u0086\u01e4\3\2\2\2\u0088\u01e9\3\2\2\2\u008a\u01ee"+
		"\3\2\2\2\u008c\u01f1\3\2\2\2\u008e\u01f6\3\2\2\2\u0090\u01f9\3\2\2\2\u0092"+
		"\u01fe\3\2\2\2\u0094\u0201\3\2\2\2\u0096\u0097\t\2\2\2\u0097\t\3\2\2\2"+
		"\u0098\u0099\7^\2\2\u0099\u009a\13\2\2\2\u009a\13\3\2\2\2\u009b\u009e"+
		"\t\3\2\2\u009c\u009e\5\n\3\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2\2\2\u009e"+
		"\r\3\2\2\2\u009f\u00a3\t\4\2\2\u00a0\u00a2\t\5\2\2\u00a1\u00a0\3\2\2\2"+
		"\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\17"+
		"\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\n\6\2\2\u00a7\21\3\2\2\2\u00a8"+
		"\u00ad\7$\2\2\u00a9\u00ae\5\f\4\2\u00aa\u00ae\5\20\6\2\u00ab\u00ae\5\34"+
		"\f\2\u00ac\u00ae\5\36\r\2\u00ad\u00a9\3\2\2\2\u00ad\u00aa\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\7$\2\2\u00b2"+
		"\23\3\2\2\2\u00b3\u00b7\7%\2\2\u00b4\u00b6\n\7\2\2\u00b5\u00b4\3\2\2\2"+
		"\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00bb"+
		"\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bc\t\b\2\2\u00bb\u00ba\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00be\b\b\2\2\u00be\25\3\2\2\2\u00bf\u00c0\7>\2\2"+
		"\u00c0\u00c1\7>\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\b\t\3\2\u00c3\27\3"+
		"\2\2\2\u00c4\u00c5\t\t\2\2\u00c5\31\3\2\2\2\u00c6\u00c7\7&\2\2\u00c7\u00c8"+
		"\7}\2\2\u00c8\u00c9\7}\2\2\u00c9\33\3\2\2\2\u00ca\u00d8\7&\2\2\u00cb\u00d1"+
		"\7}\2\2\u00cc\u00d2\5\f\4\2\u00cd\u00d2\5\20\6\2\u00ce\u00d2\5*\23\2\u00cf"+
		"\u00d2\5\34\f\2\u00d0\u00d2\5\22\7\2\u00d1\u00cc\3\2\2\2\u00d1\u00cd\3"+
		"\2\2\2\u00d1\u00ce\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\3\2"+
		"\2\2\u00d5\u00d6\7\177\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d9\5\16\5\2\u00d8"+
		"\u00cb\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9\35\3\2\2\2\u00da\u00db\7&\2\2"+
		"\u00db\u00dc\t\n\2\2\u00dc\37\3\2\2\2\u00dd\u00de\7&\2\2\u00de\u00df\7"+
		"*\2\2\u00df\u00e0\7*\2\2\u00e0!\3\2\2\2\u00e1\u00e2\7&\2\2\u00e2\u00e3"+
		"\7*\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\b\17\4\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e7\b\17\5\2\u00e7#\3\2\2\2\u00e8\u00e9\7&\2\2\u00e9%\3\2\2\2\u00ea"+
		"\u00eb\7*\2\2\u00eb\u00ec\7+\2\2\u00ec\'\3\2\2\2\u00ed\u00ef\5\b\2\2\u00ee"+
		"\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2"+
		"\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\b\22\6\2\u00f3)\3\2\2\2\u00f4\u00f9"+
		"\7)\2\2\u00f5\u00f8\n\13\2\2\u00f6\u00f8\5\n\3\2\u00f7\u00f5\3\2\2\2\u00f7"+
		"\u00f6\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2"+
		"\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd\7)\2\2\u00fd"+
		"+\3\2\2\2\u00fe\u00ff\7)\2\2\u00ff\u0100\b\24\7\2\u0100-\3\2\2\2\u0101"+
		"\u0102\7$\2\2\u0102\u0103\b\25\b\2\u0103\u0104\3\2\2\2\u0104\u0105\b\25"+
		"\t\2\u0105/\3\2\2\2\u0106\u0107\7b\2\2\u0107\u0108\b\26\n\2\u0108\u0109"+
		"\3\2\2\2\u0109\u010a\b\26\13\2\u010a\61\3\2\2\2\u010b\u010e\5\f\4\2\u010c"+
		"\u010e\5\20\6\2\u010d\u010b\3\2\2\2\u010d\u010c\3\2\2\2\u010e\u010f\3"+
		"\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\63\3\2\2\2\u0111"+
		"\u0117\5\62\27\2\u0112\u0117\5\30\n\2\u0113\u0117\5*\23\2\u0114\u0117"+
		"\5$\20\2\u0115\u0117\5\20\6\2\u0116\u0111\3\2\2\2\u0116\u0112\3\2\2\2"+
		"\u0116\u0113\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0115\3\2\2\2\u0117\65"+
		"\3\2\2\2\u0118\u011c\5\34\f\2\u0119\u011c\5\36\r\2\u011a\u011c\5&\21\2"+
		"\u011b\u0118\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011a\3\2\2\2\u011c\67"+
		"\3\2\2\2\u011d\u011e\5\66\31\2\u011e9\3\2\2\2\u011f\u0120\7&\2\2\u0120"+
		"\u0121\7*\2\2\u0121\u0122\7*\2\2\u0122\u0123\3\2\2\2\u0123\u0124\b\33"+
		"\f\2\u0124;\3\2\2\2\u0125\u0126\5\"\17\2\u0126\u0127\b\34\r\2\u0127\u0128"+
		"\3\2\2\2\u0128\u0129\b\34\5\2\u0129=\3\2\2\2\u012a\u012b\7b\2\2\u012b"+
		"\u012c\b\35\16\2\u012c\u012d\3\2\2\2\u012d\u012e\b\35\13\2\u012e?\3\2"+
		"\2\2\u012f\u0130\7&\2\2\u0130\u0131\b\36\17\2\u0131A\3\2\2\2\u0132\u0133"+
		"\7$\2\2\u0133\u0134\b\37\20\2\u0134\u0135\3\2\2\2\u0135\u0136\b\37\21"+
		"\2\u0136C\3\2\2\2\u0137\u013d\5\f\4\2\u0138\u013d\5\30\n\2\u0139\u013d"+
		"\5\b\2\2\u013a\u013d\5\20\6\2\u013b\u013d\t\f\2\2\u013c\u0137\3\2\2\2"+
		"\u013c\u0138\3\2\2\2\u013c\u0139\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013b"+
		"\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f"+
		"E\3\2\2\2\u0140\u0141\5\66\31\2\u0141G\3\2\2\2\u0142\u0146\7%\2\2\u0143"+
		"\u0145\n\r\2\2\u0144\u0143\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0144\3\2"+
		"\2\2\u0146\u0147\3\2\2\2\u0147\u0149\3\2\2\2\u0148\u0146\3\2\2\2\u0149"+
		"\u014a\t\7\2\2\u014a\u014b\3\2\2\2\u014b\u014c\b\"\22\2\u014cI\3\2\2\2"+
		"\u014d\u0151\7%\2\2\u014e\u0150\n\r\2\2\u014f\u014e\3\2\2\2\u0150\u0153"+
		"\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0154\3\2\2\2\u0153"+
		"\u0151\3\2\2\2\u0154\u0155\7b\2\2\u0155\u0156\3\2\2\2\u0156\u0157\b#\23"+
		"\2\u0157\u0158\3\2\2\2\u0158\u0159\b#\21\2\u0159K\3\2\2\2\u015a\u015b"+
		"\7&\2\2\u015b\u015c\7*\2\2\u015c\u015d\7*\2\2\u015dM\3\2\2\2\u015e\u015f"+
		"\5\"\17\2\u015f\u0160\b%\24\2\u0160\u0161\3\2\2\2\u0161\u0162\b%\25\2"+
		"\u0162O\3\2\2\2\u0163\u0164\7$\2\2\u0164\u0165\b&\26\2\u0165\u0166\3\2"+
		"\2\2\u0166\u0167\b&\27\2\u0167Q\3\2\2\2\u0168\u0169\7b\2\2\u0169\u016a"+
		"\b\'\30\2\u016a\u016b\3\2\2\2\u016b\u016c\b\'\21\2\u016cS\3\2\2\2\u016d"+
		"\u016e\7)\2\2\u016e\u016f\b(\31\2\u016fU\3\2\2\2\u0170\u0171\7>\2\2\u0171"+
		"\u0172\7>\2\2\u0172\u0173\3\2\2\2\u0173\u0174\b)\32\2\u0174W\3\2\2\2\u0175"+
		"\u0176\5\64\30\2\u0176Y\3\2\2\2\u0177\u0179\5\b\2\2\u0178\u0177\3\2\2"+
		"\2\u0179\u017a\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017c"+
		"\3\2\2\2\u017c\u017d\b+\6\2\u017d[\3\2\2\2\u017e\u017f\5\66\31\2\u017f"+
		"]\3\2\2\2\u0180\u0184\7%\2\2\u0181\u0183\n\7\2\2\u0182\u0181\3\2\2\2\u0183"+
		"\u0186\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0187\3\2"+
		"\2\2\u0186\u0184\3\2\2\2\u0187\u0188\t\7\2\2\u0188\u0189\b-\33\2\u0189"+
		"_\3\2\2\2\u018a\u018b\7&\2\2\u018b\u018c\7*\2\2\u018c\u018d\7*\2\2\u018d"+
		"a\3\2\2\2\u018e\u018f\5\"\17\2\u018f\u0190\b/\34\2\u0190\u0191\3\2\2\2"+
		"\u0191\u0192\b/\5\2\u0192c\3\2\2\2\u0193\u0194\7+\2\2\u0194\u0195\b\60"+
		"\35\2\u0195\u0196\3\2\2\2\u0196\u0197\b\60\21\2\u0197e\3\2\2\2\u0198\u0199"+
		"\7b\2\2\u0199\u019a\b\61\36\2\u019a\u019b\3\2\2\2\u019b\u019c\b\61\13"+
		"\2\u019cg\3\2\2\2\u019d\u019e\7*\2\2\u019e\u019f\b\62\37\2\u019fi\3\2"+
		"\2\2\u01a0\u01a1\7$\2\2\u01a1\u01a2\b\63 \2\u01a2\u01a3\3\2\2\2\u01a3"+
		"\u01a4\b\63\t\2\u01a4k\3\2\2\2\u01a5\u01a6\7)\2\2\u01a6\u01a7\b\64!\2"+
		"\u01a7m\3\2\2\2\u01a8\u01a9\7>\2\2\u01a9\u01aa\7>\2\2\u01aa\u01ab\3\2"+
		"\2\2\u01ab\u01ac\b\65\"\2\u01aco\3\2\2\2\u01ad\u01ae\5\64\30\2\u01aeq"+
		"\3\2\2\2\u01af\u01b1\5\b\2\2\u01b0\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2"+
		"\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\b\67"+
		"\6\2\u01b5s\3\2\2\2\u01b6\u01b7\5\66\31\2\u01b7u\3\2\2\2\u01b8\u01b9\7"+
		"&\2\2\u01b9\u01ba\7*\2\2\u01ba\u01bb\7*\2\2\u01bb\u01bc\3\2\2\2\u01bc"+
		"\u01bd\b9#\2\u01bdw\3\2\2\2\u01be\u01bf\5\"\17\2\u01bf\u01c0\b:$\2\u01c0"+
		"\u01c1\3\2\2\2\u01c1\u01c2\b:\25\2\u01c2y\3\2\2\2\u01c3\u01c4\t\16\2\2"+
		"\u01c4\u01c5\b;%\2\u01c5{\3\2\2\2\u01c6\u01c7\7$\2\2\u01c7\u01c8\b<&\2"+
		"\u01c8\u01c9\3\2\2\2\u01c9\u01ca\b<\21\2\u01ca}\3\2\2\2\u01cb\u01d1\5"+
		"\f\4\2\u01cc\u01d1\5\30\n\2\u01cd\u01d1\5\b\2\2\u01ce\u01d1\5\20\6\2\u01cf"+
		"\u01d1\t\f\2\2\u01d0\u01cb\3\2\2\2\u01d0\u01cc\3\2\2\2\u01d0\u01cd\3\2"+
		"\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2"+
		"\u01d0\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\177\3\2\2\2\u01d4\u01d5\5\66"+
		"\31\2\u01d5\u0081\3\2\2\2\u01d6\u01da\7%\2\2\u01d7\u01d9\n\7\2\2\u01d8"+
		"\u01d7\3\2\2\2\u01d9\u01dc\3\2\2\2\u01da\u01d8\3\2\2\2\u01da\u01db\3\2"+
		"\2\2\u01db\u01dd\3\2\2\2\u01dc\u01da\3\2\2\2\u01dd\u01de\t\7\2\2\u01de"+
		"\u01df\b?\'\2\u01df\u0083\3\2\2\2\u01e0\u01e1\7&\2\2\u01e1\u01e2\7*\2"+
		"\2\u01e2\u01e3\7*\2\2\u01e3\u0085\3\2\2\2\u01e4\u01e5\5\"\17\2\u01e5\u01e6"+
		"\bA(\2\u01e6\u01e7\3\2\2\2\u01e7\u01e8\bA\25\2\u01e8\u0087\3\2\2\2\u01e9"+
		"\u01ea\7+\2\2\u01ea\u01eb\bB)\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed\bB\21"+
		"\2\u01ed\u0089\3\2\2\2\u01ee\u01ef\t\17\2\2\u01ef\u01f0\bC*\2\u01f0\u008b"+
		"\3\2\2\2\u01f1\u01f2\7$\2\2\u01f2\u01f3\bD+\2\u01f3\u01f4\3\2\2\2\u01f4"+
		"\u01f5\bD\27\2\u01f5\u008d\3\2\2\2\u01f6\u01f7\7)\2\2\u01f7\u01f8\bE,"+
		"\2\u01f8\u008f\3\2\2\2\u01f9\u01fa\7>\2\2\u01fa\u01fb\7>\2\2\u01fb\u01fc"+
		"\3\2\2\2\u01fc\u01fd\bF-\2\u01fd\u0091\3\2\2\2\u01fe\u01ff\5\64\30\2\u01ff"+
		"\u0093\3\2\2\2\u0200\u0202\5\b\2\2\u0201\u0200\3\2\2\2\u0202\u0203\3\2"+
		"\2\2\u0203\u0201\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0205\3\2\2\2\u0205"+
		"\u0206\bH\6\2\u0206\u0095\3\2\2\2#\2\3\4\5\6\7\u009d\u00a3\u00ad\u00af"+
		"\u00b7\u00bb\u00d1\u00d3\u00d8\u00f0\u00f7\u00f9\u010d\u010f\u0116\u011b"+
		"\u013c\u013e\u0146\u0151\u017a\u0184\u01b2\u01d0\u01d2\u01da\u0203.\3"+
		"\b\2\3\t\3\3\17\4\7\5\2\b\2\2\3\24\5\3\25\6\7\3\2\3\26\7\7\4\2\3\33\b"+
		"\3\34\t\3\35\n\3\36\13\3\37\f\6\2\2\3\"\r\3#\16\3%\17\7\7\2\3&\20\7\6"+
		"\2\3\'\21\3(\22\3)\23\3-\24\3/\25\3\60\26\3\61\27\3\62\30\3\63\31\3\64"+
		"\32\3\65\33\39\34\3:\35\3;\36\3<\37\3? \3A!\3B\"\3C#\3D$\3E%\3F&";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}