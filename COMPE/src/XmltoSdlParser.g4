parser grammar XmltoSdlParser;

options {
	tokenVocab = XmltoSdlLexer;
}
  
airport   
:
	airport_open airport_content airport_close 
;

value
:
 '=' STRING 
; // Our STRING is AttValue in spec


 
airport_open: OPEN AIRPORT airport_atr CLOSE;


region: REGION value;
country: COUNTRY value;
state: STATE value; 
city: CITY value;
name: NAME value; 
lat: LAT value;
lon: LON value;
alt: ALT value;
magvar: MAGVAR value;
ident: IDENT value;
airportTestRadius: ATR value;
trafficScallar: TRAFFICSCALLAR value;
com_frequency: FREQUENCY value;
com_type: TYPE value;




airport_close: OPEN SLASH AIRPORT CLOSE;
airport_atr: region? country? state? city? name? lat lon alt magvar? ident airportTestRadius trafficScallar;

airport_content: ( tower | services | com | runway | runwayAlias | (taxiwayPoint taxiwayParking taxiName taxiwayPath) | helipad)*;

tower: OPEN TOWER lat lon alt SLASH_CLOSE;

 
services: services_open services_content services_close;
services_open: OPEN SERVICES CLOSE;
services_close: OPEN SLASH SERVICES CLOSE;

services_content: (fuel)*;
fuel : OPEN FUEL fuel_type availability SLASH_CLOSE;
fuel_type  :  TYPE value;
availability: AVAILABILITY value;



com  :  OPEN COM com_frequency com_type name SLASH_CLOSE;

 

runway: runway_open runway_content runway_close;
runway_open: OPEN RUNWAY runway_atr CLOSE;
runway_close: OPEN SLASH RUNWAY CLOSE;

runway_atr: lat lon alt surface heading length width runway_number (designator | primaryDesignator | secondaryDesignator ) patternAltitude? primaryTakeoff? primaryLanding? primaryPattern? secondaryTakeoff? secondaryLanding? secondaryPattern? primaryMarkingBias secondaryMarkingBias;
surface: SURFACE value;
heading: HEADING value;
length: LENGTH value;
width: WIDTH value;
runway_number: NUMBER value;
designator: DESIGNATOR value;
primaryDesignator: PRIMARYDESIGNATOR value;
secondaryDesignator: SECONDARYDESIGNATOR value;
patternAltitude: PATTERNALTITUDE value;
primaryTakeoff: PRIMARYTAKEOFF value;
primaryLanding: PRIMARYLANDING value;
primaryPattern: PRIMARYPATTERN value;
secondaryTakeoff: SECONDARYTAKEOFF value;
secondaryLanding: SECONDARYLANDING value;
secondaryPattern: SECONDARYPATTERN value;
primaryMarkingBias: PRIMARYMARKINGBIAS value;
secondaryMarkingBias: SECONDARYMARKINGBIAS value;


runway_content: (markings)* (lights)* (offsetThreshold)* (blastPad)* (overrun)* (approachLights)* (vasi)* (ils)* (runwayStart)*;

markings: OPEN MARKINGS edges threshold fixedDistance touchdown dashes marking_ident precision edgePavement singleEnd primaryClosed secondaryClosed primaryStol secondaryStol SLASH_CLOSE;
edges: EDGES value;
threshold: THRESHOLD value;
fixedDistance: FIXEDDISTANCE value;
touchdown: TOUCHDOWN value;
dashes: DASHES value;
marking_ident: MARKING_IDENT value;
precision: PRECISION value;
edgePavement: EDGEPAVEMENT value;
singleEnd: SINGLEEND value;
primaryClosed: PRIMARYCLOSED value;
secondaryClosed: SECONDARYCLOSED value;
primaryStol: PRIMARYSTOL value;
secondaryStol: SECONDARYSTOL value;
 
lights: OPEN LIGHTS center edge centerRed SLASH_CLOSE;
center: CENTER value;
edge: EDGE value;
centerRed: CENTERRED value;


offsetThreshold: OPEN OFFSETTHRESHOLD end length width? surface? SLASH_CLOSE;
end: END value;

blastPad: OPEN BLASTPAD end length width? surface? SLASH_CLOSE;

overrun: OPEN OVERRUN end length width? surface? SLASH_CLOSE;

approachLights: OPEN APPROACHLIGHTS end system? strobes? reil? touchdown? endlights? SLASH_CLOSE;
system: SYSTEM value;
strobes: STROBES value;
reil: REIL value;
endlights: ENDLIGHTS value;

vasi: OPEN VASI end vasi_type side biasX biasZ spacing pitch SLASH_CLOSE;
vasi_type: TYPE value;
side: SIDE value;
biasX: BIASX value;
biasZ: BIASZ value;
spacing: SPACING value;
pitch: PITCH value;


ils: ils_open ils_content ils_close;

ils_open: OPEN ILS lat lon alt heading frequency end (range)? magvar ident (width)? (name)? (backCourse)? CLOSE;
frequency: FREQUENCY value;
range: RANGE value;
backCourse: BACKCOURSE value;

ils_content: (glideScope)* (dme)* (visualModel)*;
glideScope: OPEN GLIDESCOPE lat lon alt pitch range SLASH_CLOSE;
dme: OPEN DME lat lon alt range SLASH_CLOSE;

visualModel: visualModel_open visualModel_content visualModel_close;
visualModel_open: OPEN VISUALMODEL heading? imageComplexity? guid_name instanceId CLOSE;
imageComplexity: IMAGECOMPLEXITY value;
guid_name: NAME value;
instanceId: INSTANCEID value;

visualModel_content: (biasXYZ)*;
biasXYZ: OPEN BIASXYZ biasX_xyz biasY_xyz biasZ_xyz SLASH_CLOSE;
biasX_xyz: BIASX value;
biasY_xyz: BIASY value;
biasZ_xyz: BIASZ value;
visualModel_close: OPEN SLASH VISUALMODEL CLOSE;
ils_close: OPEN SLASH ILS CLOSE;

runwayStart: OPEN RUNWAYSTART runway_type lat lon alt heading end SLASH_CLOSE;
runway_type: TYPE value;

runwayAlias: OPEN RUNWAYALIAS runway_number designator SLASH_CLOSE;



helipad: OPEN HELIPAD lat lon alt surface heading length width helipad_type closed? transparent? red? green? blue? SLASH_CLOSE;

helipad_type: TYPE value;
closed: CLOSED value;
transparent: TRANSPARENT value;
red: RED value;
green: GREEN value;
blue: BLUE value;


taxiwayPoint: OPEN TAXIWAYPOINT index taxiway_type orientation? ((lat lon) | (biasX_xyz biasZ_xyz)) SLASH_CLOSE;

index: INDEX value;
taxiway_type: TYPE value;
orientation: ORIENTATION value;

taxiName: OPEN TAXINAME index255 taxi_name SLASH_CLOSE;
index255: INDEX value;
taxi_name: NAME value;


taxiwayPath: OPEN TAXIWAYPATH path_type path_start path_end width weightLimit surface drawSurface drawDetail (centerLine)? (centerLineLighted)? (leftEdge)? (leftEdgeLighted)? (rightEdge)? (rightEdgeLighted)? number designator path_name SLASH_CLOSE;

path_type:TYPE value;
path_start:START value;
path_end:END value;
weightLimit:WHEIGHTLIMIT value;
drawSurface: DRAWSURFACE value;
drawDetail: DRAWDETAIL value;
centerLine:CENTERLINE value;
centerLineLighted:CENTERLINELIGHTED value;
leftEdge:LEFTEDGE value;
leftEdgeLighted:LEFTEDGELIGHTED value;
rightEdge:RIGHTEDGE value;
rightEdgeLighted:RIGHTEDGELIGHTED value;
number:NUMBER value;
path_name:NAME value;


taxiwayParking: OPEN TAXIWAYPARKING index (lat lon | biasX biasZ) heading radius parking_type parking_name number SLASH_CLOSE;

radius: RADIUS value;
parking_type: TYPE value;
parking_name: NAME value; 