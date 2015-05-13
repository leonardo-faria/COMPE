parser grammar XmltoSdlParser;

options {
	tokenVocab = XmltoSdlLexer;
}
  
  
startpoint: document EOF;
document: airport+;
  
airport   
:
	airport_open airport_content airport_close 
;

value
:
	STRING 
; // Our STRING is AttEQUALS value in spec


 
airport_open: OPEN AIRPORT airport_atr CLOSE;


region: REGION EQUALS value;
country: COUNTRY EQUALS value;
state: STATE EQUALS value; 
city: CITY EQUALS value;
name: NAME EQUALS value; 
lat: LAT EQUALS value;
lon: LON EQUALS value;
alt: ALT EQUALS value; 
magvar: MAGVAR EQUALS value;
ident: IDENT EQUALS value;
airportTestRadius: ATR EQUALS value;
trafficScalar: TRAFFICSCALAR EQUALS value;
com_frequency: FREQUENCY EQUALS value;
com_type: TYPE EQUALS value;




airport_close: OPEN SLASH AIRPORT CLOSE;
airport_atr: region? country? state? city? name? lat lon alt magvar? ident airportTestRadius trafficScalar;

airport_content: ( tower | services | com | runway | runwayAlias | (taxiwayPoint taxiwayParking taxiName taxiwayPath) | helipad)*;

tower: OPEN TOWER lat lon alt SLASH_CLOSE;

 
services: services_open services_content services_close;
services_open: OPEN SERVICES CLOSE;
services_close: OPEN SLASH SERVICES CLOSE;

services_content: (fuel)*;
fuel : OPEN FUEL fuel_type availability SLASH_CLOSE;
fuel_type  :  TYPE EQUALS value;
availability: AVAILABILITY EQUALS value;



com  :  OPEN COM com_frequency com_type name SLASH_CLOSE;

 

runway: runway_open runway_content runway_close;
runway_open: OPEN RUNWAY runway_atr CLOSE;
runway_close: OPEN SLASH RUNWAY CLOSE;

runway_atr: lat lon alt surface heading length width runway_number (designator | primaryDesignator | secondaryDesignator ) patternAltitude? primaryTakeoff? primaryLanding? primaryPattern? secondaryTakeoff? secondaryLanding? secondaryPattern? primaryMarkingBias secondaryMarkingBias;
surface: SURFACE EQUALS value;
heading: HEADING EQUALS value;
length: LENGTH EQUALS value;
width: WIDTH EQUALS value;
runway_number: NUMBER EQUALS value;
designator: DESIGNATOR EQUALS value;
primaryDesignator: PRIMARYDESIGNATOR EQUALS value;
secondaryDesignator: SECONDARYDESIGNATOR EQUALS value;
patternAltitude: PATTERNALTITUDE EQUALS value;
primaryTakeoff: PRIMARYTAKEOFF EQUALS value;
primaryLanding: PRIMARYLANDING EQUALS value;
primaryPattern: PRIMARYPATTERN EQUALS value;
secondaryTakeoff: SECONDARYTAKEOFF EQUALS value;
secondaryLanding: SECONDARYLANDING EQUALS value;
secondaryPattern: SECONDARYPATTERN EQUALS value;
primaryMarkingBias: PRIMARYMARKINGBIAS EQUALS value;
secondaryMarkingBias: SECONDARYMARKINGBIAS EQUALS value;


runway_content: (markings)* (lights)* (offsetThreshold)* (blastPad)* (overrun)* (approachLights)* (vasi)* (ils)* (runwayStart)*;

markings: OPEN MARKINGS edges threshold fixedDistance touchdown dashes marking_ident precision edgePavement singleEnd primaryClosed secondaryClosed primaryStol secondaryStol SLASH_CLOSE;
edges: EDGES EQUALS value;
threshold: THRESHOLD EQUALS value;
fixedDistance: FIXEDDISTANCE EQUALS value;
touchdown: TOUCHDOWN EQUALS value;
dashes: DASHES EQUALS value;
marking_ident: MARKING_IDENT EQUALS value;
precision: PRECISION EQUALS value;
edgePavement: EDGEPAVEMENT EQUALS value;
singleEnd: SINGLEEND EQUALS value;
primaryClosed: PRIMARYCLOSED EQUALS value;
secondaryClosed: SECONDARYCLOSED EQUALS value;
primaryStol: PRIMARYSTOL EQUALS value;
secondaryStol: SECONDARYSTOL EQUALS value;
 
lights: OPEN LIGHTS center edge centerRed SLASH_CLOSE;
center: CENTER EQUALS value;
edge: EDGE EQUALS value;
centerRed: CENTERRED EQUALS value;


offsetThreshold: OPEN OFFSETTHRESHOLD end length width? surface? SLASH_CLOSE;
end: END EQUALS value;

blastPad: OPEN BLASTPAD end length width? surface? SLASH_CLOSE;

overrun: OPEN OVERRUN end length width? surface? SLASH_CLOSE;

approachLights: OPEN APPROACHLIGHTS end system? strobes? reil? touchdown? endlights? SLASH_CLOSE;
system: SYSTEM EQUALS value;
strobes: STROBES EQUALS value;
reil: REIL EQUALS value;
endlights: ENDLIGHTS EQUALS value;

vasi: OPEN VASI end vasi_type side biasX biasZ spacing pitch SLASH_CLOSE;
vasi_type: TYPE EQUALS value;
side: SIDE EQUALS value;
biasX: BIASX EQUALS value;
biasZ: BIASZ EQUALS value;
spacing: SPACING EQUALS value;
pitch: PITCH EQUALS value;


ils: ils_open ils_content ils_close;

ils_open: OPEN ILS lat lon alt heading frequency end (range)? magvar ident (width)? (name)? (backCourse)? CLOSE;
frequency: FREQUENCY EQUALS value;
range: RANGE EQUALS value;
backCourse: BACKCOURSE EQUALS value;

ils_content: (glideScope)* (dme)* (visualModel)*;
glideScope: OPEN GLIDESCOPE lat lon alt pitch range SLASH_CLOSE;
dme: OPEN DME lat lon alt range SLASH_CLOSE;

visualModel: visualModel_open visualModel_content visualModel_close;
visualModel_open: OPEN VISUALMODEL heading? imageComplexity? guid_name instanceId CLOSE;
imageComplexity: IMAGECOMPLEXITY EQUALS value;
guid_name: NAME EQUALS value;
instanceId: INSTANCEID EQUALS value;

visualModel_content: (biasXYZ)*;
biasXYZ: OPEN BIASXYZ biasX_xyz biasY_xyz biasZ_xyz SLASH_CLOSE;
biasX_xyz: BIASX EQUALS value;
biasY_xyz: BIASY EQUALS value;
biasZ_xyz: BIASZ EQUALS value;
visualModel_close: OPEN SLASH VISUALMODEL CLOSE;
ils_close: OPEN SLASH ILS CLOSE;

runwayStart: OPEN RUNWAYSTART runway_type lat lon alt heading end SLASH_CLOSE;
runway_type: TYPE EQUALS value;

runwayAlias: OPEN RUNWAYALIAS runway_number designator SLASH_CLOSE;



helipad: OPEN HELIPAD lat lon alt surface heading length width helipad_type closed? transparent? red? green? blue? SLASH_CLOSE;

helipad_type: TYPE EQUALS value;
closed: CLOSED EQUALS value;
transparent: TRANSPARENT EQUALS value;
red: RED EQUALS value;
green: GREEN EQUALS value;
blue: BLUE EQUALS value;


taxiwayPoint: OPEN TAXIWAYPOINT index taxiway_type orientation? ((lat lon) | (biasX_xyz biasZ_xyz)) SLASH_CLOSE;

index: INDEX EQUALS value;
taxiway_type: TYPE EQUALS value;
orientation: ORIENTATION EQUALS value;

taxiName: OPEN TAXINAME index255 taxi_name SLASH_CLOSE;
index255: INDEX EQUALS value;
taxi_name: NAME EQUALS value;


taxiwayPath: OPEN TAXIWAYPATH path_type path_start path_end width weightLimit surface drawSurface drawDetail (centerLine)? (centerLineLighted)? (leftEdge)? (leftEdgeLighted)? (rightEdge)? (rightEdgeLighted)? number designator path_name SLASH_CLOSE;

path_type:TYPE EQUALS value;
path_start:START EQUALS value;
path_end:END EQUALS value;
weightLimit:WHEIGHTLIMIT EQUALS value;
drawSurface: DRAWSURFACE EQUALS value;
drawDetail: DRAWDETAIL EQUALS value;
centerLine:CENTERLINE EQUALS value;
centerLineLighted:CENTERLINELIGHTED EQUALS value;
leftEdge:LEFTEDGE EQUALS value;
leftEdgeLighted:LEFTEDGELIGHTED EQUALS value;
rightEdge:RIGHTEDGE EQUALS value;
rightEdgeLighted:RIGHTEDGELIGHTED EQUALS value;
number:NUMBER EQUALS value;
path_name:NAME EQUALS value;


taxiwayParking: OPEN TAXIWAYPARKING index (lat lon | biasX biasZ) heading radius parking_type parking_name number SLASH_CLOSE;

radius: RADIUS EQUALS value;
parking_type: TYPE EQUALS value;
parking_name: NAME EQUALS value; 