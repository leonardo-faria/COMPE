import java.util.regex.Pattern;

import org.antlr.v4.runtime.misc.NotNull;

public class MyListener extends XmltoSdlParserBaseListener {
	@Override
	public void exitRegion(@NotNull XmltoSdlParser.RegionContext ctx) {

		String str = ctx.value().getText().split("\"")[1];

		if (str.length() > 48) {
			System.out.println("Line " + ctx.value().getStart().getLine()
					+ ": invalid " + str);
			return;
		}
	}

	@Override
	public void exitLat(@NotNull XmltoSdlParser.LatContext ctx) {

		try {
			float val = Float.parseFloat(ctx.value().getText().split("\"")[1]);

			if (val < -90.0 || val > 90) {
				System.out.println("Line " + ctx.value().getStart().getLine()
						+ ": invalid " + val);
				return;
			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + ctx.value().getStart().getLine()
					+ ": invalid " + ctx.value().getText());
			return;
		} catch (NullPointerException e) {
			System.out.println("Missing component lat");
			return;
		}

	}

	@Override
	public void exitLon(@NotNull XmltoSdlParser.LonContext ctx) {

		try {
			float val = Float.parseFloat(ctx.value().getText().split("\"")[1]);

			if (val < -180.0 || val > 180) {
				System.out.println("Line " + ctx.value().getStart().getLine()
						+ ": invalid " + val);
				return;
			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + ctx.value().getStart().getLine()
					+ ": invalid " + ctx.value().getText());
			return;
		} catch (NullPointerException e) {
			System.out.println("Missing component lon");
			return;
		}
	}

	@Override
	public void exitAlt(@NotNull XmltoSdlParser.AltContext ctx) {

		try {
			String str = ctx.value().getText().split("\"")[1];

			if (Pattern.compile("[a-zA-Z]").matcher(str).find()) {
				if (str.charAt((str.length() - 1)) != -'M'
						&& str.charAt((str.length() - 1)) != 'F') {
					System.out.println("Line "
							+ ctx.value().getStart().getLine() + ": invalid "
							+ ctx.value().getText());
					return;
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Missing component alt");
			return;
		}
	}

	@Override
	public void exitMagvar(@NotNull XmltoSdlParser.MagvarContext ctx) {

		try {
			float val = Float.parseFloat(ctx.value().getText().split("\"")[1]);

			if (val < -360.0 || val > 360) {
				System.out.println("Line " + ctx.value().getStart().getLine()
						+ ": invalid " + val);
				return;
			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + ctx.value().getStart().getLine()
					+ ": invalid " + ctx.value().getText());
			return;
		}
	}

	@Override
	public void exitIdent(@NotNull XmltoSdlParser.IdentContext ctx) {

		try {
			if (ctx.value().getText().split("\"")[1].length() > 4) {
				System.out.println("Line " + ctx.value().getStart().getLine()
						+ ": invalid " + ctx.value().getText());
				return;
			}
		} catch (NullPointerException e) {
			System.out.println("Missing component ident");
			return;
		}
	}

	@Override
	public void exitAirportTestRadius(
			@NotNull XmltoSdlParser.AirportTestRadiusContext ctx) {

		try {
			String str = ctx.value().getText().split("\"")[1];

			if (str.charAt((str.length() - 1)) != 'M'
					&& str.charAt((str.length() - 1)) != 'F'
					&& str.charAt((str.length() - 1)) != 'N') {
				System.out.println("Line " + ctx.value().getStart().getLine()
						+ ": invalid " + str);

				return;
			}
		} catch (NullPointerException e) {
			System.out.println("Missing component airport test radius");
			return;
		}
	}

	@Override
	public void exitTrafficScalar(
			@NotNull XmltoSdlParser.TrafficScalarContext ctx) {

		try {
			float val = Float.parseFloat(ctx.value().getText().split("\"")[1]);

			if (val < 0.01 || val > 1.0) {
				System.out.println("Line " + ctx.value().getStart().getLine()
						+ ": invalid " + val);
				return;
			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + ctx.value().getStart().getLine()
					+ ": invalid " + ctx.value().getText());
			return;
		} catch (NullPointerException e) {
			System.out.println("Missing component traffic scalar");
			return;
		}
	}
}