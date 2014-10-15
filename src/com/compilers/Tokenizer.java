package com.compilers;

import com.compilers.exception.SyntaxException;

import java.util.LinkedList;
public class Tokenizer {

	public static LinkedList<Token> getTokens(String input)
		throws SyntaxException {

		char[] chars = input.toCharArray();

		LinkedList<Token> tokens = new LinkedList<Token>();

		String value = "";

		for (int i = 0; i < chars.length; i++) {
			switch (chars[i]) {
				case ' ':
					break;
				case Punctuation.L_PARENT:
					tokens.add(
						new Token(TokenType.L_PARENT, String.valueOf(chars[i]))
					);

					value = "";

					break;
				case Punctuation.R_PARENT:
					tokens.add(
						new Token(TokenType.R_PARENT, String.valueOf(chars[i]))
					);

					value = "";

					break;
				case Punctuation.QUOTE:
					while (i < chars.length) {
						if (++i > (chars.length - 1)) {
							throw new SyntaxException("Unterminated string");
						}
						else if (chars[i] == Punctuation.QUOTE) {
							tokens.add(
								new Token(TokenType.STRING, value)
							);

							break;
						}

						value += chars[i];
					}

					value = "";

					break;
				default:
					throw new SyntaxException(
						"Unkown operator \"" + String.valueOf(chars[i]) + "\"");
			}
		}

		return tokens;
	}

}