import gui.PanAndZoom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.gui.TreeViewer;
public class Starter {

	public static void main(String[] args) throws IOException {

		String inputFile = null;
		if(args.length > 0) inputFile = args[0];
		InputStream is = System.in;
		if(inputFile != null) is = new FileInputStream(inputFile);

		ANTLRInputStream input = new ANTLRInputStream(is);

		XmltoSdlLexer lexer = new XmltoSdlLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		XmltoSdlParser parser = new XmltoSdlParser(tokens);

		ParserRuleContext tree = parser.startpoint(); // parse

		//System.out.println(tree.toStringTree(parser)); // print LISP-style tree

		TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);
		viewr.setScale(1);		
		PanAndZoom pan = new PanAndZoom(viewr);

		ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker

		MyListener extractor = new MyListener();
		walker.walk(extractor, tree); // initiate walk of tree with listener
	}

}