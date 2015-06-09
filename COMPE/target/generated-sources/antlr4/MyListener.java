import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.misc.NotNull;

import sdlBuilder.SdlBuilder;

public class MyListener extends XmltoSdlParserBaseListener {	
	XmltoSdlParser.ValueContext value;

	HashMap<String,HashMap<String,String>> airportAttrs;
	HashMap<String,HashMap<String,String>> fuels;
	HashMap<String,HashMap<String,String>> coms;
	HashMap<String,HashMap<String,String>> runwayAttrs;
	HashMap<String,HashMap<String,String>> markings;
	HashMap<String,HashMap<String,String>> lights;
	HashMap<String,HashMap<String,String>> offsetThreshold;
	HashMap<String,HashMap<String,String>> blastPads;
	HashMap<String,HashMap<String,String>> overRuns;
	HashMap<String,HashMap<String,String>> approachLights;
	HashMap<String,HashMap<String,String>> vasi;
	HashMap<String,HashMap<String,String>> ils;
	HashMap<String,HashMap<String,String>> glideSlope;
	HashMap<String,HashMap<String,String>> visualModel;
	HashMap<String,HashMap<String,String>> dme;
	HashMap<String,HashMap<String,String>> runwayStart;
	HashMap<String,HashMap<String,String>> runwayAlias;
	HashMap<String,HashMap<String,String>> helipad;
	HashMap<String,HashMap<String,String>> taxiwayPoint;
	HashMap<String,HashMap<String,String>> taxiwayParking;
	HashMap<String,HashMap<String,String>> taxiwayPath;
	HashMap<String,HashMap<String,String>> taxiName;

	int airportIndex;
	int fuelsIndex;
	int comsIndex;
	int runwayIndex;
	int markingsIndex;
	int lightsIndex;
	int offsetThresholdIndex;
	int blastPadIndex;
	int overRunIndex;
	int approachLightsIndex;
	int vasiIndex;
	int ilsIndex;
	int glideSlopeIndex;
	int visualModelIndex;
	int dmeIndex;
	int runwayStartIndex;
	int runwayAliasIndex;
	int taxiwayPointIndex;
	int taxiwayParkingIndex;
	int taxiwayPathIndex;
	int taxiNameIndex;
	int helipadIndex;
	boolean canBuildSdl = true;


	@Override
	public void enterXmlItems(@NotNull XmltoSdlParser.XmlItemsContext ctx){
		taxiName = new HashMap<String,HashMap<String,String>>();
		taxiwayPath = new HashMap<String,HashMap<String,String>>();
		taxiwayParking = new HashMap<String,HashMap<String,String>>();
		taxiwayPoint = new HashMap<String,HashMap<String,String>>();
		helipad = new HashMap<String,HashMap<String,String>>();
		runwayAlias = new HashMap<String,HashMap<String,String>>();
		runwayStart = new HashMap<String,HashMap<String,String>>();
		dme = new HashMap<String,HashMap<String,String>>();
		visualModel = new HashMap<String,HashMap<String,String>>();
		glideSlope = new HashMap<String,HashMap<String,String>>();
		ils = new HashMap<String,HashMap<String,String>>();
		vasi = new HashMap<String,HashMap<String,String>>();
		approachLights = new HashMap<String,HashMap<String,String>>();
		overRuns = new HashMap<String,HashMap<String,String>>();
		blastPads = new HashMap<String,HashMap<String,String>>();
		offsetThreshold = new HashMap<String,HashMap<String,String>>();
		lights = new HashMap<String,HashMap<String,String>>();
		markings = new HashMap<String,HashMap<String,String>>();
		fuels = new HashMap<String,HashMap<String,String>>();
		runwayAttrs = new HashMap<String,HashMap<String,String>>();
		coms = new HashMap<String,HashMap<String,String>>();
		airportAttrs = new HashMap<String,HashMap<String,String>>();
		airportIndex = -1;
	}

	@Override
	public void enterAirport(@NotNull XmltoSdlParser.AirportContext ctx){
		airportIndex++;
		fuelsIndex = -1;
		comsIndex = -1;
		runwayIndex = -1;
		runwayAliasIndex = -1;
		helipadIndex = -1;
		taxiwayPointIndex = -1;
		taxiwayParkingIndex = -1;
		taxiwayPathIndex = -1;
		taxiNameIndex = -1;
	}

	@Override
	public void enterFuel(@NotNull XmltoSdlParser.FuelContext ctx){
		fuelsIndex++;
	}

	@Override
	public void enterCom(@NotNull XmltoSdlParser.ComContext ctx){
		comsIndex++;
	}

	@Override
	public void enterRunway(@NotNull XmltoSdlParser.RunwayContext ctx){
		runwayIndex++;
		markingsIndex = -1;
		offsetThresholdIndex =1; 
		lightsIndex = -1;
		blastPadIndex = -1;
		overRunIndex = -1;
		approachLightsIndex = -1;
		vasiIndex = -1;
		ilsIndex = -1;
		runwayStartIndex = -1;
	}

	@Override
	public void enterMarkings(@NotNull XmltoSdlParser.MarkingsContext ctx){
		markingsIndex++;
	}

	@Override
	public void enterLights(@NotNull XmltoSdlParser.LightsContext ctx){
		lightsIndex++;
	}

	@Override
	public void enterOffsetThreshold(@NotNull XmltoSdlParser.OffsetThresholdContext ctx){
		offsetThresholdIndex++;
	}

	@Override
	public void enterBlastPad(@NotNull XmltoSdlParser.BlastPadContext ctx){
		blastPadIndex++;
	}

	@Override
	public void enterOverrun(@NotNull XmltoSdlParser.OverrunContext ctx){
		overRunIndex++;
	}

	@Override
	public void enterApproachLights(@NotNull XmltoSdlParser.ApproachLightsContext ctx){
		approachLightsIndex++;
	}

	@Override
	public void enterVasi(@NotNull XmltoSdlParser.VasiContext ctx){
		vasiIndex++;
	}

	@Override
	public void enterIls(@NotNull XmltoSdlParser.IlsContext ctx){
		ilsIndex++;

		glideSlopeIndex = -1;
		visualModelIndex = -1;
		dmeIndex = -1;
	}

	@Override
	public void enterGlideSlope(@NotNull XmltoSdlParser.GlideSlopeContext ctx){
		glideSlopeIndex++;
	}

	@Override
	public void enterVisualModel(@NotNull XmltoSdlParser.VisualModelContext ctx){
		visualModelIndex++;
	}

	@Override
	public void enterDme(@NotNull XmltoSdlParser.DmeContext ctx){
		dmeIndex++;
	}

	@Override
	public void enterRunwayStart(@NotNull XmltoSdlParser.RunwayStartContext ctx){
		runwayIndex++;
	}

	@Override
	public void enterRunwayAlias(@NotNull XmltoSdlParser.RunwayAliasContext ctx){
		runwayAliasIndex++;
	}

	@Override
	public void enterHelipad(@NotNull XmltoSdlParser.HelipadContext ctx){
		helipadIndex++;
	}


	@Override
	public void enterTaxiwayPoint(@NotNull XmltoSdlParser.TaxiwayPointContext ctx){
		taxiwayPointIndex++;
	}

	@Override
	public void enterTaxiwayParking(@NotNull XmltoSdlParser.TaxiwayParkingContext ctx){
		taxiwayParkingIndex++;
	}

	@Override
	public void enterTaxiwayPath(@NotNull XmltoSdlParser.TaxiwayPathContext ctx){
		taxiwayPathIndex++;
	}

	@Override
	public void enterTaxiName(@NotNull XmltoSdlParser.TaxiNameContext ctx){
		taxiNameIndex++;
	}

	public boolean checkStringSize(String s, int max){
		if (s.length() > max) {
			return true;
		}
		else
			return false;
	}

	public String checkStringSuffix(String s){
		if (Pattern.compile("[a-zA-Z]").matcher(s).find()) {
			if (s.charAt((s.length() - 1)) != 'M'
					&& s.charAt((s.length() - 1)) != 'F'
					&& s.charAt((s.length() - 1)) != 'N') {
				return "";
			}
			return s;
		}
		return s + "M";		
	}


	@Override 
	public void exitAirport_atr(@NotNull XmltoSdlParser.Airport_atrContext ctx) 
	{ 

		HashMap<String,String> attrs = new HashMap<String,String>();

		//ident
		if(ctx.ident().size() == 0){
			System.out.println("Missing component ident");
			canBuildSdl = false;
		}
		else if(ctx.ident().size() > 1){
			System.out.println("Duplicate attribute ident");
			canBuildSdl = false;
		}
		else{

			value = ctx.ident().get(0).value();
			String s = value.getText().split("\"")[1];
			if (checkStringSize(s, 4)) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else{
				attrs.put("ident", s);
			}
		}

		//region
		if(ctx.region().size() == 0){
			attrs.put("region", "");
		}
		else if(ctx.region().size() > 1){
			System.out.println("Duplicate attribute region");
			canBuildSdl = false;
		}
		else{
			value = ctx.region().get(0).value();
			String s = value.getText().split("\"")[1];
			if (checkStringSize(s, 48)) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;

			}
			else{
				attrs.put("region", s);
			}
		}

		//country
		if(ctx.country().size() == 0){
			attrs.put("country", "");
		}
		else if(ctx.country().size() > 1){
			System.out.println("Duplicate attribute country");
			canBuildSdl = false;
		}
		else{

			value = ctx.country().get(0).value();
			String s = value.getText().split("\"")[1];
			if (checkStringSize(s, 48)) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;

			}
			else{
				attrs.put("country", s);
			}
		}

		//state
		if(ctx.state().size() == 0){
			attrs.put("state", "");
		}
		else if(ctx.state().size() > 1){
			System.out.println("Duplicate attribute state");
			canBuildSdl = false;
		}
		else{

			value = ctx.state().get(0).value();
			String s = value.getText().split("\"")[1];
			if (checkStringSize(s, 48)) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;

			}
			else{
				attrs.put("state", s);
			}
		}

		//city
		if(ctx.city().size() == 0){
			attrs.put("city", "");
		}
		else if(ctx.city().size() > 1){
			System.out.println("Duplicate attribute city");
			canBuildSdl = false;
		}
		else{

			value = ctx.city().get(0).value();
			String s = value.getText().split("\"")[1];
			if (checkStringSize(s, 48)) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;

			}
			else{
				attrs.put("city", s);
			}
		}

		//name
		if(ctx.name().size() == 0){
			attrs.put("name", "");
		}
		else if(ctx.name().size() > 1){
			System.out.println("Duplicate attribute name");
			canBuildSdl = false;
		}
		else{

			value = ctx.name().get(0).value();
			String s = value.getText().split("\"")[1];
			if (checkStringSize(s, 48)) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;

			}
			else{
				attrs.put("name", s);
			}
		}

		//lat
		if(ctx.lat().size() == 0){
			System.out.println("Missing component lat in airport");
			canBuildSdl = false;
		}
		else if(ctx.lat().size() > 1){
			System.out.println("Duplicate attribute lat");
			canBuildSdl = false;
		}
		else{
			value = ctx.lat().get(0).value();
			try {
				float val = Float.parseFloat(value.getText().split("\"")[1]);

				if (val < -90.0 || val > 90) {
					System.out.println("Line " + value.getStart().getLine()
							+ ": invalid " + val);

					canBuildSdl = false;
				}
				else
					attrs.put("lat", ""+val);		

			} catch (NumberFormatException e) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;

			}
		}

		//lon
		if(ctx.lon().size() == 0){
			System.out.println("Missing component lon in airport");
			canBuildSdl = false;
		}
		else if(ctx.lon().size() > 1){
			System.out.println("Duplicate attribute lon");
			canBuildSdl = false;
		}
		else{
			value = ctx.lon().get(0).value();
			try {
				float val = Float.parseFloat(value.getText().split("\"")[1]);

				if (val < -180.0 || val > 180) {
					System.out.println("Line " + value.getStart().getLine()
							+ ": invalid " + val);

					canBuildSdl = false;
				}
				else
					attrs.put("lon", ""+val);		

			} catch (NumberFormatException e) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
		}

		//alt
		if(ctx.alt().size() == 0){
			System.out.println("Missing component alt in airport");
			canBuildSdl = false;
		}
		else if(ctx.alt().size() > 1){
			System.out.println("Duplicate attribute alt");
			canBuildSdl = false;
		}
		else{
			value = ctx.alt().get(0).value();
			String str = value.getText().split("\"")[1];
			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				attrs.put("alt", str);
		}

		//magvar
		if(ctx.magvar().size() == 0){
			attrs.put("magvar", "0.0");
		}
		else if(ctx.magvar().size() > 1){
			System.out.println("Duplicate attribute magvar");
			canBuildSdl = false;
		}
		else{
			value = ctx.magvar().get(0).value();
			try{
				float val = Float.parseFloat(value.getText().split("\"")[1]);

				if (val < -360.0 || val > 360.0) {
					System.out.println("Line " + value.getStart().getLine()
							+ ": invalid " + val);
					canBuildSdl = false;
				}
				else{
					attrs.put("magvar", ""+val);
				}
			} catch (NumberFormatException e) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
		}

		//airporttestreadius
		if(ctx.airportTestRadius().size() == 0){
			System.out.println("Missing component airportTestRadius in airport");
			canBuildSdl = false;
		}
		else if(ctx.airportTestRadius().size() > 1){
			System.out.println("Duplicate attribute airportTestRadius");
			canBuildSdl = false;
		}
		else{
			value = ctx.airportTestRadius().get(0).value();
			String str = value.getText().split("\"")[1];
			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}				
			attrs.put("airportTestRadius", s);
		}

		//trafficscalar
		if(ctx.trafficScalar().size() == 0){
			System.out.println("Missing component trafficScalar in airport");
			canBuildSdl = false;
		}
		else if(ctx.trafficScalar().size() > 1){
			System.out.println("Duplicate attribute trafficScalar");
			canBuildSdl = false;
		}
		else{
			value = ctx.trafficScalar().get(0).value();
			try{
				float val = Float.parseFloat(value.getText().split("\"")[1]);

				if (val < 0.01 || val > 1.0) {
					System.out.println("Line " + value.getStart().getLine()
							+ ": invalid " + val);
					canBuildSdl = false;
				}
				else{
					attrs.put("trafficScalar", ""+val);
				}
			} catch (NumberFormatException e) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
		}


		airportAttrs.put("AIRPORT_" + airportIndex , attrs);		
	}

	@Override
	public void exitFuel(@NotNull XmltoSdlParser.FuelContext ctx){
		HashMap<String,String> fuel = new HashMap<String,String>();

		//type
		try{
			value = ctx.fuel_type().value();
			String val = value.getText().split("\"")[1];
			String[] typeOptions = {"73","87","100","130","145","MOGAS","JET","JETA","JETA1","JETAP","JETB","JET4","JET5","UNKNOWN"};
			if(!Arrays.asList(typeOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong fuel type: " + value.getText() + ". Expected: " + Arrays.toString(typeOptions));
				canBuildSdl = false;
			}
			else
				fuel.put("type", val);
		} catch (NullPointerException e) {
			System.out.println("Missing component fuel type in services");
			canBuildSdl = false;
		}

		//availabilty
		try{
			value = ctx.availability().value();

			String val = value.getText().split("\"")[1];
			String[] typeOptions = {"YES","NO","PRIOR_REQUEST","UNKNOWN"};
			if(!Arrays.asList(typeOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong fuel availabilty: " + value.getText() + ". Expected: " + Arrays.toString(typeOptions));
				canBuildSdl = false;
			}
			else
				fuel.put("availability", val);
		}catch (NullPointerException e) {
			System.out.println("Missing component fuel availabilty in services");
			canBuildSdl = false;
		}

		fuels.put("AIRPORT_" + airportIndex + "-FUEL_" + fuelsIndex, fuel);		
	}

	@Override
	public void exitCom(@NotNull XmltoSdlParser.ComContext ctx){
		HashMap<String,String> com = new HashMap<String,String>();

		//frequency
		try {
			value = ctx.com_frequency().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 108.0 || val > 136.992) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				com.put("frequency", "" + val);
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
			System.out.println("Missing component com frequency");				
			canBuildSdl = false;
		}

		//type
		try{
			value = ctx.com_type().value();

			String val = value.getText().split("\"")[1];
			String[] typeOptions = {"APPROACH","ASOS","ATIS","AWOS","CENTER","CLEARANCE","CLEARANCE_PRE_TAXI",
					"CTAF","DEPARTURE","FSS","GROUND","MULTICOM","REMOTE_CLEARANCE_DELIVERY","TOWER","UNICOM"};
			if(!Arrays.asList(typeOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong COM type: " + value.getText() + ". Expected: " + Arrays.toString(typeOptions));
				canBuildSdl = false;
			}
			else
				com.put("type", val);
		} catch (NullPointerException e) {
			System.out.println("Missing component com type");				
			canBuildSdl = false;
		}

		//name
		try{
			value = ctx.name().value();
			String s = value.getText().split("\"")[1];
			if (checkStringSize(s, 48)) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;

			}
			else{
				com.put("name", s);
			}
		} catch (NullPointerException e) {
			System.out.println("Missing component com name");				
			canBuildSdl = false;
		}

		coms.put("AIRPORT_" + airportIndex + "-COM_" + comsIndex, com);	
	}

	@Override 
	public void exitRunway_atr(@NotNull XmltoSdlParser.Runway_atrContext ctx) 
	{ 
		HashMap<String,String> atrs = new HashMap<String,String>();

		//lat
		if(ctx.lat().size() == 0){
			System.out.println("Missing component lat in runway");
			canBuildSdl = false;
		}
		else if(ctx.lat().size() > 1){
			value = ctx.lat().get(0).value();
			System.out.println("Duplicate attribute lat, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.lat().get(0).value();
			try {
				float val = Float.parseFloat(value.getText().split("\"")[1]);

				if (val < -90.0 || val > 90) {
					System.out.println("Line " + value.getStart().getLine()
							+ ": invalid " + val);

					canBuildSdl = false;
				}
				else
					atrs.put("lat", ""+val);		

			} catch (NumberFormatException e) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;

			}
		}

		//lon
		if(ctx.lon().size() == 0){
			System.out.println("Missing component lon in runway");
			canBuildSdl = false;
		}
		else if(ctx.lon().size() > 1){
			value = ctx.lat().get(0).value();
			System.out.println("Duplicate attribute lon " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.lon().get(0).value();
			try {
				float val = Float.parseFloat(value.getText().split("\"")[1]);

				if (val < -180.0 || val > 180) {
					System.out.println("Line " + value.getStart().getLine()
							+ ": invalid " + val);

					canBuildSdl = false;
				}
				else
					atrs.put("lon", ""+val);		

			} catch (NumberFormatException e) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
		}

		//alt
		if(ctx.alt().size() == 0){
			System.out.println("Missing component alt in runway");
			canBuildSdl = false;
		}
		else if(ctx.alt().size() > 1){
			value = ctx.alt().get(0).value();
			System.out.println("Duplicate attribute alt " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.alt().get(0).value();
			String str = value.getText().split("\"")[1];
			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				atrs.put("alt", s);
		}


		//surface
		if(ctx.surface().size() == 0){
			System.out.println("Missing component surface in runway");
			canBuildSdl = false;
		}
		else if(ctx.surface().size() > 1){
			value = ctx.surface().get(0).value();
			System.out.println("Duplicate attribute surface " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.surface().get(0).value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"ASPHALT","BITUMINOUS","BRICK","CLAY","CEMENT","CONCRETE","CORAL","DIRT","GRASS","GRAVEL","ICE","MACADAM","OIL_TREATED, PLANKS","SAND","SHALE","SNOW","STEEL_MATS","TARMAC","UNKNOWN","WATER"};

			if(!Arrays.asList(surfaceOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong surface type: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				atrs.put("surface", val);
		}

		//heading
		if(ctx.heading().size() == 0){
			System.out.println("Missing component heading in runway");
			canBuildSdl = false;
		}
		else if(ctx.heading().size() > 1){
			value = ctx.heading().get(0).value();
			System.out.println("Duplicate attribute heading " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.heading().get(0).value();
			try{
				float val = Float.parseFloat(value.getText().split("\"")[1]);

				if (val < 0 || val > 360) {
					System.out.println("Line " + value.getStart().getLine()
							+ ": invalid " + val);

				}
				else
					atrs.put("heading", ""+val);
			} catch (NumberFormatException e) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
			} 
		}

		//length
		if(ctx.length().size() == 0){
			System.out.println("Missing component length in runway");
			canBuildSdl = false;
		}
		else if(ctx.length().size() > 1){
			value = ctx.length().get(0).value();
			System.out.println("Duplicate attribute length " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.length().get(0).value();
			String str = value.getText().split("\"")[1];

			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				atrs.put("length", s);
		}

		//width
		if(ctx.width().size() == 0){
			System.out.println("Missing component width in runway");
			canBuildSdl = false;
		}
		else if(ctx.width().size() > 1){
			value = ctx.width().get(0).value();
			System.out.println("Duplicate attribute width " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.width().get(0).value();
			String str = value.getText().split("\"")[1];

			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				atrs.put("width", s);
		}

		//number
		if(ctx.runway_number().size() == 0){
			System.out.println("Missing component number in runway");
			canBuildSdl = false;
		}
		else if(ctx.runway_number().size() > 1){
			value = ctx.runway_number().get(0).value();
			System.out.println("Duplicate attribute number " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.runway_number().get(0).value();
			String[] numberOptions = {"EAST","NORTH","NORTHEAST","NORTHWEST","SOUTH","SOUTHEAST","SOUTHWEST","WEST"};
			String str = value.getText().split("\"")[1];

			if(!Arrays.asList(numberOptions).contains(value.getText()) &&
					(Integer.parseInt(str) < 0 || Integer.parseInt(str) > 36)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong runway number: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions) + ",or a int from 00 to 36");
				canBuildSdl = false;
			}
			else
				atrs.put("number", str);
		}

		//designator
		if(ctx.designator().size() == 0){
			if(ctx.primaryDesignator().size() == 0 || ctx.secondaryDesignator().size() == 0 ){
				System.out.println("Missing component designator/Primary+Secundary Designator in runway. You must have one of the pair");
				canBuildSdl = false;
			}
			else if(ctx.primaryDesignator().size() > 1 || ctx.secondaryDesignator().size() > 1){
				System.out.println("Duplicate attribute primaryDesignator/secundaryDesignator");
				canBuildSdl = false;
			}
			else{
				//primaryDesignator
				value = ctx.primaryDesignator().get(0).value();
				String[] numberOptions = {"NONE","C","CENTER","L","LEFT","R","RIGHT","W","WATER","A","B"};
				String str = value.getText().split("\"")[1];

				if(!Arrays.asList(numberOptions).contains(value.getText())){
					System.out.println("Line "+value.getStart().getLine()+": Wrong runway primarydesignator: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions) + ",or a int from 00 to 36");
					canBuildSdl = false;
				}
				else{
					atrs.put("primaryDesignator", str);
				}

				//secundaryDesignator
				value = ctx.secondaryDesignator().get(0).value();
				str = value.getText().split("\"")[1];

				if(!Arrays.asList(numberOptions).contains(value.getText())){
					System.out.println("Line "+value.getStart().getLine()+": Wrong runway secondarydesignator: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions) + ",or a int from 00 to 36");
					canBuildSdl = false;
				}
				else{
					atrs.put("secondaryDesignator", str);
				}
			}
		}
		else if(ctx.designator().size() > 1){
			value = ctx.designator().get(0).value();
			System.out.println("Duplicate attribute designator " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			if(ctx.primaryDesignator().size() > 0){
				value = ctx.primaryDesignator().get(0).value();
				System.out.println("Do not enter both a designator and primaryDesignator. Line" +  value.getStart().getLine());
				canBuildSdl = false;
			}
			else{
				value = ctx.designator().get(0).value();
				String[] numberOptions = {"NONE","C","CENTER","L","LEFT","R","RIGHT","W","WATER","A","B"};
				String str = value.getText().split("\"")[1];

				if(!Arrays.asList(numberOptions).contains(str)){
					System.out.println("Line "+value.getStart().getLine()+": Wrong runway designator: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions) + ",or a int from 00 to 36");
					canBuildSdl = false;
				}
				else{
					atrs.put("designator", str);
					atrs.put("secondaryDesignator", str);
				}
			}
		}

		//patternAltitude
		if(ctx.patternAltitude().size() == 1){
			value = ctx.patternAltitude().get(0).value();
			String str = value.getText().split("\"")[1];

			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				atrs.put("patternAltitude", s);
		}
		else if(ctx.patternAltitude().size() > 1){
			value = ctx.patternAltitude().get(0).value();
			System.out.println("Duplicate attribute patternAltitude  " +  value.getStart().getLine());
			canBuildSdl = false;
		}

		//primaryTakeoff
		if(ctx.primaryTakeoff().size() == 0){
			atrs.put("primaryTakeoff", "TRUE");
		}
		else if(ctx.primaryTakeoff().size() > 1){
			value = ctx.primaryTakeoff().get(0).value();
			System.out.println("Duplicate attribute primaryTakeoff " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.primaryTakeoff().get(0).value();
			String[] numberOptions = {"TRUE","YES","FALSE","NO"};
			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong primaryTakeoff: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				atrs.put("primaryTakeoff", val);
		}

		//primaryLanding
		if(ctx.primaryLanding().size() == 0){
			atrs.put("primaryLanding", "TRUE");
		}
		else if(ctx.primaryLanding().size() > 1){
			value = ctx.primaryLanding().get(0).value();
			System.out.println("Duplicate attribute primaryLanding " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.primaryLanding().get(0).value();
			String[] numberOptions = {"TRUE","YES","FALSE","NO"};
			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong primaryLanding: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				atrs.put("primaryLanding", val);
		}

		//primaryPattern
		if(ctx.primaryPattern().size() == 0){
			atrs.put("primaryPattern", "LEFT");
		}
		else if(ctx.primaryPattern().size() > 1){
			value = ctx.primaryPattern().get(0).value();
			System.out.println("Duplicate attribute primaryPattern " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.primaryPattern().get(0).value();
			String[] numberOptions = {"LEFT","RIGHT"};
			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong primaryPattern: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				atrs.put("primaryPattern", val);
		}

		//secondaryTakeoff
		if(ctx.secondaryTakeoff().size() == 0){
			atrs.put("secondaryTakeoff", "TRUE");
		}
		else if(ctx.secondaryTakeoff().size() > 1){
			value = ctx.secondaryTakeoff().get(0).value();
			System.out.println("Duplicate attribute secondaryTakeoff " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.secondaryTakeoff().get(0).value();
			String[] numberOptions = {"TRUE","YES","FALSE","NO"};
			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong secondaryTakeoff: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				atrs.put("secondaryTakeoff", val);
		}

		//secondaryLanding
		if(ctx.secondaryLanding().size() == 0){
			atrs.put("secondaryLanding", "TRUE");
		}
		else if(ctx.secondaryLanding().size() > 1){
			value = ctx.secondaryLanding().get(0).value();
			System.out.println("Duplicate attribute secondaryLanding " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.secondaryLanding().get(0).value();
			String[] numberOptions = {"TRUE","YES","FALSE","NO"};
			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong secondaryLanding: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				atrs.put("secondaryLanding", val);
		}

		//secondaryPattern
		if(ctx.secondaryPattern().size() == 0){
			atrs.put("secondaryPattern", "LEFT");
		}
		else if(ctx.secondaryPattern().size() > 1){
			value = ctx.secondaryPattern().get(0).value();
			System.out.println("Duplicate attribute secondaryPattern " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.secondaryPattern().get(0).value();
			String[] numberOptions = {"LEFT","RIGHT"};
			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong secondaryPattern: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				atrs.put("secondaryPattern", val);
		}

		//primaryMarking BIAS
		if(ctx.primaryMarkingBias().size() == 0){
			System.out.println("Missing component primaryMarkingBias in runway");
			canBuildSdl = false;
		}
		else if(ctx.primaryMarkingBias().size() > 1){
			value = ctx.primaryMarkingBias().get(0).value();
			System.out.println("Duplicate attribute primaryMarkingBias " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.primaryMarkingBias().get(0).value();
			String str = value.getText().split("\"")[1];

			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				atrs.put("primaryMarkingBias", s);
		}
		//secondaryMarking BIAS
		if(ctx.secondaryMarkingBias().size() == 0){
			System.out.println("Missing component secondaryMarkingBias in runway");
			canBuildSdl = false;
		}
		else if(ctx.secondaryMarkingBias().size() > 1){
			value = ctx.secondaryMarkingBias().get(0).value();
			System.out.println("Duplicate attribute secondaryMarkingBias " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.secondaryMarkingBias().get(0).value();
			String str = value.getText().split("\"")[1];

			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				atrs.put("secondaryMarkingBias", s);
		}

		runwayAttrs.put("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex, atrs);	
	}

	@Override 
	public void exitMarkings(@NotNull XmltoSdlParser.MarkingsContext ctx){

		HashMap<String,String> marking = new HashMap<String,String>();
		//edges
		if(ctx.edges().size() == 0){
			System.out.println("Missing component edges in markings");
			canBuildSdl = false;
		}
		else if(ctx.edges().size() > 1){
			value = ctx.edges().get(0).value();
			System.out.println("Duplicate attribute edges " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.edges().get(0).value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				marking.put("edges", val);
		}

		//threshold
		if(ctx.threshold().size() == 0){
			System.out.println("Missing component threshold in markings");
			canBuildSdl = false;
		}
		else if(ctx.threshold().size() > 1){
			value = ctx.threshold().get(0).value();
			System.out.println("Duplicate attribute threshold " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.threshold().get(0).value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				marking.put("threshold", val);
		}
		//fixed
		if(ctx.fixedDistance().size() == 0){
			System.out.println("Missing component fixed in markings");
			canBuildSdl = false;
		}
		else if(ctx.fixedDistance().size() > 1){
			value = ctx.fixedDistance().get(0).value();
			System.out.println("Duplicate attribute fixed " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.fixedDistance().get(0).value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				marking.put("fixed", val);
		}

		//touchdown
		if(ctx.touchdown().size() == 0){
			System.out.println("Missing component touchdown in markings");
			canBuildSdl = false;
		}
		else if(ctx.touchdown().size() > 1){
			value = ctx.touchdown().get(0).value();
			System.out.println("Duplicate attribute touchdown " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.touchdown().get(0).value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				marking.put("touchdown", val);
		}

		//dashes
		if(ctx.dashes().size() == 0){
			System.out.println("Missing component dashes in markings");
			canBuildSdl = false;
		}
		else if(ctx.dashes().size() > 1){
			value = ctx.dashes().get(0).value();
			System.out.println("Duplicate attribute dashes " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.dashes().get(0).value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				marking.put("dashes", val);
		}
		//ident
		if(ctx.marking_ident().size() == 0){
			System.out.println("Missing component marking_ident in markings");
			canBuildSdl = false;
		}
		else if(ctx.marking_ident().size() > 1){
			value = ctx.marking_ident().get(0).value();
			System.out.println("Duplicate attribute marking_ident " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.marking_ident().get(0).value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				marking.put("ident", val);
		}
		//precision
		if(ctx.precision().size() == 0){
			System.out.println("Missing component precision in markings");
			canBuildSdl = false;
		}
		else if(ctx.precision().size() > 1){
			value = ctx.precision().get(0).value();
			System.out.println("Duplicate attribute precision " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.precision().get(0).value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				marking.put("precision", val);
		}
		//edgePavement
		if(ctx.edgePavement().size() == 0){
			System.out.println("Missing component edgePavement in markings");
			canBuildSdl = false;
		}
		else if(ctx.edgePavement().size() > 1){
			value = ctx.edgePavement().get(0).value();
			System.out.println("Duplicate attribute edgePavement " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.edgePavement().get(0).value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				marking.put("edgePavement", val);
		}
		//singleEnd
		if(ctx.singleEnd().size() == 0){
			System.out.println("Missing component singleEnd in markings");
			canBuildSdl = false;
		}
		else if(ctx.singleEnd().size() > 1){
			value = ctx.singleEnd().get(0).value();
			System.out.println("Duplicate attribute singleEnd " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.singleEnd().get(0).value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				marking.put("singleEnd", val);
		}
		//primaryClosed
		if(ctx.primaryClosed().size() == 0){
			System.out.println("Missing component primaryClosed in markings");
			canBuildSdl = false;
		}
		else if(ctx.primaryClosed().size() > 1){
			value = ctx.primaryClosed().get(0).value();
			System.out.println("Duplicate attribute primaryClosed " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.primaryClosed().get(0).value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				marking.put("primaryClosed", val);
		}
		//secondaryClosed
		if(ctx.secondaryClosed().size() == 0){
			System.out.println("Missing component secondaryClosed in markings");
			canBuildSdl = false;
		}
		else if(ctx.secondaryClosed().size() > 1){
			value = ctx.secondaryClosed().get(0).value();
			System.out.println("Duplicate attribute secondaryClosed " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.secondaryClosed().get(0).value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				marking.put("secondaryClosed", val);
		}
		//primaryStol
		if(ctx.primaryStol().size() == 0){
			System.out.println("Missing component primaryStol in markings");
			canBuildSdl = false;
		}
		else if(ctx.primaryStol().size() > 1){
			value = ctx.primaryStol().get(0).value();
			System.out.println("Duplicate attribute primaryStol " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.primaryStol().get(0).value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				marking.put("primaryStol", val);
		}
		//secondaryStol
		if(ctx.secondaryStol().size() == 0){
			System.out.println("Missing component secondaryStol in markings");
			canBuildSdl = false;
		}
		else if(ctx.secondaryStol().size() > 1){
			value = ctx.secondaryStol().get(0).value();
			System.out.println("Duplicate attribute secondaryStol " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.secondaryStol().get(0).value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				marking.put("secondaryStol", val);
		}

		markings.put("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex + "-MARKING_" + markingsIndex, marking);
	}

	@Override
	public void exitLights(@NotNull XmltoSdlParser.LightsContext ctx){
		HashMap<String,String> light = new HashMap<String,String>();


		//center
		try{
			value = ctx.center().value();
			String[] numberOptions = {"NONE","LOW","MEDIUM","HIGH"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				light.put("center", val);
		}catch (NullPointerException e) {
			light.put("center", "NONE");
		}

		//edge
		try{
			value = ctx.edge().value();
			String[] numberOptions = {"NONE","LOW","MEDIUM","HIGH"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				light.put("edge", val);

		}catch (NullPointerException e) {
			light.put("edge", "NONE");
		}

		//centerRed
		try{
			value = ctx.centerRed().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				light.put("centerRed", val);

		}catch (NullPointerException e) {
			System.out.println("Missing component center red in lights block");
			canBuildSdl = false;
		}

		lights.put("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex + "-LIGHTS" + lightsIndex, light);
	}

	@Override
	public void exitOffsetThreshold(@NotNull XmltoSdlParser.OffsetThresholdContext ctx){

		HashMap<String,String> off = new HashMap<String,String>();

		try{
			value = ctx.end().value();
			String[] numberOptions = {"PRIMARY","SECONDARY"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				off.put("end", val);
		}catch (NullPointerException e) {
			System.out.println("Missing component end in offset threshold block");
			canBuildSdl = false;
		}

		try{
			value = ctx.surface().value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"ASPHALT","BITUMINOUS","BRICK","CLAY","CEMENT","CONCRETE","CORAL","DIRT","GRASS","GRAVEL","ICE","MACADAM","OIL_TREATED, PLANKS","SAND","SHALE","SNOW","STEEL_MATS","TARMAC","UNKNOWN","WATER"};

			if(!Arrays.asList(surfaceOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong surface type: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				off.put("surface", val);
		} catch (NullPointerException e) {
			off.put("surface", "UNKNOWN");
		}

		//length
		try{
			value = ctx.length().value();
			String str = value.getText().split("\"")[1];

			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				off.put("length", s);
		}catch (NullPointerException e) {
			System.out.println("Missing component offsetThreshold length");
			canBuildSdl = false;
		}

		//width
		try{
			value = ctx.width().value();
			String str = value.getText().split("\"")[1];

			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				off.put("width", s);
		}catch (NullPointerException e) {
			off.put("width", runwayAttrs.get("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex).get("width"));
		}
	}

	@Override
	public void exitBlastPad(@NotNull XmltoSdlParser.BlastPadContext ctx){

		HashMap<String,String> blast = new HashMap<String,String>();

		try{
			value = ctx.end().value();
			String[] numberOptions = {"PRIMARY","SECONDARY"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				blast.put("end", val);
		}catch (NullPointerException e) {
			System.out.println("Missing component end in BlastPad block");
			canBuildSdl = false;
		}

		try{
			value = ctx.surface().value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"ASPHALT","BITUMINOUS","BRICK","CLAY","CEMENT","CONCRETE","CORAL","DIRT","GRASS","GRAVEL","ICE","MACADAM","OIL_TREATED, PLANKS","SAND","SHALE","SNOW","STEEL_MATS","TARMAC","UNKNOWN","WATER"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong surface type: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				blast.put("surface", val);
		} catch (NullPointerException e) {
			blast.put("surface", runwayAttrs.get("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex).get("surface"));
		}

		//length
		try{
			value = ctx.length().value();
			String str = value.getText().split("\"")[1];

			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else{
				String temp = s.substring(0, s.length()-1);
				float f1 = Float.parseFloat(temp);
				String temp1 = runwayAttrs.get("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex).get("length");
				temp = temp1.substring(0, temp1.length()-1);
				float f2 = Float.parseFloat(temp);
				(runwayAttrs.get("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex)).put("length", f1+f2+"M");
				blast.put("length", s);
			}
		}catch (NullPointerException e) {
			System.out.println("Missing component blastPad length");
			canBuildSdl = false;
		}

		//width
		try{
			value = ctx.width().value();
			String str = value.getText().split("\"")[1];

			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				blast.put("width", s);
		}catch (NullPointerException e) {
			blast.put("width", runwayAttrs.get("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex).get("width"));
		}

		blastPads.put("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex + "-BLASTPAD_" + blastPadIndex, blast);
	}

	@Override
	public void exitOverrun(@NotNull XmltoSdlParser.OverrunContext ctx){

		HashMap<String,String> over = new HashMap<String,String>();

		try{
			value = ctx.end().value();
			String[] numberOptions = {"PRIMARY","SECONDARY"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				over.put("end", val);
		}catch (NullPointerException e) {
			System.out.println("Missing component end in Overrun block");
			canBuildSdl = false;
		}

		try{
			value = ctx.surface().value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"ASPHALT","BITUMINOUS","BRICK","CLAY","CEMENT","CONCRETE","CORAL","DIRT","GRASS","GRAVEL","ICE","MACADAM","OIL_TREATED, PLANKS","SAND","SHALE","SNOW","STEEL_MATS","TARMAC","UNKNOWN","WATER"};

			if(!Arrays.asList(surfaceOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong surface type: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				over.put("surface", val);
		} catch (NullPointerException e) {
			over.put("surface", runwayAttrs.get("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex).get("surface"));
		}

		//length
		try{
			value = ctx.length().value();
			String str = value.getText().split("\"")[1];

			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else{
				String temp = s.substring(0, s.length()-1);
				float f1 = Float.parseFloat(temp);
				String temp1 = runwayAttrs.get("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex).get("length");
				temp = temp1.substring(0, temp1.length()-1);
				float f2 = Float.parseFloat(temp);
				(runwayAttrs.get("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex)).put("length", f1+f2+"M");
				over.put("length", s);
			}
		}catch (NullPointerException e) {
			System.out.println("Missing component overrun length");
			canBuildSdl = false;
		}

		//width
		try{
			value = ctx.width().value();
			String str = value.getText().split("\"")[1];

			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				over.put("width", s);
		}catch (NullPointerException e) {
			over.put("width", runwayAttrs.get("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex).get("width"));
		}

		blastPads.put("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex + "-OVERRUN_" + overRunIndex, over);
	}

	@Override
	public void exitApproachLights(@NotNull XmltoSdlParser.ApproachLightsContext ctx){

		HashMap<String,String> app = new HashMap<String,String>();

		try{
			value = ctx.end().value();
			String[] numberOptions = {"PRIMARY","SECONDARY"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				app.put("end", val);
		}catch (NullPointerException e) {
			System.out.println("Missing component end in ApproachLights block");
			canBuildSdl = false;
		}

		try{
			value = ctx.system().value();
			String[] numberOptions = {"NONE","ALSF1","ALSF2","CALVERT","CALVERT2","MALS","MALSF","MALSR","ODALS","RAIL","SALS","SALSF","SSALF","SSALR","SSALS"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				app.put("system", val);
		}catch (NullPointerException e) {
			app.put("system", "NONE");
		}

		try {
			value = ctx.strobes().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				app.put("strobes", ""+val);
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;
		} catch (NullPointerException e) {
			app.put("strobes", "0");
		}

		try{
			value = ctx.reil().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				app.put("reil", val);
		}catch (NullPointerException e) {
		}

		try{
			value = ctx.touchdown().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				app.put("touchdown", val);
		}catch (NullPointerException e) {
		}

		try{
			value = ctx.endlights().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				app.put("endLights", val);
		}catch (NullPointerException e) {
		}

		approachLights.put("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex + "-APPROACHLIGHTS_" + approachLightsIndex, app);
	}

	@Override
	public void exitVasi(@NotNull XmltoSdlParser.VasiContext ctx){

		HashMap<String,String> vas = new HashMap<String,String>();

		try{
			value = ctx.end().value();
			String[] numberOptions = {"PRIMARY","SECONDARY"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				vas.put("end", val);
		}catch (NullPointerException e) {
			System.out.println("Missing component end in Vasi block");
			canBuildSdl = false;
		}

		try{
			value = ctx.vasi_type().value();
			String[] numberOptions = {"PAPI2","PAPI4","PVASI","TRICOLOR","TVASI","VASI21",
					"VASI22","VASI23","VASI31","VASI32","VASI33","BALL","APAP","PANELS"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				vas.put("type", val);
		}catch (NullPointerException e) {
			System.out.println("Missing component type in Vasi block");
			canBuildSdl = false;
		}

		try{
			value = ctx.side().value();
			String[] numberOptions = {"LEFT","RIGHT"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				vas.put("side", val);
		}catch (NullPointerException e) {
			System.out.println("Missing component side in Vasi block");
			canBuildSdl = false;
		}


		try {
			value = ctx.spacing().value();
			String str = value.getText().split("\"")[1];
			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + s);
				canBuildSdl = false;
			}
			else
				vas.put("spacing", s);

		} catch (NullPointerException e) {
			System.out.println("Missing component spacing in Vasi block");
			canBuildSdl = false;
		}

		try {
			value = ctx.pitch().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0 || val > 10.0) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				vas.put("pitch", ""+val);
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
			System.out.println("Missing component pitch in Vasi block");
			canBuildSdl = false;
		}

		try {
			value = ctx.biasX().value();
			String str = value.getText().split("\"")[1];
			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + s);
				canBuildSdl = false;
			}
			else
				vas.put("biasX", s);
		} catch (NullPointerException e) {
			System.out.println("Missing component biasX in Vasi block");
			canBuildSdl = false;
		}

		try {
			value = ctx.biasZ().value();
			String str = value.getText().split("\"")[1];
			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + s);
				canBuildSdl = false;
			}
			else
				vas.put("biasZ", s);
		} catch (NullPointerException e) {
			System.out.println("Missing component biasZ in Vasi block");
			canBuildSdl = false;
		}

		vasi.put("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex + "-VASI_" + vasiIndex, vas);
	}

	@Override
	public void exitIls_open(@NotNull XmltoSdlParser.Ils_openContext ctx){

		HashMap<String,String> i = new HashMap<String,String>();

		//heading
		try{
			value = ctx.heading().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0 || val > 360) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;

			}
			else
				i.put("heading", "" + val);
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
			System.out.println("Missing component ils heading");
			canBuildSdl = false;
		}

		//frequency
		try {
			value = ctx.frequency().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 108.0 || val > 136.992) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				i.put("frequency", "" + val);
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
			System.out.println("Missing component ils heading");
			canBuildSdl = false;
		}

		//end
		try{
			value = ctx.end().value();
			String[] numberOptions = {"PRIMARY","SECONDARY"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				i.put("end", val);
		}catch (NullPointerException e) {
			System.out.println("Missing component end in ILS block");
			canBuildSdl = false;
		}

		//range
		try{
			value = ctx.range().value();
			String str = value.getText().split("\"")[1];

			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				i.put("range", s);
		}catch (NullPointerException e) {
			i.put("range", "27N");
		}

		//magvar
		try {
			value = ctx.magvar().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < -360.0 || val > 360.0) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				i.put("magvar", "" + val);
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
			i.put("magvar", "0.0");
		}

		//ident
		try{
			value = ctx.ident().value();
			String str = value.getText().split("\"")[1];

			if (str.length() > 5) {
				System.out.println("Line "
						+ value.getStart().getLine() + ": invalid "
						+ value.getText());
				canBuildSdl = false;
			}
			else
				i.put("ident", str);
		}catch (NullPointerException e) {
			System.out.println("Missing component ils ident");
			canBuildSdl = false;
		}

		//width
		try {
			value = ctx.width().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0 || val > 360.0) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				i.put("width", "" + val);
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;
		} catch (NullPointerException e) {
			i.put("width", "5");
		}

		//name
		try{

			value = ctx.name().value();
			String s = value.getText().split("\"")[1];
			if (checkStringSize(s, 48)) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;

			}
			else{
				i.put("name", s);
			}
		}catch (NullPointerException e) {
		}

		//lat
		try{
			value = ctx.lat().value();

			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < -90.0 || val > 90) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

				canBuildSdl = false;
			}
			else
				i.put("lat", ""+val);		

		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
			System.out.println("Missing component lat in ILS");
			canBuildSdl = false;
		}


		//lon
		try {
			value = ctx.lon().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < -180.0 || val > 180) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

				canBuildSdl = false;
			}
			else
				i.put("lon", ""+val);		

		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;
		} catch (NullPointerException e) {
			System.out.println("Missing component lon in ILS");
			canBuildSdl = false;
		}


		//alt
		try{
			value = ctx.alt().value();
			String str = value.getText().split("\"")[1];
			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				i.put("alt", str);
		} catch (NullPointerException e) {
			System.out.println("Missing component alt in ILS");
			canBuildSdl = false;
		}


		//backCourse
		try{
			value = ctx.backCourse().value();
			String[] numberOptions = {"TRUE","FALSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				i.put("backCourse", val);
		}catch (NullPointerException e) {
		}

		ils.put("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex + "-ILS_" + ilsIndex, i);
	}
	@Override
	public void exitGlideSlope(@NotNull XmltoSdlParser.GlideSlopeContext ctx){

		HashMap<String,String> glide = new HashMap<String,String>();

		//lat
		try{
			value = ctx.lat().value();

			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < -90.0 || val > 90) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

				canBuildSdl = false;
			}
			else
				glide.put("lat", ""+val);		

		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
			System.out.println("Missing component lat in ILS");
			canBuildSdl = false;
		}


		//lon
		try {
			value = ctx.lon().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < -180.0 || val > 180) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

				canBuildSdl = false;
			}
			else
				glide.put("lon", ""+val);		

		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;
		} catch (NullPointerException e) {
			System.out.println("Missing component lon in ILS");
			canBuildSdl = false;
		}

		//alt
		try{
			value = ctx.alt().value();
			String str = value.getText().split("\"")[1];
			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				glide.put("alt", str);
		} catch (NullPointerException e) {
			System.out.println("Missing component alt in ILS");
			canBuildSdl = false;
		}

		//pitch
		try{
			value = ctx.pitch().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0 || val > 360) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				glide.put("pitch", "" + val);
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
			System.out.println("Missing component glideslope pitch");
			canBuildSdl = false;
		}

		//range
		try{
			value = ctx.range().value();
			String str = value.getText().split("\"")[1];

			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				glide.put("range", s);
		}catch (NullPointerException e) {
			glide.put("range", "27N");
		}

		glideSlope.put("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex + "-ILS_" + ilsIndex + "-GLIDESLOPE_" + glideSlopeIndex, glide);
	}

	@Override
	public void exitVisualModel_open(@NotNull XmltoSdlParser.VisualModel_openContext ctx){

		HashMap<String,String> vm = new HashMap<String,String>();

		//heading
		try{
			value = ctx.heading().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0 || val > 360) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				vm.put("heading", "" + val);
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
		}

		//imageComplexity
		try{
			value = ctx.imageComplexity().value();
			String[] numberOptions = {"VERY_SPARSE","SPARSE", "NORMAL","DENSE","VERY_DENSE"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				vm.put("imageComplexity", val);
		}catch (NullPointerException e) {
		}

		visualModel.put("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex + "-ILS_" + ilsIndex + "-VISUALMODEL_" + visualModelIndex, vm);

	}


	@Override
	public void exitDme(@NotNull XmltoSdlParser.DmeContext ctx){

		HashMap<String,String> dm = new HashMap<String,String>();

		//lat
		try{
			value = ctx.lat().value();

			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < -90.0 || val > 90) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

				canBuildSdl = false;
			}
			else
				dm.put("lat", ""+val);		

		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
			System.out.println("Missing component lat in Dme");
			canBuildSdl = false;
		}


		//lon
		try {
			value = ctx.lon().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < -180.0 || val > 180) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

				canBuildSdl = false;
			}
			else
				dm.put("lon", ""+val);		

		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;
		} catch (NullPointerException e) {
			System.out.println("Missing component lon in Dme");
			canBuildSdl = false;
		}

		//alt
		try{
			value = ctx.alt().value();
			String str = value.getText().split("\"")[1];
			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				dm.put("alt", str);
		} catch (NullPointerException e) {
			System.out.println("Missing component alt in DME");
			canBuildSdl = false;
		}

		//range
		try{
			value = ctx.range().value();
			String str = value.getText().split("\"")[1];

			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				dm.put("range", s);
		}catch (NullPointerException e) {
			//glide.put("range", "27N");
		}

		dme.put("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex + "-ILS_" + ilsIndex + "-DME_" + dmeIndex, dm);
	}

	@Override
	public void exitRunwayStart(@NotNull XmltoSdlParser.RunwayStartContext ctx){

		HashMap<String, String> rs = new HashMap<String, String>();

		//type
		try{
			value = ctx.runway_type().value();
			String val = value.getText().split("\"")[1];
			if(!val.equals("RUNWAY")){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: RUNWAY");
				canBuildSdl = false;
			}
			else
				rs.put("type", val);
		}catch (NullPointerException e) {
		}

		//lat
		try{
			value = ctx.lat().value();

			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < -90.0 || val > 90) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

				canBuildSdl = false;
			}
			else
				rs.put("lat", ""+val);		

		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
			System.out.println("Missing component lat in RunwayStart");
			canBuildSdl = false;
		}


		//lon
		try {
			value = ctx.lon().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < -180.0 || val > 180) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

				canBuildSdl = false;
			}
			else
				rs.put("lon", ""+val);		

		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;
		} catch (NullPointerException e) {
			System.out.println("Missing component lon in RunwayStart");
			canBuildSdl = false;
		}

		//alt
		try{
			value = ctx.alt().value();
			String str = value.getText().split("\"")[1];
			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				rs.put("alt", str);
		} catch (NullPointerException e) {
			System.out.println("Missing component alt in RunwayStart");
			canBuildSdl = false;
		}

		//heading
		try{
			value = ctx.heading().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0 || val > 360) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				rs.put("heading","" + val);
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
			System.out.println("Missing component runwaystart heading");
			canBuildSdl = false;
		}

		//end
		try{
			value = ctx.end().value();
			String[] numberOptions = {"PRIMARY","SECONDARY"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				rs.put("end", val);
		}catch (NullPointerException e) {
		}

		runwayStart.put("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex + "-RUNWAYSTART_" + runwayStartIndex, rs);
	}

	@Override
	public void exitRunwayAlias(@NotNull XmltoSdlParser.RunwayAliasContext ctx){

		HashMap<String,String> ra = new HashMap<String,String>();
		//number
		try{
			value = ctx.runway_number().value();
			String[] numberOptions = {"EAST","NORTH","NORTHEAST","NORTHWEST","SOUTH","SOUTHEAST","SOUTHWEST","WEST"};
			String str = value.getText().split("\"")[1];

			if(!Arrays.asList(numberOptions).contains(value.getText()) &&
					(Integer.parseInt(str) < 0 || Integer.parseInt(str) > 36)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong runway number: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions) + ",or a int from 00 to 36");
				canBuildSdl = false;
			}
			else
				ra.put("number", str);
		}catch (NullPointerException e) {
			System.out.println("Missing component runwayAlias number");
			canBuildSdl = false;
		}

		//designator
		try{
			value = ctx.designator().value();
			String[] numberOptions = {"NONE","C","CENTER","L","LEFT","R","RIGHT","W","WATER","A","B"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				ra.put("designator", val);
		}catch (NullPointerException e) {
			System.out.println("Missing component runwayAlias designator");
			canBuildSdl = false;

		}

		runwayStart.put("AIRPORT_" + airportIndex + "-RUNWAYALIAS_" + runwayAliasIndex, ra);
	}

	@Override
	public void exitHelipad(@NotNull XmltoSdlParser.HelipadContext ctx){

		HashMap<String,String> hp = new HashMap<String,String>();

		//lat
		try{
			value = ctx.lat().value();

			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < -90.0 || val > 90) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

				canBuildSdl = false;
			}
			else
				hp.put("lat", ""+val);		

		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
			System.out.println("Missing component lat in helipad");
			canBuildSdl = false;
		}


		//lon
		try {
			value = ctx.lon().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < -180.0 || val > 180) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

				canBuildSdl = false;
			}
			else
				hp.put("lon", ""+val);		

		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;
		} catch (NullPointerException e) {
			System.out.println("Missing component lon in helipad");
			canBuildSdl = false;
		}

		//alt
		try{
			value = ctx.alt().value();
			String str = value.getText().split("\"")[1];
			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				hp.put("alt", str);
		} catch (NullPointerException e) {
			System.out.println("Missing component alt in helipad");
			canBuildSdl = false;
		}

		//surface
		try{
			value = ctx.surface().value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"ASPHALT","BITUMINOUS","BRICK","CLAY","CEMENT","CONCRETE","CORAL","DIRT","GRASS","GRAVEL","ICE","MACADAM","OIL_TREATED, PLANKS","SAND","SHALE","SNOW","STEEL_MATS","TARMAC","UNKNOWN","WATER"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong surface type: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				hp.put("surface", val);
		} catch (NullPointerException e) {
			System.out.println("Missing component helipad surface");
			canBuildSdl = false;
		}

		//heading
		try{
			value = ctx.heading().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0 || val > 360) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				hp.put("heading", "" + val);
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
			System.out.println("Missing component helipad heading");
			canBuildSdl = false;
		}

		//length
		try{
			value = ctx.length().value();
			String str = value.getText().split("\"")[1];

			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				hp.put("length", s);
		}catch (NullPointerException e) {
			System.out.println("Missing component helipad length");
			canBuildSdl = false;
		}

		//width
		try{
			value = ctx.width().value();
			String str = value.getText().split("\"")[1];

			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}
			else
				hp.put("width", s);
		}catch (NullPointerException e) {
			System.out.println("Missing component helipad width");
			canBuildSdl = false;
		}

		//type
		try{
			value = ctx.helipad_type().value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"NONE","CIRCLE","H","MEDICAL","SQUARE"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong helipad type: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;

			}
			else
				hp.put("type", val);
		} catch (NullPointerException e) {
			System.out.println("Missing component helipad type");
			canBuildSdl = false;
		}

		//closed
		try{
			value = ctx.closed().value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"TRUE","FALSE"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong closed type: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				hp.put("closed", val);
		} catch (NullPointerException e) {
		}

		//transparent
		try{
			value = ctx.transparent().value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"TRUE","FALSE"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong transparent type: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl  = false;
			}
			else
				hp.put("transparent", val);
		} catch (NullPointerException e) {
		}

		//red
		try {
			value = ctx.red().value();
			int val = Integer.parseInt(value.getText().split("\"")[1]);

			if (val < 0 || val > 255) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				hp.put("red", "" + val);
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;
		} catch (NullPointerException e) {

		}

		//green
		try {
			value = ctx.green().value();
			int val = Integer.parseInt(value.getText().split("\"")[1]);

			if (val < 0 || val > 255) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				hp.put("green", "" + val);
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;
		} catch (NullPointerException e) {

		}

		//blue
		try {
			value = ctx.blue().value();
			int val = Integer.parseInt(value.getText().split("\"")[1]);

			if (val < 0 || val > 255) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				hp.put("blue", "" + val);
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {

		}

		helipad.put("AIRPORT_" + airportIndex + "-HELIPAD_" + helipadIndex, hp);

	}

	@Override
	public void exitTaxiwayPoint(@NotNull XmltoSdlParser.TaxiwayPointContext ctx){

		HashMap<String,String> tp = new HashMap<String,String>();

		//index
		try{
			value = ctx.index().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0 || val > 3999) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else {
				boolean  passed = true;
				for(int i = 0; i < taxiwayPoint.size();i++){
					if(taxiwayPoint.get("AIRPORT_" + airportIndex + "-TAXIWAYPOINT_" + i).get("index").equals("" + val)){
						System.out.println("TaxiwayPoint index must be unique. Line " + value.getStart().getLine());
						canBuildSdl = false;
						passed = false;
					}
				}

				if(passed)
					tp.put("index", "" + val);				
			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
			System.out.println("Missing component taxiwayPoint index");
			canBuildSdl = false;
		}

		//type
		try{
			value = ctx.taxiway_type().value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"NORMAL","HOLD_SHORT","ILS_HOLD_SHORT","HOLD_SHORT_NO_DRAW","ILS_HOLD_SHORT_NO_DRAW"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong taxyway type: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				tp.put("type", val);
		} catch (NullPointerException e) {
			System.out.println("Missing component taxiwayPoint type");
			canBuildSdl = false;
		}

		//orientation
		try{
			value = ctx.orientation().value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"FORWARD","REVERSE"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong taxyway orientation: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				tp.put("orientation", val);
		} catch (NullPointerException e) {
		}

		try{
			//lat
			value = ctx.lat().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);
			if (val < -90.0 || val > 90) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

				canBuildSdl = false;
			}
			else
				tp.put("lat", ""+val);		

			//lon
			value = ctx.lon().value();
			val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < -180.0 || val > 180) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				tp.put("lon", ""+val);		

		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;
		} catch (NullPointerException e) {
			try{
				value = ctx.biasX_xyz().value();
				float val = Float.parseFloat(value.getText().split("\"")[1]);
				tp.put("biasX", "" + val);

				value = ctx.biasZ_xyz().value();
				val = Float.parseFloat(value.getText().split("\"")[1]);
				tp.put("biasZ", "" + val);

			} catch (NumberFormatException e2) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}catch (NullPointerException e1) {
				System.out.println("Missing components taxiwayPoint lat,lon/biasX,biasZ    You must have one of the pairs");
				canBuildSdl = false;
			}
		}

		taxiwayPoint.put("AIRPORT_" + airportIndex + "-TAXIWAYPOINT_" + taxiwayPointIndex, tp);
	}

	@Override
	public void exitTaxiwayParking(@NotNull XmltoSdlParser.TaxiwayParkingContext ctx){
		HashMap<String,String> tp = new HashMap<String,String>();

		//index
		try{
			value = ctx.index().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0 || val > 3999) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else {
				boolean  passed = true;
				for(int i = 0; i < taxiwayPoint.size();i++){
					if(taxiwayPoint.get("AIRPORT_" + airportIndex + "-TAXIWAYPARKING_" + i).get("index").equals("" + val)){
						System.out.println("TaxiwayParking index must be unique. Line " + value.getStart().getLine());
						canBuildSdl = false;
						passed = false;
					}
				}

				if(passed)
					tp.put("index", "" + val);				
			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
			System.out.println("Missing component taxiwayParking index");
			canBuildSdl = false;
		}

		try{
			//lat
			value = ctx.lat().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);
			if (val < -90.0 || val > 90) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);

				canBuildSdl = false;
			}
			else
				tp.put("lat", ""+val);		

			//lon
			value = ctx.lon().value();
			val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < -180.0 || val > 180) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				tp.put("lon", ""+val);		

		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;
		} catch (NullPointerException e) {
			try{
				value = ctx.biasX().value();
				float val = Float.parseFloat(value.getText().split("\"")[1]);
				tp.put("biasX", "" + val);

				value = ctx.biasZ().value();
				val = Float.parseFloat(value.getText().split("\"")[1]);
				tp.put("biasZ", "" + val);

			} catch (NumberFormatException e2) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}catch (NullPointerException e1) {
				System.out.println("Missing components taxiwayParking lat,lon/biasX,biasZ    You must have one of the pairs");
				canBuildSdl = false;
			}
		}

		//heading
		try{
			value = ctx.heading().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0 || val > 360) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				tp.put("heading", "" + val);
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());

		} catch (NullPointerException e) {
			System.out.println("Missing component taxiwayParking heading");
		}

		//radius
		try {
			value = ctx.radius().value();
			String str = value.getText().split("\"")[1];
			String s;
			if((s = checkStringSuffix(str)) == ""){
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			}				
			tp.put("radius", s);
		} catch (NullPointerException e) {
			System.out.println("Missing component taxiwayParking radius");
		}

		//type
		try{
			value = ctx.parking_type().value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"NONE","DOCK_GA","FUEL","GATE_HEAVY","GATE_MEDIUM","GATE_SMALL","RAMP_CARGO","RAMP_GA"
					,"RAMP_GA_LARGE","RAMP_GA_MEDIUM","RAMP_GA_SMALL","RAMP_MIL_CARGO","RAMP_MIL_COMBAT","VEHICLE"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong taxyparking type: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				tp.put("type", val);
		} catch (NullPointerException e) {
			System.out.println("Missing component taxiwayParking type");
			canBuildSdl = false;
		}

		//name
		try{
			value = ctx.parking_name().value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"PARKING","DOCK","GATE","NONE","N_PARKING","NE_PARKING","NW_PARKING","SE_PARKING"
					,"S_PARKING","SW_PARKING","W_PARKING","E_PARKING"};


			if(!(Arrays.asList(surfaceOptions).contains(val) || Pattern.compile("GATE_[A-Z]").matcher(val).find())){

				System.out.println("Line "+value.getStart().getLine()+": Wrong taxyparking name: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				tp.put("name", val);
		} catch (NullPointerException e) {
			System.out.println("Missing component taxiwayParking name");
			canBuildSdl = false;
		}

		//number
		try{
			value = ctx.number().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0 || val > 3999) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				tp.put("number", "" + val);
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
			System.out.println("Missing component taxiwayParking number");
			canBuildSdl = false;
		}

		taxiwayParking.put("AIRPORT_" + airportIndex + "-TAXIWAYPARKING_" + taxiwayParkingIndex, tp);
	}

	@Override
	public void exitTaxiwayPath(@NotNull XmltoSdlParser.TaxiwayPathContext ctx){

		HashMap<String,String> tp = new HashMap<String,String>();

		//type
		if(ctx.path_type().size() == 0){
			System.out.println("Missing component path_type in taxiwayPath");
			canBuildSdl = false;
		}
		else if(ctx.path_type().size() > 1){
			System.out.println("Duplicate attribute path_type in taxiwayPath, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.path_type().get(0).value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"RUNWAY","PARKING","TAXI","PATH","CLOSED","VEHICLE"};


			if(!Arrays.asList(surfaceOptions).contains(val)){
				System.out.println("Line "+value.getStart().getLine()+": Wrong taxiway type: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				tp.put("type", val);
		}

		//start
		//TODO check connectivity
		if(ctx.path_start().size() == 0){
			System.out.println("Missing component path_start in taxiwayPath");
			canBuildSdl = false;
		}
		else if(ctx.path_start().size() > 1){
			System.out.println("Duplicate attribute path_start in taxiwayPath, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			try{
				value = ctx.path_start().get(0).value();
				float val = Float.parseFloat(value.getText().split("\"")[1]);

				if (val < 0 || val > 3999) {
					System.out.println("Line " + value.getStart().getLine()
							+ ": invalid " + val);
					canBuildSdl = false;
				}
				else
					tp.put("start","" + val);
			} catch (NumberFormatException e) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;

			}
		}

		//end
		if(ctx.path_end().size() == 0){
			System.out.println("Missing component path_end in taxiwayPath");
			canBuildSdl = false;
		}
		else if(ctx.path_end().size() > 1){
			System.out.println("Duplicate attribute path_end in taxiwayPath, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			try{
				value = ctx.path_end().get(0).value();
				float val = Float.parseFloat(value.getText().split("\"")[1]);

				if (val < 0 || val > 3999) {
					System.out.println("Line " + value.getStart().getLine()
							+ ": invalid " + val);
					canBuildSdl = false;
				}
				else
					tp.put("end", "" + val);
			} catch (NumberFormatException e) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;

			} 
		}

		//width
		if(ctx.width().size() == 0){
			System.out.println("Missing component width in taxiwayPath");
			canBuildSdl = false;
		}
		else if(ctx.width().size() > 1){
			System.out.println("Duplicate attribute width in taxiwayPath, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			try{
				value = ctx.width().get(0).value();
				Float.parseFloat(value.getText().split("\"")[1]);
				tp.put("width", value.getText());
			} catch (NumberFormatException e) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			} 
		}

		//weightLimit
		if(ctx.weightLimit().size() == 0){
			System.out.println("Missing component weightLimit in taxiwayPath");
			canBuildSdl = false;
		}
		else if(ctx.weightLimit().size() > 1){
			System.out.println("Duplicate attribute weightLimit in taxiwayPath, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			try{
				value = ctx.weightLimit().get(0).value();
				Float.parseFloat(value.getText().split("\"")[1]);
				tp.put("weightLimit", value.getText());
			} catch (NumberFormatException e) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			} 
		}

		//surface
		if(ctx.surface().size() == 0){
			System.out.println("Missing component surface in taxiwayPath");
			canBuildSdl = false;
		}
		else if(ctx.surface().size() > 1){
			System.out.println("Duplicate attribute surface in taxiwayPath, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.surface().get(0).value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"ASPHALT","BITUMINOUS","BRICK","CLAY","CEMENT","CONCRETE","CORAL","DIRT","GRASS","GRAVEL","ICE","MACADAM","OIL_TREATED, PLANKS","SAND","SHALE","SNOW","STEEL_MATS","TARMAC","UNKNOWN","WATER"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong surface type: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				tp.put("surface", val);
		}

		//drawDetail
		if(ctx.drawDetail().size() == 0){
			System.out.println("Missing component drawDetail in taxiwayPath");
			canBuildSdl = false;
		}
		else if(ctx.drawDetail().size() > 1){
			System.out.println("Duplicate attribute drawDetail in taxiwayPath, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.drawDetail().get(0).value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"TRUE","FALSE"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong drawDetail: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				tp.put("drawDetail", val);
		} 

		//drawSurface
		if(ctx.drawDetail().size() == 0){
			System.out.println("Missing component drawDetail in taxiwayPath");
			canBuildSdl = false;
		}
		else if(ctx.drawDetail().size() > 1){
			System.out.println("Duplicate attribute drawDetail in taxiwayPath, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.drawSurface().get(0).value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"TRUE","FALSE"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong drawSurface: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				tp.put("drawSurface", val);
		}

		//centerLine
		if(ctx.centerLine().size() == 0){
			tp.put("centerLine", "FALSE");
		}
		else if(ctx.centerLine().size() > 1){
			System.out.println("Duplicate attribute centerLine in taxiwayPath, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.centerLine().get(0).value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"TRUE","FALSE"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong centerLine: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				tp.put("centerLine", val);
		} 

		//centerLineLighted
		if(ctx.centerLineLighted().size() == 0){
			tp.put("centerLineLighted", "FALSE");
		}
		else if(ctx.centerLineLighted().size() > 1){
			System.out.println("Duplicate attribute centerLineLighted in taxiwayPath, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.centerLineLighted().get(0).value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"TRUE","FALSE"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong centerLineLeighted: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				tp.put("centerLineLighted", val);
		}

		//leftEdge
		if(ctx.leftEdge().size() == 0){
			tp.put("leftEdge", "NONE");
		}
		else if(ctx.leftEdge().size() > 1){
			System.out.println("Duplicate attribute leftEdge in taxiwayPath, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.leftEdge().get(0).value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"NONE","SOLID","DASHED","SOLID_DASHED"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong leftedge: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				tp.put("leftEdge", val);
		}

		//leftEdgeLighted
		if(ctx.leftEdgeLighted().size() == 0){
			tp.put("leftEdgeLighted", "FALSE");
		}
		else if(ctx.leftEdgeLighted().size() > 1){
			System.out.println("Duplicate attribute centerLine in taxiwayPath, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.leftEdgeLighted().get(0).value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"TRUE","FALSE"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong leftEdgeLeighted: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				tp.put("leftEdgeLighted", val);
		} 

		//rightEdge
		if(ctx.rightEdge().size() == 0){
			tp.put("rightEdge", "NONE");
		}
		else if(ctx.rightEdge().size() > 1){
			System.out.println("Duplicate attribute rightEdge in taxiwayPath, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.rightEdge().get(0).value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"NONE","SOLID","DASHED","SOLID_DASHED"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong rightedge: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				tp.put("rightEdge", val);
		} 

		//rightEdgeLighted
		if(ctx.rightEdgeLighted().size() == 0){
			tp.put("rightEdgeLighted", "FALSE");
		}
		else if(ctx.leftEdgeLighted().size() > 1){
			System.out.println("Duplicate attribute rightEdgeLighted in taxiwayPath, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.rightEdgeLighted().get(0).value();

			String val = value.getText().split("\"")[1];
			String[] surfaceOptions = {"TRUE","FALSE"};

			if(!Arrays.asList(surfaceOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong rightEdgeLeighted: " + value.getText() + ". Expected: " + Arrays.toString(surfaceOptions));
				canBuildSdl = false;
			}
			else
				tp.put("rightEdgeLighted", val);
		} 

		//number
		if(ctx.number().size() == 0){
			System.out.println("Missing component drawDetail in number");
			canBuildSdl = false;
		}
		else if(ctx.number().size() > 1){
			System.out.println("Duplicate attribute number in taxiwayPath, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.number().get(0).value();
			String str = value.getText().split("\"")[1];

			if(tp.get("type").equals("RUNWAY")){
				try{
					if(Integer.parseInt(str) < 0 || Integer.parseInt(str) > 36){
						System.out.println("Line "+value.getStart().getLine()+": Wrong taxiWayPath number: " + value.getText() + ". Expected:  an int from 00 to 36");
						canBuildSdl = false;
					}
					else
						tp.put("number", str);

				}catch (NumberFormatException e) {
					System.out.println("Line " + value.getStart().getLine()
							+ ": invalid " + value.getText());
				} 
			}
			else{
				String[] numberOptions = {"EAST","NORTH","NORTHEAST","NORTHWEST","SOUTH","SOUTHEAST","SOUTHWEST","WEST"};
				if(!Arrays.asList(numberOptions).contains(value.getText())){
					System.out.println("Line "+value.getStart().getLine()+": Wrong taxiWayPath number: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
					canBuildSdl = false;
				}
				else
					tp.put("number", str);
			}
		}

		//designator
		if(ctx.designator().size() == 0){
			if(tp.get("type").equals("RUNWAY")){
				System.out.println("Missing component designator in number");
				canBuildSdl = false;
			}
			else
				tp.put("designator", "NONE");
		}
		else if(ctx.designator().size() > 1){
			System.out.println("Duplicate attribute designator in taxiwayPath, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			value = ctx.designator().get(0).value();
			String[] numberOptions = {"NONE","C","CENTER","L","LEFT","R","RIGHT","W","WATER","A","B"};

			String val = value.getText().split("\"")[1];
			if(!Arrays.asList(numberOptions).contains(val)){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: " + Arrays.toString(numberOptions));
				canBuildSdl = false;
			}
			else
				tp.put("designator", val);
		}

		//designator
		if(ctx.path_name().size() == 0){
			if(tp.get("type").equals("RUNWAY")){
				System.out.println("Missing component path_name in number");
				canBuildSdl = false;
			}
		}
		else if(ctx.path_name().size() > 1){
			System.out.println("Duplicate attribute path_name in taxiwayPath, line " +  value.getStart().getLine());
			canBuildSdl = false;
		}
		else{
			try{
				value = ctx.path_name().get(0).value();
				float val = Float.parseFloat(value.getText().split("\"")[1]);

				if (val < 0 || val > 255) {
					System.out.println("Line " + value.getStart().getLine()
							+ ": invalid " + val);
					canBuildSdl = false;
				}
				else
					tp.put("name", "" + val);
			} catch (NumberFormatException e) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + value.getText());
				canBuildSdl = false;
			} 
		}

		taxiwayPath.put("AIRPORT_" + airportIndex + "-TAXIWAYPATH_" + taxiwayPathIndex, tp);
	}

	@Override
	public void exitTaxiName(@NotNull XmltoSdlParser.TaxiNameContext ctx){

		HashMap<String, String> tn = new HashMap<String, String>();

		try{
			value = ctx.index255().value();
			float val = Float.parseFloat(value.getText().split("\"")[1]);

			if (val < 0 || val > 255) {
				System.out.println("Line " + value.getStart().getLine()
						+ ": invalid " + val);
				canBuildSdl = false;
			}
			else
				tn.put("index", "" + val);
		} catch (NumberFormatException e) {
			System.out.println("Line " + value.getStart().getLine()
					+ ": invalid " + value.getText());
			canBuildSdl = false;

		} catch (NullPointerException e) {
			System.out.println("Missing component taxiName index");
			canBuildSdl = false;
		}

		try{
			value = ctx.taxi_name().value();

			String val = value.getText().split("\"")[1];
			if(val.length() > 8){

				System.out.println("Line "+value.getStart().getLine()+": Wrong value: " + value.getText() + ". Expected: 8 chars max" );
				canBuildSdl = false;
			}
			else
				tn.put("name", val);
		}catch (NullPointerException e) {
			System.out.println("Missing component taxiName name");
			canBuildSdl = false;
		}
	}

	
	@Override
	public void exitDocument(@NotNull XmltoSdlParser.DocumentContext ctx){
		if(canBuildSdl){
			SdlBuilder.build();
		}
		else
			System.out.println("Errors found, sdl file could not be built");
	}
}