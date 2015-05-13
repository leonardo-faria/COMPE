lexer grammar XmltoSdlLexer;

S: [ \t\n\r]+ -> skip ;

OPEN        :   '<'                     -> pushMode(INSIDE);
mode INSIDE;

WS: [ \t\n\r]+ -> skip ;

AIRPORT: 'Airport';
REGION: 'region';
COUNTRY: 'country'; 
STATE: 'state';
CITY: 'city';
NAME: 'name';
LAT: 'lat'; 
LON: 'lon';
ALT: 'alt';
MAGVAR: 'magvar';
IDENT: 'ident';
ATR: 'airportTestRadius';
TRAFFICSCALAR: 'trafficScalar';
SERVICES: 'Services';
FUEL: 'Fuel';
TYPE: 'type';
AVAILABILITY: 'availability';
TOWER: 'Tower';
RUNWAY: 'Runway';
SURFACE: 'surface';
HEADING: 'heading';
LENGTH: 'length';
WIDTH: 'width';
NUMBER: 'number';
DESIGNATOR: 'designator';
PRIMARYDESIGNATOR: 'primaryDesignator';
SECONDARYDESIGNATOR: 'secondaryDesignator';
PATTERNALTITUDE: 'patternAltitude';
PRIMARYTAKEOFF: 'primaryTakeoff';
PRIMARYLANDING: 'primaryLanding';
PRIMARYPATTERN: 'primaryPattern';
SECONDARYTAKEOFF: 'secondaryTakeoff';
SECONDARYLANDING: 'secondaryLanding';
SECONDARYPATTERN: 'secondaryPattern';
PRIMARYMARKINGBIAS: 'primaryMarkingBias';
SECONDARYMARKINGBIAS: 'secondaryMarkingBias';
MARKINGS: 'Markings';
EDGES: 'edges';
THRESHOLD: 'threshold';
FIXEDDISTANCE: 'fixedDistance';
TOUCHDOWN: 'touchdown';
DASHES: 'dashes';
MARKING_IDENT: 'ident';
PRECISION: 'precision';
EDGEPAVEMENT: 'edgePavement';
SINGLEEND: 'singleEnd';
PRIMARYCLOSED: 'primaryClosed';
SECONDARYCLOSED: 'secondaryClosed';
PRIMARYSTOL: 'primaryStol';
SECONDARYSTOL: 'secondaryStol';
LIGHTS: 'Lights';
CENTER: 'center';
EDGE: 'edge';
CENTERRED: 'centerRed';
OFFSETTHRESHOLD: 'OffsetThreshold';
END: 'end';
BLASTPAD: 'BlastPad';
OVERRUN: 'Overrun';
APPROACHLIGHTS: 'ApproachLights';
SYSTEM: 'system';
STROBES: 'strobes';
REIL: 'reil';
ENDLIGHTS: 'endLights';
VASI: 'vasi';
SIDE: 'side';
BIASX: 'biasX';
BIASY: 'biasY';
BIASZ: 'biasZ';
SPACING: 'spacing';
PITCH: 'pitch';
ILS: 'Ils';
FREQUENCY: 'frequency';
RANGE: 'range';
BACKCOURSE: 'backCourse';
GLIDESCOPE: 'GlideScope';
DME: 'DME';
VISUALMODEL: 'VisualModel';
IMAGECOMPLEXITY: 'imageComplexity';
INSTANCEID: 'InstanceId';
BIASXYZ: 'BiasXYZ';
BIASX_xyz: 'biasX';
BIASY_xyz: 'biasY';
BIASZ_xyz: 'biasZ';
RUNWAYSTART: 'RunwayStart';
RUNWAYALIAS: 'RunwayAlias';
START: 'start';
INDEX: 'index';
ORIENTATION: 'orientation';
TAXIWAYPATH: 'TaxiwayPath';
WHEIGHTLIMIT: 'weightLimit';
DRAWSURFACE:'drawSurface';
DRAWDETAIL:'drawDetail';
CENTERLINE:'centerLine';
CENTERLINELIGHTED:'centerLineLIGHTED';
LEFTEDGELIGHTED: 'leftEdgeLighted';
RIGHTEDGE:'rightEdge';
RIGHTEDGELIGHTED: 'rightEdgeLighted';
COM:'Com';
LEFTEDGE: 'leftEdge';
HELIPAD: 'Helipad';
TAXINAME: 'taxiName'; 
TAXIWAYPARKING: 'TaxiwayParking';
RADIUS:'radius';
CLOSED:'closed';
TRANSPARENT:'transparent';
RED:'red';
GREEN:'green';
BLUE:'blue';
TAXIWAYPOINT:'TaxiwayPoint';

CLOSE       :   '>'                     -> popMode ;
SLASH_CLOSE :   '/>'                    -> popMode ;
SLASH       :   '/' ;
EQUALS      :   '=' ;

STRING      :   '"' ~[<"]* '"'
            ;
Name        :   NameStartChar NameChar* ;

fragment
DIGIT       :   [0-9] ;

NameChar    :   NameStartChar
            |   '-' | '_' | '.' | DIGIT 
            |   '\u00B7'
            |   '\u0300'..'\u036F'
            |   '\u203F'..'\u2040'
            ;

fragment
NameStartChar
            :   [:a-zA-Z]
            |   '\u2070'..'\u218F' 
            |   '\u2C00'..'\u2FEF' 
            |   '\u3001'..'\uD7FF' 
            |   '\uF900'..'\uFDCF' 
            |   '\uFDF0'..'\uFFFD'
            ;