import java.util.Arrays;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.misc.NotNull;

public class MyListener extends XmltoSdlParserBaseListener {	
	XmltoSdlParser.ValueContext value;

	@Override 
	public void exitAirport_atr(@NotNull XmltoSdlParser.Airport_atrContext ctx) 
	{ 
		//ident
		value = ctx.ident().value();
		try {
			if (value.getText().split("\"")[1].length() > 4) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());

			}
		} catch (NullPointerException e) {
			System.out.println("Missing component ident");

		}

		//airporttestreadius
		value = ctx.airportTestRadius().value();
		try {
			String str = value.getText().split("\"")[1];

			if (str.charAt((str.length() - 1)) != 'M'
					&& str.charAt((str.length() - 1)) != 'F'
					&& str.charAt((str.length() - 1)) != 'N') {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + str);


			}
		} catch (NullPointerException e) {
			System.out.println("Missing component airport test radius");

		}

		//trafficscalar
		value = ctx.trafficScalar().value();
		try {
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0.01 || val > 1.0) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());

		} catch (NullPointerException e) {
			System.out.println("Missing component traffic scalar");

		}

	}

	@Override
	public void exitLat(@NotNull XmltoSdlParser.LatContext ctx) {

		try {
			float val = Float.parseFloat(ctx.value().getText().split("\"")[1]);

			if (val < -90.0 || val > 90) {
				System.out.println("Line " + ctx.value().getStart().getLine()
						+ ": invalid " + val);

			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + ctx.value().getStart().getLine()
					+ ": invalid " + ctx.value().getText());

		} catch (NullPointerException e) {
			System.out.println("Missing component lat");

		}

	}

	@Override
	public void exitLon(@NotNull XmltoSdlParser.LonContext ctx) {

		try {
			float val = Float.parseFloat(ctx.value().getText().split("\"")[1]);

			if (val < -180.0 || val > 180) {
				System.out.println("Line " + ctx.value().getStart().getLine()
						+ ": invalid " + val);

			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + ctx.value().getStart().getLine()
					+ ": invalid " + ctx.value().getText());

		} catch (NullPointerException e) {
			System.out.println("Missing component lon");

		}
	}

	@Override
	public void exitAlt(@NotNull XmltoSdlParser.AltContext ctx) {

		try {
			String str = ctx.value().getText().split("\"")[1];

			if (Pattern.compile("[a-zA-Z]").matcher(str).find()) {
				if (str.charAt((str.length() - 1)) != 'M'
						&& str.charAt((str.length() - 1)) != 'F') {
					System.out.println("Line "
							+ ctx.value().getStart().getLine() + ": invalid "
							+ ctx.value().getText());

				}
			}
		} catch (NullPointerException e) {
			System.out.println("Missing component alt");

		}
	}

	@Override 
	public void exitFuel_type(@NotNull XmltoSdlParser.Fuel_typeContext ctx) 
	{ 
		try{
			value = ctx.value();

			String val = value.getText().split("\"")[1];
			String[] typeOptions = {"73","87","100","130","145","MOGAS","JET","JETA","JETA1","JETAP","JETB","JET4","JET5","UNKNOWN"};
			if(!Arrays.asList(typeOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong fuel type: " + value.getText() + ". Expected: " + Arrays.toString(typeOptions));


			}
		} catch (NullPointerException e) {
			System.out.println("Missing component fuel type");

		}
	}

	@Override 
	public void exitAvailability(@NotNull XmltoSdlParser.AvailabilityContext ctx) 
	{ 
		try{
			value = ctx.value();

			String val = value.getText().split("\"")[1];
			String[] typeOptions = {"YES","NO","PRIOR_REQUEST","UNKNOWN"};
			if(!Arrays.asList(typeOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong fuel availabilty: " + value.getText() + ". Expected: " + Arrays.toString(typeOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component fuel availabilty");

		}
	}

	@Override
	public void exitCom_frequency(@NotNull XmltoSdlParser.Com_frequencyContext ctx) {

		try {
			float val = Float.parseFloat(ctx.value().getText().split("\"")[1]);

			if (val < 108.0 || val > 136.992) {
				System.out.println("Line " + ctx.value().getStart().getLine()
						+ ": invalid " + val);

			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + ctx.value().getStart().getLine()
					+ ": invalid " + ctx.value().getText());

		} catch (NullPointerException e) {
			System.out.println("Missing component com frequency");
		}
	}

	@Override 
	public void exitCom_type(@NotNull XmltoSdlParser.Com_typeContext ctx) 
	{ 
		try{
			value = ctx.value();

			String val = value.getText().split("\"")[1];
			String[] typeOptions = {"APPROACH","ASOS","ATIS","AWOS","CENTER","CLEARANCE","CLEARANCE_PRE_TAXI",
					"CTAF","DEPARTURE","FSS","GROUND","MULTICOM","REMOTE_CLEARANCE_DELIVERY","TOWER","UNICOM"};
			if(!Arrays.asList(typeOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong COM type: " + value.getText() + ". Expected: " + Arrays.toString(typeOptions));


			}
		} catch (NullPointerException e) {
			System.out.println("Missing component com type");

		}
	}

	@Override 
	public void exitRunway_atr(@NotNull XmltoSdlParser.Runway_atrContext ctx) 
	{ 
		//surface
		try{
			value = ctx.surface().value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"ASPHALT","BITUMINOUS","BRICK","CLAY","CEMENT","CONCRETE","CORAL","DIRT","GRASS","GRAVEL","ICE","MACADAM","OIL_TREATED, PLANKS","SAND","SHALE","SNOW","STEEL_MATS","TARMAC","UNKNOWN","WATER"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong surface type: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));


			}
		} catch (NullPointerException e) {
			System.out.println("Missing component runway surface");

		}

		//heading
		try{
			value = ctx.heading().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0 || val > 360) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());

		} catch (NullPointerException e) {
			System.out.println("Missing component runway heading");
		}

		//length
		try{
			value = ctx.length().value();
			String str = value.getText().split("\"")[1];

			if (Pattern.compile("[a-zA-Z]").matcher(str).find()) {
				if (str.charAt((str.length() - 1)) != 'M'
						&& str.charAt((str.length() - 1)) != 'F') {
					System.out.println("Line "
							+ value.getStart().getLine() + ": invalid "
							+ value.getText());

				}
			}
		}catch (NullPointerException e) {
			System.out.println("Missing component runway length");

		}

		//width
		try{
			value = ctx.width().value();
			String str = value.getText().split("\"")[1];

			if (Pattern.compile("[a-zA-Z]").matcher(str).find()) {
				if (str.charAt((str.length() - 1)) != 'M'
						&& str.charAt((str.length() - 1)) != 'F') {
					System.out.println("Line "
							+ value.getStart().getLine() + ": invalid "
							+ value.getText());

				}
			}
		}catch (NullPointerException e) {
			System.out.println("Missing component runway width");

		}

		//number
		try{
			value = ctx.runway_number().value();
			String[] numberOptions = {"EAST","NORTH","NORTHEAST","NORTHWEST","SOUTH","SOUTHEAST","SOUTHWEST","WEST"};
			String str = value.getText().split("\"")[1];

			if(!Arrays.asList(numberOptions).contains(value.getText()) &&
					(Integer.parseInt(str) < 0 || Integer.parseInt(str) > 36)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong runway number: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions) + ",or a int from 00 to 36");


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component runway number");

		}

		//designator


		//patternAltitude
		try{
			value = ctx.patternAltitude().value();
			String str = value.getText().split("\"")[1];

			if (Pattern.compile("[a-zA-Z]").matcher(str).find()) {
				if (str.charAt((str.length() - 1)) != 'M'
						&& str.charAt((str.length() - 1)) != 'F') {
					System.out.println("Line "
							+ value.getStart().getLine() + ": invalid "
							+ value.getText());

				}
			}
		}catch (NullPointerException e) {
			//nao é obrigatorio
		}

		//primaryTakeoff
		try{
			value = ctx.primaryTakeoff().value();
			String[] numberOptions = {"TRUE","YES","FALSE","NO"};
			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong primaryTakeoff: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			//nao é obrigatorio
		}

		//primaryLanding
		try{
			value = ctx.primaryLanding().value();
			String[] numberOptions = {"TRUE","YES","FALSE","NO"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong primary Landing: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			//nao é obrigatorio
		}

		//primaryPattern
		try{
			value = ctx.primaryPattern().value();
			String[] numberOptions = {"LEFT","RIGHT"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong primary Pattern: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			//nao é obrigatorio
		}

		//secondaryTakeoff
		try{
			value = ctx.secondaryTakeoff().value();
			String[] numberOptions = {"TRUE","YES","FALSE","NO"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong primary takeoff: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			//nao é obrigatorio
		}

		//secondaryLanding
		try{
			value = ctx.secondaryLanding().value();
			String[] numberOptions = {"TRUE","YES","FALSE","NO"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong secondary Landing: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			//nao é obrigatorio
		}

		//secondaryPattern
		try{
			value = ctx.secondaryPattern().value();
			String[] numberOptions = {"LEFT","RIGHT"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong secondary pattern: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			//nao é obrigatorio
		}

		//primaryMarking BIAS
		try{
			value = ctx.primaryMarkingBias().value();
			String str = value.getText().split("\"")[1];

			if (Pattern.compile("[a-zA-Z]").matcher(str).find()) {
				if (str.charAt((str.length() - 1)) != 'M'
						&& str.charAt((str.length() - 1)) != 'N' && str.charAt((str.length() - 1)) != 'F') {
					System.out.println("Line "
							+ value.getStart().getLine() + ": invalid "
							+ value.getText());

				}
			}
		}catch (NullPointerException e) {
			System.out.println("Missing component runway primaryMarking BIAS");
		}

		//secondaryMarking BIAS
		try{
			value = ctx.secondaryMarkingBias().value();
			String str = value.getText().split("\"")[1];

			if (Pattern.compile("[a-zA-Z]").matcher(str).find()) {
				if (str.charAt((str.length() - 1)) != 'M'
						&& str.charAt((str.length() - 1)) != 'N' && str.charAt((str.length() - 1)) != 'F') {
					System.out.println("Line "
							+ value.getStart().getLine() + ": invalid "
							+ value.getText());
				}
			}
		}catch (NullPointerException e) {
			System.out.println("Missing component runway secondaryMarking BIAS");
		}
	}

	@Override 
	public void exitMarkings(@NotNull XmltoSdlParser.MarkingsContext ctx){
		try{
			value = ctx.edges().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component edges");
		}

		try{
			value = ctx.threshold().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component threshold");
		}

		try{
			value = ctx.fixedDistance().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component fixedDistance");
		}

		try{
			value = ctx.touchdown().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component touchdown");
		}

		try{
			value = ctx.dashes().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component dashes");
		}

		try{
			value = ctx.marking_ident().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component marking_ident");
		}

		try{
			value = ctx.precision().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component precision");
		}

		try{
			value = ctx.edgePavement().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component edgePavement");
		}

		try{
			value = ctx.singleEnd().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component singleEnd");
		}

		try{
			value = ctx.primaryClosed().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component primaryClosed");
		}

		try{
			value = ctx.secondaryClosed().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component secondaryClosed");
		}

		try{
			value = ctx.primaryStol().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component primaryStol");
		}

		try{
			value = ctx.secondaryStol().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component secondaryStol");
		}
	}

	@Override
	public void exitLights(@NotNull XmltoSdlParser.LightsContext ctx){
		try{
			value = ctx.center().value();
			String[] numberOptions = {"NONE","LOW","MEDIUM","HIGH"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component center in lights block");
		}

		try{
			value = ctx.edge().value();
			String[] numberOptions = {"NONE","LOW","MEDIUM","HIGH"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component edge in lights block");
		}

		try{
			value = ctx.centerRed().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component center red in lights block");
		}
	}

	@Override
	public void exitOffsetThreshold(@NotNull XmltoSdlParser.OffsetThresholdContext ctx){
		try{
			value = ctx.end().value();
			String[] numberOptions = {"PRIMARY","SECONDARY"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component end in offset threshold block");
		}

		try{
			value = ctx.surface().value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"ASPHALT","BITUMINOUS","BRICK","CLAY","CEMENT","CONCRETE","CORAL","DIRT","GRASS","GRAVEL","ICE","MACADAM","OIL_TREATED, PLANKS","SAND","SHALE","SNOW","STEEL_MATS","TARMAC","UNKNOWN","WATER"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong surface type: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));


			}
		} catch (NullPointerException e) {

		}

		//length
		try{
			value = ctx.length().value();
			String str = value.getText().split("\"")[1];

			if (Pattern.compile("[a-zA-Z]").matcher(str).find()) {
				if (str.charAt((str.length() - 1)) != 'M'
						&& str.charAt((str.length() - 1)) != 'F') {
					System.out.println("Line "
							+ value.getStart().getLine() + ": invalid "
							+ value.getText());

				}
			}
		}catch (NullPointerException e) {
			System.out.println("Missing component offsetThreshold length");
		}

		//width
		try{
			value = ctx.width().value();
			String str = value.getText().split("\"")[1];

			if (Pattern.compile("[a-zA-Z]").matcher(str).find()) {
				if (str.charAt((str.length() - 1)) != 'M'
						&& str.charAt((str.length() - 1)) != 'F') {
					System.out.println("Line "
							+ value.getStart().getLine() + ": invalid "
							+ value.getText());

				}
			}
		}catch (NullPointerException e) {

		}
	}

	@Override
	public void exitBlastPad(@NotNull XmltoSdlParser.BlastPadContext ctx){
		try{
			value = ctx.end().value();
			String[] numberOptions = {"PRIMARY","SECONDARY"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component end in BlastPad block");
		}

		try{
			value = ctx.surface().value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"ASPHALT","BITUMINOUS","BRICK","CLAY","CEMENT","CONCRETE","CORAL","DIRT","GRASS","GRAVEL","ICE","MACADAM","OIL_TREATED, PLANKS","SAND","SHALE","SNOW","STEEL_MATS","TARMAC","UNKNOWN","WATER"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong surface type: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));


			}
		} catch (NullPointerException e) {

		}

		//length
		try{
			value = ctx.length().value();
			String str = value.getText().split("\"")[1];

			if (Pattern.compile("[a-zA-Z]").matcher(str).find()) {
				if (str.charAt((str.length() - 1)) != 'M'
						&& str.charAt((str.length() - 1)) != 'F') {
					System.out.println("Line "
							+ value.getStart().getLine() + ": invalid "
							+ value.getText());

				}
			}
		}catch (NullPointerException e) {
			System.out.println("Missing component BlastPad length");
		}

		//width
		try{
			value = ctx.width().value();
			String str = value.getText().split("\"")[1];

			if (Pattern.compile("[a-zA-Z]").matcher(str).find()) {
				if (str.charAt((str.length() - 1)) != 'M'
						&& str.charAt((str.length() - 1)) != 'F') {
					System.out.println("Line "
							+ value.getStart().getLine() + ": invalid "
							+ value.getText());

				}
			}
		}catch (NullPointerException e) {

		}
	}

	@Override
	public void exitOverrun(@NotNull XmltoSdlParser.OverrunContext ctx){
		try{
			value = ctx.end().value();
			String[] numberOptions = {"PRIMARY","SECONDARY"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component end in Overrun block");
		}

		try{
			value = ctx.surface().value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"ASPHALT","BITUMINOUS","BRICK","CLAY","CEMENT","CONCRETE","CORAL","DIRT","GRASS","GRAVEL","ICE","MACADAM","OIL_TREATED, PLANKS","SAND","SHALE","SNOW","STEEL_MATS","TARMAC","UNKNOWN","WATER"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong surface type: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));


			}
		} catch (NullPointerException e) {

		}

		//length
		try{
			value = ctx.length().value();
			String str = value.getText().split("\"")[1];

			if (Pattern.compile("[a-zA-Z]").matcher(str).find()) {
				if (str.charAt((str.length() - 1)) != 'M'
						&& str.charAt((str.length() - 1)) != 'F') {
					System.out.println("Line "
							+ value.getStart().getLine() + ": invalid "
							+ value.getText());

				}
			}
		}catch (NullPointerException e) {
			System.out.println("Missing component Overrun length");
		}

		//width
		try{
			value = ctx.width().value();
			String str = value.getText().split("\"")[1];

			if (Pattern.compile("[a-zA-Z]").matcher(str).find()) {
				if (str.charAt((str.length() - 1)) != 'M'
						&& str.charAt((str.length() - 1)) != 'F') {
					System.out.println("Line "
							+ value.getStart().getLine() + ": invalid "
							+ value.getText());

				}
			}
		}catch (NullPointerException e) {

		}
	}

	@Override
	public void exitApproachLights(@NotNull XmltoSdlParser.ApproachLightsContext ctx){
		try{
			value = ctx.end().value();
			String[] numberOptions = {"PRIMARY","SECONDARY"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component end in ApproachLights block");
		}

		try{
			value = ctx.system().value();
			String[] numberOptions = {"NONE","ALSF1","ALSF2","CALVERT","CALVERT2","MALS","MALSF","MALSR","ODALS","RAIL","SALS","SALSF","SSALF","SSALR","SSALS"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
		}

		try {
			value = ctx.strobes().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());

		} catch (NullPointerException e) {

		}

		try{
			value = ctx.reil().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
		}

		try{
			value = ctx.touchdown().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
		}

		try{
			value = ctx.endlights().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
		}
	}

	@Override
	public void exitVasi(@NotNull XmltoSdlParser.VasiContext ctx){
		try{
			value = ctx.end().value();
			String[] numberOptions = {"PRIMARY","SECONDARY"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component end in Vasi block");
		}

		try{
			value = ctx.vasi_type().value();
			String[] numberOptions = {"PAPI2","PAPI4","PVASI","TRICOLOR","TVASI","VASI21",
					"VASI22","VASI23","VASI31","VASI32","VASI33","BALL","APAP","PANELS"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component type in Vasi block");
		}

		try{
			value = ctx.side().value();
			String[] numberOptions = {"LEFT","RIGHT"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component side in Vasi block");
		}


		try {
			value = ctx.spacing().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());

		} catch (NullPointerException e) {
			System.out.println("Missing component spacing in Vasi block");
		}

		try {
			value = ctx.pitch().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0 || val > 10.0) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());

		} catch (NullPointerException e) {
			System.out.println("Missing component pitch in Vasi block");
		}
	}

	@Override
	public void exitIls_open(@NotNull XmltoSdlParser.Ils_openContext ctx){
		//heading
		try{
			value = ctx.heading().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0 || val > 360) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());

		} catch (NullPointerException e) {
			System.out.println("Missing component ils heading");
		}

		try {
			value = ctx.frequency().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 108.0 || val > 136.992) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());

		} catch (NullPointerException e) {
			System.out.println("Missing component ils frequency");
		}

		try{
			value = ctx.end().value();
			String[] numberOptions = {"PRIMARY","SECONDARY"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
			System.out.println("Missing component end in ILS block");
		}

		try{
			value = ctx.range().value();
			String str = value.getText().split("\"")[1];

			if (Pattern.compile("[a-zA-Z]").matcher(str).find()) {
				if (str.charAt((str.length() - 1)) != 'M'
						&& str.charAt((str.length() - 1)) != 'N') {
					System.out.println("Line "
							+ value.getStart().getLine() + ": invalid "
							+ value.getText());

				}
			}
		}catch (NullPointerException e) {

		}

		try {
			value = ctx.magvar().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < -360.0 || val > 360.0) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());

		} catch (NullPointerException e) {
			System.out.println("Missing component ils magvar");
		}

		try{
			value = ctx.ident().value();
			String str = value.getText().split("\"")[1];

			if (str.length() > 5) {
				System.out.println("Line "
						+ value.getStart().getLine() + ": invalid "
						+ value.getText());
			}
		}catch (NullPointerException e) {
			System.out.println("Missing component ils ident");
		}
		
		try {
			value = ctx.width().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0 || val > 360.0) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());

		} catch (NullPointerException e) {
		}
		
		try{
			value = ctx.backCourse().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));


			}
		}catch (NullPointerException e) {
		}
	}

	@Override
	public void exitGlideSlope(@NotNull XmltoSdlParser.GlideSlopeContext ctx){
		try{
			value = ctx.pitch().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0 || val > 360) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());

		} catch (NullPointerException e) {
			System.out.println("Missing component glideslope pitch");
		}
		
		try{
			value = ctx.range().value();
			String str = value.getText().split("\"")[1];

			if (Pattern.compile("[a-zA-Z]").matcher(str).find()) {
				if (str.charAt((str.length() - 1)) != 'M'
						&& str.charAt((str.length() - 1)) != 'N') {
					System.out.println("Line "
							+ value.getStart().getLine() + ": invalid "
							+ value.getText());

				}
			}
		}catch (NullPointerException e) {
			System.out.println("Missing component glideslope range");
		}
	}
}