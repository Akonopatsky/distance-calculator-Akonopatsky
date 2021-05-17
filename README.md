## task for java junior vacancy

### http requests and test data are in /src/main/resources/httprequests:
- 1_loadFile.http - load data from smalltest.xml in DB. **It is not idempotent** ;
- 2_getAllCities.http - get List of all cities in the DB ;
- 3_GetDistances.http - get distance calculation results as cartesian between cities;

Rest mapping:
- /api/upload: upload xml file in DB. File must contain XmlDto.class structure;
- /api/distances: 	calculate distances between cities ;
- /api/cities:  get List of all cities in the DB Json format;
- /api/stream: get List of all cities using stream in xml format;
