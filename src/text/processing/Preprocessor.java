package text.processing;

public class Preprocessor {

	private static String[] StopWordsRegexes = { "\\byourselves\\b|\\bthemselves\\b", "\\bourselves\\b|\\bshouldn't\\b",
			"\\bcouldn't\\b|\\bwouldn't\\b|\\byourself\\b",
			"\\bhaven't\\b|\\bwhere's\\b|\\bbecause\\b|\\bdoesn't\\b|\\bbetween\\b|\\bthere's\\b|\\bthey'll\\b|\\bweren't\\b|\\bhimself\\b|\\bagainst\\b|\\bmustn't\\b|\\bthey've\\b|\\bthrough\\b|\\bherself\\b|\\bthey're\\b|\\bfurther\\b",
			"\\bwhat's\\b|\\bduring\\b|\\bwasn't\\b|\\bshe'll\\b|\\bwhen's\\b|\\bhere's\\b|\\bhaving\\b|\\bmyself\\b|\\bitself\\b|\\bhasn't\\b|\\bhadn't\\b|\\byou've\\b|\\bcannot\\b|\\btheirs\\b|\\bbefore\\b|\\bshould\\b|\\bthey'd\\b|\\byou'll\\b|\\bdidn't\\b|\\baren't\\b|\\bthat's\\b|\\bshan't\\b|\\byou're\\b",
			"\\bdon't\\b|\\babout\\b|\\bthese\\b|\\bwould\\b|\\babove\\b|\\bhe'll\\b|\\bbeing\\b|\\bwe've\\b|\\bother\\b|\\bshe'd\\b|\\bwhy's\\b|\\bisn't\\b|\\bshe's\\b|\\bwhere\\b|\\bafter\\b|\\bcan't\\b|\\bought\\b|\\bcould\\b|\\bunder\\b|\\byours\\b|\\bwon't\\b|\\bwhile\\b|\\bhow's\\b|\\bthose\\b|\\bwhich\\b|\\byou'd\\b|\\bbelow\\b|\\blet's\\b|\\bwe're\\b|\\bdoing\\b|\\btheir\\b|\\bwho's\\b|\\bwe'll\\b|\\bagain\\b|\\bthere\\b|\\buntil\\b",
			"\\bvery\\b|\\bbeen\\b|\\byour\\b|\\bwhen\\b|\\bthey\\b|\\bthem\\b|\\bthen\\b|\\beach\\b|\\bi've\\b|\\binto\\b|\\bsame\\b|\\bdoes\\b|\\bhave\\b|\\bwhom\\b|\\bwe'd\\b|\\bmore\\b|\\bsuch\\b|\\bdown\\b|\\bthat\\b|\\bours\\b|\\bthan\\b|\\bonly\\b|\\bfrom\\b|\\bit's\\b|\\bthis\\b|\\bboth\\b|\\bmost\\b|\\bonce\\b|\\bwere\\b|\\bhere\\b|\\bsome\\b|\\bhers\\b|\\bhe's\\b|\\bover\\b|\\bhe'd\\b|\\bi'll\\b|\\bwith\\b|\\bwhat\\b",
			"\\bher\\b|\\byou\\b|\\bi'd\\b|\\bour\\b|\\bi'm\\b|\\bout\\b|\\bhow\\b|\\bare\\b|\\btoo\\b|\\boff\\b|\\bthe\\b|\\bdid\\b|\\bbut\\b|\\bown\\b|\\bhad\\b|\\bhim\\b|\\bhis\\b|\\bfew\\b|\\bhas\\b|\\ball\\b|\\bits\\b|\\bshe\\b|\\bwho\\b|\\bfor\\b|\\bwhy\\b|\\bnor\\b|\\bnot\\b|\\band\\b|\\bwas\\b|\\bany\\b",
			"\\bif\\b|\\bin\\b|\\bis\\b|\\bit\\b|\\bam\\b|\\ban\\b|\\bas\\b|\\bat\\b|\\bbe\\b|\\bby\\b|\\bso\\b|\\bto\\b|\\bdo\\b|\\bme\\b|\\bup\\b|\\bmy\\b|\\bno\\b|\\bwe\\b|\\bof\\b|\\bon\\b|\\bor\\b|\\bhe\\b",
			"\\ba\\b|\\bi\\b" };

	public static String Preprocess(String sentence) {
		String processedSentence = sentence.toLowerCase();
		for (String stopWordsRegex : StopWordsRegexes) {
			processedSentence = processedSentence.replaceAll(stopWordsRegex, "");
		}
		processedSentence = processedSentence.replaceAll("[^A-Za-z0-9]", " ");
		processedSentence = processedSentence.replaceAll("\\s+", " ");
		return processedSentence;
	}
}
