package sdlBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class SdlBuilder {
	int airportIndex;
	int runwayIndex;
	int helipadIndex;
	int taxiwayIndex;
	int parkingspaceIndex;
	int utilitiesIndex;

	HashMap<String,HashMap<String,String>> airportAttrs;
	HashMap<String,HashMap<String,String>> fuels;
	HashMap<String,HashMap<String,String>> coms;
	HashMap<String,HashMap<String,String>> towers;
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
	HashMap<String, ArrayList<HashMap<String,String>>> taxiPathperName;
	HashMap<String,HashMap<String,String>> taxiName;

	Namespace ns;

	public SdlBuilder(HashMap<String, HashMap<String, String>> airportAttrs,
			HashMap<String, HashMap<String, String>> towers,
			HashMap<String, HashMap<String, String>> fuels,
			HashMap<String, HashMap<String, String>> coms,
			HashMap<String, HashMap<String, String>> runwayAttrs,
			HashMap<String, HashMap<String, String>> markings,
			HashMap<String, HashMap<String, String>> lights,
			HashMap<String, HashMap<String, String>> offsetThreshold,
			HashMap<String, HashMap<String, String>> blastPads,
			HashMap<String, HashMap<String, String>> overRuns,
			HashMap<String, HashMap<String, String>> approachLights,
			HashMap<String, HashMap<String, String>> vasi,
			HashMap<String, HashMap<String, String>> ils,
			HashMap<String, HashMap<String, String>> glideSlope,
			HashMap<String, HashMap<String, String>> visualModel,
			HashMap<String, HashMap<String, String>> dme,
			HashMap<String, HashMap<String, String>> runwayStart,
			HashMap<String, HashMap<String, String>> runwayAlias,
			HashMap<String, HashMap<String, String>> helipad,
			HashMap<String, HashMap<String, String>> taxiwayPoint,
			HashMap<String, HashMap<String, String>> taxiwayParking,
			HashMap<String, ArrayList<HashMap<String,String>>> taxiPathperName,
			HashMap<String, HashMap<String, String>> taxiName) {
		super();
		this.airportAttrs = airportAttrs;
		this.towers = towers;
		this.fuels = fuels;
		this.coms = coms;
		this.runwayAttrs = runwayAttrs;
		this.markings = markings;
		this.lights = lights;
		this.offsetThreshold = offsetThreshold;
		this.blastPads = blastPads;
		this.overRuns = overRuns;
		this.approachLights = approachLights;
		this.vasi = vasi;
		this.ils = ils;
		this.glideSlope = glideSlope;
		this.visualModel = visualModel;
		this.dme = dme;
		this.runwayStart = runwayStart;
		this.runwayAlias = runwayAlias;
		this.helipad = helipad;
		this.taxiwayPoint = taxiwayPoint;
		this.taxiwayParking = taxiwayParking;
		this.taxiPathperName = taxiPathperName;
		this.taxiName = taxiName;
		airportIndex = 0;
		runwayIndex = 0;
		helipadIndex = 0;
		taxiwayIndex = 0;
		parkingspaceIndex = 0;
		utilitiesIndex = 0;


	}

	public void build(){
		try {
			Document doc = new Document();
			createScenario(doc);

			Element bases = new Element("bases",ns);
			doc.getRootElement().addContent(bases);
			doc.getRootElement().addContent(new Element("controllers",ns));
			doc.getRootElement().addContent(new Element("agentTypes",ns));
			doc.getRootElement().addContent(new Element("noFlyAreas",ns));

			for(int i = 0; i < airportAttrs.size();i++){
				Element base = createBase(bases);
				base.addContent(createAirport());
				airportIndex++;
			}



			// new XMLOutputter().output(doc, System.out);
			XMLOutputter xmlOutput = new XMLOutputter();

			// display nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			//xmlOutput.setFormat(xmlOutput.getFormat().setExpandEmptyElements(true));
			xmlOutput.output(doc, new FileWriter("SDLOutput.xml"));

			System.out.println("File Saved!");
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}


	private Element createAirport() {
		Element airport = new Element("airport",ns);
		airport.addContent(new Element("name",ns).setText(airportAttrs.get("AIRPORT_"+airportIndex).get("name")));
		airport.addContent(new Element("description",ns).setText("XXX Description XXX"));
		airport.addContent(createContactPerson());
		airport.addContent(createLocation());
		airport.addContent(new Element("ICAO",ns).setText(airportAttrs.get("AIRPORT_"+airportIndex).get("ident")));
		airport.addContent(new Element("IATA",ns).setText("ABC"));
		airport.addContent(new Element("magVar",ns).setText(airportAttrs.get("AIRPORT_"+airportIndex).get("magvar")));

		Element runways = new Element("runways",ns);
		while(runwayAttrs.get("AIRPORT_" + airportIndex + "-RUNWAY_" + runwayIndex) != null){
			runways.addContent(createRunway(runways, runwayIndex));
			runwayIndex++;
		}
		airport.addContent(runways);

		Element helipads = new Element("helipads",ns);
		while(helipad.get("AIRPORT_" + airportIndex + "-HELIPAD_" + helipadIndex) != null){
			helipads.addContent(createHelipad(helipadIndex));
			helipadIndex++;
		}
		airport.addContent(helipads);

		Element taxiways = new Element("taxiways",ns);
		while(taxiName.get("AIRPORT_" + airportIndex + "-TAXINAME_" + taxiwayIndex) != null){
			taxiways.addContent(createTaxiway(taxiwayIndex));
			taxiwayIndex++;
		}		
		airport.addContent(taxiways);

		Element parkingspaces = new Element("parkingSpaces",ns);
		while(taxiwayParking.get("AIRPORT_" + airportIndex + "-TAXIWAYPARKING_" + parkingspaceIndex) != null){
			parkingspaces.addContent(createParking(parkingspaceIndex));
			parkingspaceIndex++;
		}
		airport.addContent(parkingspaces);
		airport.addContent(new Element("hangars",ns));

		Element utilities = new Element("utilities",ns);
		while(taxiwayParking.get("AIRPORT_" + airportIndex + "-TOWER_" + utilitiesIndex) != null){
			utilities.addContent(createTower(utilitiesIndex));
			utilitiesIndex++;
		}
		airport.addContent(utilities);
		return airport;
	}

	private Element createTower(int i) {
		Element tower = new Element("tower",ns).setAttribute(new Attribute("id", "u"+(i+1)));
		tower.addContent(new Element("designation",ns).setText("Tower"));
		tower.addContent(createCoords(towers.get("AIRPORT_" + airportIndex + "-TOWER_"+i)));
		tower.addContent(new Element("radius").setAttribute(new Attribute("lengthUnit", "Meter"))
				.setText("2.55"));
		tower.addContent(new Element("height").setAttribute(new Attribute("lengthUnit", "Meter"))
				.setText("254.55"));

		return tower;
	}

	private Element createParking(int index) {
		Element parking = new Element("parking",ns).setAttribute(new Attribute("parkingType", taxiwayParking.get("AIRPORT_"+airportIndex + "-TAXIWAYPARKING_" + index).get("type")))
				.setAttribute(new Attribute("id", "p"+taxiwayParking.get("AIRPORT_"+airportIndex + "-TAXIWAYPARKING_" + index).get("index")));
		parking.addContent(new Element("designation",ns).setText("Parking" + taxiwayParking.get("AIRPORT_"+airportIndex + "-TAXIWAYPARKING_" + index).get("index")));
		parking.addContent(new Element("description",ns).setText("Parking" + taxiwayParking.get("AIRPORT_"+airportIndex + "-TAXIWAYPARKING_" + index).get("type")));
		Element airlines = new Element("airlines",ns).setText(taxiwayParking.get("AIRPORT_"+airportIndex + "-TAXIWAYPARKING_" + index).get("airlineCodes"));
		parking.addContent(airlines);

		taxiwayParking.get("AIRPORT_"+airportIndex + "-TAXIWAYPARKING_" + index).put("alt", "48");
		parking.addContent(createCoords(taxiwayParking.get("AIRPORT_"+airportIndex + "-TAXIWAYPARKING_" + index)));

		Element radius = new Element("radius",ns);
		String s = taxiwayParking.get("AIRPORT_"+airportIndex + "-TAXIWAYPARKING_" + index).get("radius");
		if(s.charAt(s.length()-1) == 'M')
			radius.setAttribute("lengthUnit","Meter");
		else
			radius.setAttribute("lengthUnit","Feet");
		String val = s.substring(0, s.length() - 1);
		radius.setText(val);
		parking.addContent(radius);
		//TODO fazer isto
		//		Element con = new Element("connectsToTaxiway").setAttribute(new Attribute(", value))

		return parking;
	}

	private Element createTaxiway(int index) {
		Element taxiway = new Element("taxiway",ns).setAttribute(new Attribute("id", "x"+taxiName.get("AIRPORT_"+airportIndex + "-TAXINAME_" + index).get("index")));
		taxiway.addContent(new Element("designation",ns).setText("Taxiway " + taxiName.get("AIRPORT_"+airportIndex + "-TAXINAME_" + index).get("name")));
		taxiway.addContent(new Element("surface",ns).setText(taxiPathperName.get("AIRPORT_"+airportIndex + "-TAXINAME_" + index).get(0).get("surface")));

		Element width = new Element("width",ns);
		String s = taxiPathperName.get("AIRPORT_"+airportIndex + "-TAXINAME_" + index).get(0).get("width");
		if(s.charAt(s.length()-1) == 'M')
			width.setAttribute("lengthUnit","Meter");
		else
			width.setAttribute("lengthUnit","Feet");
		String val = s.substring(0, s.length() - 1);
		width.setText(val);
		taxiway.addContent(width);

		Element path = new Element("path",ns);
		Element startpoint = new Element("startpoint",ns);
		String indy = taxiPathperName.get("AIRPORT_"+airportIndex + "-TAXINAME_" + index).get(0).get("start");
		taxiwayPoint.get("AIRPORT_"+airportIndex + "-TAXIWAYPOINT_"+indy ).put("alt", "48");
		startpoint.addContent(createCoords(taxiwayPoint.get("AIRPORT_"+airportIndex + "-TAXIWAYPOINT_"+indy )));
		Element connects = new Element("connectsTo",ns);
		connects.addContent(new Element("rway",ns).setAttribute(new Attribute("idr", taxiPathperName.get("AIRPORT_"+airportIndex + "-TAXINAME_" + index).get(0).get("end"))));
		path.addContent(startpoint);

		for(int i = 1; i < taxiPathperName.get("AIRPORT_"+airportIndex + "-TAXINAME_" + index).size()-1;i++){
			Element midpoint = new Element("midpoint",ns);
			indy = taxiPathperName.get("AIRPORT_"+airportIndex + "-TAXINAME_" + index).get(i).get("start");
			taxiwayPoint.get("AIRPORT_"+airportIndex + "-TAXIWAYPOINT_"+indy ).put("alt", "48");
			midpoint.addContent(createCoords(taxiwayPoint.get("AIRPORT_"+airportIndex + "-TAXIWAYPOINT_"+indy)));
			Element connectsm = new Element("connectsTo",ns);
			connectsm.addContent(new Element("rway",ns).setAttribute(new Attribute("idr", taxiPathperName.get("AIRPORT_"+airportIndex + "-TAXINAME_" + index).get(i).get("end"))));
			path.addContent(midpoint);			
		}

		Element endpoint = new Element("endpoint",ns);
		indy = taxiPathperName.get("AIRPORT_"+airportIndex + "-TAXINAME_" + index).get(taxiPathperName.get("AIRPORT_"+airportIndex + "-TAXINAME_" + index).size()-1).get("start");
		taxiwayPoint.get("AIRPORT_"+airportIndex + "-TAXIWAYPOINT_"+indy ).put("alt", "48");
		endpoint.addContent(createCoords(taxiwayPoint.get("AIRPORT_"+airportIndex + "-TAXIWAYPOINT_"+indy)));
		Element connectsm = new Element("connectsTo",ns);
		connectsm.addContent(new Element("rway",ns).setAttribute(new Attribute("idr",taxiPathperName.get("AIRPORT_"+airportIndex + "-TAXINAME_" + index).get(taxiPathperName.get("AIRPORT_"+airportIndex + "-TAXINAME_" + index).size()-1).get("end"))));
		path.addContent(endpoint);	

		taxiway.addContent(path);

		return taxiway;
	}

	private Element createHelipad(int index) {
		Element heli = new Element("helipad",ns).setAttribute("idGroup","h"+helipad.get("AIRPORT_"+airportIndex + "-HELIPAD_" + index).get("heading"));
		heli.addContent(new Element("designation",ns).setText(helipad.get("AIRPORT_"+airportIndex + "-HELIPAD_" + index).get("heading")));
		heli.addContent(new Element("surface",ns).setText(helipad.get("AIRPORT_"+airportIndex + "-HELIPAD_" + index).get("surface")));
		heli.addContent(createCoords(helipad.get("AIRPORT_"+airportIndex + "-HELIPAD_" + index)));
		heli.addContent(new Element("radius",ns).setText("12"));
		return heli;
	}

	private Element createRunway(Element runways, int index) {
		Element runway = new Element("runway",ns).setAttribute("id","r" + runwayAttrs.get("AIRPORT_"+airportIndex + "-RUNWAY_" + index).get("number"));
		runway.addContent(createCoords(runwayAttrs.get("AIRPORT_"+airportIndex + "-RUNWAY_" + index)));
		createLenWid(runwayAttrs.get("AIRPORT_"+airportIndex + "-RUNWAY_" + index), runway);
		runway.addContent(new Element("surface",ns).setText(runwayAttrs.get("AIRPORT_"+airportIndex + "-RUNWAY_" + index).get("surface")));

		Element baseend = new Element("baseEnd",ns);
		baseend.addContent(new Element("designation",ns).setText(runwayAttrs.get("AIRPORT_"+airportIndex + "-RUNWAY_" + index).get("number")));
		Element startpoint = new Element("startpoint",ns);
		startpoint.addContent(createCoords(runwayAttrs.get("AIRPORT_"+airportIndex + "-RUNWAY_" + index)));
		startpoint.addContent(new Element("connectsTo",ns)
		.addContent(new Element("xway",ns)
		.setAttribute(new Attribute("idr", "x05"))));
		baseend.addContent(startpoint);
		baseend.addContent(new Element("heading",ns).setAttribute(new Attribute("headingType","True")).setText(runwayAttrs.get("AIRPORT_"+airportIndex + "-RUNWAY_" + index).get("heading")));
		Element endpoint = new Element("endpoint",ns);
		endpoint.addContent(createCoords(runwayAttrs.get("AIRPORT_"+airportIndex + "-RUNWAY_" + index)));
		endpoint.addContent(new Element("connectsTo",ns)
		.addContent(new Element("xway",ns)
		.setAttribute(new Attribute("idr", "x01"))));
		baseend.addContent(endpoint);
		runway.addContent(baseend);

		Element reciprocalEnd = new Element("reciprocalEnd",ns);
		reciprocalEnd.addContent(new Element("designation",ns).setText("" + (Integer.parseInt(runwayAttrs.get("AIRPORT_"+airportIndex + "-RUNWAY_" + index).get("number")) + 18 )));
		Element rstartpoint = new Element("startpoint",ns);
		rstartpoint.addContent(createCoords(runwayAttrs.get("AIRPORT_"+airportIndex + "-RUNWAY_" + index)));
		rstartpoint.addContent(new Element("connectsTo",ns)
		.addContent(new Element("xway",ns)
		.setAttribute(new Attribute("idr", "x05"))));
		reciprocalEnd.addContent(rstartpoint);
		reciprocalEnd.addContent(new Element("heading",ns).setAttribute(new Attribute("headingType","True")).setText(runwayAttrs.get("AIRPORT_"+airportIndex + "-RUNWAY_" + index).get("heading")));
		Element rendpoint = new Element("endpoint",ns);
		rendpoint.addContent(createCoords(runwayAttrs.get("AIRPORT_"+airportIndex + "-RUNWAY_" + index)));
		rendpoint.addContent(new Element("connectsTo",ns)
		.addContent(new Element("xway",ns)
		.setAttribute(new Attribute("idr", "x01"))));
		reciprocalEnd.addContent(rendpoint);

		runway.addContent(reciprocalEnd);
		return runway;

	}

	private void createLenWid(HashMap<String,String> map, Element runway){
		Element length = new Element("length",ns);
		String s = map.get("length");
		if(s.charAt(s.length()-1) == 'M')
			length.setAttribute("lengthUnit","Meter");
		else
			length.setAttribute("lengthUnit","Feet");
		String val = s.substring(0, s.length() - 1);
		length.setText(val);
		runway.addContent(length);

		Element width = new Element("width",ns);
		s = map.get("width");
		if(s.charAt(s.length()-1) == 'M')
			width.setAttribute("lengthUnit","Meter");
		else
			width.setAttribute("lengthUnit","Feet");
		val = s.substring(0, s.length() - 1);
		width.setText(val);
		runway.addContent(width);
	}

	private Element createBase(Element bases) {
		Element baseOO = new Element("baseOfOperations",ns);
		baseOO.setAttribute(new Attribute("id", "b" + (airportIndex +1)));
		bases.addContent(baseOO);

		createSpecifications(baseOO);

		return baseOO;
	}

	private void createSpecifications(Element element) {
		element.addContent(new Element("name",ns).setText(airportAttrs.get("AIRPORT_"+airportIndex).get("name")));
		element.addContent(new Element("mobility",ns).setAttribute(new Attribute("water", "true"))
				.setAttribute(new Attribute("underwater", "false"))
				.setAttribute(new Attribute("land", "true"))
				.setAttribute(new Attribute("air", "true")));
		element.addContent(new Element("description",ns).setText("XXX Description XXX"));
		element.addContent(new Element("history",ns).setText("XXX History XXX"));
		element.addContent(createContactPerson());
		element.addContent(createLocation());
		element.addContent(new Element("availability",ns).setAttribute(new Attribute("available", "always")));
	}

	private Element createContactPerson() {
		Element cp = new Element("contactPerson",ns);
		cp.addContent(new Element("name",ns).setText("XXX Name XXX"));
		cp.addContent(new Element("title",ns).setText("XXX title XXX"));
		cp.addContent(new Element("institution",ns).setText("XXX institution XXX"));
		cp.addContent(new Element("position",ns).setText("XXX position XXX"));
		cp.addContent(new Element("address",ns).setText("XXX address XXX"));
		cp.addContent(new Element("zipCode",ns).setText("XXX zipCode XXX"));
		cp.addContent(new Element("city",ns).setText("XXX city XXX"));
		cp.addContent(new Element("stateDistrictRegion",ns).setText("XXX State XXX"));
		cp.addContent(new Element("country",ns).setText("XXX country XXX"));
		cp.addContent(new Element("telephone",ns).setText("XXX telephone XXX"));
		cp.addContent(new Element("cellphone",ns).setText("XXX cellphone XXX"));
		cp.addContent(new Element("fax",ns).setText("XXX fax XXX"));
		cp.addContent(new Element("email",ns).setText("XXX email XXX"));

		return cp;
	}

	private Element createLocation() {
		Element cp = new Element("location",ns);
		cp.addContent(new Element("address",ns).setText("xxxxxxxxxxxxx"));
		cp.addContent(new Element("zipCode",ns).setText("xxxxxxxxxxxxx"));
		cp.addContent(new Element("city",ns).setText(airportAttrs.get("AIRPORT_"+airportIndex).get("city")));
		cp.addContent(new Element("stateDistrictRegion",ns).setText(airportAttrs.get("AIRPORT_"+airportIndex).get("state")));
		cp.addContent(new Element("country",ns).setText(airportAttrs.get("AIRPORT_"+airportIndex).get("country")));

		cp.addContent(createCoords(airportAttrs.get("AIRPORT_"+airportIndex)));

		return cp;
	}

	private Element createCoords(HashMap<String,String> map){
		Element coord = new Element("coordinates",ns);
		coord.addContent(new Element("latitude",ns).setText(map.get("lat")));
		coord.addContent(new Element("longitude",ns).setText(map.get("lon")));
		coord.addContent(new Element("altitude",ns).setAttribute("measured", "amsl").setText(map.get("alt")));
		return coord;
	}


	public void createScenario(Document doc) {
		ns = Namespace.getNamespace("dcs:scenario"); 
		Element scenario = new Element("scenario",ns);
		scenario.addNamespaceDeclaration(Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance"));
		scenario.addNamespaceDeclaration(Namespace.getNamespace("xsd", "http://www.w3.org/2001/XMLSchema"));
		doc.setRootElement(scenario);
	}


}

